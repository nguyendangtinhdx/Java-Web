<%@page import="com.tinhnd.bean.MayBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý cửa hàng</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/menu.css">

</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand"
        href="MainServlet">Trang chủ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachMay=1">Danh sách máy</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themMay=1">Thêm mới máy</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachKhachHang=1">Danh sách khách hàng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themKhachHang=1">Thêm mới khách hàng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachDichVu=1">Danh sách dịch vụ</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themDichVu=1">Thêm mới dịch vụ</a></li>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get" action="MainServlet">
            <input class="form-control mr-sm-2" type="text" placeholder="Từ khóa tìm kiếm..."
                aria-label="Search" name="key">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiem">Tìm kiếm</button>
        </form>
        
    </div>
    </nav>
    <div class="wrapper">
  <ul id="folding-menu">
    <li><a href="MainServlet">Trang chủ</a></li>
    <li><a href="MainServlet?themSuDungMay=1">Đăng ký sử dụng máy</a></li>
    <li><a href="MainServlet?themSuDungDichVu=1">Đăng ký sử dụng dịch vụ</a></li>
    <li><a href="MainServlet?danhSachDangKy=1">Danh sách đăng ký</a></li>
  </ul>
</div>
    
</body>
</html>