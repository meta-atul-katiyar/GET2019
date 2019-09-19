
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
.profile-container {position: absolute;
					right: 0px;
					top: 60px;
					background-color: white
					}
					
.profile-container img{position: relative;
					right: 0px;
					top: 0px;
					background-color: white;
					width: 150;
					height: 180}
					
.profile-container button{postion:relative;
					top:240px;right:0px}

</style>
</head>
<body>
	<div class="topnav">
		<a class="active" href="/UserHome">Home</a>
		<a href="/CoWorkers">CoWorkers</a>
		<a href="/Friends">Friends</a>
		<a href="/About">About</a>
		<a href="/Logout" style="float:right;">Logout</a>

	</div>

	<div class='profile-container'>
		<img src="images/${imageName}" width="150px" height="180px"/>
		<button type=submit value='change'  onclick= "window.location.href = '/uploadImage'">change</button>
	</div>
	<div class="container">
	<table>
	
		 <c:forEach items="${passList}" var="pass">
    	
    	  <tr>
    	  <th> Vehicle Name:</th>
          <td> ${pass.getVehicleName()}</td>
          </tr>
          <tr>
    	  <th> Vehicle Type:</th>
          <td> ${pass.getType()}</td>
          </tr>
          <tr>
    	  <th> Vehicle Number:</th>
          <td> ${pass.getVehicleNumber()}</td>
          </tr>
          <tr>
    	  <th> Vehicle Identification:</th>
          <td> ${pass.getIdentification()}</td>
          </tr>
          <tr>
    	  <th> Plan Name:</th>
          <td> ${pass.getPlanName()}</td>
          </tr>
          <tr>
    	  <th> Price:</th>
          <td> ${pass.getPrice()}</td>
          </tr>
          <tr>
    	  <th> Vehicle Name:</th>
          <td> ${pass.getGenerationTime()}</td>
          </tr><br/><br/>
          <tr><td><br/></td></tr>
          
          <br/>
    </c:forEach>
    <tr>
          <td><a href="/AddVehicle" > Add New Vehicle</a></td>
          </tr>
	</table>
	</div>
		
</body>
</html>