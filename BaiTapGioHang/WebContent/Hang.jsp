<%@page import="Bean.HangBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<style type="text/css">
table{
    width: 700px;
    margin: auto;
}
.sach{
    text-align: center;
    padding:  20px;
}
</style>
</head>
<body>
    <table>
<!--     <tr><th>Mã hàng</th><th>Tên hàng</th><th>Giá</th><th>Số lượng</th><th>Thành tiền</th><th></th></r><tr> -->
    
    <%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    
    ArrayList<HangBean> ds = (ArrayList<HangBean>)request.getAttribute("dsHang");
    int n = ds.size();
    for(int i=0; i<n ; i++){  
    %>
        <td class='sach'>
        <img src='<%=ds.get(i).getHinhAnh()%>' height='330' > <br>
       <%=ds.get(i).getTenHang()%>  <br>
       <%=ds.get(i).getGia() %><br>
       <%=ds.get(i).getSoLuong() %><br>
       <a href="MuaHangServlet?mh=<%=ds.get(i).getMaHang() %>&th=<%=ds.get(i).getTenHang()%> &gia=<%=ds.get(i).getGia()%>">
            <img src='Img/buttonMua.jpg'>
       </a>
        </td>
      
       <%
        }
       %>
   <!-- </tr> -->
  
   </table>
</body>
</html>