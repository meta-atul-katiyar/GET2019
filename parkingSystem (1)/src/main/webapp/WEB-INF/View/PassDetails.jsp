<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Price List</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div align="center">
<%-- 	<form:form modelAttribute="passType"> --%>
<!-- 	     <h2>Select your plan</h2> -->
<!-- 	     <table border = 1> -->
<!-- 	           <tr> -->
<!-- 	           <th>Plna</th> -->
<!-- 	           <th> Price in INR</th> -->
<!-- 	           </tr> -->
	           
<%-- 	           <c:forEach items="${priceList}" var="price"> --%>
<!-- 	           <tr> -->
<!-- 	              <td>Daily</td> -->
<!-- 	              <td>price</td> -->
<!-- 	           </tr> -->
<%-- 	           </c:forEach> --%>
<!-- 	     </table> -->
<%-- 	     </form:form> --%>
<form:form modelAttribute="passDetailDB">
 <table border='5px'>
           
                <tr>
                    <th>Plan name</th>
                    <th>Price</th>
                    <th>Select</th>
                </tr>
    		<c:forEach items="${priceList}" var="price" >
    		<tr>
    	  	<td> ${price.getPlanName()}</td>
          	<td> ${price.getPrice()*5}</td>
          	<td> <form:radiobutton path="priceListId" value="${price.getID()}" /> </td>
          	</tr><br/>
    		</c:forEach>
			<tr>
			
			</tr>
        </table>
        <button type="submit" class="btn btn-primary">Get Pass</button>
         </form:form>
	</div>

</body>
</html>