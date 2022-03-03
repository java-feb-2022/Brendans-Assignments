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
<title>New Art</title>
</head>
<body>
	<div class="container">
		<h1>New Art</h1>
		<form:form action="/create" method="post" modelAttribute="art"
			class="form-group">
			<form:label path="title">Title:</form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input path="title" class="form-control" />
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:input path="description" class="form-control" />
			<input type="submit" value="Submit" class="btn btn-success my-2">
		</form:form>
	</div>
</body>
</html>