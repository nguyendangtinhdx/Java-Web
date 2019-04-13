<%@page import="bean.DonViUngHoBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa đợt ủng hộ</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%
        String mduh = "", mdvuh = "" , nuh = "";
        if (request.getParameter("maDotUngHo") != null) {
            mduh = request.getParameter("maDotUngHo");
        }
        if (request.getParameter("maDonViUngHo") != null) {
            mdvuh = request.getParameter("maDonViUngHo");
        }
        if (request.getParameter("ngayUngHo") != null) {
            nuh = request.getParameter("ngayUngHo");
        }
        String nuhE = "";
        if(request.getAttribute("nuhE") != null){
            nuhE = (String)request.getAttribute("nuhE");
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
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?dotUngHo=1">Đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?chiTietDotUngHo=1">Chi tiết đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?addDotUngHo=1">Thêm mới đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?addChiTietDotUngHo=1">Thêm mới chi tiết đợt ủng hộ</a></li>
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
        <h3 style="text-align: center; color: red;">Sửa đợt ủng hộ</h3>
        <form action="DotUngHoServlet" method="post">
          <div class="form-group">
                <label><b>Mã đợt ủng hộ</b></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Mã đợt ủng hộ"
                    name="maDotUngHo" value="<%=mduh %>" readonly="readonly">
            </div>
            <div class="form-group">
                <label><b>Đơn vị ủng hộ</b></label>: <%=mdvuh %>
                <select class="form-control form-control-sm" name="maDonViUngHo">
                <% 
                    if(request.getAttribute("ListDonViUngHo") != null){
                    ArrayList<DonViUngHoBEAN> donViUngHo = (ArrayList<DonViUngHoBEAN>)request.getAttribute("ListDonViUngHo");
                    for(DonViUngHoBEAN dvuh : donViUngHo){
                %>
                    <option value="<%=dvuh.getMaDonViUngHo()%>"><%=dvuh.getHoTenNguoiDaiDien() %></option>
                <%
                    }
                }
                %>
                </select>
            </div>
            <div class="form-group">
                <label><b>Ngày ủng hộ</b> <span style="color: red"><%=nuhE %></span></label> <input type="date" class="form-control form-control-sm" name="ngayUngHo"  value="<%=nuh %>">
            </div>
            
         <button type="submit" class="btn btn-outline-success" name="loai" value="sua">Lưu dữ liệu</button>
        </form>
    </div>
</body>
</html>