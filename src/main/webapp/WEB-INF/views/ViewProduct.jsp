<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product</title>
</head>
<body>
	<h2>View Product</h2>

	Product Name :  ${product.productName }<br> 
	Price :${product.price }<br>
	Category:${product.category }<br>
	Qty : ${product.qty }<br>
	<img alt="" src="${product.productImagePath}" height="300px" width="300px"> <br><br>
</body>
</html>