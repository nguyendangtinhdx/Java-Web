<%@page import="Bo.GioHangBo"%>
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
<title>Sản phẩm</title>
</head>
<body>
    <%
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);
        
        
        int pages = 6;
        
        GioHangBo giohang = (GioHangBo) session.getAttribute("giohang");
        
        if(giohang == null){
            giohang = new GioHangBo();
            session.setAttribute("giohang", giohang);
        }
        /* Cart cart = (Cart) session.getAttribute("cart"); */
        
    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div>
            <div class="col-sm-9">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-12 padding-right">

                            <div class="features_items">
                                <!--features_items-->
                                <h2 class="title text-center" id="margin_top" style="margin-top: 3px;"><%=request.getParameter("tenLoai") %></h2>

                                <%
                                        ArrayList<SachBean> list = (ArrayList<SachBean>)request.getAttribute("ListSachByPage");
                                        if(request.getAttribute("ListSachByPage") != null){ 
                                            for(SachBean sach : list){
                                %>

                                <div class="col-sm-4" style="height: 500px;" >
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=request.getParameter("tenLoai") %>">
                                                    <img src="image/<%=sach.getAnh()%>"
                                                    alt="<%=sach.getTenSach()%>"
                                                    title="<%=sach.getTenSach()%>" height="280" />
                                                </a>
                                                <h2><%=nf.format(sach.getGia())%>
                                                    đ
                                                </h2>
                                                <a href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=request.getParameter("tenLoai") %>">
                                                <p class="hover"><%=sach.getTenSach()%></p></a>
                                                <p>
                                                    Tác giả:
                                                    <%=sach.getTacGia()%></p>
                                                <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm vào giỏ
                                                    hàng</a>
                                            </div>
                                            <img src="image/new.png" class="new" alt="" />
                                        </div>

                                    </div>
                                </div>

                                <%
                                            }
                                    }
                                %>            
                            <div style="clear: both;"></div>
                            <div class="row">
                            <div class="col-sm-4"></div>
                            <div class="col-sm-4"> 
                                <ul class="pagination" >
                                    <li><a href="XuLyServlet?maLoai=<%=request.getParameter("maLoai")%>&tenLoai=<%=request.getParameter("tenLoai")%>&start=<%=0 %>&end=<%=pages %> "> &laquo; </a></li>
                                    <%
                                    ArrayList<SachBean> arr  = (ArrayList<SachBean>)request.getAttribute("ListSachByLoai");
                                        int dem = 0;
                                        int a, b;
                                        int limit = arr.size() / pages;
                                        if (limit * pages < arr.size()) {
                                            limit += 1;
                                        }
                                        for (int i = 1; i <= limit; i++) {
                                            a = (i - 1) * pages;
                                            b = i * pages;
                                            if (b > arr.size()) {
                                                b = arr.size();
                                            }
                                            dem++;
                                    %>
                                    <li><a href="XuLyServlet?maLoai=<%=request.getParameter("maLoai")%>&tenLoai=<%=request.getParameter("tenLoai")%>&start=<%=a%>&end=<%=b%> "><%=i%> </a></li>
                                    <%
                                        }
                                    %>
                                    <li><a href="XuLyServlet?maLoai=<%=request.getParameter("maLoai")%>&tenLoai=<%=request.getParameter("tenLoai")%>&start=<%=(dem-1)*pages %>&end=<%=arr.size() %> "> &raquo; </a></li>
                
                                </ul>
                               </div> 
                                <div class="col-sm-4"></div> 
                            </div>

                        </div>
                            <!--features_items-->

                            <div class="recommended_items">
                                <!--recommended_items-->
                                <h2 class="title text-center" id="margin_top_detail">Sách mới
                                    nhất</h2>

                                <div id="recommended-item-carousel" class="carousel slide"
                                    data-ride="carousel">
                                    <div class="carousel-inner">


                                        <div class="item active">
                                            <%
                                                 ArrayList<SachBean> ListSachByLoaiMoiNhat = (ArrayList<SachBean>)request.getAttribute("ListSachByLoaiMoiNhat");
                                                 if(request.getAttribute("ListSachByLoaiMoiNhat") != null){
                                                     for(SachBean sach : ListSachByLoaiMoiNhat){
                                            %>
                                            <div class="col-sm-4">
                                                <div class="product-image-wrapper">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=request.getParameter("tenLoai")%>">
                                                                <img src="image/<%=sach.getAnh()%>"
                                                                alt="<%=sach.getTenSach()%>"
                                                                title="<%=sach.getTenSach()%>"
                                                                height="250" />
                                                            </a>
                                                            <h2><%=nf.format(sach.getGia())%>
                                                                đ
                                                            </h2>
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=request.getParameter("tenLoai")%>">
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
                                                 ArrayList<SachBean> ListSachByLoaiMoiNhat2 = (ArrayList<SachBean>)request.getAttribute("ListSachByLoaiMoiNhat");
                                                 if(request.getAttribute("ListSachByLoaiMoiNhat") != null){
                                                     for(SachBean sach : ListSachByLoaiMoiNhat2){
                                            %>
                                            <div class="col-sm-4">
                                                <div class="product-image-wrapper">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=request.getParameter("tenLoai")%>">
                                                                <img src="image/<%=sach.getAnh()%>"
                                                                alt="<%=sach.getTenSach()%>"
                                                                title="<%=sach.getTenSach()%>"
                                                                height="250" />
                                                            </a>
                                                            <h2><%=nf.format(sach.getGia())%>
                                                                đ
                                                            </h2>
                                                            <a
                                                                href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=request.getParameter("tenLoai")%>">
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