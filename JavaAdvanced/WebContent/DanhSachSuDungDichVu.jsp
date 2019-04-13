<%@page import="com.tinhnd.bean.DichVuBEAN"%>
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
</head>
<body>
    <%
        int pages = 5;
    %>
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
                aria-label="Search" name="keyDichVu">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemDichVu">Tìm kiếm</button>
        </form>
        
    </div>
    </nav>
    
    <div>
     <h3 style="text-align: center; color: red;">Thông tin sử dụng dịch vụ</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã khách hàng</th>
                    <th>Mã dịch vụ</th>
                    <th>Ngày sử dụng</th>
                    <th>Giờ sử dụng</th>
                    <th>Số lượng</th>
                    <th colspan="2">Tùy chọn</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    if(request.getAttribute("ListDichVuByPage") != null){
                        ArrayList<DichVuBEAN> dv = (ArrayList<DichVuBEAN>)request.getAttribute("ListDichVuByPage");
                        for(DichVuBEAN d : dv){
                           
                    %>
                    <tr>
                    <td><%=d.getMaDV() %></td>
                    <td><%=d.getTenDV() %></td>
                    <td><%=d.getDonViTinh() %></td>
                    <td><%=d.getDonGia() %></td>
                    <td><a href="MainServlet?suaDV=1&maDV=<%=d.getMaDV()%>&tenDV=<%=d.getTenDV()%>&donViTinh=<%=d.getDonViTinh()%>&donGia=<%=d.getDonGia()%>">
                    <img src="image/icon_edit.png"></a></td>
                    <td><a href="DichVuServlet?loai=xoaDV&maDV=<%=d.getMaDV() %>"><img src="image/icon_delete.png"></a></td>
                    </tr>
                    <%
                        }
                    }
                    %> 
            </tbody>
        </table>
    </div>
    <div style="clear: both;"></div>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="MainServlet?danhSachDichVu=1&start=<%=0 %>&end=<%=pages %> ">&laquo; </a></li>
                <%
                    ArrayList<DichVuBEAN> arr = (ArrayList<DichVuBEAN>) request.getAttribute("ListDichVu");
                    int dem = 0;
                    int a, b;
                    int limit = arr.size() / pages;
                    if (limit * pages < arr.size()) {
                        limit += 1;
                    }
                    for (int i = 1; i <= limit; i++) {
                        a = (i - 1) * pages;
                        b = i * pages;
                        if (b > arr.size()) {
                            b = arr.size();
                        }
                        dem++;
                %>
                <li class="page-item"><a class="page-link" href="MainServlet?danhSachDichVu=1&start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                <%
                    }
                %>
                <li class="page-item"><a class="page-link" href="MainServlet?danhSachDichVu=1&start=<%=(dem - 1) * pages%>&end=<%=arr.size()%> "> &raquo; </a></li>

            </ul>
        </div>
        <div class="col-sm-4"></div>
    </div>
</body>
</html>