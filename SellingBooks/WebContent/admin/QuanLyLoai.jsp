<%@page import="Bean.AdminBean"%>
<%@page import="Bo.LoaiBo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.LoaiBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý loại sách</title>
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
        <p class="tieude_admin">Thông tin loại sách</p>
        <a href="${root}/admin/ThemLoai.jsp" class="button">Thêm loại sách</a>
        <table class="data">
            <tr class="data">
                <th class="data" width="30px">STT</th>
                <th class="data">Mã loại</th>
                <th class="data">Tên loại</th>
                <th class="data" width="75px">Tùy chọn</th>
            </tr>
            <%
                LoaiBo loaiSach = new LoaiBo();
                ArrayList<LoaiBean> list = loaiSach.getListLoai();
                int count = 0;
                for (LoaiBean loai : list) {
                    count++ ;
            %>
            <tr class="data">
                <td class="data" width="30px"><%=count %></td>
                <td class="data"><%=loai.getMaLoai() %></td>
                <td class="data"><%=loai.getTenLoai() %></td>
                <td class="data" width="75px">
                    <center>
                        <a href="/SellingBooks/admin/SuaLoai.jsp?loai=sua&maLoai=<%=loai.getMaLoai() %>&tenLoai=<%=loai.getTenLoai() %>"><img src="${root}/image/admin/icon_edit.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/SellingBooks/QuanLyLoaiServlet?loai=xoa&maLoai=<%=loai.getMaLoai() %>"><img src="${root}/image/admin/icon_delete.png"></a>
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