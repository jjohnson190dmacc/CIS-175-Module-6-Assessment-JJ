<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Build Lists</title>
</head>
<body>
	<form method = "post" action = "listNavigationServlet">
		<table>
			<c:forEach items = "${requestScope.allLists }" var = "currentList">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentList.listId }"></td>
					<td><h2>${currentList.listName }</h2></td>
				</tr>
				<tr>
					<td colspan = "3">Build List: ${currentList.buildList.buildName }</td>
				</tr>
				<c:forEach var = "listVal" items = "${currentList.listOfParts }">
					<tr>
						<td></td>
						<td colspan = "3">${listVal.manufacturerName }, ${listVal.productType }, ${listVal.productName }</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type = "submit" value = "add" name = "doThisToList">
		<input type = "submit" value = "delete" name = "doThisToList">
		<input type = "submit" value = "update" name = "doThisToList">
	</form>
	<a href = "index.jsp">Return to Main</a>
</body>
</html>