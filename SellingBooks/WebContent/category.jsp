<%@page import="Bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.LoaiBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>
</head>
<body>

    <div class="left-sidebar">
        <div class="left-sidebar">
            <h2>Sách</h2>
            <div class="panel-group category-products" id="accordian">
                <!--category-productsr-->
                 <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordian" href="#all">
                                <span class="badge pull-right"><i class="fa fa-chevron-down"></i></span>
                               Tất cả
                            </a>
                        </h4>
                    </div>
                    <div id="all" class="panel-collapse collapse">
                        <div class="panel-body">
                            <ul>
                                <%
                                ArrayList<LoaiBean> ListLoai = (ArrayList<LoaiBean>)request.getAttribute("ListLoai");
                                if(request.getAttribute("ListLoai") != null){
                                    for(LoaiBean loai : ListLoai){
                                %>
                                <li><a
                                    href="XuLyServlet?maLoai=<%=loai.getMaLoai()%>&tenLoai=<%=loai.getTenLoai()%>"><%=loai.getTenLoai()%>
                                </a></li>
                                <%
                                    }
                                    }
                                %>
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
                                <span class="badge pull-right"><i class="fa fa-chevron-down"></i></span>
                                Tự nhiên
                            </a>
                        </h4>
                    </div>
                    <div id="sportswear" class="panel-collapse collapse">
                        <div class="panel-body">
                            <ul>
                                <%
                                ArrayList<LoaiBean> ListLoaiTuNhien = (ArrayList<LoaiBean>)request.getAttribute("ListLoaiTuNhien");
                                if(request.getAttribute("ListLoaiTuNhien") != null){
                                    for(LoaiBean loai : ListLoaiTuNhien){
                                %>
                                <li><a
                                    href="XuLyServlet?maLoai=<%=loai.getMaLoai()%>&tenLoai=<%=loai.getTenLoai()%>"><%=loai.getTenLoai()%>
                                </a></li>
                                <%
                                    }
                                    }
                                %>
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordian" href="#mens"> <span
                                class="badge pull-right"><i class="fa fa-chevron-down"></i></span>
                                Xã hội
                            </a>
                        </h4>
                    </div>
                    <div id="mens" class="panel-collapse collapse">
                        <div class="panel-body">
                            <ul>
                                <%
                                ArrayList<LoaiBean> ListLoaiXaHoi = (ArrayList<LoaiBean>)request.getAttribute("ListLoaiXaHoi");
                                if(request.getAttribute("ListLoaiXaHoi") != null){
                                    for(LoaiBean loai : ListLoaiXaHoi){
                                %>
                                <li><a
                                    href="XuLyServlet?maLoai=<%=loai.getMaLoai()%>&tenLoai=<%=loai.getTenLoai()%>"><%=loai.getTenLoai()%>
                                </a></li>
                                <%
                                    }
                                    }
                                %>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!--/category-products-->
            <!-- 
            <div class="brands_products">
                brands_products
                <h2>Brands</h2>
                <div class="brands-name">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="#"> <span class="pull-right">(50)</span>Acne
                        </a></li>
                        <li><a href="#"> <span class="pull-right">(56)</span>Grüne Erde 
                        </a></li>
                    </ul>
                </div>
            </div> -->
            <!--/brands_products-->

            <div class="price-range">
                <!--price-range-->
                <h2>Thư viện ảnh</h2>
                <div id="similar-product" class="carousel slide" data-ride="carousel" >

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <a href=""><img src="image/slide_category/1.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/2.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/3.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/4.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/5.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/6.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/7.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/8.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/9.jpg" alt=""></a>
                        </div>
                        <div class="item">
                            <a href=""><img src="image/slide_category/10.jpg" alt=""></a>
                        </div>

                    </div>

                    <!-- Controls -->
                    <a class="left item-control" href="#similar-product" data-slide="prev"> <i
                        class="fa fa-angle-left"></i>
                    </a> <a class="right item-control" href="#similar-product" data-slide="next"> <i
                        class="fa fa-angle-right"></i>
                    </a>
                </div>
            </div>
            <!--/price-range-->
            <br> <br>

            <div class="price-range">
                <!--price-range-->
                <h2>Bản tin</h2>

                <img src="image/anh_bantin.png" alt="" width="100%" height="200">
                <br> <a href="XuLyServlet?news=1"> <b>THỂ LỆ CHƯƠNG TRÌNH TÍCH LŨY ĐIỂM </b></a>
                <p>Đối tượng tham gia: khách đến mua hàng trực tiếp tại nhà sách Minh Khai. Cách
                    tham gia: · Khi mua hàng, khách tích điểm qua số điện thoại hoặc thẻ thành viên
                    nếu có. · Thẻ thành viên được cấp cho khách ở lần đầu tiên khách nhận tiền chiết
                    khấu. Quy tắc tích</p>

            </div>
            <!--/price-range-->
            <br> <br>

            <h2>Website liên kết</h2>
            <!--shipping-->
            <div class="shipping text-center">
                <a href="https://www.facebook.com/fanpage.minhkhaibookstore" target="_blank"><img src="image/lienket/facebook-logo.jpg" alt="" height="150" width="270" /></a><br>
                <a href="http://www.ems.com.vn/" target="blank"><img src="image/lienket/logo-gui-nhanh.jpg" alt="" height="150" width="270" /></a><br>
                <a href="http://www.vnpost.vn/vi-vn/" target="blank"><img src="image/lienket/logo-gui-thuong.jpg" alt="" height="150" width="270" /></a>
            </div>
            <!--/shipping-->
        </div>
    </div>

    <div style="margin-bottom: 30px;"></div>
</body>
</html>