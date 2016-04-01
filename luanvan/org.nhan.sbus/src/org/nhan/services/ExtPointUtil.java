package org.nhan.services;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class ExtPointUtil {

	public static IExtension[] getExtensions(String extensionPoint) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint xpoint = registry.getExtensionPoint(extensionPoint);
		if (xpoint == null) {
			throw new NullPointerException("Invalid extension point: "
					+ extensionPoint);
		}
		return xpoint.getExtensions();
	}

	public static IConfigurationElement[] getConfigElements(
			String extensionPoint) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint xpoint = registry.getExtensionPoint(extensionPoint);
		if (xpoint == null) {
			throw new NullPointerException("Invalid extension point: "
					+ extensionPoint);
		}
		return xpoint.getConfigurationElements();
	}
}
