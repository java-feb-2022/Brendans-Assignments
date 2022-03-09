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
<title>Login & Registration</title>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center flex-column mx-auto">
		<h1>Welcome!</h1>
		<h3>Join our growing community.</h3>
	</div>
	<div class="d-flex container-md">
		<div class="container justify-content-center align-items-center col-4">
			<h1>Register</h1>
			<form:form action="/register" method="post" modelAttribute="newUser" class="form-group">
				<form:label path="userName">User Name:</form:label>
				<form:errors path="userName" class="text-danger"/>
				<form:input path="userName" class="form-control"/>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="text-danger"/>
				<form:input path="email" class="form-control"/>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" class="text-danger"/>
				<form:password path="password" class="form-control"/>
				<form:label path="confirm">Confirm PW:</form:label>
				<form:errors path="confirm" class="text-danger"/>
				<form:password path="confirm" class="form-control"/>
				<input type="submit" value="Register" class="btn btn-success my-2">
			</form:form>
		</div>
		<div class="container justify-content-center align-items-center col-4">
			<h1>Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin" class="form-group">
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="text-danger"/>
				<form:input path="email" class="form-control"/>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" class="text-danger"/>
				<form:password path="password" class="form-control"/>
				<input type="submit" value="Login" class="btn btn-success my-2">
			</form:form>
		</div>
	</div>
</body>
</html>