<%@page import="java.text.NumberFormat"%>
<%@page import="Tam.CGioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%NumberFormat nf = NumberFormat.getIntegerInstance(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Đặt hàng</title>
<style type="text/css">
   body{
    width: 700px;
    margin: auto;
   }
   table{
   margin-top: 20px;
   }
</style>
</head>
<body>
    <form method='post' action='DatHang.jsp'>
        Tên hàng<input type='text' name='txtth' class="form-control input-sm" required>
        Giá <input type='text' name='txtgia' class="form-control input-sm" required>
        Số lượng<input type='text' name='txtsl' class="form-control input-sm" required><br>
        <input type='submit' name='un1' value='Đặt hàng' class="btn btn-success">
    </form>

    <%
        String th = request.getParameter("txtth");
        String gia = request.getParameter("txtgia");
        String sl = request.getParameter("txtsl");
        if (th != null && gia != null && sl != null) {
            CGioHang g = new CGioHang();
            //Neu mua hang lan dau   
            if (session.getAttribute("gh") == null) {
                session.setAttribute("gh", g);//Tạo giỏ
            }
            //Gian session: gh vao bien: g   
            g = (CGioHang)session.getAttribute("gh");
            //Them hang vao bien: g   
            g.Them(th, Long.parseLong(gia), Long.parseLong(sl));
            //Luu bien vao session   
            session.setAttribute("gh", g);
        }
        //Hien thi do trong session: gh
        if (session.getAttribute("gh") != null) {
            CGioHang g = new CGioHang();
            g = (CGioHang)session.getAttribute("gh");
            int sh = g.ds.size();
            
    %>
    <table  class="table table-responsive table-hover">
    <h3 style="color: red; text-align: center">Danh sách đơn hàng</h3>
        <tr>
            <th width="300">Tên hàng</th>
            <th  width="180">Giá</th>
            <th  width="200" >Số lượng</th>
            <th  width="200" >Thành tiền</th>
            <th></th>
        </tr>
        <%
            for (int i = 0; i < sh; i++) {
        %>
        <tr>
            <td><%=g.ds.get(i).getTenhang()%></td>
            <td><%=nf.format(g.ds.get(i).getGia()) %></td>
            <td><%=g.ds.get(i).getSoluong()%>
                <form method='post' action='Sua.jsp?th=<%=g.ds.get(i).getTenhang()%>'>
                    <input type='text' name='txtsua' class="form-control input-sm">
                    <input type='submit' name='tt' value='Sửa' class="btn btn-warning btn-xs">
                </form></td>
            <td><%=nf.format(g.ds.get(i).getThanhtien()) %></td>
            <td class="text-right"><a href="Xoa.jsp?th=<%=g.ds.get(i).getTenhang()%>"><button class="btn btn-danger btn-xs">Xóa</button></a></td>
        </tr>
        <%
            }
        %>
        <% if(sh>0){ %>
        <tr>
            <td class="text-left"><a href="XoaDonHang.jsp"><button class="btn btn-danger btn-xs">Xóa đơn hàng</button></a></td>
            <td></td>
            <td></td>
            <td></td>
            <td align='text-right'>
            <b>Tổng tiền: </b>
            <mark><%=nf.format(g.Tongtien()) %>VNĐ</mark>
              <a href="XoaDonHang.jsp" style="text-decoration: none; color: #fff">
                <button onclick="ThanhToan()" class="btn btn-primary">Thanh toán</button> 
                </a>
                <script type="text/javascript">
                    function ThanhToan() {
                        alert("Tổng số tiền bạn cần thanh toán là: " + <%=g.Tongtien()%> + "VNĐ");
                    }
                </script>
            </td>
        </tr>   
        <%} %>
    </table>    
    <%
        }
    %>
</body>
</html>