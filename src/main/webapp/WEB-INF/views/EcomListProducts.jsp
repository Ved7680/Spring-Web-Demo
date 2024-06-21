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
		</tr>
		 <%
		 for (EProductBean p: product_list){
			 out.print("<tr>");
			 out.print("<td>" + p.getProductId() + "</td><td>" + p.getProductName() + "</td>");
			 out.print("</tr>");
		 }
		 %>
		
	</table>
</body>
</html>