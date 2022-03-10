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
<title>Add a New Book</title>
</head>
<body>
	<div class="container d-flex flex-column">
		<h1>Add a Book to your Shelf!</h1>
		<form:form action="/create/book" method="post" modelAttribute="newBook" class="form-group">
			<form:label path="title">Title:</form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input path="title" class="form-control"/>
			<form:label path="author">Author:</form:label>
			<form:errors path="author" class="text-danger"/>
			<form:input path="author" class="form-control"/>
			<form:label path="thoughts">My Thoughts:</form:label>
			<form:errors path="thoughts" class="text-danger"/>
			<form:input path="thoughts" class="form-control"/>
			<form:errors path="user" class="text-danger"/>
			<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
			<input type="submit" value="Add Book" class="btn btn-success my-2">
			<a href="/home" class="btn btn-warning">Back to the Shelves</a>
		</form:form>
	</div>
</body>
</html>