<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New List</title>
</head>
<body>
	<form action = "createNewListServlet" method = "post">
	List Name: <input type = "text" name = "newListName"><br />
	Build Name: <input type = "text" name = "newBuildName"><br />
	
	Available Parts:<br />
	<select name = "allPartsToAdd" multiple size = "6">
		<c:forEach items = "${requestScope.allItems }" var = "currentItem">
			<option value = "${currentItem.partID }">${currentItem.manufacturerName } | ${currentItem.productType } | ${currentItem.productName }</option>
		</c:forEach>
	</select>
	<br />
	<input type = "submit" value = "Create List and Add Parts">
	</form>
	<a href = "index.jsp">Add New Items Instead</a>
</body>
</html>