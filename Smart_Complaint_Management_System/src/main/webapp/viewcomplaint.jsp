<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,
                com.scms.model.Complaint,
                com.scms.model.User" %>
<%@page session="true" %>
<%
	User u=(User)session.getAttribute("user"); 
	if(u==null)
	{ 
		response.sendRedirect("login.jsp"); 
		return;
		}
	List<Complaint> complaints = (List<Complaint>)request.getAttribute("complaints");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>View Complaint</title>
</head>
<body>
	<div class="container">
		<h2>My Complaints</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>Category</th>
				<th>Description</th>
				<th>Status</th>
				<th>Assigned</th>
				<th>Created</th>
			</tr>
			<% for(Complaint c: complaints){ %>
 			<tr>
 				<td><%=c.getId()%></td>
 				<td><%=c.getCategory()%></td>
 				<td><pre><%=c.getDescription()%></pre></td>
 				<td><%=c.getStatus()%></td>
 				<td><%=c.getAssignedTo()%></td>
 				<td><%=c.getCreatedAt()%></td>
 			</tr>
			<% } %>
		</table><p><a href="addcomplaint.jsp">Submit new</a> • <a href="logout">Logout</a></p>
	</div>
	
</body>
</html>