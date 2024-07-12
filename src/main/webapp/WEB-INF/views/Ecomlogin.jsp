<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login Page</h2> <br><br><br>
	<form action="elogin" method="post">
		Email: <input type="text" name="email"> 
		<span style="color:red">${loginerror}</span>
		
		<br><br>
		
		Password: <input type="password" name="password"> <br><br>
		<span style="color:red">${loginerror}</span>
		
		<input type="submit" value="Login"> 
	</form>
</body>
</html>