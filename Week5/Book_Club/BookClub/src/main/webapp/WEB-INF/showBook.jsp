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
<title>Show Selected Book</title>
</head>
<body>
	<div class="container justify-content-center align-items-center d-flex flex-column">
		<h1><i><c:out value="${book.title}"/></i></h1>
		<!-- need to add info about person and other things -->
		<h3><span class="text-danger"><c:out value="${book.user.name}"/></span> read <span class="text-primary"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.author}"/></span>.</h3>
		<h3>Here are <c:out value="${book.user.name}"/>'s thoughts:</h3>
		<p><c:out value="${book.thoughts}"/></p>
		<a href="/home" class="btn btn-warning my-2">Back to the Shelves</a>
	</div>
</body>
</html>