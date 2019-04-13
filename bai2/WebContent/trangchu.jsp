<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dang Nhap</title>
</head>
<body>
<table align ="center" border = "2" cellpadding = "10" cellspacing = "0">
	<tr align='right'><td><%if(session.getAttribute("un")==null) { %>
	<form method="post" action='BanHang.jsp'>
		UserName <input type="text" name="txta"> <br>
		PassWord <input type="text" name="txtb"> <br>
		<input type='submit' name='btnl' value ='Login'> <br>
	</form>
	<%
	if(request.getParameter("txta")!=null)
		{
		String un = request.getParameter("txta");
		String pw = request.getParameter("txtb");
		out.print("You Must Login First!!!");
		if(request.getParameter("btnl")!=null && un.equals("1") && pw.equals("2"))
		{
			session.setAttribute("un", un);
			response.sendRedirect("trangchu.jsp");
		}
		}
	}
	else out.print("Xin Chao: " + session.getAttribute("un"));
	%>
	</td>
	</tr>
</table>
</body>
</html>