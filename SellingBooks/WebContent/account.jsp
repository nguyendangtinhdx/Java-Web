<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<title>Tài khoản</title>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
<%
    String hoTenErr = "", diaChiErr= "",sdtErr = "", emailErr = "", tenDangNhapErr = "", matKhauErr = "" , ht = "", dc = "", sdt = "", email = "", tdn = "", mk = "", CaptchaErrKhachHang = "" ;
    if(request.getAttribute("hoTenErr") != null){
        hoTenErr = (String)request.getAttribute("hoTenErr");
    }
    if(request.getAttribute("diaChiErr") != null){
        diaChiErr = (String)request.getAttribute("diaChiErr");
    }
    if(request.getAttribute("sdtErr") != null){
        sdtErr = (String)request.getAttribute("sdtErr");
    }
    if(request.getAttribute("emailErr") != null){
        emailErr = (String)request.getAttribute("emailErr");
    }
    if(request.getAttribute("tenDangNhapErr") != null){
        tenDangNhapErr = (String)request.getAttribute("tenDangNhapErr");
    }
    if(request.getAttribute("matKhauErr") != null){
        matKhauErr = (String)request.getAttribute("matKhauErr");
    }
    if(request.getAttribute("CaptchaErrKhachHang") != null){
        CaptchaErrKhachHang = (String)request.getAttribute("CaptchaErrKhachHang");
    }
    
    if(request.getParameter("hoten") != null)
    {
        ht = request.getParameter("hoten");
    }
    if(request.getParameter("diachi") != null)
    {
        dc = request.getParameter("diachi");
    }
    if(request.getParameter("sdt") != null)
    {
        sdt = request.getParameter("sdt");
    }
    if(request.getParameter("email") != null)
    {
        email = request.getParameter("email");
    }
    if(request.getParameter("tendangnhap") != null)
    {
        tdn = request.getParameter("tendangnhap");
    }
    if(request.getParameter("matkhau") != null)
    {
        mk = request.getParameter("matkhau");
    }
%>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <%-- <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div> --%>
            <div class="col-sm-12">
                <div class="row">
                    <div class="col-sm-5 col-sm-offset-1">
                        <div class="login-form">
                            <!--login form-->
                            <h2>Đăng nhập</h2>
                            <form action="KhachHangServlet" method="post">
                            <%
                            if(request.getAttribute("error") != null){
                            %>
                                <b style="color: red; margin-bottom: 10px; float: right;"><%=request.getAttribute("error") %></b>
                            <%} 
                            if(request.getAttribute("loginsuccess") != null){
                            %>
                                <b style="color: green; margin-bottom: 10px; float: right;"><%=request.getAttribute("loginsuccess") %></b>
                            <%} %>
                                <input type="text" placeholder="Tên đăng nhập" name="tendangnhap" /> 
                                <input type="password" placeholder="Mật khẩu" name="matkhau" />
                                <input type="hidden" value="dangnhap" name="loai">
                                <button type="submit" class="btn btn-default">Đăng nhập</button><span style="color: red; float: right;"><%=CaptchaErrKhachHang %></span>
                                <div style="margin-bottom:  20px"></div>
                                <div class="g-recaptcha" data-sitekey="6LeM0zgUAAAAAMkX0zN3Jw7kX93jogJexlGHJpuz"></div>
                            </form>
                        </div>
                        <!--/login form-->
                    </div>
                    <div class="col-sm-5">
                        <div class="signup-form">
                            <!--sign up form-->
                            <h2>Đăng ký</h2>
                            <form action="KhachHangServlet" method="post">
                            <% if(request.getAttribute("signupsuccess") != null){
                            %>
                                <b style="color: green; margin-bottom: 10px; float: right;"><%=request.getAttribute("signupsuccess") %></b>
                            <%} %>
                                <input type="text" placeholder="Họ tên" name="hoten" value="<%=ht %>" /> <p style="color: red"><%=hoTenErr %></p>
                                <input type="text" placeholder="Địa chỉ" name="diachi" value="<%=dc %>" />  <p style="color: red"><%=diaChiErr %></p>
                                <input type="text" placeholder="Số điện thoại" name="sdt" value="<%=sdt %>" /> <p style="color: red"><%=sdtErr %></p>
                                <input type="email" placeholder="Email" name="email" value="<%=email %>" /> <p style="color: red"><%=emailErr %></p>
                                <input type="text" placeholder="Tên đăng nhập" name="tendangnhap" value="<%=tdn %>" /> <p style="color: red"><%=tenDangNhapErr %></p>
                                <!-- <span id="user-result"></span> -->
                                <input type="password" placeholder="Mật khẩu" name="matkhau" value="<%=mk %>"  /> <p style="color: red"><%=matKhauErr %></p>
                                <!-- <span id="user-result"></span> -->
                                <input type="hidden" value="dangky" name="loai">
                                <button type="submit" class="btn btn-default">Đăng ký</button>
                            </form>
                        </div>
                        <!--/sign up form-->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>

<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
      $(document).ready(function () {
           var x_timer;
           $("#tendangnhap").keyup(function (e) {
                clearTimeout(x_timer);
                var user_name = $(this).val();
                x_timer = setTimeout(function () {
                    check_username_ajax(user_name);
                }, 1000);
                });
 
           function check_username_ajax(username) {
                $("#user-result").html('<img src="image/account/ajax-loader.gif" />');
                $.post('XuLyServlet', {'username': username}, function (data) {
                    $("#user-result").html(data);
                 });
           }
       });
</script> -->
</html>