<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload image</title>
</head>
<body>

<a>Profile Upload:</a>
Select file: <br />
<form action="uploadImage?empId="+<%= request.getParameter("empId") %> method="post"
                        enctype="multipart/form-data">
<input  type="hidden" name="empId"  size="50" value=<%= request.getParameter("empId") %>></input>
<input type="file" name=ImageFile size="50" />
<br />
<input type="submit" value="Upload File" />
</form>
</body>
</html>
