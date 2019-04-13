<%@page import="Bean.AdminBean"%>
<%@page import="Bean.KhachHangBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.KhachHangBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý khách hàng</title>
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
        <p class="tieude_admin">Thông tin khách hàng</p>
        <table class="data">
            <tr class="data">
                <th class="data" width="30px">STT</th>
                <th class="data">Mã khách hàng</th>
                <th class="data">Họ tên</th>
                <th class="data">Địa chỉ</th>
                <th class="data">Số điện thoại</th>
                <th class="data">Email</th>
                <th class="data">Tên đăng nhập</th>
                <th class="data">Mật khẩu</th>
                <th class="data" width="75px">Tùy chọn</th>
            </tr>
            <%
                KhachHangBo khachHang = new KhachHangBo();
                ArrayList<KhachHangBean> list = khachHang.getListKhachHang();
                int count = 0;
                for (KhachHangBean khachhang : list) {
                    count++ ;
            %>
            <tr class="data">
                <td class="data" width="30px"><%=count %></td>
                <td class="data"><%=khachhang.getMaKhachHang() %></td>
                <td class="data"><%=khachhang.getHoTen() %></td>
                <td class="data"><%=khachhang.getDiaChi() %></td>
                <td class="data"><%=khachhang.getSdt() %></td>
                <td class="data"><%=khachhang.getEmail() %></td>
                <td class="data"><%=khachhang.getTenDangNhap() %></td>
                <td class="data"><%=khachhang.getMatKhau() %></td>
                <td class="data" width="75px">
                    <center>
                        <a href="/SellingBooks/QuanLyKhachHangServlet?loai=xoa&maKhachHang=<%=khachhang.getMaKhachHang() %>"><img src="${root}/image/admin/icon_delete.png"></a>
                    </center>
                </td>
            </tr>
            <%
                }
            %>

        </table>
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