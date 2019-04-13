<%@page import="Dao.ThongKeHoaDonDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.ThongKeHoaDonBean"%>
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
<title>Thống kê</title>
</head>
<body>
    <%
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumIntegerDigits(0);
    
    
    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
                <section id="cart_items">
                    <div class="col-sm-12">
                        <h3 class="active tieude">Danh sách các khách hàng đã đặt hàng</h3>
                        <div class="table-responsive cart_info">
                            <table class="table table-condensed">
                                <thead>
                                    <tr class="cart_menu">
                                        <td class="image" width="150">Họ tên</td>
                                        <td class="description" width="400">Tên sách</td>
                                        <td class="price" width="150">Số lượng</td>
                                        <td class="quantity" width="200">Giá</td>
                                        <td class="total">Thành tiền</td>
                                        <td class="status">Tình trạng</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                <%
                                boolean kt = false;
                                double total = 0;
                                if(request.getAttribute("ListThongKeHoaDon") != null)
                                {
                                 ArrayList<ThongKeHoaDonBean> list = (ArrayList<ThongKeHoaDonBean>)request.getAttribute("ListThongKeHoaDon");
                                    for(ThongKeHoaDonBean hoadon : list){ 
                                   kt = true;
                                %>
                                
                                    <tr>
                                        <td class="cart_description">
                                                <p><%=hoadon.getHoTen() %></p> 
                                        </td>
                                         <td class="cart_description">
                                            <p> <%=hoadon.getTenSach() %></p>
                                        </td>
                                        <td class="cart_quantity">
                                         <p> <%=hoadon.getSoLuongMua() %></p>
                                        </td>
                                        <td class="cart_price">
                                            <p><%=nf.format(hoadon.getGia()) %> đ</p>
                                        </td>
                                        <td class="cart_total">
                                            <p class="cart_total_price"><%=nf.format(hoadon.getThanhTien() ) %> đ</p>
                                        </td>
                                           <td class="cart_price">
                                           <%
                                               String tinhtrang = "Đã mua";
                                               if(hoadon.getTinhTrang() == false)
                                                   tinhtrang = "Chưa mua";
                                           %>
                                            <p><%=tinhtrang %></p>
                                        </td>
                                    </tr>
                                    <%
                                    total += hoadon.getThanhTien();
                                         }  
                                    }
                                    if(kt == true){
                                    %>
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