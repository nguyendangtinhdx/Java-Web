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
         String nsd = "", gsd = "", sl = "";

        if (request.getParameter("ngaySuDung") != null) {
            nsd = request.getParameter("ngaySuDung");
        }
        if (request.getParameter("gioSuDung") != null) {
            gsd = request.getParameter("gioSuDung");
        }
        if (request.getParameter("soLuong") != null) {
            sl = request.getParameter("soLuong");
        }
     
        String nsdE = "",gsdE = "" ;
        if(request.getAttribute("nsdE") != null){
            nsdE = (String)request.getAttribute("nsdE");
        }
        if(request.getAttribute("gsdE") != null){
            gsdE = (String)request.getAttribute("gsdE");
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
                aria-label="Search" name="keyDichVu">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemDichVu">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    <div id="content">
        <h3 style="text-align: center; color: red;">Đăng ký sử dụng dịch vụ</h3>
        <form action="SuDungDichVuServlet" method="post">
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
                <label><b>Tên dịch vụ: </b></label> 
                <select name="maDV">
                    <%
                        DichVuBO dichVuBO = new DichVuBO();
                        ArrayList<DichVuBEAN> listDichVu = dichVuBO.getListDichVu();
                        for (DichVuBEAN dv : listDichVu) {
                    %>
                    <option value="<%=dv.getMaDV()%>"><%=dv.getTenDV()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
             <div class="form-group">
                <label><b>Ngày sử dụng: </b> <span style="color: red"><%=nsdE %></span></label> <input type="date" class="form-control form-control-sm" name="ngaySuDung" value="<%=nsd %>">
            </div>
            <div class="form-group">
                <label><b>Giờ sử dụng:</b> <span style="color: red"><%=gsdE %></label> <input type="text"  class="form-control form-control-sm" placeholder="00:00"
                    name="gioSuDung" value="<%=gsd %>" >
            </div>
            <div class="form-group">
                <label><b>Số lượng: </b> </label> <input type="number"  class="form-control form-control-sm" placeholder="Số lượng"
                    name="soLuong" min="0"  required="required" value="<%=sl %>">
            </div>

            <button type="submit" class="btn btn-outline-success" name="loai" value="them">Đăng ký</button>
        </form>
    </div>
</body>
</html>