<%@page import="Bo.HangBo"%>
<%@page import="Bean.Hang"%>
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
	String th = request.getParameter("th");
	int soluong = Integer.parseInt(request.getParameter("txtsua"));
	HangBo hang = (HangBo)session.getAttribute("gh");
	hang.Them(th,(float)0,soluong);
	session.setAttribute("gh", hang);
	response.sendRedirect("BanHang.jsp");
%>
</body>
</html>