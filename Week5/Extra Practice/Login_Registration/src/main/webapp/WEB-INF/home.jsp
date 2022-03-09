<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<c:out value="${userLog.userName}"/>
		</h1>
		<p>This is your dashboard. Nothing to see here yet.</p>
		<a href="/logout" class="btn btn-danger">Logout</a>
	</div>
</body>
</html>