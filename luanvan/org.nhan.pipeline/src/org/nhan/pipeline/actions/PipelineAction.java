package org.nhan.pipeline.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.nhan.pipeline.Pipeline;

public class PipelineAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	public PipelineAction() {
	}

	public void dispose() {
		this.window = null;
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	public void run(IAction action) {
		if (window == null)
			return;

		Pipeline pipe = new Pipeline("simple:combined");
		String[] params = {"4","5"};
		pipe.setParameterValues(params);
		pipe.processPipeline();

	}

	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
