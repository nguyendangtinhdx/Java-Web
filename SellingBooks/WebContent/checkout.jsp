<%@page import="Bo.GioHangBo"%>
<%@page import="Bean.KhachHangBean"%>
<%@page import="Bean.HangBean"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.NumberFormat"%>
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
<title>Thanh toán</title>
</head>
<body>
    <%
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumIntegerDigits(0);
    
    GioHangBo giohang = (GioHangBo)session.getAttribute("giohang");
    if(giohang == null){
        giohang = new GioHangBo();
        session.setAttribute("giohang", giohang);
    }
    
    KhachHangBean khachhang = (KhachHangBean)session.getAttribute("tendangnhap");
    if(khachhang == null){
        response.sendRedirect("account.jsp");
    }
    
    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
<%--             <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div> --%>
                <section id="cart_items">
                    <div class="col-sm-12">
                        <h3 class="active tieude">Giỏ hàng của bạn</h3>
                        <div class="table-responsive cart_info">
                            <table class="table table-condensed">
                                <thead>
                                    <tr class="cart_menu">
                                        <td class="image" width="150">Sách</td>
                                        <td class="description" width="400">Tên sách</td>
                                        <td class="price" width="200">Giá</td>
                                        <td class="quantity" width="200">Số lượng</td>
                                        <td class="total">Thành tiền</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                <%
                                double total = 0;
                                boolean kt = false;
                                for(Map.Entry<String, HangBean> sach : giohang.getHang().entrySet()){
                                    kt = true;
                                %>
                                
                                    <tr>
                                        <td class="cart_product" width="150"><img
                                                src="image/<%=sach.getValue().getSach().getAnh() %>" alt=""  width="100" height="150"></td>
                                        <td class="cart_description" width="400">
                                            <h4>
                                                <p><%=sach.getValue().getSach().getTenSach() %></p> 
                                            </h4>
                                            <p><b>Tác giả:</b> <%=sach.getValue().getSach().getTacGia() %></p>
                                        </td>
                                        <td class="cart_price" width="200">
                                            <p><%=nf.format(sach.getValue().getSach().getGia()) %> đ</p>
                                        </td>
                                        <td class="cart_quantity" width="200">
                                        <form action="GioHangServlet" method="post">
                                            <div class="cart_quantity_button">
                                                    <input class="cart_quantity_input" type="text" value="<%=sach.getValue().getSoLuong() %>" autocomplete="off" size="2" disabled="disabled">
                                            </div>
                                        </form>
                                        </td>
                                        <td class="cart_total">
                                            <p class="cart_total_price"><%=nf.format(sach.getValue().getSoLuong() * sach.getValue().getSach().getGia() ) %> đ</p>
                                        </td>
                                    </tr>
                                    <%
                                    total += sach.getValue().getSoLuong() * sach.getValue().getSach().getGia();
                                    } 
                                    %>
                                    <%if(kt == true) { %>
                                    <tr>
                                        <td colspan="3">&nbsp;</td>
                                        <td colspan="3">
                                            <table class="table table-condensed total-result">
                                                <tr>
                                                    <td><h4><b>Tổng tiền thanh toán:</b></h4></td>
                                                    <td><span><%=nf.format(total) %> đ</span></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr> 
                                    <%} %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <%if(kt == true) { %>
                <div class="row">
                    <div class="col-sm-8"></div>
                    <div class="col-sm-4">
                        <div class="shopper-informations">
                            <div class="shopper-info">
                                <form action="ThanhToanServlet" method="post">
                                    <input type="submit" onclick="alert('Bạn đã thanh toán')"  value="Xác nhận thanh toán" class="btn btn-primary">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <%} %>
                </section>
                <!--/#cart_items-->
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
</html>