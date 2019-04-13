<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.AdminBean"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.LoaiBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa sách</title>
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
    <%
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);
        String maSach = "", tenSach = "", maLoai = "", tenLoai = "",
                    tacGia = "", soLuong = "", gia = "", soTap = "",
                    anh = "";
            if (request.getParameter("maSach") != null) {
                maSach = (String) request.getParameter("maSach");
            }
            if (request.getParameter("tenSach") != null) {
                tenSach = (String) request.getParameter("tenSach");
            }
            if (request.getParameter("maLoai") != null) {
                maLoai = (String) request.getParameter("maLoai");
            }
            if (request.getParameter("tenLoai") != null) {
                tenLoai = (String) request.getParameter("tenLoai");
            }
            if (request.getParameter("tacGia") != null) {
                tacGia = (String) request.getParameter("tacGia");
            }
            if (request.getParameter("soLuong") != null) {
                soLuong = (String) request.getParameter("soLuong");
            }
            if (request.getParameter("gia") != null) {
                gia = (String) request.getParameter("gia");
            }
            if (request.getParameter("soTap") != null) {
                soTap = (String) request.getParameter("soTap");
            }
            if (request.getParameter("anh") != null) {
                anh = (String) request.getParameter("anh");
            }

            String maSachErr = "", tenSachErr = "", tacGiaErr = "",
                    soTapErr = "", anhErr = "" , soLuongErr = "" , giaErr = "";
            if (request.getAttribute("maSachErr") != null) {
                maSachErr = (String) request.getAttribute("maSachErr");
            }
            if (request.getAttribute("tenSachErr") != null) {
                tenSachErr = (String) request.getAttribute("tenSachErr");
            }
            if (request.getAttribute("tacGiaErr") != null) {
                tacGiaErr = (String) request.getAttribute("tacGiaErr");
            }
            if (request.getAttribute("soTapErr") != null) {
                soTapErr = (String) request.getAttribute("soTapErr");
            }
            if (request.getAttribute("anhErr") != null) {
                anhErr = (String) request.getAttribute("anhErr");
            }
            if (request.getAttribute("soLuongErr") != null) {
                soLuongErr = (String) request.getAttribute("soLuongErr");
            }
            if (request.getAttribute("giaErr") != null) {
                giaErr = (String) request.getAttribute("giaErr");
            }
    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <p class="tieude_admin">Sửa sách</p>
        <div id="rightContent">
            <form action="/SellingBooks/QuanLySachServlet" method="post">
                <table width="95%">
                    <tr>
                        <td width="125px"><b>Mã sách</b></td>
                        <td><input type="text" class="panjang" name="maSach"
                            value="<%=maSach%>" disabled="disabled"><span
                            style="color: red"><%=maSachErr%></span></td>
                    </tr>
                    <tr>
                        <td><b>Tên sách</b></td>
                        <td><input type="text" class="panjang" name="tenSach"
                            value="<%=tenSach%>"><span style="color: red"><%=tenSachErr%></span></td>
                    </tr>
                    <tr>
                        <td><b>Tên loại</b></td>
                        <td><select name="maLoai">
                                <%
                                    LoaiBo loaiBo = new LoaiBo();
                                        ArrayList<LoaiBean> list = loaiBo.getListLoai();
                                        for (LoaiBean loai : list) {
                                %>
                                <option value="<%=loai.getMaLoai()%>"><%=loai.getTenLoai()%></option>
                                <%
                                    }
                                %>
                        </select> <mark><%=tenLoai %></mark></td>
                    </tr>
                    <tr>
                        <td><b>Tác giả</b></td>
                        <td><input type="text" class="panjang" name="tacGia"
                            value="<%=tacGia%>"><span style="color: red"><%=tacGiaErr%></span></td>
                    </tr>
                    <tr>
                        <td><b>Số tập</b></td>
                        <td><input type="number" class="pendek" name="soTap"
                            value="<%=soTap%>"><span style="color: red"> <%=soTapErr%></span></td>
                    </tr>
                    <tr>
                        <td><b>Ảnh</b></td>
                        <td><input type="text" class="sedang" name="anh" value="<%=anh%>"> <input type="file">
                        <span style="color: red"><%=anhErr%></span><a href="${root }/admin/upload.jsp" class="btn btn-info"> Link upload ảnh</td>
                    </tr>
                    <tr>
                        <td><b>Số lượng</b></td>
                        <td><input type="number" class="pendek" name="soLuong" value="<%=Integer.parseInt(soLuong) %>" required="required"><span
                            style="color: red"><%=soLuongErr %></span></td>
                    </tr>
                    <tr>
                        <td><b>Giá</b></td>
                        <td><input type="number" class="pendek" name="gia" value="<%=Integer.parseInt(gia) %>"
                            step="1000"  required="required"> đ <span style="color: red"><%=giaErr%></span></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="loai" value="sua"></td>
                        <input type="hidden" name="maSach" value="<%=maSach%>">
                        <td><input type="submit" class="button" value="Lưu dữ liệu"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <%
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>