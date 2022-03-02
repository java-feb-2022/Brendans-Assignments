<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Showing Expense</title>
</head>
<body>
	<div class="container d-flex flex-column justify-content-center align-items-center">
		<h1 class="text-info">Expense Details</h1>
		<h3>Expense Name: ${expense.name}</h3>
		<h3>Expense Description: ${expense.description}</h3>
		<h3>Vendor: ${expense.vendor}</h3>
		<h3>Amount Spent: ${expense.amount}</h3>
		<a href="/expenses">Go Back</a>
	</div>
</body>
</html>