<%@page import="bean.HoKhauBEAN"%>
<%@page import="bean.CongDanBEAN"%>
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
     <h3 style="text-align: center; color: red;">Thông tin hộ khẩu</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>HoKhauID</th>
                    <th>Tỉnh - Thành phố</th>
                    <th>Quận - Huyện</th>
                    <th>Phường - Xã</th>
                    <th>Tổ - Thôn</th>
                    <th>Chủ Hộ</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    if(request.getAttribute("ListHoKhau") != null){
                        ArrayList<HoKhauBEAN> hoKhau = (ArrayList<HoKhauBEAN>)request.getAttribute("ListHoKhau");
                        for(HoKhauBEAN cd : hoKhau){
                    %>
                    <tr>
                    <td><%=cd.getHoKhauID() %></td>
                    <td><%=cd.getTinh_TP() %></td>
                    <td><%=cd.getQuan_Huyen() %></td>
                    <td><%=cd.getPhuong_Xa()%></td>
                    <td><%=cd.getTo_Thon() %></td>
                    <td><%=cd.getChuHoID() %></td>
                    <td><a href="HoKhauServlet?edit=1&hoKhauID=<%=cd.getHoKhauID()%>&tinh_TP=<%=cd.getTinh_TP()%>&quanHuyen=<%=cd.getQuan_Huyen()%>&phuong_Xa=<%=cd.getPhuong_Xa()%>&to_Thon=<%=cd.getTo_Thon()%>&chuHoID=<%=cd.getChuHoID()%>">
                    <img src="image/icon_edit.png"></a></td>
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