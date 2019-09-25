
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
<body style="margin:0">
<div class = "topnav">
<a href="home"> Home</a>
<a href="UserHome">About</a>
<a href="AddUser">Add User</a>
<a href="showUser">Show User</a>
<a style="float:right"  href="logout">logout</a>
</div>

	
	<div class="table-responsive">
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>#</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Father Name</th>
          <th>contactNumber</th>
          <th>Email</th>
          <th>username</th>
          <th> ClickTo Edit</th>
        </tr>
      </thead>
      <tbody>
      <c:if test="${not empty users}">
    	 <c:forEach var="user" items="${users}" varStatus="loopcounter">
    	
         <tr>
          <td> ${loopcounter.count }</td>
          <td> ${user.getFirstName() }</td>
          <td> ${user.lastName}</td>
          <td> ${user.fatherName} </td>
          <td> ${user.contactNumber }</td>
          <td> ${user.email}</td>
          <td> ${user.username}</td>
          <td> <a href="EditUserDetails">Edit</a> </td>
        </tr>		
 	  	</c:forEach>
	  </c:if>
      </tbody>
    </table>
  </div>		
</body>
</html>