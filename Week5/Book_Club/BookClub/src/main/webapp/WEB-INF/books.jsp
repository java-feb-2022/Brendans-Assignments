<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Home Page</title>
</head>
<body>
	<div class="container justify-content-center align-items-center d-flex flex-column">
		<h1>
			Welcome,
			<c:out value="${user.name}"/>
		</h1>
		<p>Books from everyone's shelves:</p>
		<a href="/books/new">+ Add a book to my shelf!</a>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.name}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/logout" class="btn btn-danger">Logout</a>
	</div>
</body>
</html>