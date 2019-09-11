<!-- 
    Jsp page for student registration page.  
 -->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<title>Student Detail Page</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="student">
			<h1>Student Detail Form</h1>
			
					First Name :
					<form:input path="firstName"  /><br/>
					<form:errors path = "firstName" cssClass="text-danger"></form:errors>
					<br/>
				
					Last Name
					<form:input path="lastName"  /><br/>
					<form:errors path = "lastName" cssClass="text-danger"></form:errors>
					<br/>
				
					Father Name
					<form:input path="fatherName"  /><br/>
					<form:errors path = "fatherName" cssClass="text-danger"></form:errors>
					<br/>
		
					Email
					<form:input path="email" /><br/>
			    	<form:errors path = "email" cssClass="text-danger"></form:errors>
			    	<br/>
				
					Class
					<form:input path="studentClass"  /><br/>
					<form:errors path = "studentClass" cssClass="text-danger"></form:errors>
					<br/>
				
					Age
					<form:input path="age" /><br/>
					<form:errors path = "age" cssClass="text-danger"></form:errors>
					<br/>
		
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>