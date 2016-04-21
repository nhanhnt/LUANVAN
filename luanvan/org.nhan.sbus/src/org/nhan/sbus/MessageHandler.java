package org.nhan.sbus;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import java.util.HashMap;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * The main plugin class to be used in the desktop.
 */
public class MessageHandler extends Plugin {
	protected static final String PLUGIN_ID = "org.nhan.sbus";

	protected static final String EXT_SERVLETS = PLUGIN_ID + ".servlets";

	protected static final String EXT_WEBSERVICES = PLUGIN_ID + ".webservices";

	public static final String EXT_SERVICES = PLUGIN_ID + ".services";

	protected static final int SERVER_PORT = 8088;

	// Jetty HTTP server
	private WebServer webServer;

	// Loaded extensions
	private HashMap<String, ServiceProxy> serviceCache;

	// The shared instance.
	private static MessageHandler plugin;
	

	/**
	 * The constructor.
	 */
	public MessageHandler() {
		plugin = this;
	}
	
	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		startWebServer();
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		if (webServer != null && webServer.isStarted()) {
			webServer.stop();
		}
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static MessageHandler getDefault() {
		return plugin;
		//return new MessageHandler();
	}

	private void startWebServer() throws Exception {
		new Thread() {
			public void run() {
				webServer = new WebServer(SERVER_PORT);

				webServer.loadServlets(MessageHandler.EXT_SERVLETS);
				webServer.start();

				webServer.loadWebServices(MessageHandler.EXT_WEBSERVICES);
			}
		}.start();
	}

	protected static void log(String message) {
		plugin.getLog().log(
				new Status(IStatus.INFO, PLUGIN_ID, 0, message, null));
	}

	/**
	 * Logs the error message
	 */
	protected static void log(String message, Exception exp) {
		plugin.getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, 0, message, exp));
	}

	public static Object getService(String service) {
		ServiceProxy proxy = getDefault().getServiceProxy(service);
		return proxy.getDelegate();
	}

	protected ServiceProxy getServiceProxy(String service) {

		if (serviceCache == null) {
			serviceCache = ServiceProxy
					.loadServices(MessageHandler.EXT_SERVICES);
		}

		ServiceProxy proxy = serviceCache.get(service);
		if (proxy == null)
			throw new IllegalArgumentException("No such service: " + service);
		return proxy;
	}

	protected Object invoke(String service, String operation, Object... params)
			throws Exception {
		ServiceProxy sproxy = getServiceProxy(service);

		OperationProxy oproxy = sproxy.getOperation(operation);

		long t1 = System.currentTimeMillis();
		Object response = oproxy.invoke(params);
		long t2 = System.currentTimeMillis();

		log("Total time in service invokation " + (t2 - t1) + " ms");
		return response;
	}
}
