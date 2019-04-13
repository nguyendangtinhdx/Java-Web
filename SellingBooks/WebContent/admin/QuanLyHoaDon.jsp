<%@page import="Bean.AdminBean"%>
<%@page import="Bo.KhachHangBo"%>
<%@page import="Bean.HoaDonBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.HoaDonBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý hóa đơn</title>
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
        <p class="tieude_admin">Thông tin hóa đơn</p>
        <table class="data">
            <tr class="data">
                <th class="data" width="30px">STT</th>
                <th class="data">Mã hóa đơn</th>
                <th class="data">Tên khách hàng</th>
                <th class="data">Ngày mua</th>
                <th class="data">Tình trạng thanh toán</th>
                <th class="data" width="75px">Tùy chọn</th>
            </tr>
            <%
                HoaDonBo hoaDon = new HoaDonBo();
                ArrayList<HoaDonBean> list = hoaDon.getListHoaDon();
                
                KhachHangBo khachHang = new KhachHangBo();
                
                int count = 0;
                String status = "";
                for (HoaDonBean hoadon : list) {
                    count++ ;
            %>
            <tr class="data">
                <td class="data" width="30px"><%=count %></td>
                <td class="data"><%=hoadon.getMaHoaDon() %></td>
                 <td class="data"><%=hoadon.getHoTen() %></td>
                <td class="data"><%=hoadon.getNgayMua() %></td>
                <% 
                    if(hoadon.isDaMua() == true) status = "Đã thanh toán";
                    else status = "Chưa thanh toán";
                %>
                <td class="data"><%=status %></td>
                <td class="data" width="75px">
                    <center>
                        <a href="/SellingBooks/QuanLyHoaDonServlet?loai=xacnhan&maHoaDon=<%=hoadon.getMaHoaDon() %>"><img src="${root}/image/admin/oke.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/SellingBooks/QuanLyHoaDonServlet?loai=xoa&maHoaDon=<%=hoadon.getMaHoaDon() %>"><img src="${root}/image/admin/icon_delete.png"></a>
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