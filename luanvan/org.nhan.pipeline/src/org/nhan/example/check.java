package org.nhan.example;

import org.nhan.pipeline.Pipeline;

public class check {
	public static void main(String[] args) {
		Pipeline pipe = new Pipeline("square");
		pipe.setParameterValue("input", "10");
		// pipe.setParameterValue("b","15");
		pipe.processPipeline();
	}
}
