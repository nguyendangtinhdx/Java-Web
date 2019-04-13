<%@page import="Bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm tài khoản</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <%
        AdminBean admin = null;
        if (session.getAttribute("tendangnhap_admin") != null) {
            admin = (AdminBean) session.getAttribute("tendangnhap_admin");
        }
        if(admin != null){
    %>
    <%
        String tenDangNhap = "", matKhau = "";
        if (request.getParameter("tenDangNhap") != null) {
            tenDangNhap = (String) request.getParameter("tenDangNhap");
        }
        if (request.getParameter("matKhau") != null) {
            matKhau = (String) request.getParameter("matKhau");
        }

        String tenDangNhapErr = "", matKhauErr = "";
        if (request.getAttribute("tenDangNhapErr") != null) {
            tenDangNhapErr = (String) request.getAttribute("tenDangNhapErr");
        }
        if (request.getAttribute("matKhauErr") != null) {
            matKhauErr = (String) request.getAttribute("matKhauErr");
        }
    %>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <p class="tieude_admin">Thêm tài khoản</p>
        <div id="rightContent">
            <form action="/SellingBooks/QuanLyTaiKhoanServlet" method="post">
                <table width="95%">
                    <tr>
                        <td width="125px"><b>Tên tài khoản</b></td>
                        <td><input type="text" class="panjang" name="tenDangNhap" value="<%=tenDangNhap %>"><span style="color: red"><%=tenDangNhapErr %></span></td>
                    </tr>
                    <tr>
                        <td><b>Mật khẩu</b></td>
                        <td><input type="text" class="panjang" name="matKhau" value="<%=matKhau %>" ><span style="color: red"><%=matKhauErr %></span></td>
                    </tr>
                    <tr>
                        <td><b>Quyền</b></td>
                        <td>
                            <input type="radio" name="quyen" value="true"> True
                            <input type="radio" name="quyen" value="false" checked="checked">  False
                        </td>
                    </tr>
                     <tr>
                        <td><input type="hidden" name="loai" value="them"></td>
                        <td><input type="submit" class="button" value="Lưu dữ liệu"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <%
    }else{
        response.sendRedirect("login.jsp");
    }
    %>
</body>
</html>