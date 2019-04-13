<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="trangchu.jsp">
		UserName <input type="text" name="txta">
		PassWord <input type="text" name="txtb">
		<input type='submit' name='btnl' value ='Login'>
		<table align ="center" border = "2" cellpadding = "10" cellspacing = "0">
			<tr>
				<td> <a href='ptGet.jsp?ts=db'>Doc Bao</a></td>
				<td> <a href='ptGet.jsp?ts=vc'>Vui Cuoi</a></td>
				<td> <a href='ptGet.jsp?ts=tt'>The Thao</a></td>
			</tr>
			<tr>
			<td>abc</td>
			</tr>
		</table>
	</form>
	<%
		if(request.getParameter("txta")!=null && request.getParameter("txtb")!=null)
		{
			String un = request.getParameter("txta");
			String pw = request.getParameter("txtb");
			if(request.getParameter("btnl")!=null && un.equals("abc") && pw.equals("123"))
			{
				session.setAttribute("un", request.getParameter("txta"));
			}
		}
	%>
</body>
</html>