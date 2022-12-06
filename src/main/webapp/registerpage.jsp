<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
    <form action="RegisterServlet" method="post">
    <div class="container">
    <h1>Register Here!</h1>
    <label for="userName"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="userName">
    
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password">
    
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email">  
    
    <label for="contact"><b>Contact</b></label>
    <input type="text" placeholder="Enter Contact" name="contact">  
        <input type="submit" value="Call Servlet" />
        </div>
    </form>

</body>
