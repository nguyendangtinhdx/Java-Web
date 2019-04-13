<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
</head>
<body>
    <%
        AdminBean admin = null;
        if (session.getAttribute("tendangnhap_admin") != null) {
            admin = (AdminBean) session.getAttribute("tendangnhap_admin");
        }
    %>
    <div id="header">
        <div class="inHeader">
            <div class="mosAdmin">
                
                <%
                if(admin != null){
                %>
                    Xin chào: 
                    <%=admin.getTenDanhNhap() %>
                    <br>
                     <a href="${root }/QuanLyDangNhapServlet?loai=dangxuat">Đăng xuất</a>
                <%}else{ %>
                <br> 
                <a href="${root}/admin/login.jsp">Đăng nhập</a>
                <%} %>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</body>
</html>