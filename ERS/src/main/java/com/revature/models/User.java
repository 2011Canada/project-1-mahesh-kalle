package com.revature.models;

/*
 * User ID(Number)
Username(VARCHAR2)
Password(VARCHAR2)
First Name(VARCHAR2)
Last Name(VARCHAR2)
 */
public class User {

private int user_id;	
private String username;
private String password;
private String fname;
private String lname;
private String email;
private int role_id;

public User() {

}
public User(int user_id,String user_name, String pass_word, String first_name, String last_name,String e_mail,int roleID) { //Constructor for the SQL Select method.

this.user_id = user_id;
this.username = user_name;
this.password = pass_word;
this.fname = first_name;
this.lname = last_name;
this.email = e_mail;
this.role_id = roleID;

}

public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getFname() {
return fname;
}
public void setFname(String fname) {
this.fname = fname;
}
public String getLname() {
return lname;
}
public void setLname(String lname) {
this.lname = lname;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public int getRole_id() {
return role_id;
}
public void setRole_id(int role_id) {
this.role_id = role_id;
}
@Override
public String toString() {
	return "ERS_User [user_id=" + user_id + ", username=" + username + ", fname=" + fname
			+ ", lname=" + lname + ", email=" + email + ", role_id=" + role_id + "]";
}


}