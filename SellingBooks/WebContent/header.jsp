<%@page import="Bean.KhachHangBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
</head>
<body>
<%
        KhachHangBean kh = null;
        if(session.getAttribute("tendangnhap") != null){
             kh = (KhachHangBean)session.getAttribute("tendangnhap");
        }
%>

    <div class="header-middle">
        <!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="XuLyServlet"><img src="image/logo.png" alt="" /></a>
                    </div>

                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle usa"
                            data-toggle="dropdown">
                            Chọn ngôn ngữ <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Tiếng Anh</a></li>
                            <li><a href="#">Tiếng Nhật</a></li>
                            <li><a href="#">Tiếng Trung</a></li>
                            <li><a href="#">Tiếng Pháp</a></li>
                            <li><a href="#">Tiếng Nga</a></li>
                        </ul>
                    </div>


                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <%
                            if(kh != null){
                            %>
                            <li><a href="XuLyServlet?thongke=1"><i class="fa fa-exchange"></i>
                                    Danh sách đơn hàng đã đặt </a></li>
                            <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i>
                                    Thanh toán</a></li>
                            <%} %>
                            <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Giỏ
                                    hàng</a></li>
                            
                            <%
                                if (kh != null) {
                            %>
                            <li><a href="#"><i
                                    class="fa fa-user"></i><%=kh.getTenDangNhap()%></a></li>
                            <li><a href="KhachHangServlet?loai=dangxuat"><i class="fa fa-unlock-alt"></i> Đăng xuất</a></li>
                            <%
                                }else{
                            %>
                            <li><a href="account.jsp"><i class="fa fa-lock"></i> Đăng nhập
                                    & đăng ký</a></li>
                            <%} %>
                            <!-- <li><a href="shipment.jsp"><i class="fa fa-exchange"></i> Giao
                                    hàng 24h</a></li>
                            <li><a href="orderAmazon.jsp"><i class="fa fa-adn"></i> Đặt
                                    hàng Amazon</a></li> -->
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/header-middle-->

    <div class="header-bottom">
        <!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <div class="mainmenu pull-left">
                        <ul class="nav navbar-nav collapse navbar-collapse">
                            <li><a href="XuLyServlet" class="active">Trang chủ</a></li>
                            <li class="dropdown"><a href="recommend.jsp">Giới thiệu<i
                                    class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="XuLyServlet">Sản phẩm</a></li>
                                    <li><a href="checkout.jsp">Thanh toán</a></li>
                                    <li><a href="cart.jsp">Giỏ hàng</a></li>
                                    <li><a href="account.jsp">Đăng nhập</a></li>
                                </ul></li>
                            <li><a href="XuLyServlet?help=1">Hướng dẫn mua hàng</a></li>
                            <li><a href="XuLyServlet?news=1">Bản tin</a></li>
                            <li><a href="XuLyServlet?contact=1">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
                <form action="XuLyServlet" method="post">
                        <div class="col-sm-4">
                            <div class="input-group search_box"> 
                                <input type="text" class="form-control" placeholder="Từ khóa tìm kiếm..." name="key" > 
                                <span class="input-group-btn">
                                    <button class="btn btn-success">Tìm kiếm</button>
                                </span>
                            </div>
                    </div>
                    </form>
            </div>
            
        </div>
    </div>
    <!--/header-->
</body>
</html>