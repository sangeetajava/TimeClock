<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>All Shifts</title>
	</head>
	<body>
		<div class="container">
		<%@ include file="header.jsp" %>
		<h1>List of all shifts</h1>
		<c:if test="${message ne null}">
			<div class="alert alert-success">
				<strong>${message}</strong>
			</div>
		</c:if>
		<!-- Table creation START-->
		<a href="getEmployee"><button type="button" class="btn btn-success">Emp Details</button></a>
		<table class="table table-hover table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Status</th>
					<th>Start</th>
					<th>end</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${shifts}" var="shift"> 
					<tr>
						<td>${shift.status}</td>
						
						<td>${shift.startTime }</td>
						<td>${shift.endTime }</td>
						<td>
							<c:if test="${shift.status eq 'Working'}">
								<a href="endShift"><button type="button" class="btn btn-danger">End Shift</button></a>
							</c:if>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- Table creation END-->
		</div>
	</body>
</html>