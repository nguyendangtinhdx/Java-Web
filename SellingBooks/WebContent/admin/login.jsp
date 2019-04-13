<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
<%
        String  tenDangNhapErr = "", matKhauErr = "", CaptchaErr = "";
        if(request.getAttribute("tenDangNhapErr") != null){
            tenDangNhapErr = (String)request.getAttribute("tenDangNhapErr");
        }
        if(request.getAttribute("matKhauErr") != null){
            matKhauErr = (String)request.getAttribute("matKhauErr");
        }
        if(request.getAttribute("CaptchaErr") != null){
            CaptchaErr = (String)request.getAttribute("CaptchaErr");
        }
        
        String tenDangNhap = "", matKhau = "";
        if(request.getParameter("tenDangNhap") != null)
        {
            tenDangNhap = request.getParameter("tenDangNhap");
        }
        if(request.getParameter("matkhau") != null)
        {
            matKhau = request.getParameter("matKhau");
        }
%>
    <div id="header">
        <div class="inHeaderLogin"></div>
    </div>

    <div id="loginForm">
        <div class="headLoginForm">Đăng nhập hệ thống</div>
        <div class="fieldLogin">
            <form method="post" action="/SellingBooks/QuanLyDangNhapServlet">
                <label>Tên đăng nhập</label> <span style="color: red; float: right;"><%=tenDangNhapErr %></span><br> 
                <input type="text" class="login" name="tenDangNhap" value="<%=tenDangNhap %>"><br>
                
                <label>Mật khẩu</label><span style="color: red; float: right;"><%=matKhauErr %></span><br> 
                <input type="password" class="login" name="matKhau" value="<%=matKhau %>"><br>
                
                <input type="hidden" value="dangnhap" name="loai">
                <input type="submit" class="button" value="Đăng nhập"><span style="color: red; float: right;"><%=CaptchaErr %></span>
                <div style="margin-bottom:  20px"></div>
                <div class="g-recaptcha" data-sitekey="6LeM0zgUAAAAAMkX0zN3Jw7kX93jogJexlGHJpuz"></div>
            </form>
        </div>
    </div>
</body>
</html>