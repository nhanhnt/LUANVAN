package org.nhan.pipeline;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.ui.plugin.*;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class PipelinePlugin extends AbstractUIPlugin {

	//The shared instance.
	private static PipelinePlugin plugin;
	
	/**
	 * The constructor.
	 */
	public PipelinePlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static PipelinePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.nhan.pipeline", path);
	}
	 protected static File getResource(String res) throws IOException {
	        Path path = new Path(res);
	        URL url = Platform.find(plugin.getBundle(), path);
	        url = Platform.resolve(url);
	        return new File(url.getFile());
	    }
}
