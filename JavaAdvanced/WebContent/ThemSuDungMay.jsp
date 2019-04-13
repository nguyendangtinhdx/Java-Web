<%@page import="com.tinhnd.bean.MayBEAN"%>
<%@page import="com.tinhnd.bo.MayBO"%>
<%@page import="com.tinhnd.bean.DichVuBEAN"%>
<%@page import="com.tinhnd.bo.DichVuBO"%>
<%@page import="com.tinhnd.bean.KhachHangBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tinhnd.bo.KhachHangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý của hàng</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%
         String  nbdsd = "",gbdsd = "",tgsd = "";
        if (request.getParameter("ngayBatDauSuDung") != null) {
            nbdsd = request.getParameter("ngayBatDauSuDung");
        }
        if (request.getParameter("gioBatDauSuDung") != null) {
            gbdsd = request.getParameter("gioBatDauSuDung");
        }
        if (request.getParameter("thoiGianSuDung") != null) {
            tgsd = request.getParameter("thoiGianSuDung");
        }
     
        String nbdsdE = "",gbdsdE = "", tgsdE = "";

        if(request.getAttribute("nbdsdE") != null){
            nbdsdE = (String)request.getAttribute("nbdsdE");
        }
        if(request.getAttribute("gbdsdE") != null){
            gbdsdE = (String)request.getAttribute("gbdsdE");
        }
        if(request.getAttribute("tgsdE") != null){
            tgsdE = (String)request.getAttribute("tgsdE");
        }


    %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="MainServlet">Trang
        chủ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachMay=1">Danh sách máy</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themMay=1">Thêm mới máy</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachKhachHang=1">Danh sách khách hàng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themKhachHang=1">Thêm mới khách hàng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachDichVu=1">Danh sách dịch vụ</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themDichVu=1">Thêm mới dịch vụ</a></li>
        </ul>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get" action="MainServlet">
            <input class="form-control mr-sm-2" type="text" placeholder="Từ khóa tìm kiếm..."
                aria-label="Search" name="keyMay">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemMay">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    <div id="content">
        <h3 style="text-align: center; color: red;">Đăng ký sử dụng máy</h3>
        <form action="SuDungMayServlet" method="post">
            <div class="form-group">
                <label><b>Tên khách hàng: </b></label>
                 <select name="maKH">
                    <%
                        KhachHangBO khachHangBO = new KhachHangBO();
                        ArrayList<KhachHangBEAN> listKhachHang = khachHangBO.getListKhachHang();
                        for (KhachHangBEAN kh : listKhachHang) {
                    %>
                    <option value="<%=kh.getMaKH()%>"><%=kh.getTenKH()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label><b>Mã máy: </b></label> 
                <select name="maMay">
                    <%
                        MayBO mayBO = new MayBO();
                        ArrayList<MayBEAN> listMay = mayBO.getListMay();
                        for (MayBEAN m : listMay) {
                    %>
                    <option value="<%=m.getMaMay()%>"><%=m.getMaMay()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
             <div class="form-group">
                <label><b>Ngày bắt đầu sử dụng: </b> <span style="color: red"><%=nbdsdE %></span></label> <input type="date" class="form-control form-control-sm" name="ngayBatDauSuDung" value="<%=nbdsd %>">
            </div>
            <div class="form-group">
                <label><b>Giờ bắt đầu sử dụng:</b> <span style="color: red"><%=gbdsdE %></span></label> <input type="text"  class="form-control form-control-sm" placeholder="00:00"
                    name="gioBatDauSuDung" value="<%=gbdsd %>" >
            </div>
            <div class="form-group">
                <label><b>Thời gian sử dụng: </b> <span style="color: red"><%=tgsdE %></span></label> <input type="text"  class="form-control form-control-sm" placeholder="Thời gian sử dụng"
                    name="thoiGianSuDung" value="<%=tgsd %>" >
            </div>

            <button type="submit" class="btn btn-outline-success" name="loai" value="them">Đăng ký</button>
        </form>
    </div>
</body>
</html>