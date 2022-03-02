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
<title>Expense Tracking</title>
</head>
<body>
	<div
		class="container d-flex flex-column justify-content-center align-items-center">
		<h1>Save Travels</h1>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${expenses}" var="exp">
				<tr>
					<td><a href="/expenses/show/${exp.id}" class="text-info"><c:out value="${exp.name}"/></a></td>
					<td><c:out value="${exp.vendor}"/></td>
					<td><c:out value="${exp.amount}"/></td>
					<td><a href="/expenses/edit/${exp.id}" class="text-warning">Edit</a> | <a href="/expenses/delete/${exp.id}" class="text-danger">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container bg-dark text-light">
		<h1>Add an Expense:</h1>
		<form:form action="/expenses" method="post" modelAttribute="expense"
			class="form-group">
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
	</div>
</body>
</html>