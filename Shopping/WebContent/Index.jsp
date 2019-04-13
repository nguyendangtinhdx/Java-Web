<%@page import="java.text.NumberFormat"%>
<%@page import="Entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <% NumberFormat nf = NumberFormat.getIntegerInstance(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Giỏ hàng</title>
<link rel="stylesheet" href="bootstrap.min.css">
<style>
body {
    width: 700px;
    margin: auto;
}
</style>
</head>
<body>
    <form action="Create.jsp" method="POST">
        <div class="form-group" style="margin-top: 20px">
            <label>Tên hàng:</label> 
            <input class="form-control input-sm" type="text" name="name"required /> 
            <label>Giá:</label> 
            <input class="form-control input-sm" type="number" name="price" required /> 
            <label>Số lượng:</label> 
            <input class="form-control input-sm" type="number" name="quantity" required />
            <button class="btn btn-success" style="margin-top: 24px">Mua hàng</button>
        </div>
    </form>

    <table class="table table-responsive table-hover">
        <h3 style="color: red; text-align: center">Danh sách đơn hàng</h3>
        <thead>
            <tr>
                <th>Tên hàng</th>
                <th width="">Giá</th>
                <th>Số lượng</th>
                <th>Thành tiền</th>
                <th colspan="2"></th>
            </tr>
        </thead>
        <tbody>
            <%
                if(session.getAttribute("products") != null){
                    ArrayList<Product> products =(ArrayList<Product>)session.getAttribute("products");
                    int i = 1;
                    int sum = 0;
                    for(Product item : products){%>
            <tr>
                <td><%=item.Name%></td>
                <td><%=nf.format(item.Price) %></td>
                <td><%=item.Quantity%></td>
                <td><%=nf.format(item.Price * item.Quantity) %></td>
                <td class="text-right">
                <a href="Edit.jsp?index=<%=(i-1) %>" class="btn btn-warning">Sửa</a> 
                <a href="Delete.jsp?idDelete=<%=(i-1) %>" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
            <% sum+=(item.Price*item.Quantity); i++;%>
              <%}%>   
            <tr>
                <%if(i>1){ %>
                <td>
                    <a href="DeleteDonHang.jsp?idDeleteDonHang=<%=(i-2) %>" class="btn btn-danger">Xóa đơn hàng</a>
                </td>
                <td colspan="6" class="text-right">
                    <b>Tổng tiền thanh toán:<b><mark><%=nf.format(sum)%> VNĐ </mark><br> <br> 
                    <!--  <input type="submit"  value="Thanh toán" class="btn btn-primary" > -->
                            <a href="DeleteDonHang.jsp?idDeleteDonHang=<%=(i-2) %>" style="text-decoration: none; color: #fff">
                            <button onclick="ThanhToan()" class="btn btn-primary">Thanh toán</button> 
                            </a>
                            <script type="text/javascript">
                                function ThanhToan() {
                                	alert("Tổng số tiền bạn cần thanh toán là: " + <%=sum %> + "VNĐ");
                                }
                            </script>
                </td>
                <%} %>
            </tr>
            <%
                }
            %>

        </tbody>
    </table>
</body>
</html>