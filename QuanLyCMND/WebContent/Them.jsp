<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tạo mới hoạt động thiện nguyện</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%
        String cmndID = "", ten = "", ho = "", ngaySinh = "", noiSinh = "",
                tinhTrangHonNhan = "", ngheNghiep = "";
        if (request.getParameter("cmndID") != null) {
            cmndID = request.getParameter("cmndID");
        }
        if (request.getParameter("ten") != null) {
            ten = request.getParameter("ten");
        }
        if (request.getParameter("ho") != null) {
            ho = request.getParameter("ho");
        }
        if (request.getParameter("ngaySinh") != null) {
            ngaySinh = request.getParameter("ngaySinh");
        }
        if (request.getParameter("noiSinh") != null) {
            noiSinh = request.getParameter("noiSinh");
        }
        if (request.getParameter("tinhTrangHonNhan") != null) {
            tinhTrangHonNhan = request.getParameter("tinhTrangHonNhan");
        }
        if (request.getParameter("ngheNghiep") != null) {
            ngheNghiep = request.getParameter("ngheNghiep");
        }

        String cmndIDE = "", tenE = "", hoE = "",ngaySinhE= "" ,noiSinhE = "", tinhTrangHonNhanE = "", ngheNghiepE="";
        if(request.getAttribute("cmndIDE") != null){
            cmndIDE = (String)request.getAttribute("cmndIDE");
        }
        if(request.getAttribute("tenE") != null){
            tenE = (String)request.getAttribute("tenE");
        }
        if(request.getAttribute("hoE") != null){
            hoE = (String)request.getAttribute("hoE");
        }
        if(request.getAttribute("ngaySinhE") != null){
            ngaySinhE = (String)request.getAttribute("ngaySinhE");
        }
        if(request.getAttribute("noiSinhE") != null){
            noiSinhE = (String)request.getAttribute("noiSinhE");
        }
        if(request.getAttribute("tinhTrangHonNhanE") != null){
            tinhTrangHonNhanE = (String)request.getAttribute("tinhTrangHonNhanE");
        }
        if(request.getAttribute("ngheNghiepE") != null){
            ngheNghiepE = (String)request.getAttribute("ngheNghiepE");
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
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?quanLyCongDan=1">Quản lý công dân</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?quanLyHoKhau=1">Quản lý hộ khẩu</a></li>
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
        <h3 style="text-align: center; color: red;">Thêm mới công dân</h3>
        <form action="CongDanServlet" method="post">
          <div class="form-group">
                <label><b>CmndID</b> <span style="color: red"><%=cmndIDE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="CmndID"
                    name="cmndID" value="<%=cmndID %>">
            </div>
            <div class="form-group">
                <label><b>Tên</b> <span style="color: red"><%=tenE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Tên"
                    name="ten" value="<%=ten %>">
            </div>
            <div class="form-group">
                <label><b>Họ</b> <span style="color: red"><%=hoE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Họ"
                    name="ho"  value="<%=ho %>" >
            </div>
            <div class="form-group">
                <label><b>Ngày sinh</b> <span style="color: red"><%=ngaySinhE %></span></label> <input type="date"
                    class="form-control form-control-sm" name="ngaySinh"  value="<%=ngaySinh %>">
            </div>
            <div class="form-group">
                <label><b>Giới tính</b> </label> 
                <select class="form-control form-control-sm" name="gioiTinh">
                    <option value="Nam">Nam</option>
                    <option value="Nu">Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label><b>Nơi sinh</b> <span style="color: red"><%=noiSinhE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Nơi sinh" name="noiSinh"  value="<%=noiSinh %>" >
            </div>
             <div class="form-group">
                <label><b>Tình trạng hôn nhân</b> <span style="color: red"><%=tinhTrangHonNhanE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Tình trạng hôn nhân"
                    name="tinhTrangHonNhan"  value="<%=ho %>" >
            </div>
             <div class="form-group">
                <label><b>Nghề nghiệp</b> <span style="color: red"><%=ngheNghiepE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Nghề nghiệp"
                    name="ngheNghiep"  value="<%=ho %>" >
            </div>
         <button type="submit" class="btn btn-outline-success" name="loai" value="them">Thêm mới</button>
        </form>
    </div>
</body>
</html>