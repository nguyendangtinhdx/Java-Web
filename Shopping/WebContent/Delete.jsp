<%@page import="Entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
</head>
<body>
    <%
        ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
        if(request.getParameter("idDelete") != null){
            products.remove(Integer.parseInt(request.getParameter("idDelete")));
        }
        response.sendRedirect("Index.jsp");
    %>
</body>
</html>