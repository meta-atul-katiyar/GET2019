
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>User Home</title>


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
<body>
	<div class="topnav">
		<a class="active" href="/UserHome">Home</a> 
		<a href="/Friends">Friends</a>
		<a href="/About">About</a>
		<a href="/Logout" style="float:right;">Logout</a>

	</div>
	<div class="container">
	<table>
	
		
    	
    	  <tr>
    	  <th>Name:</th>
          <td> ${emp.getFullName()}</td>
          </tr>
          <tr>
    	  <th>Gender:</th>
          <td> ${emp.getGender()}</td>
          </tr>
          <tr>
    	  <th>Contact:</th>
          <td> ${emp.getContactNumber()}</td>
          </tr>
          <tr>
    	  <th>Email:</th>
          <td> ${emp.getEmail()}</td>
          </tr>
          <tr>
    	  <th>Organization:</th>
          <td> ${emp.getOrganization()}</td>
          </tr>
          
		  <tr>
          <td><a href="/EditUser" >Edit</a></td>
          </tr>
      
          
	</table>
	</div>
		
</body>
</html>