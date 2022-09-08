<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
		<h1>Employee Details</h1>
		<div>Emp ID : ${employee.id }</div>
		<div>Emp Name : ${employee.name }</div>
		<div>Emp Salary : ${employee.salary }</div>
		<div>Emp Department : ${employee.department }</div>
		<div>Profile: ${employee.profile }</div>
		<div>Emp Address : ${employee.address }</div>
		<div>Emp password : ${employee.password }</div>
	</div>
</body>
</html>