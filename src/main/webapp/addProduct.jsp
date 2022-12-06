<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product and its Details</title>
</head>
<body>
    <form action="./ProductServlet/insert" method="post">
        Name: <input type="text" name="productname"> 
        Category: <input type="text" name="category"> 
        Price: <input type="number" name="price"> 
        Image link: <input type="text" name="image">
        <input type="submit" value="Add Product" />
    </form>

</body>

</html>