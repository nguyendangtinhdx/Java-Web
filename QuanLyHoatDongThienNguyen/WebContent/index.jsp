<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="bean.HoatDongBEAN"%>
<%@page import="bean.ThanhVienBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý hoạt động thiện nguyện</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand"
        href="XuLyServlet">Trang chủ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?add=1">Thêm mới</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?tk=1">Thống kê</a></li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Từ khóa tìm kiếm..."
                aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    
    <div>
     <h3 style="text-align: center; color: red;">Thông tin hoạt động</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã hoạt động</th>
                    <th>Tên hoạt động</th>
                    <th>Mô tả hoạt động</th>
                    <th>Ngày  giờ bắt đầu</th>
                    <th>Ngày giờ kết thúc</th>
                    <th>Số lượng tối thiểu</th>
                    <th>Số lượng tối đa</th>
                    <th>Thời gian đăng ký</th>
                    <th>Trạng thái</th>
                    <th>Mã thành viên</th>
                    <th colspan="2">Tùy chọn</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    if(request.getAttribute("ListHoatDong") != null){
                        ArrayList<HoatDongBEAN> hoatDong = (ArrayList<HoatDongBEAN>)request.getAttribute("ListHoatDong");
                        for(HoatDongBEAN hd : hoatDong){
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                           
                    %>
                    <tr>
                    <td><%=hd.getMaHoatDong() %></td>
                    <td><%=hd.getTenHoatDong() %></td>
                    <td><%=hd.getMoTaHoatDong() %></td>
                    <td><%=df.format( hd.getNgayGioBatDau()) %></td>
                    <td><%=df.format( hd.getNgayGioKetThuc()) %></td>
                    <td><%=hd.getSoLuongToiThieu() %></td>
                    <td><%=hd.getSoLuongToiDa() %></td>
                    <td><%=hd.getThoiHanDangKy() %></td>
                    <td><%=hd.getTrangThai() %></td>
                    <td><%=hd.getMaThanhVien() %></td>
                    <td><a href="XuLyServlet?edit=1&maHoatDong=<%=hd.getMaHoatDong()%>&tenHoatDong=<%=hd.getTenHoatDong()%>&moTaHoatDong=<%=hd.getMoTaHoatDong()%>&ngayGioBatDau=<%=hd.getNgayGioBatDau()%>&ngayGioKetThuc=<%=hd.getNgayGioKetThuc()%>&soLuongToiThieu=<%=hd.getSoLuongToiThieu()%>&soLuongToiDa=<%=hd.getSoLuongToiDa()%>&thoiHanDangKy=<%=hd.getThoiHanDangKy()%>&trangThai=<%=hd.getTrangThai()%>&lyDoHuyHoatDong=<%=hd.getLyDoHuyHoatDong()%>">
                    <img src="image/icon_edit.png"></a></td>
                    <td><a href="HoatDongServlet?loai=xoa&maHoatDong=<%=hd.getMaHoatDong() %>"><img src="image/icon_delete.png"></a></td>
                    </tr>
                    <%
                        }
                    }
                    %>
            </tbody>
        </table>
    </div>
</body>
</html>