<%@page import="bean.ThongKeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê điểm trung bình của các trưởng đoàn</title>
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
     <h3 style="text-align: center; color: red;">Thống kê điểm trung bình của các trưởng đoàn</h3>
        <table class="table table-hover" style="width: 80%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã thành viên</th>
                    <th>Họ tên</th>
                    <th>Điểm trung bình</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    if(request.getAttribute("ListThongKe") != null){
                        ArrayList<ThongKeBEAN> thongKe = (ArrayList<ThongKeBEAN>)request.getAttribute("ListThongKe");
                        for(ThongKeBEAN tk : thongKe){
                    %>
                    <tr>
                    <td><%=tk.getMaThanhVien() %></td>
                    <td><%=tk.getHoTen() %></td>
                    <td><%=tk.getDiemTrungBinh() %></td>
                    <%
                        }
                    }
                    %>
            </tbody>
        </table>
    </div>
</body>
</html>