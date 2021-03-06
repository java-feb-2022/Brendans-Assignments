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
<title>Edit Expense</title>
</head>
<body>
<div class="container mx-auto">
		<h1>Edit an Expense:</h1>
		<form:form action="/expenses/${expense.id}" method="put" modelAttribute="expense"
			class="form-group">
			<input type="hidden" name="_method" value="put"/>
			<form:label path="name">Expense Name:</form:label>
			<form:errors path="name" class="text-danger" />
			<form:input path="name" class="form-control" />
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor" class="text-danger" />
			<form:input path="vendor" class="form-control" />
			<form:label path="amount">Amount:</form:label>
			<form:errors path="amount" class="text-danger" />
			<form:input path="amount" class="form-control" />
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:input path="description" class="form-control" />
			<input type="submit" value="Submit" class="my-2 btn btn-success" />
		</form:form>
		<a href="/expenses">Go Back</a>
	</div>
</body>
</html>