<!-- 
     Jsp page to show the student. 
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>
  <h3>List Of Student</h3>
	<table border ="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Father Name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
		</tr>
		
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.getFirstName()}</td>
				<td>${student.getLastName()}</td>
				<td>${student.getFatherName()}</td>
				<td>${student.getEmail()}</td>
				<td>${student.getStudentClass()}</td>
				<td>${student.getAge()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>