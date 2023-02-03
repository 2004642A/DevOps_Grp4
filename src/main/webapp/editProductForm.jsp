<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit product form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
	<div>
		<a class="navbar-brand"> Product Management Application </a>
	</div>
	<ul class="navbar-nav">
		<li><a href="<%=request.getContextPath()%>/ProductServlet"
			class="nav-link">Back to Dashboard</a></li>
	</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${product != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${product == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${product != null}">
Edit Product
</c:if>
						<c:if test="${product == null}">
Add New Product
</c:if>
					</h2>
				</caption>
				<c:if test="${product != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${product.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out
value='${product.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Category</label> <input type="text"
						value="<c:out
value='${product.category}' />"
						class="form-control" name="category">
				</fieldset>
				<fieldset class="form-group">
					<label>Price</label> <input type="number"
						value="<c:out
value='${product.price}' />" class="form-control"
						name="price">
				</fieldset>
				<fieldset class="form-group">
					<label> Image</label> <input type="text"
						value="<c:out
value='${product.image}' />" class="form-control"
						name="image">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>