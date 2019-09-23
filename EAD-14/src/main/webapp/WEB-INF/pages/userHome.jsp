
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


</head>
<body>
	
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
        </tr>
      </thead>
      <tbody>
      <c:if test="${not empty user}">
    	 <c:forEach var="user" items="${user}" varStatus="loopcounter">
    	
         <tr>
          <td> ${loopcounter.count }</td>
          <td> ${user.getFirstName() }</td>
          <td> ${user.lastName}</td>
          <td> ${user.fatherName} </td>
          <td> ${user.contactNumber }</td>
          <td> ${user.email}</td>
          <td> ${user.username}</td>
        </tr>		
 	  	</c:forEach>
	  </c:if>
      </tbody>
    </table>
  </div>		
</body>
</html>