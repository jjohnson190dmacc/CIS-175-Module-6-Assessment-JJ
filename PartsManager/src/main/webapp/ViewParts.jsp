<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Parts</title>
</head>
<body>
	<form method = "post" action ="navigationController">
		<table>
			<c:forEach items = "${requestScope.allParts }" var ="currentPart">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentPart.partID }"></td>
					<td>${currentPart.manufacturerName } | </td>
					<td>${currentPart.productType } | </td>
					<td>${currentPart.productName }</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "add" name = "userChoiceForPart">
		<input type = "submit" value = "update" name = "userChoiceForPart">
		<input type = "submit" value = "delete" name = "userChoiceForPart">
	</form>
	<a href = "index.jsp">Return to Main</a>
</body>
</html>