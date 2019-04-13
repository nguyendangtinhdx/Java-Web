<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getParameter("txta")!=null)
		{
			if(session.getAttribute("x")==null)
				session.setAttribute("x", 0);
			int tam = (int)session.getAttribute("x");
			tam = tam + Integer.parseInt(request.getParameter("txta"));
			session.setAttribute("x", tam);
			out.print(tam);
		}
	%>
	<form method = 'post' action ="congdonsession.jsp">
		a = <input type="text" name="txta" placeholder="nhap a">
		<input type='submit' name='btnc' value ='+'>
	</form>
	<p>SESSION</p>
</body>
</html>