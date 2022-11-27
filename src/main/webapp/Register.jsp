<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">
	Name: <input type="text" name="userName">
	Title: <input type="text" name="title">
	Text: <input type="text" name="text">
	Category: <select name="category">
		<option>Test1</option>
		<option>Test2</option>
		<option>Test3</option>
	</select>
	<input type="submit" value="Post Now" />
</form>

</body>
</html>