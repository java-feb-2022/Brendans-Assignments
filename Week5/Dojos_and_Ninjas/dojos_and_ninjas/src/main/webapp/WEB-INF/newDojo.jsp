<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>New Dojo</title>
</head>
<body>
	<div class="container bg-dark text-light">
		<h1>New Dojo</h1>
		<form:form action="/dojo/create" method="post" modelAttribute="dojo" class="form-group">
			<form:label path="name">Name:</form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path="name" class="form-control"/>
			<input type="submit" value="Create Dojo" class="btn btn-success my-2">
		</form:form>
	</div>
</body>
</html>