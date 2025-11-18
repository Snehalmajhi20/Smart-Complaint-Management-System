<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.*,
				com.scms.model.Complaint,
				com.scms.model.Department,
				com.scms.model.User" %>
				
<%@page session="true" %>
<%
	User user=(User)session.getAttribute("user");
	if(user==null||! "admin".equals(user.getRole()))
	{ 
		response.sendRedirect("login.jsp"); return;
		}
	List<Complaint> complaints=(List<Complaint>)request.getAttribute("complaints");
	List<Department> departments=(List<Department>)request.getAttribute("departments");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Admin Dashboard Page</title>
</head>
<body>
	<div class="container">
		<h2>Admin Dashboard</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>User</th>
				<th>Category</th>
				<th>Description</th>
				<th>Status</th>
				<th>Assigned</th>
				<th>Action</th>
			</tr>
			<% for(Complaint c: complaints){ %>
			<tr>
 				<td><%=c.getId()%></td>
 				<td><%=c.getUserId()%></td>
 				<td><%=c.getCategory()%></td>
 				<td><pre><%=c.getDescription()%></pre></td>
 				<td><%=c.getStatus()%></td>
 				<td><%=c.getAssignedTo()%></td>
 				<td>
  					<form action="updateStatus" method="post">
   						<input type="hidden" name="complaintId" value="<%=c.getId()%>"/>
   						<select name="status">
   							<option>Pending</option>
   							<option>In Progress</option>
   							<option>Resolved</option>
   						</select>
   						<select name="assignedTo">
   							<option><%=c.getAssignedTo()%></option><% for(Department d: departments){ %>
     						<option><%=d.getName()%></option><% } %></select>
   							<button type="submit">Update</button>
  					</form>
 				</td>
			</tr>
			<% } %>
		</table>
		<p><a href="logout">Logout</a></p>
	</div>
</body>
</html>