<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload ảnh</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
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
        <form method="post" action="/SellingBooks/UploadServlet" enctype="multipart/form-data">
            Chọn file ảnh: <input type="file" name="uploadFile" /> <br />
            <br /> <input type="submit" value="Upload" />
        </form>
    </center>

    <%
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>