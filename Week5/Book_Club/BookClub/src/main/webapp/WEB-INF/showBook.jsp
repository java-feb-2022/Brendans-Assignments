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
	<div>
		<h1><i><c:out value="${book.title}"/></i></h1>
		<!-- need to add info about person and other things -->
		<h3><%-- <c:out value="${ } --%></h3>
	</div>
</body>
</html>