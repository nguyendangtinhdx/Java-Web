<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Footer</title>
</head>
<body>
    <%
        AdminBean admin = null;
        if (session.getAttribute("tendangnhap_admin") != null) {
            admin = (AdminBean) session.getAttribute("tendangnhap_admin");
        }
        if (admin != null) {
    %>
    <div id="footer">
        &copy; 2017 by <a href="https://www.facebook.com/nguyendangtinhdx.BI" target="_blank">Nguyễn
            Đăng Tỉnh </a> | Email: <b>nguyendangtinhdx@gmail.com</b>
    </div>
    <%
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>