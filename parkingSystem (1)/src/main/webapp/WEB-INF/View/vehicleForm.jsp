
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<title>Insert title here</title>


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
		<a class="active" href="/">Home</a> <a href="#news">News</a>
		<a href="#contact">Contact</a> <a href="#about">About</a>

	</div>

	<div id="vehicleForm" class="container" align=center >
		<h1>Add Vehicle</h1>
		<hr/>
		<br/><br/>
		<form:form modelAttribute="vehicle" >
		<form:errors path="*" cssClass="errorblock" element="div" />
			<div class="form-group row">
				<label for="inputVehicleName3" class="col-sm-2 col-form-label">Vehicle Name</label>
				<div class="col-sm-10">
			<form:input path="vehicleName" class="form-control " id="inputVehicleName3" />
			<form:errors path = "vehicleName" cssClass="CssStyle1"></form:errors>
			</div>
			<br/><br/> 
			</div>
			<div class="form-group row">
				<label for="inputVehicleType3" class="col-sm-2 col-form-label">Vehicle Type</label>
				<div class="col-sm-10">
			<form:select class="form-control " path="type"  id="inputVehicleType3">

				<form:option id="cycle" value="cycle"/>cycle
				<form:option id="twoWheeler" value="twoWheeler"/>two Wheeler
				<form:option id="fourWheeler" value="fourWheeler"/>Four Wheeler
			</form:select><br> <br>
			</div>
			</div>
			
			<div class="form-group row">
				<label for="inputVehicleNumber3" class="col-sm-2 col-form-label">Vehicle Number</label>
				<div class="col-sm-10">
			<form:input type="text" class="form-control "
				path="vehicleNumber" placeholder="RJ14AA0000"
				id="inputVehicleNumber3"/><br> <br> 
				</div></div>
				
				<div class="form-group row">
				<label for="inputEmployeeId" class="col-sm-2 col-form-label" >Employee Id</label>
				<div class="col-sm-10">
				 <form:input type="text" class="form-control "
				path="employeeId"  
				readonly="true" id = "inputEmployeeId" value="${ID}"/><br/><br/> 
				</div></div>
				
				<div class="form-group row">
				<label for="inputTextArea" class="col-sm-2 col-form-label">Identification</label>
			<div class="col-sm-10">
			<textarea rows="2" cols="50" id="inputTextArea" class="form-control "></textarea>
			</div></div>
			<br> <br> 
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-primary">Reset</button>

		</form:form>
	</div>
	<br/><br/>
</body>
</html>