<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm loại sách</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <%
        AdminBean admin = null;
        if (session.getAttribute("tendangnhap_admin") != null) {
            admin = (AdminBean) session.getAttribute("tendangnhap_admin");
        }
        if(admin != null){
    %>
    <%
    String maLoai = "" ,tenLoai = "" ;
    if(request.getParameter("maLoai")!=null){
        maLoai = (String) request.getParameter("maLoai");
    }
    if(request.getParameter("tenLoai")!=null){
        tenLoai = (String) request.getParameter("tenLoai");
    }
    
    String maLoaiErr = "" ,tenLoaiErr = "" ;
    if(request.getAttribute("maLoaiErr")!=null){
        maLoaiErr = (String) request.getAttribute("maLoaiErr");
    }
    if(request.getAttribute("tenLoaiErr")!=null){
        tenLoaiErr = (String) request.getAttribute("tenLoaiErr");
    }
    
    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <p class="tieude_admin">Thêm loại sách</p>
        <div id="rightContent">
            <form action="/SellingBooks/QuanLyLoaiServlet" method="post">
                <table width="95%">
                    <tr>
                        <td width="125px"><b>Mã loại</b></td>
                        <td><input type="text" class="panjang" name="maLoai" value="<%=maLoai %>"><span style="color: red"><%=maLoaiErr %></span></td>
                    </tr>
                    <tr>
                        <td><b>Tên loại</b></td>
                        <td><input type="text" class="panjang" name="tenLoai" value="<%=tenLoai %>"><span style="color: red"><%=tenLoaiErr %></span></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="loai" value="them"></td>
                        <td><input type="submit" class="button" value="Lưu dữ liệu"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <%
    }else{
        response.sendRedirect("login.jsp");
    }
    %>
</body>
</html>