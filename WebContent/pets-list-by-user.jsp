<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pets List</title>
<style type="text/css">
table{
	border-collapse: collapse;
  	width: 50%;}
td {width: 50%;}
td.radio{width:15px;}
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
<form method="post" action="petsNavigationServlet">
		<table>
			<!-- <tr>
			<th>&nbsp;</th>
			<th class="bold">Type</th>
			<th class="bold">Name</th>
			<th class="bold">Owner</th>
			</tr> -->
			<c:forEach items="${requestScope.allList}" var="currentlist">
				<tr>
					<td class="radio"><input type="radio" name="id" value="${currentlist.id}"></td>
					<td>Owner Name: ${currentlist.ownerName}</td>
					<td>Owner Phone: ${currentlist.ownerPhone}</td>
				</tr>
				<tr>
					<td colspan="3">Trip Date: ${currentlist.tripDate}</td>
				</tr>
				<tr>
					<td colspan="3">Pets Sitter: ${currentlist.petsSitter}</td>
				</tr>
				<tr>
					<td colspan="3">Pets List: ${currentlist.petsSitter.petsSitterName}</td>
				</tr>
				<c:forEach var="listVal" items="${curentlist.listOfPets}">
					<tr><td></td><td colspan="3">
					${listVal.type}, ${listVal.name}, ${listVal.owner}
					</td>
					</tr>
				</c:forEach>
				</c:forEach>
		</table>
		<br>
		<!-- <input class="btn" type="submit" value="edit" name="doThisToItem"> -->
		<input class="btn" type="submit" value="delete" name="doThisToItem">
		<input class="btn" type="submit" value="add" name="doThisToItem">
	</form>
	<a href="addItemsForListServlet">Create a new List</a>
	<a href="index.html">Insert a new item</a>
</body>
</html>