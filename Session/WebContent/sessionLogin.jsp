<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
    String error = "";
    String a = request.getParameter("a");
    if(a != null && a.equals("logout")){
        session.setAttribute("username", null);
        response.sendRedirect("sessionLogin.jsp");
    }
    
    String inputUserName = request.getParameter("username");
    String inputPassWord = request.getParameter("password");
    if (inputUserName != null && inputPassWord != null){
        if(inputUserName.equals("abc") && inputPassWord.equals("123")){
            session.setAttribute("username", inputUserName);
            //response.sendRedirect("?a=" + session.getAttribute("a").toString());
        }else{
            error = "<font color=red>Thông tin không đúng !</font>";
        }
    }else{
        if(a != null && !a.equals("logout")){
            error = "Vui lòng đăng nhập !";
        }
    }


    if(session.getAttribute("username") != null){
        if(a == null){
            out.print("Nội dung trang chính");
        }else if(a.equals("lk1")){
            out.print("Nội dung trang web lk1");
        }else if(a.equals("lk2")){
            out.print("Nội dung trang web lk2");
        }else {
            out.print("Nội dung trang chính");
        }
    }
%>
<br>
    <form method="post">
        <table class="table table-bordered" style="width:250px" align="center">
            <% if (error != ""){%>
            <tr>
                <td colspan="3" align="center">
                    <%=error%>
                </td>
            </tr>
            <%}%>
            <tr>
            <% if(session.getAttribute("username") == null){ %>
                <td colspan="3">
                    <label>Tài khoản:</label><input type="text" name="username" <%if(inputUserName != null) out.print("value=\"" + inputUserName + "\"");%> class="form-control">
                    <label>Mật khẩu:</label><input type="password" name="password" <%if(inputPassWord != null) out.print("value=\"" + inputPassWord + "\"");%> class="form-control">
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input type="submit" name="submit" value="Đăng nhập" class="btn btn-primary">
                </td>
            <%}else{%>
                <td colspan="3" align="center">
                    Xin chào: <%=session.getAttribute("username") %>!
                </td>
            <%}%>
            </tr>
            <tr align="center">
                <td><a href="?a=lk1">Liên kết 1</a></td>
                <td><a href="?a=lk2">Liên kết 2</a></td>
                <td>
                    <%if(session.getAttribute("username") != null){ %>
                    <a href="?a=logout">Đăng xuất</a>
                    <%}else{ %>
                    <a href="#"><s>Đăng xuất</s></a>
                    <%} %>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>