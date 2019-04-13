<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
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
    <div id="leftBar">
        <ul>
            <li><a href="${root}/admin/index.jsp">Trang chủ</a></li>
            <li><a href="${root}/admin/QuanLySach.jsp">Sách</a></li>
            <li><a href="${root}/admin/QuanLyLoai.jsp">Loại sách</a></li>
            <li><a href="${root}/admin/QuanLyHoaDon.jsp">Hóa đơn</a></li>
            <li><a href="${root}/admin/QuanLyChiTietHoaDon.jsp">Chi tiết HĐ</a></li>
            <li><a href="${root}/admin/QuanLyKhachHang.jsp">Khách hàng</a></li>
            <li><a href="/SellingBooks/admin/QuanLyTaiKhoan.jsp">Tài khoản</a></li>
            <li><a href="${root}/XuLyServlet">Về Website</a></li>
        </ul>
    </div>
    <%
    }else{
        response.sendRedirect("login.jsp");
    }
    %>
</body>
</html>