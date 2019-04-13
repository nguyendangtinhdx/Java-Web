
<%@page import="java.text.NumberFormat"%>
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
    <a class="btn btn-info" href="XuLyServlet" style="margin: 20px 0 0 20px">Tiếp tục mua hàng</a>
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

    %>
            <tr>
                <td>
                        <input type="checkbox" name="chon" value="mahang%>" ><br>
                </td>
                <td>mahang</td>
                <td>tenhang</td>
                <td>gia</td>
                <td>soluong
            <%--       <form action="SuaHangServlet?mh=<%=h.getMaHang() %>" method="post"> --%>
                      <!--   <input type='submit' name='btnSua' value='Sửa' class="btn btn-warning btn-xs text-right" style="margin:0px 0 5px 0; float: right;"> -->
                        <button class="btn btn-warning btn-xs text-right" name="btnSua" value="mahang">Sửa</button>
                        <input type="text" name="mahang" class="form-control input-sm">
                   <!--  </form> -->
                </td>
                <td>gia * soluong</td>
                <td class="text-right">
                    <a class="btn btn-danger" name="btnXoa" href="XoaHangServlet?mh=mahang>">Xóa</a>
                </td>
            </tr>

        <tr>
        <td class="text-left">
            <button  class="btn btn-danger" name="btnXoa">Xóa</button>

        </td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td class='text-right'>
                <b>Tổng thành tiền: </b>

            </td>
        </tr>
</table>
</form> 
</body>
</html>