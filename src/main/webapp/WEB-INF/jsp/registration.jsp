<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Employee</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
		<h1>Employee Registration Page</h1>
		<c:if test="${message ne null}">
			<div class="alert alert-success"><strong>${message}</strong></div>
		</c:if>
		
		<form action="registerEmployee" method="post">
			<div class="row">
				<div class="col-md-3">EmployeeName</div><div class="col-md-9"><input type="text" name="name"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">EmployeeAge</div><div class="col-md-9"><input type="number" name="age"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">SALARY</div><div class="col-md-9"><input type="number" name="salary"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Department</div><div class="col-md-9"><input type="text" name="department"></div>
			</div>	
			<br>
			<div class="row">
				<div class="col-md-3">Address</div><div class="col-md-9"><input type="text" name="address"></div>
			</div>	
			<div class="row">
				<div class="col-md-3">Email</div><div class="col-md-9"><input type="text" name="email"></div>
			</div>
			<div class="row">
				<div class="col-md-3">Password</div><div class="col-md-9"><input type="text" name="password"></div>
			</div>
			<button type="submit" class="btn btn-success">Register</button>
		</form>
	</div>
</body>
</html>