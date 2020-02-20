<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item List</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Pet Type: <input type ="text" name = "petType" value= "${itemToEdit.type}"><br><br>
Pet Name: <input type = "text" name = "petName" value= "${itemToEdit.name}"><br><br>
Pet Owner: <input type = "text" name = "petOwner" value= "${itemToEdit.owner}"><br><br>
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>