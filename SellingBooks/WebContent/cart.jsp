<%@page import="Bo.GioHangBo"%>
<%@page import="Bean.HangBean"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
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
<title>Giỏ hàng</title>
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
                                        <td class="price">Giá</td>
                                        <td class="quantity">Số lượng</td>
                                        <td class="edit" width="150">Chỉnh sửa</td>
                                        <td class="total">Thành tiền</td>
                                        <td></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                <%
                                boolean kt = false;
                                for(Map.Entry<String, HangBean> sach : giohang.getHang().entrySet()){
                                    kt = true;
                                %>
                                
                                    <tr>
                                        <td class="cart_product"><img
                                                src="image/<%=sach.getValue().getSach().getAnh() %>" alt=""  width="100" height="150"></td>
                                        <td class="cart_description">
                                            <h4>
                                                <p><%=sach.getValue().getSach().getTenSach() %></p> 
                                            </h4>
                                            <p><b>Tác giả:</b> <%=sach.getValue().getSach().getTacGia() %></p>
                                        </td>
                                        <td class="cart_price">
                                            <p><%=nf.format(sach.getValue().getSach().getGia()) %> đ</p>
                                        </td>
                                         <td class="cart_price" >
                                            <p><%=sach.getValue().getSoLuong() %></p>
                                        </td>
                                        <td class="cart_quantity">
                                        <form action="GioHangServlet?loai=cong&maSach=<%=sach.getValue().getSach().getMaSach() %>" method="post">
                                            <div class="cart_quantity_button">
                                              <%--       <a class="cart_quantity_down" href="GioHangServlet?loai=tru&maSach=<%=sach.getValue().getSach().getMaSach() %>&maGioHang=<%=System.currentTimeMillis()%>"> - </a>
                                                    <input class="cart_quantity_input" type="text" value="<%=sach.getValue().getSoLuong() %>" autocomplete="off" size="2" >
                                                    <a class="cart_quantity_up" href="GioHangServlet?loai=cong&maSach=<%=sach.getValue().getSach().getMaSach() %>&maGioHang=<%=System.currentTimeMillis()%>"> + </a>
 --%>                                            <input class="cart_quantity_input" type="number"  name="soluong" value="1" style="width: 50px; margin-right: 2px" >
                                            <input type="submit" value="Thêm" class="btn btn-danger btn-sm" > 
                                        
                                            </div>
                                        </form>
                                        </td>
                                        <td class="cart_total">
                                            <p class="cart_total_price"><%=nf.format(sach.getValue().getSoLuong() * sach.getValue().getSach().getGia() ) %> đ</p>
                                        </td>
                                        <td class="cart_delete"><a class="cart_quantity_delete"
                                            href="GioHangServlet?loai=xoa&maSach=<%=sach.getValue().getSach().getMaSach() %>"><i class="fa fa-times"></i></a></td>
                                    </tr>
                                    <%} %>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <%
                        if(kt == true){
                %>
                <div class="row">
                    <section id="do_action">
                    <div class="col-sm-8"></div>
                    <div class="col-sm-4 text-right">
                        <a class="btn btn-default update" href="GioHangServlet?loai=xoaDonHang">Hủy
                            đơn hàng</a> <a class="btn btn-default check_out" href="checkout.jsp">Thanh
                            toán</a>
                    </div>
                    </section>
                    <!--/#do_action-->
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