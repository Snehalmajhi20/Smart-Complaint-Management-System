<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Registration page</title>
</head>
<body>
	<div class="container">
		<h2>Register</h2>
		<form action="register" method="post">
			<input name="name" placeholder="Full name" required>
			<input type="email" name="email" placeholder="Email" required>
			<input type="password" name="password" placeholder="Password" required>
			<button type="submit">Register</button>
		</form>
	</div>
</body>
</html>