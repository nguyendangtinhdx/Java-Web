<%@page import="bean.HangBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý của hàng</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="jquery/jquery.min.js"></script>
</head>
<body>

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
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachHang=1">Danh sách hãng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themHang=1">Thêm mới hãng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachMayTinh=1">Danh sách máy tính</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themMayTinh=1">Thêm mới máy tính</a></li>
        </ul>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get" action="MainServlet">
            <input class="form-control mr-sm-2" type="text" placeholder="Từ khóa tìm kiếm..." aria-label="Search" name="keyMayTinh">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemMayTinh">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    <div id="content">
        <h3 style="text-align: center; color: red;">Cập nhật máy tính</h3>
        <form action="MayTinhServlet" method="post">
          <div class="form-group">
                <label><b>Mã:</b> <span style="color: red" id="errorMa"></span></label> 
                <input type="text"class="form-control form-control-sm" placeholder="Mã máy tính" name="ma" id="ma" readonly="readonly" value="<%=request.getParameter("ma") %>">
            </div>
            <div class="form-group">
                <label><b>Tên:</b> <span style="color: red"></span></label> 
                <input type="text" class="form-control form-control-sm" placeholder="Tên" name="ten" value="<%=request.getParameter("ten") %>">
            </div>
            <div class="form-group">
                <label><b>Giá:</b> <span style="color: red"></span></label> 
                <input type="number" class="form-control form-control-sm" placeholder="Giá" name="gia" value="<%=request.getParameter("gia") %>">
            </div>
            <div class="form-group">
                <label><b>Số lượng: </b> <span style="color: red"></span></label> 
                <input type="number" class="form-control form-control-sm" placeholder="Số lượng" name="soLuong" value="<%=request.getParameter("soLuong") %>">
            </div>
            <div class="form-group">
                <label><b>Ngày sản xuất: </b> <span style="color: red"></span></label> 
                <input type="date" class="form-control form-control-sm"  name="ngaySanXuat" value="<%=request.getParameter("ngaySanXuat") %>">
            </div>
             <div class="form-group">
                <label><b>Mã hãng:</b></label> <mark><%=request.getParameter("maHang") %></mark>
                <select class="form-control form-control-sm" name="maHang">
                <%
                if(request.getAttribute("ListHang") != null){
                     ArrayList<HangBEAN> list = (ArrayList<HangBEAN>)request.getAttribute("ListHang");
                     for(HangBEAN h : list){
                %>
                    <option  value="<%=h.getMaHang() %>"><%=h.getTenHang() %></option>
                <%
                     }
                }
                %>
                </select>
            </div>
         <button type="submit" class="btn btn-outline-success" name="loai" value="sua" id="btnEdit" onclick="return CheckValidate()">Cập nhật</button>
        </form>
    </div>
</body>
</html>