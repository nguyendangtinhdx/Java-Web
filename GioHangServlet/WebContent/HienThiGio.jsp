<%@page import="java.net.URL"%>
<%@page import="Bean.GioHangBean"%>
<%@page import="Bo.GioHangBo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css"/>
    
    <style>
    img {
        width:200px;height:200px;
        margin: 0px 200px 0px 150px;
    }
    </style>
    <title>Insert title here</title>
</head>
<body>
    <img src='Gio.jpg'>
    <h1><span class = "label label-default">DANH SACH HANG TRONG GIO</span></h1>

    <form method = 'get' action="ThaoTacGioHang">   
        <table width="50%" border='1' cellpadding="4" cellspacing="0" class = "table table-hover">
            <thead>
                <tr>
                <th class="col-md-1">Xoa</th>
                <th>Ten Hang</th>
                <th>Gia</th>
                <th>So Luong</th>
                <th>Thanh Tien</th>
                <th>Sua</th>
                </tr>
            </thead>
            <tbody>
                <%
                if(session.getAttribute("gh")!=null){
                    GioHangBo h= (GioHangBo) session.getAttribute("gh");
                    for(GioHangBean ha : h.gh){%>
                        <tr>
                        <td class="col-md-1"><input type="checkbox" name="kt" value="<%=ha.getTenhang()%>">Xoa<br></td>
                        <td><%=ha.getTenhang()%></td>
                        <td><%=ha.getGia() %></td>
                        <td><%=ha.getSoluong()%></td><br>
                        <td><%=ha.getGia()*ha.getSoluong()%></td><br>
                        <td>
                             <input type='text' name='<%=ha.getMahang() %>'>
                             <button type = "submit" name="butcong" class = "btn btn-default" value= "<%=ha.getMahang()%>">
                             <span class = "glyphicon glyphicon-plus"></span>
                             </button>
                             <button type = "submit" name= "buttru" class = "btn btn-default" value= "<%=ha.getMahang() %>">
                             <span class = "glyphicon glyphicon-minus"></span>
                             </button>
                        </td>
                        </tr>
                        <tr>    
                <%      }
                    }
                    %>
                    </tr>
                    <tr>
                    Tong tien can thanh toan: 

            <%
                double sum = 0;
                if(session.getAttribute("gh")!= null)
                {
                    GioHangBo h = (GioHangBo)session.getAttribute("gh");
                    for(GioHangBean ha: h.gh)
                    {
                        sum = sum+(ha.getGia()*ha.getSoluong());
                    }
                }   
            %>
            <%=sum %>
                    
                    </tr>
            </tbody>
            
        </table>
        <button type='submit' class = "btn btn-success"> <span class = "glyphicon glyphicon-trash"></span>Xoa </button>
    </form>
    
    <script src="jquery-1.11.2.min.js"></script>
    <script src="bootstrap.min.js"></script>
</body>
</html>