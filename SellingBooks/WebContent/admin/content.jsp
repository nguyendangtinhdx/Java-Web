<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Content</title>
</head>
<body>
    <%
        AdminBean admin = null;
        if (session.getAttribute("tendangnhap_admin") != null) {
            admin = (AdminBean) session.getAttribute("tendangnhap_admin");
        }
        if(admin != null){
    %>
    <div id="rightContent">
        <h3>Trang quản trị</h3>
        <div class="quoteOfDay">
            <b>Chào mừng bạn đến với Webiste bán hàng online</b><br> <i style="color: #5b5b5b;"></i>
        </div>
    </div>
    <div class="clear"></div>
        <%
    }else{
        response.sendRedirect("login.jsp");
    }
    %>
</body>
</html>