<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="hello">  
		First Name : <input type="text" name="firstName"/> <br><br>  
		Last Name : <input type="text" name="lastName"/> <br><br> 
		Father Name : <input type="text" name="fatherName"/> <br><br> 
		Email : <input type="text" name="email"/> <br><br>  
		Standard : <input type="number" name="standard"/> <br><br> 
		Age : <input type="number" name="age"/> <br><br> 
		<input type="submit" name="submit" onclick=printValues()>
	</form>  
</body>

<script>
	function printValues()
{
	
		console.log("first name: ", document.getElementByName("fistName").value);
		console.log("last name: ", document.getElementByName("fistName").value);
		console.log("father's name: ", document.getElementByName("fatherName").value);
		console.log("email: ", document.getElementByName("email").value);
		console.log("standard: ", document.getElementByName("standard").value);
		console.log("age: ", document.getElementByName("age").value);
	}
	
</script>

</html>