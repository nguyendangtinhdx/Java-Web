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
Welcome! <s:property value="%{#session.login}"/>
	<form action="timkiem" method="post">
		Name:<input type="text" name="name" /><br>
		<input type="submit" value="Search"/>
	</form>
	<table border="1">
		<tr>
			<th>STT</th>
			<th>id</th>
			<th>name</th>
			<th>details</th>
			<th>price</th>
			<th colspan="3">Thao tac</th>
		</tr>
		<s:iterator var="L" value="list" status="number">
			<tr>
			<td><s:property value="#number.count" /></td>
			<td><s:property value="#L.id"/></td>
			<td><s:property value="#L.name"/></td>
			<td><s:property value="#L.details"/></td>
			<td><s:property value="#L.price" /></td>
			<td><a href="insert.jsp">Insert</a></td>
			<td><a href="sua?id=<s:property value="#L.id"/>">Update</a></td>
			<td><a href="xoa?id=<s:property value="#L.id"/>">Delete</a></td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>