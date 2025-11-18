<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@page import="com.scms.model.User" %>
<%@page session="true" %>
<%
 User usr=(User)session.getAttribute("user");
 if(usr==null)
 { 
	 response.sendRedirect("login.jsp"); 
	 return;
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Add Complaint</title>
</head>
<body>
	<div class="container">
		<h2>Submit Complaint</h2>
		<form action="addComplaint" method="post">
			<select name="category">
				<option>Electricity</option>
				<option>Water</option>
				<option>Cleaning</option>
				<option>Internet</option>
			</select>
			<textarea name="description" placeholder="Describe issue" required></textarea>
			<button type="submit">Submit</button>
		</form>
			<p>
				<a href="myComplaints">My Complaints</a> • <a href="logout">Logout</a>
			</p>
	</div>
</body>
</html>