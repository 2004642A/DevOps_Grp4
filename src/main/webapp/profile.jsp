<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<div class="row">
		<div class="container">
			<h3 class="text-center">Profile</h3>
			<hr>
 <div align="center">
  <h4>You have logined successfully!</h4>
 </div>
			<!---<br>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Password</th>
						<th>Email</th>
						<th>Language</th>
						<th>Actions</th>
					</tr>
				</thead>
	
				<tbody>
					<c:forEach var="login" items="${listUser}">
						<tr>
							<td><c:out value="${login.name}" /></td>
							<td><c:out value="${login.password}" /></td>
							<td><c:out value="${login.email}" /></td>
							<td><c:out value="${login.contact}" /></td>
							<td><a href="edit?name=<c:out value='${login.name}'/>">Edit</a>
							<a href="delete?name=<c:out value='${login.name}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>-->
		</div>
</div>
</body>
</html>