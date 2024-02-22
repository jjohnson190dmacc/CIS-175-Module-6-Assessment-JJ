<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Existing List</title>
</head>
<body>
	<form action = "editBuildListDetailsServlet" method = "post">
		<input type = "hidden" name = "id" value = "${listToUpdate.listId }">
		List Name: <input type = "text" name = "listName" value = "${listToUpdate.listName }"><br />
		Build Name: <input type = "text" name = "buildName" value = "${listToUpdate.buildList.buildName }"><br />
		
		Available Parts: <br />
		
		<select name = "allPartsToAdd" multiple size = "6">
			<c:forEach items = "${requestScope.allItems }" var = "currentPart">
				<option value = "${currentPart.partID }">${currentPart.manufacturerName } | ${currentPart.productType } | ${currentPart.productName }</option>
			</c:forEach>
		</select>
		<br />
		<input type = "submit" value = "Edit List and Add Parts">
	</form>
	<a href = "index.jsp">Add New Items Instead</a>
</body>
</html>