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
		<h1>Add Shift</h1>
		<c:if test="${message ne null}">
			<div class="alert alert-success"><strong>${message}</strong></div>
		</c:if>
		
		<form action="addShift" method="post">
			<div class="row">
				<div class="col-md-3">StartTime</div><div class="col-md-9"><input type="datetime" name="name"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">EndTime</div><div class="col-md-9"><input type="time" name="age"></div>
			</div>
		</form>
	</div>
</body>
</html>