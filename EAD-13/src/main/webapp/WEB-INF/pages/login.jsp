<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body align = "center">
	<h2>Login</h2>
	<form action="/login"  method="POST">
		<h4 class="text-danger">${errorMsg}</h4>
				User:
				<input type='text' name='username'><br/><br/>
				Password:
			   <input type='password' name='password' /><br/><br/>
			  <input type="submit" name="submit" value="Submit" />
	</form>
</body>
</html>