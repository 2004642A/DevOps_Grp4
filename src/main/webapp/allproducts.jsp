<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="container">
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
			</div>
			<br>
			<h1 align=center>All Products</h1>
			<c:forEach var="product" items="${listProducts}">
				<div class="row">
					<div class="col-md-3">
						<div class="card w-150" style="width: 18rem;">
							<img class="card-img-top" src="${product.image}"
								alt="Card image cap">
							<div class="card-body">
								<h5>
									<c:out value="${product.name}" />
								</h5>
								<h6>
									<c:out value="${product.category}" />
								</h6>
								<h6>
									<c:out value="$ ${product.price}" />
								</h6>
								<div class="mt-3 d-flex justify-content-between">
									<a href="#" class="btn btn-primary">Add to Cart</a>
								</div>
								<!--  <form action="addToCart" method="post">
                        <input type="hidden" name="name" value="$ ${product.name} " />
                        <input type="hidden" name="price" value="$ ${product.price}" />
                       <input type="submit" value="Cart" />
                 </form>-->
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

</body>
</html>
