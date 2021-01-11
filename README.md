<h2>Expense Reimbursement System</h2>
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. 
All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. 
Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to 
approve and deny requests for expense reimbursement.

<h3>Technologies Used</h3>
<ul>
<li>Java 8</li>
<li>JavaScript ES6</li>
<li>AJAX</li>
<li>HTML5</li>
<li>CSS</li>
<li>PostgreSQL 13.1</li>
</ul>

<h3>Features</h3>
<ol>
<li>Employee can log into the system and can view all submitted request in the past. Also employee can create new reimbursment request.</li>
<li>Employees must select the type of reimbursement request as: LODGING, TRAVEL, FOOD, or OTHER.</li>
<li>Finance Manager can log in into the system. View All submitted request.</li>
<li>Finance Manager can Approve or Reject the request submitted by employees.</li>
<li>Finance Manager can filter request based on status :Approved, Pending or Denied.</li>
</ol>

<h3>To-do list</h3>
<ul>
<li>Clone the project into your desired folder using below command in gitbash.</li>
git clone https://github.com/2011Canada/project-1-mahesh-kalle.git
<li>Create Postgres database with schema name 'ers' (in DBeaver) using the script provided in ERS_DB.sql file.</li>
<li>The script file creates new schema and the tables required for the project.</li>
<li>Import project in Eclipse or Spring Tool Suite(IDE) and install Tomcat 9 server on your system.</li>
<li>Set environment variables in your system for DB_URL, DB_USERNAME and DB_PASSWORD.</li>
<li>From the IDE, right click on the project and Select Run As > Run on Server.</li>
</ul>

<h3>Usage</h3>
<h4>Employee Usage:</h4>
<ul>
<li>Open the web browser and type "http://localhost:8080/ers/html/index.html" in the address bar. It will open Login page.</li>
<li>If you enter the username and password for employee, it will open the Employee Screen.</li>
<li>On the employee screen , it will show all past request.It also has a button to create new request.</li>
<li>On click on any past request it will display the ticket details in the pop-up window.</li>
<li>Fill out the new request form and click on submit to submit the request. </li>
<li>Employees must select the type of reimbursement request as: LODGING, TRAVEL, FOOD, or OTHER.</li>
<li>The new request shows as 'Pending' state until Manager Approves/Rejects the request.</li>
</ul>
<div align="center">
  <a target="_blank" rel="noopener noreferrer" href="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Login%20Page.png"><img src="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Login%20Page.png" width="600" style="max-width:100%;"></a>
  </div>
  <br>
  <div align="center">
  <a target="_blank" rel="noopener noreferrer" href="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Employee_Page.png"><img src="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Employee_Page.png" width="600" style="max-width:100%;"></a>
  </div>
<br>
  <div align="center">
  <a target="_blank" rel="noopener noreferrer" href="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Ticket_Details_Employee.png"><img src="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Ticket_Details_Employee.png" width="600" style="max-width:100%;"></a>
  </div>
  
<h4>Manager Usage:</h4>
<ul>
<li>Open the web browser and type "http://localhost:8080/ers/html/index.html" in the address bar. It will open Login page.</li>
<li>If you enter the username and password for manager, it will open the Manager Screen.</li>
<li>On the manager screen , it will show all the requests submitted by all the employees.</li>
<li>On click on any request it will display the ticket details in the pop-up window where the manager can approve/deny the request.</li>
<li>Manager can approve or reject the employees request.</li>
<li>Manager can filter request based on status :Approved, Pending or Denied.</li>
</ul>
 <div align="center">
  <a target="_blank" rel="noopener noreferrer" href="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Manager_Page.png"><img src="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Manager_Page.png" width="600" style="max-width:100%;"></a>
  </div>
<br>
  <div align="center">
  <a target="_blank" rel="noopener noreferrer" href="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Ticket_Details_Manager.png"><img src="https://github.com/2011Canada/project-1-mahesh-kalle/blob/main/Images/Ticket_Details_Manager.png" width="600" style="max-width:100%;"></a>
  </div>
