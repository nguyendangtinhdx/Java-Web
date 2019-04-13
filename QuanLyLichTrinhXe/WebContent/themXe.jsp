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
        $(document).ready(function() {
            $('.errorBienSo').hide();
            $('#btnAdd').click(function(event) {
                var dtVal = $('#bienSo').val();
                if (CheckBienSoXe(dtVal)) {
                    $('.errorBienSo').hide();
                } else {
                    $('.errorBienSo').show();
                    event.preventDefault();
                }
            });
        });
        function CheckBienSoXe(id) {
            var dtRegex = new RegExp(/^[0-9]{2}+H+[0-9]{1}+K+[0-9]{5}/);
       //     var dtRegex = new RegExp(/^KH+[0-9]{5}/);
            return dtRegex.test(id);
        }

       
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
        <h3 style="text-align: center; color: red;">Thêm mới Xe</h3>
        <form action="XeServlet" method="post">
          <div class="form-group">
                <label><b>Mã xe:</b> <span style="color: red" id="errorMa"></span></label> 
                <input type="text"class="form-control form-control-sm" placeholder="Mã xe" name="maXe" id="maXe" value="">
            </div>
            <div class="form-group">
                <label><b>Hãng sản xuất:</b> <span style="color: red"></span></label> 
                <input type="text" class="form-control form-control-sm" placeholder="Hãng sản xuất" name="hangSanXuat" value="">
            </div>
           
             <div class="form-group">
                <label><b>Mã loại xe:</b></label> 
                <select class="form-control form-control-sm" name="maLoaiXe">
                <%
                if(request.getAttribute("ListLoaiXe") != null){
                     ArrayList<LoaiXeBEAN> list = (ArrayList<LoaiXeBEAN>)request.getAttribute("ListLoaiXe");
                     for(LoaiXeBEAN h : list){
                %>
                    <option  value="<%=h.getMaLoaiXe() %>"><%=h.getMoTaLoaiXe() %></option>
                <%
                     }
                }
                %>
                </select>
            </div>
            
             <div class="form-group">
                <label><b>Biển số:</b> <span style="color: red" class="errorBienSo">Lỗi định dạng Biển số (xxYx - xxxxx) </span></label> 
                <input type="text" class="form-control form-control-sm" placeholder="Biển số" name="bienSo" value="" id="bienSo">
            </div>
            <div class="form-group">
                <label><b>Hạn kiểm định: </b> <span style="color: red"></span></label> 
                <input type="date" class="form-control form-control-sm" placeholder="Hạn kiểm định" name="hanKiemDinh" value="">
            </div>
            
            <div class="form-group">
                <label><b>Mã nhà xe:</b></label> 
                <select class="form-control form-control-sm" name="maNhaXe">
                <%
                if(request.getAttribute("ListNhaXe") != null){
                     ArrayList<NhaXeBEAN> list = (ArrayList<NhaXeBEAN>)request.getAttribute("ListNhaXe");
                     for(NhaXeBEAN h : list){
                %>
                    <option  value="<%=h.getMaNhaXe() %>"><%=h.getTenNhaXe() %></option>
                <%
                     }
                }
                %>
                </select>
            </div>

         <button type="submit" class="btn btn-outline-success" name="loai" value="them" id="btnAdd">Thêm mới</button>
        </form>
    </div>
</body>
</html>