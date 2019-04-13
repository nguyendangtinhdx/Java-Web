<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Thong tin tim kiem</h1>
	<table border="1">
		<tr>
			<th>STT</th>
			<th>ID</th>
			<th>NAME</th>
			<th>DETAILS</th>
			<th>PRICE</th>
			<th colspan="3">THAO TAC</th>
		</tr>
		<s:iterator var="L" value="list" status="number">
		<tr>
			<td><s:property value="#number.count"/></td>
			<td><s:property value="#L.id"/></td>
			<td><s:property value="#L.name"/></td>
			<td><s:property value="#L.details"/></td>
			<td><s:property value="#L.price"/></td>
			<td><a href="them">Insert</a></td>
			<td><a href="sua?id=<s:property value="#L.id"/>">Update</a></td>
			<td><a href="xoa?id=<s:property value="#L.id"/>">Delete</a></td>
		</tr>
		</s:iterator>
	</table>
	<a href="logout">Logout</a>
</body>
</html>