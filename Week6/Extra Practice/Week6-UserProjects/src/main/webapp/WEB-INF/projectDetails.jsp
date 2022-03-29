<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Project Page</title>
</head>
<body>
<div class="container">
	<p>
		<a href="/dashboard">Home</a> || 
		<a href="/new">New Project</a> || 
	    <a href="/logout">Logout</a> ||
	</p>
	<h1>Project Details:</h1>
	<p>${project.projectName}</p>
	<p>${project.description}</p>
	<h4>Created By:</h4>
	<p>${project.user.userName}</p>
	
	<h2>Ratings:</h2>
	<form:form action="/projects/rating" method="put" modelAttribute="newRating">
	    <div class="form-group">
	        <form:label path="rating">Rating:</form:label>
	        <form:errors class="text-danger" path="rating"/>
	        <form:input class="form-control" path="rating"/>
	    </div>
	</form:form>
	<!-- check for viewing user to allow for edit/delete if they are the owner -->
	<c:if test="${project.user.id==loggedInUser.id}">
		<a href="/projects/edit/${project.id}">Edit</a>
		<form:form action="/projects/delete/${project.id}" method="delete">
			<button class="btn btn-danger">Delete</button>
		</form:form>
	</c:if>
</div>
</body>
</html>