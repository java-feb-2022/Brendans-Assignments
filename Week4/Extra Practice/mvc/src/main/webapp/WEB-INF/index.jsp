<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Books</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Number of Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBook" items="${books}">
			<tr>
				<td><c:out value="${oneBook.id}"/></td>
				<td><c:out value="${oneBook.title}"/></td>
				<td><c:out value="${oneBook.language}"/></td>
				<td><c:out value="${oneBook.numberOfPages}"/></td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>