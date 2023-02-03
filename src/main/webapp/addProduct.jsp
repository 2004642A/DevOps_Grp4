<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product and its Details Jenkins Test</title>
</head>
<body>
    <form action="AddProductServlet" method="post">
        Name: <input type="text" name="productname" id="name"> 
        Category: <input type="text" name="category" id="category"> 
        Price: <input type="number" name="price" id="price"> 
        Image link: <input type="text" name="image" id="image">
        <input type="submit" value="Add Product" id="submit"/>
    </form>

</body>

</html>