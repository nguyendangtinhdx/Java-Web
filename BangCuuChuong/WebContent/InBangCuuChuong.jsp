<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bảng cửu chương</title>
</head>
<body>
	<table border="1" width="100%" style="border-collapse: collapse; background: lightblue">
		<tr>
			<td colspan="10"  style="text-align: center; color: #ff0000; font-size: 40px ;width=100%">Bảng
				cửu chương</td>
		</tr>
		<%
			for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<%
				for (int j = 1; j <= 10; j++) {
			%>
			<td><%=i%> X <%=j%> = <%=i * j%></td>

			<%
				}
			%>
		</tr>
		<%
			}
		%>


	</table>
</body>
</html>