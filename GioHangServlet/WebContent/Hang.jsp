<%@page import="Bean.HangBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css"/>
    <title>Insert title here</title>
    
</head>
<body>

<table width="50%" border='1' cellpadding="4" cellspacing="0">
<%
ArrayList<HangBean> ds = (ArrayList<HangBean>)request.getAttribute("dshang");
int n = ds.size();
    for(int i = 0; i<n;i++){%>
        <tr>
        <td>
        <img src='<%=ds.get(i).getAnh()%>'><br>
        <%=ds.get(i).getTenhang() %><br>
        <%=ds.get(i).getGia() %><br>
        <a style="font-size:16px" href='MuaHang?mh= <%=ds.get(i).getMahnag() %>&th=<%=ds.get(i).getTenhang() %>&g=<%=ds.get(i).getGia() %>'><img src='icon4.png' height="42" width="42"> </a>
        </td>
        <td>
        <%i++;
        if(i<n){
        %>
        <img src='<%=ds.get(i).getAnh()%>'><br>
        <%=ds.get(i).getTenhang() %><br>
        <%=ds.get(i).getGia() %><br>
        <a style="font-size:16px" href='MuaHang?mh= <%=ds.get(i).getMahnag() %>&th=<%=ds.get(i).getTenhang() %>&g=<%=ds.get(i).getGia() %>'><img src='icon4.png' height="42" width="42"> </a>
        <%} %>
        </tr>
    <%}%>
    
</table>
</body>
</html>