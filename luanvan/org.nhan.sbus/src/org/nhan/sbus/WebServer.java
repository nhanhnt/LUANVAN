package org.nhan.sbus;

import java.io.InputStream;

import javax.servlet.Servlet;

import org.apache.axis.client.AdminClient;
import org.apache.axis.transport.http.AdminServlet;
import org.apache.axis.transport.http.AxisServlet;
import org.apache.axis.utils.Options;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import org.mortbay.jetty.MimeTypes;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.servlet.ServletMapping;
import org.osgi.framework.Bundle;

public class WebServer {
	// Jetty HTTP server
	private final Server server;

	// Default servlet and application context
	private final Context context;

	// Client for web service deployment
	private AdminClient adminClient;

	public WebServer(final int port) {
		server = new Server(port);
		context = new Context(server, "/", Context.SESSIONS);

		// Deploy Axis servlets
		deploy("AxisServlet", new AxisServlet(), new String[] {
				"/servlet/AxisServlet", "/services/*" });

		deploy("AdminServlet", new AdminServlet(),
				new String[] { "/servlet/AdminServlet" });

		MimeTypes mimeTypes = context.getMimeTypes();
		if (mimeTypes == null) {
			mimeTypes = new MimeTypes();
			context.setMimeTypes(mimeTypes);
		}
		mimeTypes.addMimeMapping("xsd", "text/xml");
		mimeTypes.addMimeMapping("wsdl", "text/xml");

		adminClient = new AdminClient();

		String[] args = { "-lhttp://localhost:" + port
				+ "/services/AdminService" };
		try {
			Options op = new Options(args);
			adminClient.processOpts(op);
		} catch (Exception exp) {
			// This must not happen
			MessageHandler.log("Can't instantiate deployment client", exp);
		}
	}

	protected void loadServlets(String extensionPoint) {
		IConfigurationElement[] extensions = ExtPointUtil
				.getConfigElements(extensionPoint);
		if (extensions == null || extensions.length < 1) {
			MessageHandler.log("No attached servlet extensions");
			return;
		}

		for (IConfigurationElement conElServlet : extensions) {
			try {
				Servlet servletClass = (javax.servlet.Servlet) conElServlet
						.createExecutableExtension("class");
				String servletName = conElServlet.getAttribute("name");

				// Find mappings
				IConfigurationElement[] conElMappings = conElServlet
						.getChildren();
				String[] mappings = new String[conElMappings.length];

				for (int i = 0; i < mappings.length; i++) {
					mappings[i] = conElMappings[i].getAttribute("pathSpec");
				}

				deploy(servletName, servletClass, mappings);

			} catch (Exception exp) {
				MessageHandler.log("Can't deploy servlet", exp);
			}
		}
	}

	protected void loadWebServices(String extensionPoint) {
		IConfigurationElement[] extensions = ExtPointUtil
				.getConfigElements(extensionPoint);
		if (extensions == null || extensions.length < 1) {
			MessageHandler.log("No attached web services");
			return;
		}

		for (IConfigurationElement conElWebs : extensions) {
			try {
				String wsddPath = conElWebs.getAttribute("wsdd");
				deploy(wsddPath);
			} catch (Exception exp) {
				MessageHandler.log("Can't deploy web service: " + conElWebs,
						exp);
			}
		}
	}

	public void deploy(String name, Servlet servlet, String[] pathSpecs) {
		if (name == null || name.length() < 1) {
			// Use servlet class name as servlet name in the servlet context
			name = servlet.getClass().getName();
		}

		ServletHolder holder = new ServletHolder();
		holder.setName(name);
		holder.setServlet(servlet);

		ServletMapping mapping = new ServletMapping();
		mapping.setServletName(name);
		mapping.setPathSpecs(pathSpecs);

		context.addServlet(holder, null);
		context.getServletHandler().addServletMapping(mapping);
	}

	public String deploy(InputStream wsdd) throws Exception {
		// If server is not completely started give it some
		// time to do the initialization.
		while (server.isStarting()) {
			Thread.sleep(1000);
		}
		return adminClient.process(wsdd);
	}

	public String deploy(String wsddPath) throws Exception {
		// Translate this plugin relative path to Eclipse terminology
		Path path0 = new Path("schema/feeds.wsdd");

		// Now get the input stream
		Bundle bundle = Platform.getBundle(MessageHandler.PLUGIN_ID);
		InputStream stream = FileLocator.openStream(bundle, path0, false);

		// Finally deploy the web service from the wsdd content stream
		return deploy(stream);
	}

	public boolean start() {
		try {
			server.start();
			// server.join();
			MessageHandler.log("Jetty HTTP server now running");
			return true;
		} catch (Exception exp) {
			MessageHandler.log("Can't start Jetty", exp);
			return false;
		}
	}

	public boolean isStarted() {
		return server.isStarted();
	}

	public boolean isRunning() {
		return server.isRunning();
	}

	public boolean stop() {
		try {
			server.stop();
			return true;
		} catch (Exception exp) {
			MessageHandler.log("Can't stop Jetty", exp);
			return false;
		}
	}
}
