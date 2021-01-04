package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.ReimbursementService;
import com.revature.util.LoggerSingleton;

/**
 * Servlet implementation class Servlet
 */
	public class ReimbursementServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoggerSingleton.getLogger().info("ReimbursementServlet - doGet");
		ReimbursementService.process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetURL = ReimbursementService.process(request, response);
		LoggerSingleton.getLogger().info("ReimbursementServlet - doPost");
		request.getRequestDispatcher(targetURL).forward(request, response);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoggerSingleton.getLogger().info("ReimbursementServlet - doPut");
		ReimbursementService.process(request, response);

	}
}
