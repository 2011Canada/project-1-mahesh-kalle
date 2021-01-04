package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.util.LoggerSingleton;

public class LoginController {

	public static String login(HttpServletRequest request){
		
		UserDAO user = new UserDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User newUser = new User();
		newUser = user.selectUser(username);
			
			if(username.equals(newUser.getUsername()) && password.equals(newUser.getPassword())) {
				if(newUser.getRole_id() == 1) { //User Login
					request.getSession().setAttribute("CurrentUser", newUser); //CurrentUser will be the reference name.
					LoggerSingleton.getLogger().info("Redirecting to /html/employee.html");
					return "/html/employee.html";
				}
				else if(newUser.getRole_id() == 2) { //Manager Login
					request.getSession().setAttribute("CurrentUser", newUser); //CurrentUser will be the reference name.
					LoggerSingleton.getLogger().info("Redirecting to /html/manager.html");
					return "/html/manager.html";
				}
				return "/html/index.html"; //Back to Login Page

		}
			else {
				
				request.setAttribute("error", "Please check the username or password.");
				return "/html/index.html";
			}
					
		
	}
}
