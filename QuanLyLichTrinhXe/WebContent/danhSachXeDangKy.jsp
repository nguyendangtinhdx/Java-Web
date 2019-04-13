<%@page import="bean.XeDangKyBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý lịch trình xe</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

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
            <input class="form-control mr-sm-2" type="text" placeholder="Từ khóa tìm kiếm..." aria-label="Search" name="keyXeDangKy">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemXeDangKy">Tìm kiếm</button>
        </form>
        
    </div>
    </nav>
    
    <div>
     <h3 style="text-align: center; color: red;">Danh sách xe có đăng ký</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã xe</th>
                    <th>Biển số</th>
                    <th>Tên tài xế</th>
                    <th>Tên nhà xe</th>
                    <th>Mã tuyến</th>
                    <th>Tên tuyến</th>
                    <th>Ngày xuất bến</th>
                    <th>Giờ xuất bến</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    if(request.getAttribute("ListXeDangKy") != null){
                        ArrayList<XeDangKyBEAN> list = (ArrayList<XeDangKyBEAN>)request.getAttribute("ListXeDangKy");
                        for(XeDangKyBEAN m : list){
                           
                    %>
                    <tr>
                    <td><a href="MainServlet?themLichTrinhXe=1"><%=m.getMaXe() %></a> </td>
                    <td><%=m.getBienSo() %></td>
                    <td><%=m.getTenTaiXe() %></td>
                    <td><%=m.getTenNhaXe() %></td>
                    <td><%=m.getMaTuyen() %></td>
                    <td><%=m.getTenTuyen() %></td>
                    <td><%=m.getNgayXuatBen() %></td>
                    <td><%=m.getGioXuatBen() %></td>
                    </tr>
                    <%
                        }
                    }
                    %> 
            </tbody>
        </table>
    </div>
    <div style="clear: both;"></div>
</body>
</html>