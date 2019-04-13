<%@page import="org.apache.jasper.tagplugins.jstl.core.Remove"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Product"%>
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
    ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
    int k = Integer.parseInt(request.getParameter("idDeleteDonHang"));
    if(request.getParameter("idDeleteDonHang") != null)
    {
        for( int i = k; i >= 0 ; i--)
        {
            products.remove(i);
        }
    }
    response.sendRedirect("Index.jsp");
%>
</body>
</html>