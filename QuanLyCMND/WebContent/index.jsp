<%@page import="bean.LichSuLuuTruBEAN"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

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
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?add=1">Thêm mới công dân</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?quanLyCongDan=1">Quản lý công dân</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?quanLyHoKhau=1">Quản lý hộ khẩu</a></li>
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
     <h3 style="text-align: center; color: red;">Thông tin lịch sử lưu trú</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Số CMND</th>
                    <th>Hộ khẩu ID</th>
                    <th>Loại lưu trú ID</th>
                    <th>Thời gian bắt đầu lưu trú</th>
                    <th>Thời gian kết thúc lưu trú</th>
                    <th>Quan hệ với chủ hộ</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    if(request.getAttribute("ListLichSuLuuTru") != null){
                        ArrayList<LichSuLuuTruBEAN> lichSuLuuTru = (ArrayList<LichSuLuuTruBEAN>)request.getAttribute("ListLichSuLuuTru");
                        for(LichSuLuuTruBEAN ls : lichSuLuuTru){
                            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    %>
                    <tr>
                    <td><%=ls.getCmndID() %></td>
                    <td><%=ls.getHoKhauID() %></td>
                    <td><%=ls.getLoaiLuuTruID() %></td>
                    <td><%=df.format( ls.getThoiGianBatDauLT()) %></td>
                    <td><%=df.format( ls.getThoiGianKetThucLT()) %></td>
                    <td><%=ls.getQuanHeVoiChuHo() %></td>
                   <%--  <td><a href="XuLyServlet?edit=1&maHoatDong=<%=ls.getMaHoatDong()%>&tenHoatDong=<%=hd.getTenHoatDong()%>&moTaHoatDong=<%=hd.getMoTaHoatDong()%>&ngayGioBatDau=<%=hd.getNgayGioBatDau()%>&ngayGioKetThuc=<%=hd.getNgayGioKetThuc()%>&soLuongToiThieu=<%=hd.getSoLuongToiThieu()%>&soLuongToiDa=<%=hd.getSoLuongToiDa()%>&thoiHanDangKy=<%=hd.getThoiHanDangKy()%>&trangThai=<%=hd.getTrangThai()%>&lyDoHuyHoatDong=<%=hd.getLyDoHuyHoatDong()%>">
                    <img src="image/icon_edit.png"></a></td>
                    <td><a href="HoatDongServlet?loai=xoa&maHoatDong=<%=hd.getMaHoatDong() %>"><img src="image/icon_delete.png"></a></td> --%>
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