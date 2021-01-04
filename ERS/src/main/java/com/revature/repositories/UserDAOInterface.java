package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.*;

public interface UserDAOInterface {

	public ArrayList<User> selectAllUsers(); 
	public User selectUser(String x);
	public void insertUser(User x);
	//public void updateUser(ERS_User x); I'm not sure if we are going to need this.
	
}