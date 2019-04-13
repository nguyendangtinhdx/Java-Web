<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="Bo.LoaiBo"%>
<%
    NumberFormat nf = NumberFormat.getIntegerInstance();
    nf.setMinimumIntegerDigits(0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bán hàng online</title>
<link rel="stylesheet" href="bootstrap.min.css">
<style>
body {
    margin: 0 20px 0 20px;
}
</style>
</head>
<body>
    <nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="HienThiLoaiSach">Trang chủ</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="GioHang.jsp">Giỏ hàng</a></li>
            <li><a href="ThanhToan">Thanh toán</a></li>
            <li><a href="KhachHang">Khách hàng</a></li>
            <li><a href="Logout">Đăng xuất</a></li>
        </ul>
        <ul class="nav navbar-nav" style="float: right; margin-top: 8px">
            <li>
                <form class="form-inline" action="XuLyServlet" method="post">
                    <input class="form-control" type="text" placeholder="Từ khóa..." name="key">
                    <button class="btn btn-success" type="submit">Tìm kiếm</button>
                </form>
            </li>
        </ul>

    </div>
    </nav>
    <div class="row">
        <div class="col-sm-2">
            <table align="center" class='table table-responsive table-hover'>
                <tr>
                    <td align="center"><b>Loại sách</b></td>
                </tr>
                <%
                    ArrayList<LoaiBean> dsloai = (ArrayList<LoaiBean>) request
                            .getAttribute("dsloai");
                    if (request.getAttribute("dsloai") != null) {
                        for (LoaiBean loai : dsloai) {
                %>
                <tr>
                    <td align="center"><a
                        href="XuLyServlet?ml=<%=loai.getMaLoai()%>&tl=<%=loai.getTenLoai()%>"><%=loai.getTenLoai()%></a>
                    </td>
                </tr>
                <%
                    }
                    }
                %>

            </table>
        </div>
        <div class="col-sm-10">
            <table align="center">
                <tr>
                    <center>
                        <h2 style="margin-bottom: 20px; color: red">Danh sách sách</h2>
                    </center>
                </tr>
                <%
                    ArrayList<SachBean> dssach = (ArrayList<SachBean>) request
                            .getAttribute("dssach");
                    int ss = dssach.size();
                    int i = 0;
                    if (request.getAttribute("dssach") != null) {
                        while (true) {
                            out.print("<tr>");
                            for (int j = 1; j <= 3; j++, i++) {
                                if (i == ss)
                                    break;
                                SachBean sach = dssach.get(i);
                %>
                <td width="400px" style="margin-bottom: 20px"><img src="<%=sach.getAnh()%>"
                    height="280" width="250"><br> <b><%=sach.getTenSach()%></b><br>
                    <b>Tác giả: </b><%=sach.getTacGia()%><br> <b>Giá: </b><%=nf.format(sach.getGia())%>
                    đ<br> <a href="MuaHang"><button class="btn btn-success">Mua</button></a></td>
                <%
                    }
                            out.print("</tr>");
                            if (i == ss)
                                break;
                        }
                    }
                %>
            </table>
        </div>
    </div>

</body>
</html>