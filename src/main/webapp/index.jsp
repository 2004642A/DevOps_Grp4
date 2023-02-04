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
    <h1 align=center>Welcome to DevOps Group 4 e-Commerce!!!!</h1>
    <!-- Create a form with the action attribute to specific where to send the form-data when
the form is submitted, method attribute to specific the method used (GET, POST, PUT, DELETE,
Etc.) -->

    <form action="registerpage.jsp" method="post">
        <input type="submit" value="Sign up" />
    </form>
    <form action="login.jsp" method="post">
        <input type="submit" value="Log in" />
    </form>
    <form action="UserServlet/dashboard" method="post">
        <input type="submit" value="Manage Users" />
    </form>
    <form action="AllProductsServlet" method="post">
        <input type="submit" value="All Products for Customers" />
    </form>
    <form action="ProductServlet" method="post">
        <input type="submit" value="Manage Products for Admin" />
    </form>

</body>
</html>
