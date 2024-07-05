<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h2>Welcome to the Signup Page</h2>
	
	<form action="esignup" method="post" enctype="multipart/form-data">
		First Name: <input type="text" name="firstName" value="${user_details.firstName}"> 
		<span style="color:red">${firstNameError}</span>
		
		<br><br>
		
		Email: <input type="email" name="email" value="${user_details.email}">
		<span style="color:red">${emailError}</span>
		
		<br><br>
		
		Password: <input type="password" name="password">
		<span style="color:red">${passwordError}</span>
		
		<br><br>
		
		Profile Picture: <input type="file" name="profilePic">
		
		<br><br>
		
		<input type="submit" value="Signup">
		
	</form>
	
</body>
</html>