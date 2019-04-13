<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
</head>
<body>
    <%
        AdminBean admin = null;
        if (session.getAttribute("tendangnhap_admin") != null) {
            admin = (AdminBean) session.getAttribute("tendangnhap_admin");
        }
        if (admin != null) {
    %>
    <center>
        <img src="${msg}">
        <br>
        <a href="${root}/admin/ThemSach.jsp">Về trang thêm sách</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="${root}/admin/QuanLySach.jsp">Về trang quản lý sách</a>
        <br>
        <%
        if(request.getAttribute("link") != null){
            String t = (String)request.getAttribute("link");
          %>
            link là: <%=t %>
          <%
        }
        %>
    </center>

    <%
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>