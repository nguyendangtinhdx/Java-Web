<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý cửa hàng</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%
         String mm = "", vt = "", tt = "";
        if (request.getParameter("maMay") != null) {
            mm = request.getParameter("maMay");
        }
        if (request.getParameter("viTri") != null) {
            vt = request.getParameter("viTri");
        }
        if (request.getParameter("trangThai") != null) {
            tt = request.getParameter("trangThai");
        }
     
        String vtE = "";
        if(request.getAttribute("vtE") != null){
            vtE = (String)request.getAttribute("vtE");
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
        <h3 style="text-align: center; color: red;">Sửa máy</h3>
        <form action="MayServlet" method="post">
          <div class="form-group">
                <label><b>Mã máy:</b></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Mã máy"
                    name="maMay" value="<%=mm %>" readonly="readonly">
            </div>
            <div class="form-group">
                <label><b>Vị trí:</b> <span style="color: red"><%=vtE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Vị trí"
                    name="viTri" value="<%=vt %>">
            </div>
             <div class="form-group">
                <label><b>Trạng thái:</b></label> <mark><%=tt %></mark>
                <select class="form-control form-control-sm" name="trangThai">
                    <option selected value="Rảnh">Rảnh</option>
                    <option selected value="Bận">Bận</option>
                    <option selected value="Dùng được">Dùng được</option>
                    <option selected value="Đang sửa chữa">Đang sửa chữa</option>
                </select>
            </div>
         <button type="submit" class="btn btn-outline-success" name="loai" value="sua">Sửa</button>
        </form>
    </div>
</body>
</html>