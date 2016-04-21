package org.nhan.sbus;

import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class ServiceProxy {
	public static HashMap<String, ServiceProxy> loadServices(
			String extensionPoint) {
		HashMap<String, ServiceProxy> services = new HashMap<String, ServiceProxy>();

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(extensionPoint);
		if (point == null) {
			throw new NullPointerException("Unable to resolve '"
					+ extensionPoint + "' extension-point");
		}

		IConfigurationElement[] extensions = point.getConfigurationElements();
		if (extensions != null) {
			for (IConfigurationElement extension : extensions) {
				try {
					ServiceProxy proxy = new ServiceProxy(extension);
					services.put(proxy.getName(), proxy);
				} catch (Exception exp) {
					MessageHandler.log("Can't load extension", exp);
				}
			}
		}
		return services;
	}

	
	private ServiceProxy(IConfigurationElement element) throws Exception {
		operationsCache = new HashMap<String, OperationProxy>();
		serviceName = element.getAttribute("name");
		delegate = element.createExecutableExtension("class");

		IConfigurationElement[] opElems = element.getChildren();

		for (IConfigurationElement opElem : opElems) {
			OperationProxy operation = new OperationProxy(delegate, opElem);
			operationsCache.put(operation.getName(), operation);
		}
	}

	
	public String getName() {
		return serviceName;
	}

	
	public boolean hasOperation(String name) {
		return operationsCache.containsKey(name);
	}

	
	public OperationProxy getOperation(String name) {
		OperationProxy proxy = operationsCache.get(name);
		if (proxy == null)
			new IllegalArgumentException("No such operation: " + name);
		return proxy;

	}

	
	public Object getDelegate() {
		return delegate;
	}

	private Object delegate;

	private String serviceName;

	private HashMap<String, OperationProxy> operationsCache;
}
