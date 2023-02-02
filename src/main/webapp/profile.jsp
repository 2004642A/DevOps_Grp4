<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	 <title>Profile</title>
	 <style>
body {
    font-family: Arial, sans-serif;
}

.profile-card {
    width: 500px;
    margin: 50px auto;
    text-align: center;
    background-color: #f2f2f2;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 2px 2px 10px #ccc;
}

.profile-card h1 {
    font-size: 36px;
    margin-bottom: 20px;
}

.profile-info ul {
    list-style: none;
    padding: 0;
    margin: 30px 0;
}

.profile-info li {
    font-size: 18px;
    padding: 10px;
    border-bottom: 1px solid #ccc;
}

.profile-info li:last-child {
    border-bottom: none;
}
</style>
</head>
<body>
 <div class="profile-card">
        <h1>Welcome, <%= request.getSession().getAttribute("name") %>!</h1>
        <div class="profile-info">
            <ul>
                <li>Username: <%= request.getSession().getAttribute("name") %></li>
                <li>Email: <%= request.getAttribute("email") %></li>
                <li>Contact no: <%= request.getAttribute("contact") %></li>
            </ul>
        </div>
    </div>
</body>
</html>