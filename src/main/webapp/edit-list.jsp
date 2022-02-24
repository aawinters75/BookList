<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit An Existing List</title>
</head>
<body>
	<form action = "editListDetailsServlet" method="post">
	<input type ="hidden" name = "id" value= "${listToEdit.id}">
	List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
	
	Owner Name: <input type = "text" name = "ownerName" value="${listToEdit.owner.ownerName}"><br />
	Available Books:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.store} |
${currentitem.item}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href = "index.html">Add new books instead.</a>
</body>
</html>