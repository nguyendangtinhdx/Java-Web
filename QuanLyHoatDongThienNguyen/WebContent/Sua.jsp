<%@page import="bean.HoatDongBEAN"%>
<%@page import="bean.ThanhVienBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa thông tin hoạt động thiện nguyện</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%
        String mhd = "", thd = "", mthd = "", ngbd = "", ngkt = "", sltt = "",
                sltd = "", thdk = "",tt = "", ldhhd = "" ;
        if (request.getParameter("maHoatDong") != null) {
            mhd = request.getParameter("maHoatDong");
        }
        if (request.getParameter("tenHoatDong") != null) {
            thd = request.getParameter("tenHoatDong");
        }
        if (request.getParameter("moTaHoatDong") != null) {
            mthd = request.getParameter("moTaHoatDong");
        }
        if (request.getParameter("ngayGioBatDau") != null) {
            ngbd = request.getParameter("ngayGioBatDau");
        }
        if (request.getParameter("ngayGioKetThuc") != null) {
            ngkt = request.getParameter("ngayGioKetThuc");
        }
        if (request.getParameter("soLuongToiThieu") != null) {
            sltt = request.getParameter("soLuongToiThieu");
        }
        if (request.getParameter("soLuongToiDa") != null) {
            sltd = request.getParameter("soLuongToiDa");
        }
        if (request.getParameter("thoiHanDangKy") != null) {
            thdk = request.getParameter("thoiHanDangKy");
        }
        if (request.getParameter("trangThai") != null) {
            tt = request.getParameter("trangThai");
        }
        if (request.getParameter("lyDoHuyHoatDong") != null) {
            ldhhd = request.getParameter("lyDoHuyHoatDong");
        }
        String thdE = "", mthdE = "",ngbdE= "" ,ngktE = "",thdkE = "", ldhhdE = "";
        if(request.getAttribute("thdE") != null){
            thdE = (String)request.getAttribute("thdE");
        }
        if(request.getAttribute("mthdE") != null){
            mthdE = (String)request.getAttribute("mthdE");
        }
        if(request.getAttribute("ngbdE") != null){
            ngbdE = (String)request.getAttribute("ngbdE");
        }
        if(request.getAttribute("ngktE") != null){
            ngktE = (String)request.getAttribute("ngktE");
        }
        if(request.getAttribute("thdkE") != null){
            thdkE = (String)request.getAttribute("thdkE");
        }
        if(request.getAttribute("ldhhdE") != null){
            ldhhdE = (String)request.getAttribute("ldhhdE");
        }
    %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="XuLyServlet">Trang
        chủ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?add=1">Thêm mới</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?tk=1">Thống kê</a></li>
        </ul>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Từ khóa tìm kiếm..."
                aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    <div id="content">
        <h3 style="text-align: center; color: red;">Sửa thông tin hoạt động thiện nguyện</h3>
        <form action="HoatDongServlet" method="post">
          <div class="form-group">
                <label><b>Mã hoạt động</b></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Mã hoạt động"
                    name="maHoatDong" value="<%=mhd %>" readonly="readonly" >
            </div>
            <div class="form-group">
                <label><b>Tên hoạt động</b> <span style="color: red"><%=thdE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Tên hoạt động"
                    name="tenHoatDong" value="<%=thd %>">
            </div>
            <div class="form-group">
                <label><b>Mô tả công việc</b> <span style="color: red"><%=mthdE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Mô tả hoạt động"
                    name="moTaHoatDong"  value="<%=mthd %>" >
            </div>
            <div class="form-group">
                <label><b>Ngày giờ bắt đầu</b> <span style="color: red"><%=ngbdE %></span></label> <input type="text" placeholder="yyyy-MM-dd hh:mm:ss"
                    class="form-control form-control-sm" name="ngayGioBatDau"  value="<%=ngbd %>">
            </div>
            <div class="form-group">
                <label><b>Ngày giờ kết thúc</b> <span style="color: red"><%=ngktE %></span></label> <input type="text" placeholder="yyyy-MM-dd hh:mm:ss"
                    class="form-control form-control-sm" name="ngayGioKetThuc"  value="<%=ngkt %>">
            </div>
            <div class="form-group">
                <label><b>Số lượng người tham gia tối thiểu</b></label> <input type="number"
                    class="form-control form-control-sm"
                    placeholder="Số lượng người tham gia tối thiểu" name="soLuongToiThieu"  value="<%=sltt %>"required=required"" >
            </div>
            <div class="form-group">
                <label><b>Số lượng người tham gia tối đa</b></label> <input type="number"
                    class="form-control form-control-sm"
                    placeholder="Số lượng người tham gia tối đa" name="soLuongToiDa"  value="<%=sltd %>" required="required">
            </div>
            <div class="form-group">
                <label><b>Thời hạn đăng ký</b> <span style="color: red"><%=thdkE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Thời hạn đăng ký" name="thoiHanDangKy"  value="<%=thdk %>">
            </div>
            <div class="form-group">
                <label><b>Trạng thái</b></label>: <span><%=tt %></span>
                <select class="form-control form-control-sm" name="trangThai">
                    <option selected value="Đang mời đăng ký">Đang mời đăng ký</option>
                    <option selected value="Đã hết hạn đăng ký">Đã hết hạn đăng ký</option>
                    <option selected value="Trưởng đoàn tự hủy">Trưởng đoàn tự hủy</option>
                    <option selected value="Đã kết thúc">Đã kết thúc</option>
                </select>
            </div>
            <div class="form-group">
                <label><b>Tên thành viên</b></label> 
                <select class="form-control form-control-sm" name="maThanhVien">
                <% 
                    if(request.getAttribute("ListThanhVien") != null){
                    ArrayList<ThanhVienBEAN> thanhVien = (ArrayList<ThanhVienBEAN>)request.getAttribute("ListThanhVien");
                    for(ThanhVienBEAN tv : thanhVien){
                %>
                    <option value="<%=tv.getMaThanhVien() %>"><%=tv.getHoTen() %></option>
                <%
                    }
                }
                %>
                </select>
            </div>
             <div class="form-group">
                <label><b>Lý do huy hoạt động</b> <span style="color: red"><%=ldhhdE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Lý do hủy hoạt động" name="lyDoHuyHoatDong"  value="<%=ldhhd %>">
            </div>
         <button type="submit" class="btn btn-outline-success" name="loai" value="sua">Lưu dữ liệu</button>
        </form>
    </div>
</body>
</html>