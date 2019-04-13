<%@page import="java.text.NumberFormat"%>
<%@page import="com.tinhnd.bean.DangKyBEAN"%>
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
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);
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
                aria-label="Search" name="keyMay">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemMay">Tìm kiếm</button>
        </form>
        
    </div>
    </nav>
    
    <div>
     <h3 style="text-align: center; color: red;">Thông tin đăng khách hàng đăng ký</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã khách hàng</th>
                    <th>Tên khách hàng</th>
                    <th>Mã máy</th>
                    <th>Vị trí</th>
                    <th>Trạng thái</th>
                    <th>Ngày bắt đầu sử dụng</th>
                    <th>Giờ bắt đầu sử dụng</th>
                    <th>Thời gian sử dụng</th>
                    <th>Mã dịch vụ</th>
                    <th>Ngày sử dụng</th>
                    <th>Giờ sử dụng</th>
                    <th>Số lượng</th>
                    <th>Tổng tiền</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    int sum = 0;
                    if(request.getAttribute("ListDangKyByPage") != null){
                        ArrayList<DangKyBEAN> dk = (ArrayList<DangKyBEAN>)request.getAttribute("ListDangKyByPage");
                        for(DangKyBEAN d : dk){
                           
                    %>
                    <tr>
                    <td><%=d.getMaKH() %></td>
                    <td><%=d.getTenKH() %></td>
                    <td><%=d.getMaMay() %></td>
                    <td><%=d.getViTri() %></td>
                    <td><%=d.getTrangThai() %></td>
                    <td><%=d.getNgayBatDauSuDung() %></td>
                    <td><%=d.getGioBatDauSuDung() %></td>
                    <td><%=d.getThoiGianSuDung() %></td>
                    <td><%=d.getMaDV() %></td>
                    <td><%=d.getNgaySuDung() %></td>
                    <td><%=d.getGioSuDung() %></td>
                    <td><%=d.getSoLuong() %></td>
                    <td><%=d.getTongTien() %></td>
                    <%
                    sum += d.getTongTien();
                        }
                    }
                    %> 
            </tbody>
        </table>
       
        <b style="float: right; margin-right: 20px"><label>Tổng tiền sử dụng dịch vụ: </label> <%=nf.format(sum) %> VNĐ</b>
    </div>
    <div style="clear: both;"></div>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="MainServlet?danhSachDangKy=1&start=<%=0 %>&end=<%=pages %> ">&laquo; </a></li>
                <%
                    ArrayList<DangKyBEAN> arr = (ArrayList<DangKyBEAN>) request.getAttribute("ListDangKy");
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
                <li class="page-item"><a class="page-link" href="MainServlet?danhSachDangKy=1&start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                <%
                    }
                %>
                <li class="page-item"><a class="page-link" href="MainServlet?danhSachDangKy=1&start=<%=(dem - 1) * pages%>&end=<%=arr.size()%> "> &raquo; </a></li>

            </ul>
        </div>
        <div class="col-sm-4"></div>
    </div>
</body>
</html>