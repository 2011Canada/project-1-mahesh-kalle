package com.reimbursement.controllers;

import javax.servlet.http.HttpServletRequest;

import com.reimbursement.models.User;
import com.reimbursement.repositories.UserDAO;
import com.reimbursement.util.LoggerSingleton;

public class LoginController {

	
	public static String login(HttpServletRequest request){
		
		//LoggerSingleton.getLogger().info("Login Class..");
		
		UserDAO user = new UserDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User newUser = new User();
		newUser = user.selectUser(username);
			
			if(username.equals(newUser.getUsername()) && password.equals(newUser.getPassword())) {
				if(newUser.getRole_id() == 1) { //employee ID number
					request.getSession().setAttribute("CurrentUser", newUser); //CurrentUser will be the reference name.
					return "/html/employee.html";
				}
				else if(newUser.getRole_id() == 2) { //Boss ID number
					request.getSession().setAttribute("CurrentUser", newUser); //CurrentUser will be the reference name.
					return "/html/manager.html";
				}
				return "/html/index.html"; //Return back to main screen if the ROLE_ID doesnt match up..

		}
			else return
					"/html/index.html";
		
	}
}
