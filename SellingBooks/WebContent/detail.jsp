<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.SachBean"%>
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
<link href="css/style.css" rel="stylesheet">
<title>Chi tiết sản phẩm</title>
</head>
<body>
    <%
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);
        
        SachBean sach = (SachBean)request.getAttribute("Sach");
    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div>
            <div class="col-sm-9">
                <div class="col-sm-12 padding-right">
                    <div class="product-details">
                        <!--product-details-->
                        <div class="col-sm-5">
                            <div class="view-product">
                                <img src="image/<%=sach.getAnh()%>" alt="<%=sach.getTenSach()%>" />
                            </div>

                        </div>
                        <div class="col-sm-7">
                            <div class="product-information">
                                <!--/product-information-->
                                <img src="image/new.jpg" class="newarrival" alt="" />
                                <h2><%=sach.getTenSach()%></h2>
                                <p>
                                    <b>Tác giả: </b>
                                    <%=sach.getTacGia()%>
                                </p>
                                <p>
                                    <b>Thể loại: </b> <a
                                        href="XuLyServlet?maLoai=<%=request.getParameter("maLoai")%>&tenLoai=<%=request.getParameter("tenLoai")%>"><%=request.getParameter("tenLoai")%></a>
                                </p>
                                <p>
                                    <b>Số tập: </b>
                                    <%=sach.getSoTap()%>
                                </p>
                                <p>
                                    <b>Số lượng: </b>
                                    <%=sach.getSoLuong()%>
                                </p>
                                <p>
                                    <b>Xuất bản: </b>
                                    <%=sach.getNgayNhap()%>
                                </p>

                                <span> <span><%=nf.format(sach.getGia())%> đ</span><br>

                                </span>
                                <p class="margin_button">
                                    <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>" class="btn btn-default add-to-cart"><i
                                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                </p>
                            </div>
                            <!--/product-information-->
                        </div>
                    </div>
                    <!--/product-details-->

                    <div class="category-tab shop-details-tab">
                        <!--category-tab-->
                        <div class="col-sm-12">
                            <ul class="nav nav-tabs">
                                <li><a href="#details" data-toggle="tab">Chi tiết sản phẩm</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="reviews">
                                <div class="col-sm-12">
                                    <p>Nội dung sản phẩm</p>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!--/category-tab-->

                    <div class="recommended_items">
                        <!--recommended_items-->
                        <h2 class="title text-center" id="margin_top_detail">Sách mới nhất</h2>

                        <div id="recommended-item-carousel" class="carousel slide"
                            data-ride="carousel">
                            <div class="carousel-inner">


                                <div class="item active">
                                     <%
                                        ArrayList<SachBean> ListSachMoiNhat = (ArrayList<SachBean>)request.getAttribute("ListSachMoiNhat");
                                        if(request.getAttribute("ListSachMoiNhat") != null){
                                            for(SachBean sachmoi : ListSachMoiNhat){
                                    %>
                                    <div class="col-sm-4">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <a
                                                        href="XuLyServlet?maSach=<%=sachmoi.getMaSach()%>&maLoai=<%=request.getParameter("maLoai")%> %>&tenLoai=<%=request.getParameter("tenLoai")%>">
                                                        <img src="image/<%=sachmoi.getAnh()%>"
                                                        alt="<%=sachmoi.getTenSach()%>"
                                                        title="<%=sachmoi.getTenSach()%>"
                                                        height="250" />
                                                    </a>
                                                    <h2><%=nf.format(sachmoi.getGia())%>
                                                        đ
                                                    </h2>
                                                    <a
                                                        href="XuLyServlet?maSach=<%=sachmoi.getMaSach()%>&maLoai=<%=request.getParameter("maLoai")%>&tenLoai=<%=request.getParameter("tenLoai")%>">
                                                        <p class="hover"><%=sachmoi.getTenSach()%></p>
                                                    </a>
                                                    <p>
                                                        Tác giả:
                                                        <%=sachmoi.getTacGia()%></p>
                                                        <a href="GioHangServlet?loai=them&maSach=<%=sachmoi.getMaSach() %>" class="btn btn-default add-to-cart"><i
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
                                        ArrayList<SachBean> ListSachMoiNhat2 = (ArrayList<SachBean>)request.getAttribute("ListSachMoiNhat");
                                        if(request.getAttribute("ListSachMoiNhat") != null){
                                            for(SachBean sachmoi : ListSachMoiNhat2){
                                    %>
                                    <div class="col-sm-4">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <a
                                                        href="XuLyServlet?maSach=<%=sachmoi.getMaSach()%>&maLoai=<%=request.getParameter("maLoai")%> %>&tenLoai=<%=request.getParameter("tenLoai")%>">
                                                        <img src="image/<%=sachmoi.getAnh()%>"
                                                        alt="<%=sachmoi.getTenSach()%>"
                                                        title="<%=sachmoi.getTenSach()%>"
                                                        height="250" />
                                                    </a>
                                                    <h2><%=nf.format(sachmoi.getGia())%>
                                                        đ
                                                    </h2>
                                                    <a
                                                        href="XuLyServlet?maSach=<%=sachmoi.getMaSach()%>&maLoai=<%=request.getParameter("maLoai")%>&tenLoai=<%=request.getParameter("tenLoai")%>">
                                                        <p class="hover"><%=sachmoi.getTenSach()%></p>
                                                    </a>
                                                    <p>
                                                        Tác giả:
                                                        <%=sachmoi.getTacGia()%></p>
                                                        <a href="GioHangServlet?loai=them&maSach=<%=sachmoi.getMaSach() %>" class="btn btn-default add-to-cart"><i
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
                                <li class="active"><a href="#tshirt" data-toggle="tab">Sách
                                        liên quan 1</a></li>
                                <li><a href="#blazers" data-toggle="tab">Sách liên quan 2</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="tshirt">
                                <%
                                    ArrayList<SachBean> ListSachLienQuan = (ArrayList<SachBean>)request.getAttribute("ListSachLienQuan");
                                    if(request.getAttribute("ListSachLienQuan") != null){
                                        for(SachBean sachlienquan : ListSachLienQuan){
                                %>
                                <div class="col-sm-3">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a
                                                    href="XuLyServlet?maSach=<%=sachlienquan.getMaSach()%>&maLoai=<%=request.getParameter("maLoai") %>&tenLoai=<%=request.getParameter("tenLoai") %>">
                                                    <img src="image/<%=sachlienquan.getAnh()%>"
                                                    alt="<%=sachlienquan.getTenSach()%>"
                                                    title="<%=sachlienquan.getTenSach() %> %>" height="250" />
                                                </a>
                                                <h2><%=nf.format(sachlienquan.getGia()) %>
                                                    đ
                                                </h2>
                                                <a
                                                    href="XuLyServlet?maSach=<%=sachlienquan.getMaSach()%>&maLoai=<%=request.getParameter("maLoai") %>&tenLoai=<%=request.getParameter("tenLoai") %>">
                                                    <p class="hover"><%=sachlienquan.getTenSach() %></p>
                                                </a>
                                                <p>
                                                    Tác giả:
                                                    <%=sachlienquan.getTacGia() %></p>
                                                    <a href="GioHangServlet?loai=them&maSach=<%=sachlienquan.getMaSach() %>" class="btn btn-default add-to-cart"><i
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

                            <div class="tab-pane fade" id="blazers">
                              
                                   <%
                                    ArrayList<SachBean> ListSachLienQuan2 = (ArrayList<SachBean>)request.getAttribute("ListSachLienQuan2");
                                    if(request.getAttribute("ListSachLienQuan2") != null){
                                        for(SachBean sachlienquan : ListSachLienQuan2){
                                %>
                                <div class="col-sm-3">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a
                                                    href="XuLyServlet?maSach=<%=sachlienquan.getMaSach()%>&maLoai=<%=request.getParameter("maLoai") %>&tenLoai=<%=request.getParameter("tenLoai") %>">
                                                    <img src="image/<%=sachlienquan.getAnh()%>"
                                                    alt="<%=sachlienquan.getTenSach()%>"
                                                    title="<%=sachlienquan.getTenSach() %> %>" height="250" />
                                                </a>
                                                <h2><%=nf.format(sachlienquan.getGia()) %>
                                                    đ
                                                </h2>
                                                <a
                                                    href="XuLyServlet?maSach=<%=sachlienquan.getMaSach()%>&maLoai=<%=request.getParameter("maLoai") %>&tenLoai=<%=request.getParameter("tenLoai") %>">
                                                    <p class="hover"><%=sachlienquan.getTenSach() %></p>
                                                </a>
                                                <p>
                                                    Tác giả:
                                                    <%=sachlienquan.getTacGia() %></p>
                                                    <a href="GioHangServlet?loai=them&maSach=<%=sachlienquan.getMaSach() %>" class="btn btn-default add-to-cart"><i
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
    <jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</html>