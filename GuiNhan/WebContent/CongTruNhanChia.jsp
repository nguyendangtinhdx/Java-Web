<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cộng trừ nhân chia</title>
</head>
<body>
<%
    float  a = 0, b = 0;
    String kq = "";
   if(request.getParameter("txta") != null && request.getParameter("txta") != null)
   {
       a = Float.parseFloat(request.getParameter("txta"));
       b = Float.parseFloat(request.getParameter("txtb"));
       
       if(request.getParameter("btnCong")  != null)
       {
           kq += (a + b);
       }
       else if(request.getParameter("btnTru")  != null)
       {
           kq += (a - b);
       }
       else if(request.getParameter("btnNhan")  != null)
       {
           kq += (a * b);
       }
       else if(request.getParameter("btnChia")  != null)
       {
           if(Math.abs(b) < 1e-10) 
               kq = "Mẫu số không được = 0";
           else kq += (a*1.0/b);
       }
   }


%>
<!-- <form action="Tong.jsp" method="post"> Thực hiện ở trang Tong.jsp   -->
<form action="CongTruNhanChia.jsp" method="post">
    <table width="400" align="center">
        <tr>
            <td>
                <label>Nhập số a:</label>
               <input type="text" name="txta" class="form-control" value="<%=a %>">
               
               <label>Nhập số b:</label>
               <input type="text" name="txtb" class="form-control" value="<%=b %>">
            <br>
               <input type="submit" name="btnCong" value="Cộng" class="btn btn-primary">
               <input type="submit" name="btnTru" value="Trừ" class="btn btn-success">
               <input type="submit" name="btnNhan" value="Nhân" class="btn btn-warning">
                <input type="submit" name="btnChia" value="Chia" class="btn btn-danger">
            <br>
                <label>Kết quả:</label>
                <input type="text" name="kq" class="form-control" value="<%=kq %>">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>