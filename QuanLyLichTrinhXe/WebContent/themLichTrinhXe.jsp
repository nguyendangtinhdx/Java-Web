<%@page import="bean.TuyenXeBEAN"%>
<%@page import="bean.XeBEAN"%>
<%@page import="bean.NhaXeBEAN"%>
<%@page import="bean.LoaiXeBEAN"%>
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
<script>


       
</script>
<body>
    <% 


    %>
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
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachXeDangKy=1">Danh sách xe đăng ký</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themXe=1">Thêm xe</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachXe=1">Danh sách xe</a></li>            
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachTongTien=1">Danh sách thu nhập của nhà xe</a></li>
        </ul>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get" action="MainServlet">
            <input class="form-control mr-sm-2" type="text" placeholder="Từ khóa tìm kiếm..." aria-label="Search" name="keyMayTinh">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemMayTinh">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    <div id="content">
        <h3 style="text-align: center; color: red;">Thêm mới lịch trình xe</h3>
        <form action="LichTrinhXeServlet" method="post">
            <div class="form-group">
                <label><b>Mã  xe:</b></label> 
                <select class="form-control form-control-sm" name="maXe">
                <%
                if(request.getAttribute("ListXe") != null){
                     ArrayList<XeBEAN> list = (ArrayList<XeBEAN>)request.getAttribute("ListXe");
                     for(XeBEAN h : list){
                %>
                    <option  value="<%=h.getMaXe() %>"><%=h.getHangSanXuat() %></option>
                <%
                     }
                }
                %>
                </select>
            </div>
            <div class="form-group">
                <label><b>Tên tài xế:</b> <span style="color: red"></span></label> 
                <input type="text" class="form-control form-control-sm" placeholder="Tên tài xế" name="tenTaiXe" value="">
            </div>
           
             <div class="form-group">
                <label><b>Mã tuyến:</b></label> 
                <select class="form-control form-control-sm" name="maTuyen">
                <%
                if(request.getAttribute("ListTuyenXe") != null){
                     ArrayList<TuyenXeBEAN> list = (ArrayList<TuyenXeBEAN>)request.getAttribute("ListTuyenXe");
                     for(TuyenXeBEAN h : list){
                %>
                    <option  value="<%=h.getMaTuyenXe() %>"><%=h.getTenTuyen() %></option>
                <%
                     }
                }
                %>
                </select>
            </div>
            <div class="form-group">
                <label><b>Ngày xuất bến: </b> <span style="color: red"></span></label> 
                <input type="date" class="form-control form-control-sm" placeholder="Ngày xuất bến" name="ngayXuatBen" value="">
            </div>
             <div class="form-group">
                <label><b>Giờ xuất bến:</b> <span style="color: red"></span></label> 
                <input type="text" class="form-control form-control-sm" placeholder="Giờ xuất bến" name="gioXuatBen" value="">
            </div>
             <div class="form-group">
                <label><b>Số lượng hành khách:</b> <span style="color: red"></span></label> 
                <input type="number" class="form-control form-control-sm" placeholder="Số lượng hành khách" name="soLuongHanhKhach" value="">
            </div>
            
            

         <button type="submit" class="btn btn-outline-success" name="loai" value="them" id="btnAdd" >Thêm mới</button>
        </form>
    </div>
</body>
</html>