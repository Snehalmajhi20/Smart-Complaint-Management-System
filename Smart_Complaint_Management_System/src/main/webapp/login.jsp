<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Login</title>
</head>
<body>
	<div class="container">
		<h2>Login</h2>
		<c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>
		<form action="login" method="post">
			<input type="email" name="email" placeholder="Email" required>
			<input type="password" name="password" placeholder="Password" required>
			<button type="submit">Login</button>
		</form>
		<p>
			<a href="register.jsp">Create account</a>
		</p>
	</div>
</body>
</html>