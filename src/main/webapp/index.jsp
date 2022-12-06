<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DevOps e-Commerce</title>
</head>
<body>
<h1 align=center>Welcome to DevOps Group 4 e-Commerce</h1>
<!-- Create a form with the action attribute to specific where to send the form-data when
the form is submitted, method attribute to specific the method used (GET, POST, PUT, DELETE,
Etc.) -->

<form action="register.jsp" method="post">
<input type="submit" value="Sign up"/>
</form>
<form action="UserServlet/dashboard" method="post">
<input type="submit" value="Manage Users"/>
</form>

<div class = "card-header my-3"> All Products</div>
</body>
</html>