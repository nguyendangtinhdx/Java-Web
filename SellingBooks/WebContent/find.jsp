<%@page import="Bean.LoaiBean"%>
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
                         <div style="margin: 0 0 10px 12px">
                            <%
                                ArrayList<SachBean> TimKiem2 = (ArrayList<SachBean>)request.getAttribute("TimKiem");
                                
                            %>
                                 <b>Tìm thấy <span style="color: red"><%=TimKiem2.size() %></span> kết quả với từ khóa <span style="color: red"><%=request.getParameter("key") %></span></b>
                            </div> 
                            <div class="features_items">
                                <!--features_items-->
                            
                                <%
                                    LoaiBean tenLoai = (LoaiBean)request.getAttribute("TenLoaiByMaLoai");
                                    ArrayList<SachBean> TimKiem = (ArrayList<SachBean>)request.getAttribute("TimKiem");
                                    TimKiem.size();
                                    if(request.getAttribute("TimKiem") != null){
                                        for(SachBean sach : TimKiem){
                                    %>
                                            <div class="col-sm-4" style="height: 500px;" >
                                                <div class="product-image-wrapper">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                <a
                                                    href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=sach.getTenLoai() %>">
                                                    <img src="image/<%=sach.getAnh()%>"
                                                    alt="<%=sach.getTenSach()%>"
                                                    title="<%=sach.getTenSach()%>" height="280" />
                                                </a>
                                                <h2><%=nf.format(sach.getGia())%>
                                                    đ
                                                </h2>
                                                <a href="XuLyServlet?maSach=<%=sach.getMaSach()%>&maLoai=<%=sach.getMaLoai()%>&tenLoai=<%=sach.getTenLoai() %>">
                                                <p class="hover"><%=sach.getTenSach()%></p></a>
                                                <p>
                                                    Tác giả:
                                                    <%=sach.getTacGia()%></p>
                                                 <a href="GioHangServlet?loai=them&maSach=<%=sach.getMaSach() %>" class="btn btn-default add-to-cart"><i
                                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                            </div>
                                            <img src="images/home/new.png" class="new" alt="" />
                                        </div>

                                    </div>
                                </div>

                                <%
                                            }
                                    }
                                %>
                               
                            </div>
                            <!--features_items-->

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