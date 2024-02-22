<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Parts</title>
</head>
<body>
	<form action = "editPartServlet" method = "post">
		Manufacturer's Name: <input type = "text" name ="manuName" value ="${partToUpdate.manufacturerName }">
		Product Type: <input type = "text" name ="prodType" value ="${partToUpdate.productType }">
		Product Name: <input type = "text" name ="prodName" value ="${partToUpdate.productName }">
		<input type = "hidden" name = "id" value ="${partToUpdate.partID }">
		<input type = "submit" value = "Update Part">
	</form>
</body>
</html>