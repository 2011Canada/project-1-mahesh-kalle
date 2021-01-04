package com.reimbursement.repositories;

import java.sql.Connection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.net.SyslogAppender;

import com.reimbursement.models.*;
import com.reimbursement.util.ConnectionFactory;

public class TicketDAO implements TicketDAOInterface {
	final static Logger Loggy = Logger.getLogger(TicketDAO.class);

	private static ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public void insertTicket(Ticket x) {
		
		try  {
			
			Connection conn=cf.getConnection();
			
			System.out.println("Ticket Details ====== "+x);
			
			Date date = new Date(); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			
            Timestamp ts=new Timestamp(date.getTime());  
            
			
			PreparedStatement ps = conn.prepareStatement("insert into ers_reimbursement (reimb_amount,reimb_submitted, reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,reimb_status_id,reimb_type_id)"
														+ " VALUES(?,?::date,?,?,?::oid,?,?,?,?)");
			ps.setDouble(1,x.getAmount());
			ps.setTimestamp(2,x.getSubmit_date());
			ps.setTimestamp(3,x.getResolve_date());
			ps.setString(4,x.getDescription());
			ps.setBlob(5,x.getReceipt());
			ps.setInt(6,x.getAuthor());
			ps.setInt(7,x.getResolver());
			ps.setInt(8,x.getStatus_id());
			ps.setInt(9,x.getType_id());
			
			ps.executeUpdate();
			System.out.println("Success!");

		} catch (SQLException e) {
			System.out.println("Connection Failed! InsertTicket");
			e.printStackTrace();
		}
		Loggy.info("ERS Tickethas been inserted by user: " + x.getAuthor());
	}

	@Override
	public Ticket selectTicket(int x) {//Select ticket by (ticket_id) primary key for tickets.
		Ticket tick = null;
		try {
			
			Connection conn=cf.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID=?");
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.getDouble(2));
			while (rs.next()) {
				tick = new Ticket(
						rs.getInt(1),
						rs.getDouble(2),
						rs.getTimestamp(3),
						rs.getTimestamp(4),
						rs.getString(5),
						rs.getBlob(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getInt(10));
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! SelectTicket");
			e.printStackTrace();
		}
		Loggy.info("ERS Ticket " + x + " has been selected and retrieved.");
		return tick;
		
	}

	public Ticket[] selectAllTickets() { 
		BasicConfigurator.configure();
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		try {
			
			Connection conn=cf.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ticketList.add(new Ticket(
						rs.getInt(1),
						rs.getDouble(2),
						rs.getTimestamp(3),
						rs.getTimestamp(4),
						rs.getString(5),
						rs.getBlob(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getInt(10)));
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! SelectAllEmployees");
			e.printStackTrace();
		}
		Ticket[] ticketArray = new Ticket[ticketList.size()];
		for(int i = 0; i<ticketList.size();i++) {
			ticketArray[i] = ticketList.get(i);
		}
		Loggy.info("ERS Tickets have been selected and retrieved.");
		return ticketArray;
		
	}

	
	public Ticket[] selectByEmployee(User x) { 
		BasicConfigurator.configure();
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		try  {
			
			Connection conn=cf.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=?");
			ps.setInt(1,x.getUser_id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ticketList.add(new Ticket(
						rs.getInt(1),
						rs.getDouble(2),
						rs.getTimestamp(3),
						rs.getTimestamp(4),
						rs.getString(5),
						rs.getBlob(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getInt(10)));
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! SelectByEmployee");
			e.printStackTrace();
		}
		Ticket[] ticketArray = new Ticket[ticketList.size()];
		for(int i = 0; i<ticketList.size();i++) {
			ticketArray[i] = ticketList.get(i);
			System.out.println("Ticket Array : "+ticketArray[i]);
		}
		Loggy.info("ERS Ticket table has been viewed by employee ID :" + x.getUser_id());
		return ticketArray;
		
	}


	@Override
	public void updateTicket(Ticket x) { 
		try {
			
			Connection conn=cf.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET "
					+ "ticket_id=?,"
					+ "ticket_amount=?,"
					+ "submit_date=?"
					+ "resolve_date=?,"
					+ "decreiption=?,"
					+ "receipt=?,"
					+ "status_id=?,"
					+ "type_id=? "
					+ "WHERE REIMB_ID=? ");
			
			ps.setInt(11, x.getTicket_Id());
			ps.setInt(1,x.getTicket_Id());
			ps.setDouble(2,x.getAmount());
			ps.setTimestamp(3,x.getSubmit_date());
			ps.setTimestamp(4,x.getResolve_date());
			ps.setString(5,x.getDescription());
			ps.setBlob(6,x.getReceipt());
			ps.setInt(7,x.getAuthor());
			ps.setInt(8,x.getResolver());
			ps.setInt(9,x.getStatus_id());
			ps.setInt(10,x.getType_id());
			
			ps.executeQuery();
		
						
		} catch (SQLException e) {
			System.out.println("Connection Failed! UpdateTicket");
			e.printStackTrace();
		}

		
		
	}
	public static void commit() {
		try {
			
			Connection conn=cf.getConnection();
			PreparedStatement ps = conn.prepareStatement("COMMIT");
			ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Connection Failed! COMMIT");
			e.printStackTrace();
		}
		Loggy.info("ERS DB has been accessed.");

	}
	
	public void approveTicket(String x) {
		Date date= new Date();
		Timestamp current_date = new Timestamp(date.getTime());
		System.out.println("Updating.....");
		try {
			
			Connection conn=cf.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(
"UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 3,"
+ "REIMB_RESOLVED=?,REIMB_RESOLVER=2 WHERE REIMB_ID =?");
			int y = Integer.valueOf(x);
			System.out.println("y value....."+y);
			ps.setTimestamp(1, current_date);
			ps.setInt(2, y);
			ps.executeUpdate();
			//commit();
							
		} catch (SQLException e) {
			System.out.println("Statement Failed! ApproveTicket");
			e.printStackTrace();
		}
		Loggy.info("ERS Ticket " + x + " has been selected and approved.");
	}
	public void denyTicket(String x) {
		Date date= new Date();
		Timestamp current_date = new Timestamp(date.getTime());
		try {
			
			Connection conn=cf.getConnection();
			PreparedStatement ps = conn.prepareStatement(
"UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 2,"
+ "REIMB_RESOLVED=?,REIMB_RESOLVER=2 WHERE REIMB_ID =?");
			System.out.println("INSIDE DENY TICKET");
			int y = Integer.valueOf(x);
			ps.setTimestamp(1, current_date);
			ps.setInt(2, y);
			ps.executeUpdate();
			//commit();
					
		} catch (SQLException e) {
			System.out.println("Statement Failed! denyTicket");
			e.printStackTrace();
		}
		Loggy.info("ERS Ticket " + x + " has been selected and denied.");

	}

}