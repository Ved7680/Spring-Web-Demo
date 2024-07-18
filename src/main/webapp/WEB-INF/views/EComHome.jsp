<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
<h1>Home Page</h1> <br><br> 

<h4>Welcome, ${user.firstName}</h4>

&nbsp;&nbsp; <img alt="" src="${profilePicPath}" height="100px" width="100px"> <br><br>

&nbsp;&nbsp; <a href="userproducts">  <button type="button" class="btn btn-success">Products</button>  </a>

</body>
</html>