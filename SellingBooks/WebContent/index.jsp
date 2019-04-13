<%@page import="java.util.ArrayList"%>
<%@page import="Bean.SachBean"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon shortcut" href="image/logo.png">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Cửa hàng bán sách</title>
</head>
<body>
    <%
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);

    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div>
            <div class="col-sm-9">
                <section id="slider"> <jsp:include page="slider.jsp"></jsp:include> </section>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-12 padding-right">

                            <div class="features_items">
                                <!--features_items-->
                                <h2 class="title text-center" id="margin_top_detail">Sách mới
                                    nhất</h2>

                                <%
                                ArrayList<SachBean> ListSachMoiNhatTrangChu = (ArrayList<SachBean>)request.getAttribute("ListSachMoiNhatTrangChu");
                                if(request.getAttribute("ListSachMoiNhatTrangChu") != null){
                                    for(SachBean sach : ListSachMoiNhatTrangChu){
                                %>

                                <div class="col-sm-4" style="height: 500px;">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=Tin Học">
                                                    <img src="image/<%=sach.getAnh()%>"
                                                    alt="<%=sach.getTenSach()%>"
                                                    title="<%=sach.getTenSach()%>" height="280" />
                                                </a>
                                                <h2><%=nf.format(sach.getGia())%>
                                                    đ
                                                </h2>
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=Tin Học">
                                                    <p class="hover"><%=sach.getTenSach()%></p>
                                                </a>
                                                <p>
                                                    Tác giả:
                                                    <%=sach.getTacGia()%></p>
                                                <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>" class="btn btn-default add-to-cart"><i
                                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                            </div>
                                            <img src="image/new.png" class="new" alt="" />
                                        </div>

                                    </div>
                                </div>

                                <%
                                    }
                                    }
                                %>

                            </div>
                            <!--features_items-->

                            <div class="recommended_items">
                                <!--recommended_items-->
                                <h2 class="title text-center" id="margin_top_detail">Sách giá rẻ</h2>

                                <div id="recommended-item-carousel" class="carousel slide"
                                    data-ride="carousel">
                                    <div class="carousel-inner">


                                        <div class="item active">
                                              <%
                                                ArrayList<SachBean> ListSachGiaRe = (ArrayList<SachBean>)request.getAttribute("ListSachGiaRe");
                                                if(request.getAttribute("ListSachGiaRe") != null){
                                                    for(SachBean sach : ListSachGiaRe){
                                                %>
                                            <div class="col-sm-4">
                                                <div class="product-image-wrapper">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai() %>&tenLoai=Tin Học">
                                                                <img src="image/<%=sach.getAnh()%>"
                                                                alt="<%=sach.getTenSach()%>"
                                                                title="<%=sach.getTenSach()%>"
                                                                height="250" />
                                                            </a>
                                                            <h2><%=nf.format(sach.getGia())%>
                                                                đ
                                                            </h2>
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai() %>&tenLoai=Tin Học">
                                                                <p class="hover"><%=sach.getTenSach()%></p>
                                                            </a>
                                                            <p>
                                                                Tác giả:
                                                                <%=sach.getTacGia()%></p>
                                                                <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>" class="btn btn-default add-to-cart"><i
                                                                class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <%
                                                }
                                                }
                                            %>
                                        </div>


                                        <div class="item">

                                            <%
                                            ArrayList<SachBean> ListSachGiaRe2 = (ArrayList<SachBean>)request.getAttribute("ListSachGiaRe");
                                            if(request.getAttribute("ListSachGiaRe") != null){
                                                for(SachBean sach : ListSachGiaRe2){
                                            %>
                                            <div class="col-sm-4">
                                                <div class="product-image-wrapper">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai() %>&tenLoai=Tin Học">
                                                                <img src="image/<%=sach.getAnh()%>"
                                                                alt="<%=sach.getTenSach()%>"
                                                                title="<%=sach.getTenSach()%>"
                                                                height="250" />
                                                            </a>
                                                            <h2><%=nf.format(sach.getGia())%>
                                                                đ
                                                            </h2>
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai() %>&tenLoai=Tin Học">
                                                                <p class="hover"><%=sach.getTenSach()%></p>
                                                            </a>
                                                            <p>
                                                                Tác giả:
                                                                <%=sach.getTacGia()%></p>
                                                                <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>" class="btn btn-default add-to-cart"><i
                                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <%
                                                }
                                                }
                                            %>

                                        </div>
                                    </div>
                                    <a class="left recommended-item-control"
                                        href="#recommended-item-carousel" data-slide="prev"> <i
                                        class="fa fa-angle-left"></i>
                                    </a> <a class="right recommended-item-control"
                                        href="#recommended-item-carousel" data-slide="next"> <i
                                        class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>
                            <!--/recommended_items-->


                              <div class="category-tab">
                        <!--category-tab-->
                        <div class="col-sm-12">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#KhoaHoc" data-toggle="tab">Khoa học</a></li>
                                <li><a href="#ToanHoc" data-toggle="tab">Toán học</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="KhoaHoc">
                                <%
                                    ArrayList<SachBean> ListSachKhoaHoc = (ArrayList<SachBean>)request.getAttribute("ListSachKhoaHoc");
                                    if(request.getAttribute("ListSachKhoaHoc") != null){
                                        for(SachBean sach : ListSachKhoaHoc){
                                %>
                                <div class="col-sm-3">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai() %>&tenLoai=Khoa học">
                                                    <img src="image/<%=sach.getAnh()%>"
                                                    alt="<%=sach.getTenSach()%>"
                                                    title="<%=sach.getTenSach() %> %>" height="250" />
                                                </a>
                                                <h2><%=nf.format(sach.getGia()) %>
                                                    đ
                                                </h2>
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai() %>&tenLoai=Khoa học">
                                                    <p class="hover"><%=sach.getTenSach() %></p>
                                                </a>
                                                <p>
                                                    Tác giả:
                                                    <%=sach.getTacGia() %></p>
                                                    <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>&cartID=<%=System.currentTimeMillis()%>" class="btn btn-default add-to-cart"><i
                                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%
                                        }
                                    }
                                %>
                            </div>

                            <div class="tab-pane fade" id="ToanHoc">
                              
                                   <%
                                    ArrayList<SachBean> ListSachToanHoc= (ArrayList<SachBean>)request.getAttribute("ListSachToanHoc");
                                    if(request.getAttribute("ListSachToanHoc") != null){
                                        for(SachBean sach : ListSachToanHoc){
                                %>
                                <div class="col-sm-3">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=request.getParameter("maLoai") %>&tenLoai=Toán Học">
                                                    <img src="image/<%=sach.getAnh()%>"
                                                    alt="<%=sach.getTenSach()%>"
                                                    title="<%=sach.getTenSach() %> %>" height="250" />
                                                </a>
                                                <h2><%=nf.format(sach.getGia()) %>
                                                    đ
                                                </h2>
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=request.getParameter("maLoai") %>&tenLoai=Toán Học">
                                                    <p class="hover"><%=sach.getTenSach() %></p>
                                                </a>
                                                <p>
                                                    Tác giả:
                                                    <%=sach.getTacGia() %></p>
                                                <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>" class="btn btn-default add-to-cart"><i
                                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%
                                        }
                                    }
                                %>
                            
                            </div>


                        </div>
                    </div>
                    <!--/category-tab-->
                    

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</html>