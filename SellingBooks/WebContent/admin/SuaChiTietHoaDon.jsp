<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa chi tiết hóa đơn</title>
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
    <jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <p class="tieude_admin">Sửa loại sách</p>
        <div id="rightContent">
            <form action="/SellingBooks/QuanLyChiTietHoaDonServlet" method="post">
                <table width="95%">
                    <tr>
                        <td width="125px"><b>Mã chi tiết hóa đơn</b></td>
                        <td><input type="text" class="panjang" name="maChiTietHoaDon" value="<%=request.getParameter("maChiTietHoaDon") %>" disabled="disabled"></td>
                    </tr>
                       <tr>
                        <td width="125px"><b>Mã hóa đơn</b></td>
                        <td><input type="text" class="panjang" name="maHoaDon" value="<%=request.getParameter("maHoaDon") %>" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td><b>Tên sách</b></td>
                        <td><input type="text" class="panjang" name="tenSach" value="<%=request.getParameter("tenSach") %>" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td><b>Số lượng</b></td>
                        <td><input type="number" class="panjang" name="soLuong" value="<%=request.getParameter("soLuong") %>" required="required"></td>
                    </tr>
                     <tr>
                        <td><b>Giá</b></td>
                        <td><input type="number" class="panjang" name="gia" value="<%=request.getParameter("gia") %>" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="loai" value="sua"></td>
                        <input type="hidden" name="maChiTietHoaDon" value="<%=request.getParameter("maChiTietHoaDon") %>">
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