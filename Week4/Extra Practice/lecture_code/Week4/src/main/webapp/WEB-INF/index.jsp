<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>

<h1>Discover extraordinary NFTs</h1>
<a href="/new">New Art</a>
<table class="table table-dark table-hover">
	<thead>
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${arts}" var="art">
		<tr>
			<td><c:out value="${art.title}"/></td>
			<td><c:out value="${art.description}"/></td>
			<td><a href="/edit/${art.id}" class="text-warning">Edit</a>
			<form:form action="/delete/${art.id}" method="delete">
				<button class="btn btn-danger">Delete</button>
			</form:form>
			</td>
		</tr>
	</c:forEach>
	</tbody>
		
</table>

</body>
</html>