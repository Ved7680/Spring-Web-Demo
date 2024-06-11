<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the SignUp Page</h1>
	
	<form action="saveUser" method="post">
		First Name: <input type = "text" name="firstName">
		<br><br>
		Email: <input type = "email" name="email">
		<br><br>
		Password: <input type = "password" name="password">
		<br><br>
		<input type = "submit" value="Signup">
	</form>
</body>
</html>