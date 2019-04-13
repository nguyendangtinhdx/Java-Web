<%@page import="java.text.NumberFormat"%>
<%@page import="bean.ThongKeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê tổng số tiền mặt của từng hộ dân</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);
    %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand"
        href="XuLyServlet">Trang chủ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?dotUngHo=1">Đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?chiTietDotUngHo=1">Chi tiết đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?addDotUngHo=1">Thêm mới đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?addChiTietDotUngHo=1">Thêm mới chi tiết đợt ủng hộ</a></li>
            <li class="nav-item"><a class="nav-link" href="XuLyServlet?tk=1">Thống kê</a></li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Từ khóa tìm kiếm..."
                aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
        </form>
    </div>
    </nav>

    <div>
        <h3 style="text-align: center; color: red;">Thống kê tổng số tiền mặt của từng hộ dân</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã hộ dân</th>
                    <th>Họ tên chủ hộ</th>
                    <th>Tổ hoặc thông</th>
                    <th>Khối hoặc đội</th>
                    <th>Là hộ nghèo</th>
                    <th>Tống số tiền mặt</th>
                </tr>
            </thead>
            <tbody>

                <%
                    if (request.getAttribute("ListThongKe") != null) {
                        ArrayList<ThongKeBEAN> thongKe = (ArrayList<ThongKeBEAN>) request.getAttribute("ListThongKe");
                        for (ThongKeBEAN tk : thongKe) {
                %>
                <tr>
                    <td><%=tk.getMaHoDan() %></td>
                    <td><%=tk.getHoTenChuHo() %></td>
                    <td><%=tk.getTo() %></td>
                    <td><%=tk.getKhoiHoacThon() %></td>
                    <td><%=tk.getLaHoNgheo() %></td>
                    <td><%=nf.format(tk.getTongSoTienMat()) %> đ</td>
                </tr>

                <%
                    }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>