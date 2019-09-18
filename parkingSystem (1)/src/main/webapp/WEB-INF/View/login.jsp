
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

.CssStyle1 {
	font: 11pt verdana;
	font-weight: 70;
	color: red;
}
</style>
</head>
<body>
	<div class="topnav">
		<a class="active" href="/">Home</a>
		
	</div>
	<br />
	
<%-- 	<p>${logoutMessage}</p><br/> --%>
	
	<div class="container" align=center>
		<form:form modelAttribute="employee" >
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">
					Email</label>
					<div class="col-sm-10">
						<form:input path="email" class="form-control" id="email" />
							</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">
					Password</label>
					<div class="col-sm-10">
						<form:input path="password" class="form-control" id="password"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form:form>
	</div>
</body>
</html>