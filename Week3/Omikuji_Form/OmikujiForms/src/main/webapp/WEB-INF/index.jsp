<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Omikuji</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<h1>Send an Omikuji!</h1>
			<form action="/process" method="post" class="form-group border border-dark py-2 px-4">
				<label>Pick a number from 5 to 25:</label>
				<input type="number" name="number" class="form-control">
				<label>Enter the name of any city:</label>
				<input type="text" name="city" class="form-control">
				<label>Enter the name of a real person:</label>
				<input type="text" name="person" class="form-control">
				<label>Enter a professional endeavor or hobby:</label>
				<input type="text" name="hobby" class="form-control">
				<label>Enter any type of living thing:</label>
				<input type="text" name="living" class="form-control">
				<label>Say something nice to someone:</label>
				<textarea rows="5" cols="25" name="nice" class="form-control"></textarea>
				<p><i>Send and show a friend!</i></p>
				<input type="submit" value="Send" class="btn btn-primary ">
		</form>
	</div>
</body>
</html>