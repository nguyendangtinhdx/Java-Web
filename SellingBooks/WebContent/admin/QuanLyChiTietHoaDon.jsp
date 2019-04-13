<%@page import="Bean.AdminBean"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.ChiTietHoaDonBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.ChiTietHoaDonBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý chi tiết hóa đơn</title>
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
    <jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <p class="tieude_admin">Thông tin chi tiết hóa đơn</p>
        <table class="data">
            <tr class="data">
                <th class="data" width="30px">STT</th>
                <th class="data">Mã chi tiết hóa đơn</th>
                <th class="data">Mã hóa đơn</th>
                <th class="data">Tên sách</th>
                <th class="data">Số lượng mua</th>
                <th class="data">Giá</th>
                <th class="data">Thành tiền</th>
                <th class="data" width="75px">Tùy chọn</th>
            </tr>
            <%
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMinimumIntegerDigits(0);
                
                ChiTietHoaDonBo chiTietHoaDon = new ChiTietHoaDonBo();
                ArrayList<ChiTietHoaDonBean> list = chiTietHoaDon.getListChiTietHoaDon();
                int count = 0;
                for (ChiTietHoaDonBean cthd : list) {
                    count++ ;
            %>
            <tr class="data">
                <td class="data" width="30px"><%=count %></td>
                <td class="data"><%=cthd.getMaChiTietHoaDon() %></td>
                <td class="data"><%=cthd.getMaHoaDon() %></td>
                <td class="data"><%=cthd.getTenSach() %></td>
                <td class="data"><%=cthd.getSoLuongMua()%></td>
                <td class="data"><%=nf.format(cthd.getGia()) %> đ</td>
                <td class="data"><%=nf.format(cthd.getSoLuongMua() * cthd.getGia()) %> đ</td>
                <td class="data" width="75px">
                    <center>
                        <a href="/SellingBooks/admin/SuaChiTietHoaDon.jsp?loai=sua&maChiTietHoaDon=<%=cthd.getMaChiTietHoaDon() %>&maHoaDon=<%=cthd.getMaHoaDon() %>&tenSach=<%=cthd.getTenSach() %>&soLuong=<%=cthd.getSoLuongMua() %>&gia=<%=cthd.getGia() %>"><img src="${root}/image/admin/icon_edit.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/SellingBooks/QuanLyChiTietHoaDonServlet?loai=xoa&maChiTietHoaDon=<%=cthd.getMaChiTietHoaDon() %>"><img src="${root}/image/admin/icon_delete.png"></a>
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