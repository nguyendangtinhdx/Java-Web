<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cộng trừ nhân chia (lấy value của button)</title>
</head>
<body>
<%
    String kq = "";
    float a = 0;
    float b = 0;
    if(request.getParameter("txtsoa") != null && request.getParameter("txtsob") != null){
        a = Float.parseFloat(request.getParameter("txtsoa"));
        b = Float.parseFloat(request.getParameter("txtsob"));
        String btnValue = request.getParameter("btn");
        out.print( a + " " + btnValue + " " + b);
        if(btnValue.equals("+")){
            kq += (a+b);
        }
        else if(btnValue.equals("-")){
            kq += (a-b);
        }
        else if(btnValue.equals("*")){
            kq += (a*b);
        }
        else if(btnValue.equals("/")){
            if(Math.abs(b) < 1e-10) kq = "So chia khong duoc = 0";
            else kq += (a*1.0/b);
        }
    }
%>
    
<table width="400" align="center">
    <tr><td>
    <form method="post" action="CongTruNhanChia2.jsp">
        A: 
        <input type="text" class="form-control" name="txtsoa" value="<%=a%>">
        <br>
        B: 
        <input type="text" class="form-control" name="txtsob" value="<%=b%>">
        <br>
        <input type="submit" class="btn btn-info" name="btn" value="+">
        <input type="submit" class="btn btn-success" name="btn" value="-">
        <input type="submit" class="btn btn-warning" name="btn" value="*">
        <input type="submit" class="btn btn-danger" name="btn" value="/">
        <br>
        KQ: 
        <input disable type="text" class="form-control" name="txtkq" value='<%
            if(kq!=""){
                out.print(kq);
            }
        %>'>
        <br>
    </form>
    </td></tr>
</table>
</body>
</html>