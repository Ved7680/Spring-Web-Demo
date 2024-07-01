<%@page import="com.bean.EProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	List<EProductBean> product_list = (List<EProductBean>)request.getAttribute("product_list");
	%>
	<h2>Products List</h2>
	
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Action</th>
		</tr>
		 <%
		 for (EProductBean p: product_list){
			 out.print("<tr>");
			 out.print("<td>" + p.getProductId() + "</td><td>" + p.getProductName() + "</td><td> <a href='deleteproduct?productId="+p.getProductId()+"'>Delete</a> | <a href='viewproduct?productId="+p.getProductId()+"'>View</a> </td>");
			 out.print("</tr>");
		 }
		 %>
		
	</table>
	<br><br>
	Link to add new Product: <a href="/newproduct">New Product</a> <br><br>
	Link to delete Product with name: <a href="deleteproduct_name_submit">Delete Product with Name</a>
</body>
</html>