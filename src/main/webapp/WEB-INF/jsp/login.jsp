<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<h1>Employee Login Page</h1>
		<c:if test="${message ne null }">
			<div class="alert alert-warning"><strong>${message }</strong></div>
		</c:if>
		<c:if test="${param.error != null}">          
        <p>  
            Invalid username and password.  
        </p>  
	    </c:if>  
	    <c:if test="${param.logout != null}">         
	        <p>  
	            You have been logged out.  
	        </p>  
	    </c:if>  
		<form action="authentication" method="post">
			<div class="row">
				<div class="col-md-3">Email</div><div class="col-md-9"><input type="text" id="username" name="email"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Password</div><div class="col-md-9"><input type="text" id="password" name="password"></div>
			</div>
			<input type="hidden"                          
        name="${_csrf.parameterName}"  
        value="${_csrf.token}"/> 
			<button type="submit" class="btn btn-success">Login</button>
		</form>
	</div>
</body>
</html>