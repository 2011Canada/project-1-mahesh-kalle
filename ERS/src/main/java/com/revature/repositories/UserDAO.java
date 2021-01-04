package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAO implements UserDAOInterface {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();


	public ArrayList<User> selectAllUsers() throws InternalErrorException {
		ArrayList<User> userList = new ArrayList<User>();
		try (Connection conn=cf.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userList.add(new User(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7))); 
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return userList;
	}

	public User selectUser(String x) throws UserNotFoundException, InternalErrorException{//This might be used as the login method
		User cust = null;
		try  {
			Connection conn=cf.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?");
			ps.setString(1, x);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cust = new User(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7));
				return cust;
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed! SelectUser");
			e.printStackTrace();
		}
		return null;
	}

	public void insertUser(User x) throws UnauthorizedException{ // not really going to be needed, but keeping it here for now.
		try (Connection conn=cf.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS VALUES(?,?,?,?,?,?)");

			ps.setString(1, x.getUsername());
			ps.setString(2, x.getPassword());
			ps.setString(3, x.getFname());
			ps.setString(4, x.getLname());
			ps.setString(5, x.getEmail());
			ps.setInt(6, x.getRole_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}

	}

}