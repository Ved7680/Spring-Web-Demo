<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
<style>
h2 {text-align: center;}
</style>
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">

				<h2>Add Product</h2>


				<form action="saveproduct" method="post"  enctype="multipart/form-data">
					<div class="form-group">
						Product Name: <input type="text" name="productName" value="${productDetails.productName}" class="form-control"> 
						<span style="color:red">${productNameError}</span>
					</div>

					<div class="form-group">
						Category: <input type="text" name="category" value="${productDetails.category}" class="form-control">
						<span style="color:red">${categoryError}</span>
					</div>
					
					<div class="form-group">
						Qty: <input type="text" name="qty" value="${productDetails.qty}" class="form-control">
						<span style="color:red">${qtyError}</span>
					</div>
					
					<div class="form-group">
						Price: <input type="text" name="price" value="${productDetails.price}" class="form-control">
						<span style="color:red">${priceError}</span>
					</div>
					
					<div class="form-group">
						MasterImage : <input type="file" name="masterImage" class="form-control"/>
					</div>


					<input type="submit" value="Add Product" class="btn btn-success" /> <br><br>
				</form>
				<br> 
				
				<span class="text-danger">${error}</span>

			</div>
		</div>
	</div>
</body>
</html>