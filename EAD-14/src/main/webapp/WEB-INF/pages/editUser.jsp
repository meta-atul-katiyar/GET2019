
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Edit User Info</title>

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

.profile-container {
	position: absolute;
	right: 0px;
	top: 60px;
	background-color: white
}

.profile-container img {
	position: relative;
	right: 0px;
	top: 0px;
	background-color: white;
	width: 150;
	height: 180
}

.profile-container button {
	postion: relative;
	top: 240px;
	right: 0px
}
</style>
</head>
<body>
	<div class="topnav">
		<a href="home"> Home</a> <a href="UserHome">About</a> <a
			href="AddUser">Add User</a> <a href="showUser">Show User</a> <a
			style="float: right" href="logout">logout</a>
	</div>
	<div id="empDetail" class="container" align=center>
		<h1>Edit</h1>
		<hr>
		<br /> <br />

		<form:form modelAttribute="user">
			<form:errors path="${Email}" cssClass="error text-warning" />
			<div class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName" cssClass="form-control" id="firstName"
					placeholder="Enter Student frist Name" />
				<form:errors cssClass="error text-warning" path="firstName" />
			</div>

			<div class="form-group">
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName" cssClass="form-control" id="lastName"
					placeholder="Enter Student Last Name" />
				<form:errors cssClass="error text-warning" path="lastName" />
			</div>


			<div class="form-group">
				<form:label path="fatherName">Father Name:</form:label>
				<form:input path="fatherName" cssClass="form-control"
					id="fatherName" placeholder="Enter Father  Name" />
				<form:errors cssClass="error text-warning" path="fatherName" />
			</div>
			<div class="form-group row">
				<label for="contactNumber" class="col-sm-2 col-form-label">Contact
					Number</label>
				<div class="col-sm-10">
					<form:input path="contactNumber" class="form-control"
						id="contactNumber" />
					<form:errors path="contactNumber" cssClass="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input path="email" cssClass="form-control" id="Email"
					placeholder="Enter Email" />
				<form:errors cssClass="error text-warning" path="email" />
			</div>

			<div class="form-group">
				<form:label path="username">Username:</form:label>
				<form:input path="username" class="form-control" readonly="true" />
				<form:errors cssClass="error text-warning" path="username" />
			</div>
			
			<div class="form-group row">
				<label for="role" class="col-sm-2 col-form-label">role</label>
				<div class="col-sm-10">
				<form:select path="role" id="role"
					class="form-control">
					<form:options items="${roleList}" class="form-control"/>
				</form:select>
				</div>
				<form:errors path="role" cssClass="error"></form:errors>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-10">
					<form:input path="password" type="hidden" class="form-control"
						id="password" />
					<form:errors path="password" cssClass="error"></form:errors>
				</div>
			</div>
			

			
			<button type="submit" class="btn btn-primary">Submit</button>

		</form:form>
	</div>
</body>
</html>