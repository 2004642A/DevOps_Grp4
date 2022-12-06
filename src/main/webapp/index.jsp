<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DevOps e-Commerce</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
	<h1 align=center>Welcome to DevOps Group 4 e-Commerce</h1>
	<!-- Create a form with the action attribute to specific where to send the form-data when
the form is submitted, method attribute to specific the method used (GET, POST, PUT, DELETE,
Etc.) -->

	<form action="registerpage.jsp" method="post">
		<input type="submit" value="Sign up" />
	</form>
	<form action="UserServlet/dashboard" method="post">
		<input type="submit" value="Manage Users" />
	</form>
	<form action="AllProductsServlet" method="post">
		<input type="submit" value="All Products" />
	</form>
	


	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<div class="col-md-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="..." alt="Card image cap">
					<div class="card-body">
						<h5 class="name">${product.name}</h5>
						<h6 class="price">Price: $</h6>
						<h6 class="category">Category: some category</h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="#" class="btn btn-primary">Add to Cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
</body>
</html>