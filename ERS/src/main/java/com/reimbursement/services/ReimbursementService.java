package com.reimbursement.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimbursement.controllers.EmployeeController;
import com.reimbursement.controllers.LoginController;
import com.reimbursement.controllers.ManagerController;
import com.reimbursement.controllers.TicketController;

public class ReimbursementService {



	public static String process(HttpServletRequest request, HttpServletResponse response) {

		switch (request.getRequestURI()) {
		case "/ers5/html/index.do":
			try {
				return LoginController.login(request);
			} catch (NullPointerException e) {
				return "/html/index.html";
			}
		case "/ers5/html/employee.do": //Employee Redirect
			return EmployeeController.Home(request, response);
		case "/ers5/html/Manager.do": //Manager Redirect
			return ManagerController.Home(request, response);
		case "/ers5/html/submitTicket.do": //Ticket Methods
			return TicketController.submitTicket(request);
		case "/ers5/html/displayTickets.do":
			return TicketController.displayTickets(request, response);
		case "/ers5/html/displayAllTickets.do":
			return TicketController.displayAllTickets(request, response);
		case "/ers5/html/approveTicket.do":
			return TicketController.approveTicket(request);
		case "/ers5/html/denyTicket.do":
			return TicketController.denyTicket(request);
		default:

			return "/html/index.html";
		}

	}

}
