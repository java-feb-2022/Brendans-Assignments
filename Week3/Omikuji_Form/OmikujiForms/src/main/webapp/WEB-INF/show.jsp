<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Your Omikuji!</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 class="text-center">Here's Your Omikuji!</h1>
	<div class="container d-flex justify-content-center bg-info border border-dark col-3">
		<h3>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, selling <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${living}"/>, you will have good luck. Also, <c:out value="${nice}"/>.</h3>
	</div>
	<div class="container d-flex justify-content-center align-items-center">
		<a href="/">Go Back</a>
	</div>
</body>
</html>