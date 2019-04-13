<%@page import="Bean.GioHangBean"%>
<%@page import="Bean.HangBean"%>
<%@page import="javax.websocket.Session"%>
<%@page import="BO.GioHangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <h2 style="color: red; text-align: center; margin-top: -20px">Danh sách đơn hàng</h2>
    <form action="XoaHangCheckBoxServlet" method="get">
     <table class='table table-responsive table-hover'>
     <tr>
        <th width="200"></th>
        <th width="250">Mã hàng</th>
        <th width="350">Tên hàng</th>
        <th width="250">Giá</th>
        <th width="250">Số lượng</th>
        <th width="300">Thành tiền</th>
        <th width="200"></th>
     </tr>
    <%
    GioHangBO gio = (GioHangBO)session.getAttribute("gh");
    int size = gio.ds.size();
    int dem = 0;
    if(session.getAttribute("gh") != null)
    {
       /*  for(GioHangBean h: gio.ds){ */
        for(int i = 0 ; i< size ; i ++){ 
            dem++;
    %>
            <tr>
                <td>
                        <input type="checkbox" name="chon" value="<%=gio.ds.get(i).getMaHang() %>" ><br>
                </td>
                <td><%=gio.ds.get(i).getMaHang() %></td>
                <td><%=gio.ds.get(i).getTenHang() %></td>
                <td><%=gio.ds.get(i).getGia() %></td>
                <td><%=gio.ds.get(i).getSoLuong() %>
                    <form action="SuaHangServlet?mh=<%=gio.ds.get(i).getMaHang() %>" method="post">
                        <input type='submit' name='tt' value='Sửa' class="btn btn-warning btn-xs text-right" style="margin:0px 0 5px 0; float: right;">
                        <input type="text" name="txtSoLuong" class="form-control input-sm">
                    </form>
                </td>
                <td><%=(gio.ds.get(i).getSoLuong() * gio.ds.get(i).getGia()) %></td>
                <td class="text-right">
                    <a class="btn btn-danger" href="XoaHangServlet?mh=<%=gio.ds.get(i).getMaHang() %>">Xóa</a>
                </td>
            </tr>
<%
        }
    }
%>
        <td class="text-left">
        <%if(dem != 0) { %>
            <button  class="btn btn-danger" type="submit">Xóa</button>
            <%} %>
        </td>
</table>
</form> 
</body>
</html>