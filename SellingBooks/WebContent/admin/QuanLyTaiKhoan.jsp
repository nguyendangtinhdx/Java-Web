<%@page import="Bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.AdminBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý tài khoản</title>
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
    <jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <p class="tieude_admin">Thông tin tài khoản</p>
        <a href="${root}/admin/ThemTaiKhoan.jsp" class="button">Thêm tài khoản</a>
        <table class="data">
            <tr class="data">
                <th class="data" width="30px">STT</th>
                <th class="data">Tên tài khoản</th>
                <th class="data">Mật khẩu</th>
                <th class="data">Quyền</th>
                <th class="data" width="75px">Tùy chọn</th>
            </tr>
            <%
                AdminBo adminBo = new AdminBo();
                ArrayList<AdminBean> list = adminBo.getListAdmin();
                int count = 0;
                for (AdminBean ad : list) {
                    count++;
            %>
            <tr class="data">
                <td class="data" width="30px"><%=count%></td>
                <td class="data"><%=ad.getTenDanhNhap()%></td>
                <td class="data"><%=ad.getMatKhau()%></td>
                <%
                    boolean quyen = false;
                        if (ad.getQuyen() == 1)
                            quyen = true;
                %>
                <td class="data"><%=quyen%></td>
                <td class="data" width="75px">
                    <center>
                        <a
                            href="/SellingBooks/admin/SuaTaiKhoan.jsp?loai=sua&tenDangNhap=<%=ad.getTenDanhNhap()%>&quyen=<%=quyen %>"><img
                            src="${root}/image/admin/icon_edit.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a
                            href="/SellingBooks/QuanLyTaiKhoanServlet?loai=xoa&tenDangNhap=<%=ad.getTenDanhNhap()%>"><img
                            src="${root}/image/admin/icon_delete.png"></a>
                    </center>
                </td>
            </tr>
            <%
                }
            %>
        </table>
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