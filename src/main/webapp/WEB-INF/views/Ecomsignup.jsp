<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">

				<h2>Ecom Signup</h2>


				<form action="esignup" method="post" enctype="multipart/form-data">
					<div class="form-group">
						First Name: <input type="text" name="firstName" class="form-control" /> 
						<span style="color:red">${firstNameError}</span>
					</div>
					
					<div class="form-group">
						Email: <input type="email" name="email" class="form-control" />
						<span style="color:red">${emailError}</span>
					</div>
					
					<div class="form-group">
						Password: <input type="password" name="password" class="form-control" />
						<span style="color:red">${passwordError}</span>
					</div>
					
					<div class="form-group">
						Profile Picture: <input type="file" name="profilePic" class="form-control" />
					</div>


					<input type="submit" value="Signup" class="btn btn-success" />

				</form>
				<br> 
				
				<span class="text-danger">${error}</span>

			</div>


		</div>

	</div>
</body>
</html>