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
                var dtVal = $('#maKH').val();
                if (CheckID(dtVal)) {
                    $('.errorID').hide();
                } else {
                    $('.errorID').show();
                    event.preventDefault();
                }
            });
        });
        function CheckID(id) {
            var dtRegex = new RegExp(/^KH+[0-9]{5}/);
            return dtRegex.test(id);
        }
        

        $(document).ready(function() {
            $('.errorPhone').hide();
            $('#btnAdd').click(function(event) {
                var dtVal = $('#soDienThoai').val();
                if (CheckPhone(dtVal)) {
                    $('.errorPhone').hide();
                } else {
                    $('.errorPhone').show();
                    event.preventDefault();
                }
            });
        });
        function CheckPhone(dtValue) {
            var dtRegex = new RegExp(/(^090|^091|^(84)+90|^(84)+91)+[0-9]{7}/);
            return dtRegex.test(dtValue);
        }
        
        
        $(document).ready(function() {
            $('.errorEmail').hide();
            $('#btnAdd').click(function(event) {
                var dtVal = $('#diaChiEmail').val();
                if (CheckEmail(dtVal)) {
                    $('.errorEmail').hide();
                } else {
                    $('.errorEmail').show();
                    event.preventDefault();
                }
            });
        });

        function CheckEmail(dtValue) {
            var dtRegex = new RegExp(
                    /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/);
            return dtRegex.test(dtValue);
        }
</script>
<body>
    <%
         String mkh = "", tkh = "", dc = "", sdt = "", email = "";
        if (request.getParameter("maKH") != null) {
            mkh = request.getParameter("maKH");
        }
        if (request.getParameter("tenKH") != null) {
            tkh = request.getParameter("tenKH");
        }
        if (request.getParameter("diaChi") != null) {
            dc = request.getParameter("diaChi");
        }
        if (request.getParameter("soDienThoai") != null) {
            sdt = request.getParameter("soDienThoai");
        }
        if (request.getParameter("diaChiEmail") != null) {
            email = request.getParameter("diaChiEmail");
        }
     
        String mkhE = "", tkhE = "", dcE = "", sdtE = "", emailE = "";
        if(request.getAttribute("mkhE") != null){
            mkhE = (String)request.getAttribute("mkhE");
        }
        if(request.getAttribute("tkhE") != null){
            tkhE = (String)request.getAttribute("tkhE");
        }
        if(request.getAttribute("dcE") != null){
            dcE = (String)request.getAttribute("dcE");
        }
        if(request.getAttribute("sdtE") != null){
            sdtE = (String)request.getAttribute("sdtE");
        }
        if(request.getAttribute("emailE") != null){
            emailE = (String)request.getAttribute("emailE");
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
                aria-label="Search" name="keyKhachHang">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemKhachHang">Tìm kiếm</button>
        </form>
    </div>
    </nav>
    <div id="content">
        <h3 style="text-align: center; color: red;">Thêm mới khách hàng</h3>
        <form action="KhachHangServlet" method="post">
          <div class="form-group">
                <label><b>Mã khách hàng:</b> <span style="color: red"> <span class="errorID"> Lỗi định dạng Mã khách hàng (KHxxxxx) </span>
                <%=mkhE %></span></label> <input type="text" class="form-control form-control-sm" placeholder="Mã khách hàng"
                    name="maKH" id="maKH" value="<%=mkh %>">
               
            </div>
            <div class="form-group">
                <label><b>Tên khách hàng:</b> <span style="color: red"><%=tkhE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Tên khách hàng"
                    name="tenKH" value="<%=tkh %>">
            </div>
            <div class="form-group">
                <label><b>Địa chỉ:</b> <span style="color: red"><%=dcE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Địa chỉ"
                    name="diaChi" value="<%=dc %>">
            </div>
            <div class="form-group">
                <label><b>Số điện thoại:</b> <span style="color: red"><span class="errorPhone"> Lỗi định dạng Số điện thoại(xxxxxxxxxx) </span><%=sdtE %></span></label> <input type="text"
                    class="form-control form-control-sm" placeholder="Số điện thoại"
                    name="soDienThoai" id="soDienThoai" value="<%=sdt %>">
            </div>
            <div class="form-group">
                <label><b>Email:</b> <span style="color: red"><span class="errorEmail"> Lỗi định dạng Email(abc@gmail.com) </span><%=emailE %></span></label> <input type="email"
                    class="form-control form-control-sm" placeholder="Email"
                    name="diaChiEmail" id="diaChiEmail" value="<%=email %>">
            </div>
         <button type="submit" class="btn btn-outline-success" name="loai" value="them" id="btnAdd">Thêm mới</button>
        </form>
    </div>
</body>
</html>