<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.GioHangBean"%>
<%@page import="Bean.HangBean"%>
<%@page import="javax.websocket.Session"%>
<%@page import="BO.GioHangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% NumberFormat nf = NumberFormat.getInstance();    
nf.setMinimumIntegerDigits(0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
<style type="text/css">
    .table{
        width: 1000px;
        margin: auto;
    }
</style>
</head>
<body>
    <a class="btn btn-info" href="HangServlet" style="margin: 20px 0 0 20px">Tiếp tục mua hàng</a>
    <h2 style="color: red; text-align: center; margin: -30px 0 30px 0">Danh sách đơn hàng</h2>
    <form action="XoaHangCheckBoxServlet" method="get">
     <table class='table table-responsive table-hover'>
     <tr>
        <th width="200"></th>
        <th width="250">Mã hàng</th>
        <th width="350">Tên hàng</th>
        <th width="250">Giá</th>
        <th width="250">Số lượng</th>
        <th width="300">Thành tiền</th>
        <th width="210"></th>
     </tr>
    <%
    GioHangBO gio = (GioHangBO)session.getAttribute("gh");
    int size = gio.ds.size();
    int dem = 0;
    double sum = 0;
    if(session.getAttribute("gh") != null)
    {
        for(GioHangBean h: gio.ds){ 
        /* for(int i = 0 ; i< size ; i ++){  */
            dem++;
    %>
            <tr>
                <td>
                        <input type="checkbox" name="chon" value="<%=h.getMaHang() %>" ><br>
                </td>
                <td><%=h.getMaHang() %></td>
                <td><%=h.getTenHang() %></td>
                <td><%=h.getGia() %></td>
                <td><%=h.getSoLuong() %>
            <%--       <form action="SuaHangServlet?mh=<%=h.getMaHang() %>" method="post"> --%>
                      <!--   <input type='submit' name='btnSua' value='Sửa' class="btn btn-warning btn-xs text-right" style="margin:0px 0 5px 0; float: right;"> -->
                        <button class="btn btn-warning btn-xs text-right" name="btnSua" value="<%=h.getMaHang() %>">Sửa</button>
                        <input type="text" name="<%=h.getMaHang() %>" class="form-control input-sm">
                   <!--  </form> -->
                </td>
                <td><%=(h.getSoLuong() * h.getGia()) %></td>
                <td class="text-right">
                    <a class="btn btn-danger" name="btnXoa" href="XoaHangServlet?mh=<%=h.getMaHang() %>">Xóa</a>
                </td>
            </tr>
<%
        sum+=(h.getSoLuong() * h.getGia());
        }
    }
%>
        <tr>
        <td class="text-left">
        <%if(dem != 0) { %>
            <button  class="btn btn-danger" name="btnXoa">Xóa</button>
            <%} %>  
        </td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td class='text-right'>
                <b>Tổng thành tiền: </b>
                <mark><%=nf.format(sum) %> VNĐ</mark>
               <%--  <a href="ThanhToanServlet" style="text-decoration: none; color: #fff">
                <button onclick="ThanhToan()" class="btn btn-primary">Thanh toán</button> 
                </a>
                <script type="text/javascript">
                    function ThanhToan() {
                        alert("Tổng số tiền bạn cần thanh toán là: " + <%=sum%> + "VNĐ");
                    }
                </script> --%>
            </td>
        </tr>
</table>
</form> 
</body>
</html>