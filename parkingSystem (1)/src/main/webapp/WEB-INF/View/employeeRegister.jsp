
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<title>Employee Registration</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
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

.error {
	font: 11pt verdana;
	font-weight: 70;
	color: red;
}
</style>
</head>

<body>

	<div class="topnav">
		<a class="active" href="/">Home</a> 
		<a href="#contact">Contact</a> <a href="/About">About</a>
	</div>

	<div id="empDetail" class="container" align=center>
		<h1>Register Employee</h1>
		<hr>
		<br />
		<br />
		
		<form:form modelAttribute="employee">
			<%--             <form:errors path="*" cssClass="errorblock" element="div" /><br/><br/> --%>
			<div class="form-group row">
				<label for="fullName" class="col-sm-2 col-form-label">Full
					Name</label>
					<div class="col-sm-10">
						<form:input path="fullName" class="form-control" id="fullName" />
						<form:errors path="fullName" cssClass="error"></form:errors>
			`	</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Gender</label>

				<div class="form-check">
					<form:radiobutton path="gender" class="form-check-input"
						value="male" />
					Male
<!-- 				</div> -->
<!-- 				<div class="form-check-inline"> -->
					<form:radiobutton path="gender" class="form-check-input"
						value="female" />
					Female
<!-- 				</div> -->
<!-- 				<div class="form-check-inline"> -->
					<form:radiobutton path="gender" class="form-check-input"
						value="other" />
					Other
					
				</div>
					<form:errors path="gender" cssClass="error"></form:errors>
			</div>
			

			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email"
						placeholder="example@gmail.com" />
					<form:errors path="email" cssClass="error"></form:errors>
				</div>
			</div>


			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<form:input path="password" class="form-control"
						id="password" />
					<form:errors path="password" cssClass="error"></form:errors>
				</div>
			</div>

			<div class="form-group row">
				<label for="confirmPassowrd" class="col-sm-2 col-form-label">Confirm
					Password</label>
				<div class="col-sm-10">
					<input class="form-control"
						id="confirmPassowrd" onchange="isPassEqual()" />
				</div>
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


			<div class="form-group row">
				<label for="organization" class="col-sm-2 col-form-label">Organization</label>
				<div class="col-sm-10">
				<form:select path="organization" id="organization"
					class="form-control">
					<form:options items="${organizationList}" class="form-control"/>
				</form:select>
				</div>
				<form:errors path="organization" cssClass="error"></form:errors>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-primary">Reset</button>
			<br />
			<br />
                    
                    Already registered?<br />
			<a href="login">Login</a>


		</form:form>
	</div>
</body>

<script>
	function passValid() {
		var pass = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,20}$/, password = document
				.getElementById("password").value;
		if (password.match(pass)) {
			return true;
		} else {
			alert("password must contain one numeric, one small letter, one capital letter, one of these !@#$%^&* and length between 6-20");
			return false;
		}
	}

	/* function contactValid(){
	 var cont = /^\d{8}$/,
	 contact =  document.getElementById("contactNumber").value;
	
	 if(/^\d{8}$/.test(contact)){
	 return true;
	 }
	 else{
	 alert("enter valid number");
	 }
	 } */

	/* function allLetter(){
	 var letters = /^[A-Za-z\s]+$/;
	 var inputtxt = document.getElementById("fullName");
	 if((inputtxt.value.match(letters))){
	 return true;
	 }
	 else{
	 alert("enter valid name");
	 return false;
	 }
	 }
	 */

	function isPassEqual() {
		var pass = document.getElementById("password").value, confirmPass = document
				.getElementById("confirmPassowrd").value;
		if (pass != confirmPass) {
			alert("password not matched");
			document.getElementById("confirmPassword").value = "";
			return true;
		} else {
			
			return false;
		}
	}

	/* function hideEmpDetail(){
	 if(ValidateEmail() && allLetter() && passEqual()){
	 document.getElementById("empDetail").style.display = "none";
	 document.getElementById("successfulRegister").innerHTML = "welcome, successfully register by E12/000000"
	 document.getElementById("vehicleForm").style.display = "block";

	 }
	 }
	 */

	function vNumValid() {
		var vehicleNum = /^[A-Z][A-Z]\d\d[A-Z][A-Z]\d{4}$/, vnum = document
				.getElementById("vehicleNumber").value;

		if (vnum.match(vehicleNum)) {
			return true;
		} else {
			alert("vehicle number is not in format");
		}
	}

	// used to show the rate cards in different currency
	function rateCard() {
		var type = document.getElementById("vehicleType").value, currency = document
				.getElementById("currencyName").value, exchangeFromRupee = 1;
		console.log("fffff: ", currency);
		if (currency == "USD") {
			exchangeFromRupee = 0.014;
		} else if (currency == "YEN") {
			exchangeFromRupee = 1.47;
		}

		//    document.getElementById("vehicleTypeName").innerHTML = document.getElementById(type).innerHTML;
		//    document.getElementById("NameOfCurrency").innerHTML = document.getElementById(currency).innerHTML;

		if (type == "cycle") {
			document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 5;
			document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 100;
			document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 500;
		} else if (type == "twoWheeler") {
			document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 10;
			document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 200;
			document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 1000;
		} else if (type == "fourWheeler") {
			document.getElementById("dailyPrice").innerHTML = exchangeFromRupee * 20;
			document.getElementById("monthlyPrice").innerHTML = exchangeFromRupee * 500;
			document.getElementById("yearlyPrice").innerHTML = exchangeFromRupee * 3500;
		}
		document.getElementById("rateTable").style.display = "block";
	}

	//// display the price
	//function displayRate()
	//{
	//	 
	//  var varvehicleType = document.getElementById("vehicleType").value,
	//    vehicleNumber = document.getElementById("vehicleNumber").value,
	//    employeeId = document.getElementById("employeeId").value;
	//
	//  if(vehicleName != "" && vehicleType != "select type" && vehicleNumber != "" && employeeId != ""){
	//    document.getElementById("vehicleForm").style.display = "none";
	//    document.getElementById("rateInfo").style.display = "block";
	//  }
	//}

	// generate a price message for selected of selected plan
	function priceList(duration) {
		var price = document.getElementById(duration).innerHTML;
		document.getElementById("passID").innerHTML = "Pass price of your selected plan is"
				+ price;
	}

	// function to generate pass for selected plan
	function generatePass() {
		document.getElementById("passID").style.display = "block";
	}
</script>
</html>