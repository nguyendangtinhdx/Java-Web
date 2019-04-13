<%@page import="bean.DotUngHoBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin đợt ủng hộ</title>
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
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?dotUngHo=1">Đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?chiTietDotUngHo=1">Chi tiết đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?addDotUngHo=1">Thêm mới đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?addChiTietDotUngHo=1">Thêm mới chi tiết đợt ủng hộ</a></li>
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
     <h3 style="text-align: center; color: red;">Thông tin đợt ủng hộ</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã đợt ủng hộ</th>
                    <th>Mã đơn vị ủng hộ</th>
                    <th>Ngày ủng hộ</th>
                    <th colspan="2">Tùy chọn</th>
                </tr>
            </thead>
            <tbody>
                    <%  
                    if(request.getAttribute("ListDotUngHo") != null){
                        ArrayList<DotUngHoBEAN> dotUngHo = (ArrayList<DotUngHoBEAN>) request.getAttribute("ListDotUngHo");
                        for(DotUngHoBEAN duh : dotUngHo){
                    %>
                    <tr>
                    <td><%=duh.getMaDotUngHo() %></td>
                    <td><%=duh.getMaDonViUngHo() %></td>
                    <td><%=duh.getNgayUngHo() %></td>
                    <td><a href="XuLyServlet?editDotUngHo=1&maDotUngHo=<%=duh.getMaDotUngHo() %>&maDonViUngHo=<%=duh.getMaDonViUngHo() %>&ngayUngHo=<%=duh.getNgayUngHo() %>"><img src="image/icon_edit.png"></a></td>
                    <td><a href="DotUngHoServlet?loai=xoa&maDotUngHo=<%=duh.getMaDotUngHo() %>"><img src="image/icon_delete.png"></a></td>
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