<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Login Page</title>
<style>
	
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
	</style>
</head>
<body align = "center">
<div class = "topnav">
<a href="home"> Home</a>
<a href="UserHome">About</a>
<a href="AddUser">Add User</a>
<a href="showUser">Show User</a>
</div>

<div class="container ">
	<h2>Login</h2>
	<form action="/login"  method="POST">
		<h4 class="text-danger">${errorMsg}</h4>
				<div class="form-group">
				<label >User Name:</label> 
				<input cssClass="form-control" type='text' name='username'></div>
				
				<div class="form-group">
				<label >Password:</label> 
			   <input cssClass="form-control" type='password' name='password' /></div>
			  <input type="submit" name="submit" value="Login" />
	</form>
	
	</div>
</body>
</html>