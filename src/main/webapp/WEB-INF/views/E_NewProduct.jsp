<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<form action="saveproduct" method="post" enctype="multipart/form-data">
		Product Name: <input type="text" name="productName" value="${productDetails.productName}"> 
		<span style="color:red">${productNameError}</span>
		
		<br><br>
		
		Category: <input type="text" name="category" value="${productDetails.category}">
		<span style="color:red">${categoryError}</span>
		
		<br><br>
		
		Qty: <input type="text" name="qty" value="${productDetails.qty}">
		<span style="color:red">${qtyError}</span>
		
		<br><br>
		
		Price: <input type="text" name="price" value="${productDetails.price}">
		<span style="color:red">${priceError}</span>
		
		<br><br>
		
		MasterImage : <input type="file" name="masterImage"/>
		
		<br><br>
		
		<input type="submit" value="Add Product">
	</form>
</body>
</html>