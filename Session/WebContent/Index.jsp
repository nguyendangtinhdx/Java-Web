<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery-1.11.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session Login</title>
<style type="text/css">
    #red{color: red;}
</style>
</head>
<body>
    <%
        String error = "";
        String p = request.getParameter("p");
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        if (username != null && password != null)
        {
            if(username.equals("admin") && password.equals("55555"))
            {
                session.setAttribute("username", username);
                response.sendRedirect("Index.jsp");
            }
            else
            {
                response.sendRedirect("Index.jsp?p=loginFailed");
            }
        }
        else if (p !=null )
        {
            if(p.equals("loginFailed"))
            {
                error = "Đăng nhập thất bại";
            }
            else if(p.equals("logout"))
            {
                session.setAttribute("username", null);
                response.sendRedirect("Index.jsp");
            }
            else if(p.equals("link1"))
            {
                error = "Vui lòng đăng nhập";
            }
            else if(p.equals("link2"))
            {
                error = "Vui lòng đăng nhập";
            }
        }
    %>
<%-- <%@include file="Form.jsp"%> --%> 
    <form action="Index.jsp" method="post">
        <table class="table table-bordered" align="center" style="width: 250px">
            <tr>
            <%if(error != "") {%>
                <td colspan="3" align="center" id="red"><%=error %></td>
                <%} %>
            </tr>
            <tr>
            <% if(session.getAttribute("username") == null) { %>
                <td colspan="3">
                    <label>Tài khoản: </label> <input type="text"
                    class="form-control" name="txtUsername"> <label>Mật khẩu: </label> <input
                    type="password" class="form-control" name="txtPassword">
                    </td>
            </tr>
            <tr>
                <td colspan="3" align="center"><input type="submit" class="btn btn-primary"
                    value="Đăng nhập" name="btnLogin"></td>
            </tr>
            <tr>
            <% } else { %>
                <td colspan="3" align="center" id="red">
                     Xin chào: <%=session.getAttribute("username") %>!
                </td>
                <%} %>
            </tr>
            <tr>
                <td><a href="Index.jsp?p=link1">Link 1</a></td>
                <td><a href="Index.jsp?p=link2">Link 2</a></td>
                <%if(session.getAttribute("username") == null){ %>
                <td><s><a href="Index.jsp?p=logout">Đăng xuất</a></s></td>
                <%}else{ %>
                <td><a href="Index.jsp?p=logout">Đăng xuất</a></td>
                <%} %>
            </tr>
            
        </table>
    </form>
</body>
</html>