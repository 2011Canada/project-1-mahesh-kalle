package com.reimbursement.repositories;

import com.reimbursement.models.Ticket;

public interface TicketDAOInterface {

	public void insertTicket(Ticket x);
	public Ticket selectTicket(int x); //Select ticket by author of ticket.
	public Ticket[] selectAllTickets();
	public void updateTicket(Ticket x);
	
}