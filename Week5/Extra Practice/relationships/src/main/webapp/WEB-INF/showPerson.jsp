<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person Details</title>
</head>
<body>
<h1>Person Details:></h1>
<table class="table">
    <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>License Number</th>
            <th>State</th>
            <th>Exp Date</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <c:out value="${person.firstName}"/>
                <c:out value="${person.lastName}"/>
            </td>
            <td><c:out value="${person.license.state}"/></td>
            <td><c:out value="${person}"/></td>
            <td>
                <c:out value="${person.license.expirationDate}"/>
            </td>
        </tr>
    </tbody>
</table>
</body>
</html>