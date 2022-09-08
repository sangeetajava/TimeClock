<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Index page</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			
			<c:if test="${sessionScope.emp.email ne null }">
				Welcome : ${sessionScope.emp.email }
			</c:if>
			</br>
			</br>
			
			<a href="registration"><button type="button" class="btn btn-warning">Register Employee</button></a>
			<c:choose>
				<c:when test="${sessionScope.emp.name ne null }">
					<a href="addShift"><button type="button" class="btn btn-success">Add Shift</button></a>
					<a href="employeeShifts"><button type="button" class="btn btn-primary">All Shift</button></a>
					<a href="logout"><button type="button" class="btn btn-danger">Logout</button></a>
				</c:when>
				<c:otherwise>
					<a href="login"><button type="button" class="btn btn-danger">Login</button></a>					
				</c:otherwise>
			</c:choose>
			
			
			<!-- Button's learning END-->
		
		</div>
	</body>
</html>