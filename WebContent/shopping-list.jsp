<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping List</title>
<style type="text/css">
table{
	border-collapse: collapse;
  	width: 50%;}
td {width: 25px;}
td, th {
  border: 1px solid #ddd;
  padding: 8px;
}
.bold {font-weight:bold;}
tr:nth-child(even){background-color: #f2f2f2;}
tr:hover {background-color: #ddd;}
th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #0077be;
  color: white;
}
.btn {
    border: none;
    display: inline-block;
    padding: 8px 16px;
    vertical-align: middle;
    overflow: hidden;
    text-decoration: none;
    text-align: center;
    cursor: pointer;
    white-space: nowrap;
}
.btn, .btn:link, .btn:visited {
    color: #FFFFFF;
    background-color: #0077be;
}
.btn:hover {
    color: #FFFFFF;
    background-color: #368DC5;
}
</style>
</head>
<body>
<form method="post" action="navigationServlet">
		<table>
			<tr>
			<th>&nbsp;</th>
			<th class="bold">Type</th>
			<th class="bold">Name</th>
			<th class="bold">Owner</th>
			</tr>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.type}</td>
					<td>${currentitem.name}</td>
					<td>${currentitem.owner}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input class="btn" type="submit" value="edit" name="doThisToItem">
		<input class="btn" type="submit" value="delete" name="doThisToItem">
		<input class="btn" type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>