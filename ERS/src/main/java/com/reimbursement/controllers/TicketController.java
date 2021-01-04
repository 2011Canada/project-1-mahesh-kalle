package com.reimbursement.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.models.Ticket;
import com.reimbursement.models.User;
import com.reimbursement.repositories.TicketDAO;

public class TicketController { // NEEDS TO BE WORKED ON LOL

	public static String submitTicket(HttpServletRequest request) {
		User EmployeeUser = (User) request.getSession().getAttribute("CurrentUser");

		TicketDAO ticketDAO = new TicketDAO();
		int ticket_Id = 0;
		double ticket_amount = Double.parseDouble(request.getParameter("ticketAmount"));

		Date date = new Date();
		Timestamp current_date = new Timestamp(date.getTime());
		Timestamp resolve_date = null;
		String ticket_description = request.getParameter("ticketDesc");
		System.out.println(ticket_description);
		Blob receipt = null;
		int author = EmployeeUser.getUser_id();
		int resolver = 1;
		int status_id = 1;
		String responseType = request.getParameter("ticketType");
		int type_id = 0;
		switch (responseType) {
		case "Food":
			type_id = 1;
			break;
		case "Lodging":
			type_id = 2;
			break;
		case "Travel":
			type_id = 3;
			break;
		case "Other":
			type_id = 4;
			break;
		}

		Ticket newTicket = new Ticket(ticket_Id, ticket_amount, current_date, resolve_date, ticket_description,
				receipt, author, resolver, status_id, type_id);

		ticketDAO.insertTicket(newTicket);
		request.getSession().setAttribute("CurrentUser", EmployeeUser);
		return "/html/employee.html";

	}

	public static String displayTickets(HttpServletRequest request, HttpServletResponse response) {
		
		// Sessions - Marshalling Tool
		User EmployeeUser = (User) request.getSession().getAttribute("CurrentUser");
		TicketDAO tick = new TicketDAO();
		Ticket[] ticketList = tick.selectByEmployee(EmployeeUser);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(ticketList)); // returning an array
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String displayAllTickets(HttpServletRequest request, HttpServletResponse response) {
		TicketDAO tick = new TicketDAO(); // DAO Call
		Ticket[] ticketList = tick.selectAllTickets();
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(ticketList)); // returning an array
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String approveTicket(HttpServletRequest request) {
		TicketDAO tick = new TicketDAO();
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String data = br.readLine();
			tick.approveTicket(data);

		} catch (IOException e) {
			System.out.println("Something went wrong in approveTicket controller");
			e.printStackTrace();
		}
		// request.getParameter(name)
		System.out.println("Successfully approved ticket!");
		return "/html/manager.html";

	}

	public static String denyTicket(HttpServletRequest request) {
		TicketDAO tick = new TicketDAO();
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String data = br.readLine();
			System.out.println("DATA IN DENY TICKETS:" + data);
			tick.denyTicket(data);

		} catch (IOException e) {
			System.out.println("Something went wrong in denyTicket controller");
			e.printStackTrace();
		}
		System.out.println("Successfully denied ticket!");
		return "/html/manager.html";

	}

}
