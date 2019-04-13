<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý lịch trình xe</title>
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
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachXeDangKy=1">Danh sách xe đăng ký</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themXe=1">Thêm xe</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachXe=1">Danh sách xe</a></li>            
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachTongTien=1">Danh sách thu nhập của nhà xe</a></li>
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
    <li><a href="MainServlet?danhSachXeDangKy=1">Danh sách xe đăng ký</a></li>
    <li><a href="MainServlet?danhSachXe=1">Danh sách xe</a></li>
    <li><a href="MainServlet?danhSachTongTien=1">Danh sách thu nhập của nhà xe</a></li>
  </ul>
</div>
    
</body>
</html>