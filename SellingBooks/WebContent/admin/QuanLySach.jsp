<%@page import="Bean.QuanLySachBean"%>
<%@page import="Bo.QuanLySachBo"%>
<%@page import="Bean.AdminBean"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sách</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
<!-- <link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet"> -->
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
        <p class="tieude_admin">Thông tin sách</p>
        <a href="${root}/admin/ThemSach.jsp" class="button">Thêm sách</a>
        <table class="data">
            <tr class="data">
                <th class="data" width="30px">STT</th>
                <th class="data">Mã sách</th>
                <th class="data">Tên sách</th>
                <th class="data">Tên loại</th>
                <th class="data">Tác giả</th>
                <th class="data">Số tập</th>
                <th class="data">Ảnh</th>
                <th class="data">Ngày nhập</th>
                <th class="data">Số lượng</th>
                <th class="data">Giá</th>
                <th class="data" width="75px">Tùy chọn</th>
            </tr>
            <%
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMinimumIntegerDigits(0);

                QuanLySachBo sachBo = new QuanLySachBo();
                ArrayList<QuanLySachBean> arr = sachBo.getListSach();
           /*      int pages = 10;
                int start = 0, end = pages;
                if (arr.size() < pages) {
                    end = arr.size();
                }
                if (request.getParameter("start") != null) {
                    start = Integer.parseInt(request.getParameter("start"));
                }
                if (request.getParameter("end") != null) {
                    end = Integer.parseInt(request.getParameter("end"));
                } */

                int count = 0;
    /*             for (QuanLySachBean sach : sachBo.getListSachByPage(arr, start, end)) { */
                for (QuanLySachBean sach : arr) {
                    count++ ;
            %>
            <tr class="data">
                <td class="data" width="30px"><%=count%></td>
                <td class="data"><%=sach.getMaSach()%></td>
                <td class="data"><%=sach.getTenSach()%></td>
                <td class="data"><%=sach.getTenLoai()%></td>
                <td class="data"><%=sach.getTacGia()%></td>
                <td class="data"><%=sach.getSoTap()%></td>
                <td class="data"><%=sach.getAnh()%></td>
                <td class="data"><%=sach.getNgayNhap()%></td>
                <td class="data"><%=sach.getSoLuong()%></td>
                <td class="data"><%=nf.format(sach.getGia())%> đ</td>
                <td class="data" width="75px">
                    <center>
<%--                         <a href="/SellingBooks/admin/SuaSach.jsp?loai=sua&maSach=<%=sach.getMaSach() %>&tenSach=<%=sach.getTenSach() %>&tenLoai=<%=sach.getTenLoai() %>&tacGia=<%=sach.getTacGia() %>&soTap=<%=sach.getSoTap() %>&anh=<%=sach.getAnh() %>"> --%>
                        <a href="/SellingBooks/admin/SuaSach.jsp?loai=sua&maSach=<%=sach.getMaSach() %>&tenSach=<%=sach.getTenSach() %>&tenLoai=<%=sach.getTenLoai() %>&tacGia=<%=sach.getTacGia() %>&soTap=<%=sach.getSoTap() %>&anh=<%=sach.getAnh()%>&soLuong=<%=sach.getSoLuong() %>&gia=<%=sach.getGia() %>">
                        <img src="${root}/image/admin/icon_edit.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/SellingBooks/QuanLySachServlet?loai=xoa&maSach=<%=sach.getMaSach() %>"><img src="${root}/image/admin/icon_delete.png"></a>
                    </center>
                </td>
            </tr>
            <%
                }
            %>

        </table>
<%--         <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-10">
                <ul class="pagination">
                    <li><a href="${root}/admin/QuanLySach.jsp?start=<%=0%>&end=<%=pages%> "> &laquo; </a></li>
                    <%
                        int dem = 0;
                        int a, b;
                        int limit = arr.size() / pages;
                        if (limit * pages < arr.size()) {
                            limit += 1;
                        }
                        for (int i = 1; i <= limit; i++) {
                            a = (i - 1) * pages;
                            b = i * pages;
                            if (b > arr.size()) {
                                b = arr.size();
                            }
                            dem++;
                    %>
                    <li><a href="${root}/admin/QuanLySach.jsp?start=<%=a%>&end=<%=b%> "><%=i%> </a></li>
                    <%
                        }
                    %>
                    <li><a
                        href="${root}/admin/QuanLySach.jsp?start=<%=(dem - 1) * pages%>&end=<%=arr.size()%> ">
                            &raquo; </a></li>

                </ul>
            </div>
        </div> --%>

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