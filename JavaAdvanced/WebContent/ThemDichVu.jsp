<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý của hàng</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="jquery/jquery.min.js"></script>
<script>
        $(document).ready(function() {
            $('.errorID').hide();
            $('#btnAdd').click(function(event) {
                var dtVal = $('#maDV').val();
                if (CheckID(dtVal)) {
                    $('.errorID').hide();
                } else {
                    $('.errorID').show();
                    event.preventDefault();
                }
            });
        });

        function CheckID(id) {
            var dtRegex = new RegExp(/^DV+[0-9]{3}/);
            return dtRegex.test(id);
        }
</script>
</head>
<body>
    <%
         String mdv = "", tdv = "",dvt = "", dg = "";
        if (request.getParameter("maDV") != null) {
            mdv = request.getParameter("maDV");
        }
        if (request.getParameter("tenDV") != null) {
            tdv = request.getParameter("tenDV");
        }
        if (request.getParameter("donViTinh") != null) {
            dvt = request.getParameter("donViTinh");
        }
        if (request.getParameter("donGia") != null) {
            dg = request.getParameter("donGia");
        }
     
        String mdvE = "", tdvE = "",dvtE = "";
        if(request.getAttribute("mdvE") != null){
            mdvE = (String)request.getAttribute("mdvE");
        }
        if(request.getAttribute("tdvE") != null){
            tdvE = (String)request.getAttribute("tdvE");
        }
        if(request.getAttribute("dvtE") != null){
            dvtE = (String)request.getAttribute("dvtE");
        }

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
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachMay=1">Danh sách máy</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themMay=1">Thêm mới máy</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachKhachHang=1">Danh sách khách hàng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themKhachHang=1">Thêm mới khách hàng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachDichVu=1">Danh sách dịch vụ</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themDichVu=1">Thêm mới dịch vụ</a></li>
        </ul>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get" action="MainServlet">
            <input class="form-control mr-sm-2" type="text" placeholder="Từ khóa tìm kiếm..."
                aria-label="Search" name="keyDichVu">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemDichVu">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    <div id="content">
        <h3 style="text-align: center; color: red;">Thêm mới dịch vụ</h3>
        <form action="DichVuServlet" method="post">
          <div class="form-group">
                <label><b>Mã dịch vụ:</b> <span style="color: red"><span class="errorID"> Lỗi định dạng Mã dịch vụ(DVxxx) </span><%=mdvE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Mã dịch vụ"
                    name="maDV"  id="maDV" value="<%=mdv %>">
            </div>
            <div class="form-group">
                <label><b>Tên dịch vụ:</b> <span style="color: red"><%=tdvE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Tên dịch vụ"
                    name="tenDV" value="<%=tdv %>">
            </div>
            <div class="form-group">
                <label><b>Đơn vị tính:</b> <span style="color: red"><%=dvtE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Đơn vị tính"
                    name="donViTinh" value="<%=dvt %>">
            </div>
             <div class="form-group">
                <label><b>Đơn giá:</b></label> <input type="number"  class="form-control form-control-sm" placeholder="Đơn giá"
                    name="donGia" min="0"  required="required" value="<%=dg %>" >
            </div>
         <button type="submit" class="btn btn-outline-success" name="loai" value="them" id="btnAdd">Thêm mới</button>
        </form>
    </div>
</body>
</html>