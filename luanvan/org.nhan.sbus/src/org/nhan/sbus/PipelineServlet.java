package org.nhan.sbus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PipelineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DOCTYPE = "";


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String pipeName = request.getParameter("pipeline");
		String xmlParams = request.getParameter("params");
		System.out.println("----->" + xmlParams);

		Object result = null;
		try {
			result = MessageHandler.getDefault().invoke("org.nhan.pipeline",
					"invokePipe", new Object[] { pipeName, xmlParams });
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.println(DOCTYPE + result);
	}
}
