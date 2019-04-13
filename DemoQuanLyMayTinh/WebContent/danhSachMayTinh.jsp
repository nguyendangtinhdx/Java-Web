<%@page import="bean.MayTinhBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý cửa hàng</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript">
function checkDelete() {
    return confirm("Bạn có chắc chắn muốn xóa không ?");
}
</script>
</head>
<body>
    <%
        int pages = 5;
    %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand"
        href="MainServlet">Trang chủ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachHang=1">Danh sách hãng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themHang=1">Thêm mới hãng</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?danhSachMayTinh=1">Danh sách máy tính</a></li>
            <li class="nav-item"><a class="nav-link" href="MainServlet?themMayTinh=1">Thêm mới máy tính</a></li>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get" action="MainServlet">
            <input class="form-control mr-sm-2" type="text" placeholder="Từ khóa tìm kiếm..." aria-label="Search" name="keyMayTinh">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="loai" value="timKiemMayTinh">Tìm kiếm</button>
        </form>
        
    </div>
    </nav>
    
    <div>
     <h3 style="text-align: center; color: red;">Thông tin máy tính</h3>
        <table class="table table-hover" style="width: 100%; margin: auto;">
            <thead class="thead-light">
                <tr>
                    <th>Mã</th>
                    <th>Tên</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Ngày sản xuất</th>
                    <th>Mã hãng</th>
                    <th colspan="2">Tùy chọn</th>
                </tr>
            </thead>
            <tbody>
                
                    <%  
                    if(request.getAttribute("ListMayTinh") != null){
                        ArrayList<MayTinhBEAN> list = (ArrayList<MayTinhBEAN>)request.getAttribute("ListMayTinh");
                        for(MayTinhBEAN m : list){
                           
                    %>
                    <tr>
                    <td><%=m.getMa() %></td>
                    <td><%=m.getTen() %></td>
                    <td><%=m.getGia() %></td>
                    <td><%=m.getSoLuong() %></td>
                    <td><%=m.getNgaySanXuat() %></td>
                    <td><%=m.getMaHang() %></td>
                    <td><a href="MainServlet?suaMayTinh=1&ma=<%=m.getMa()%>&ten=<%=m.getTen() %>&gia=<%=m.getGia() %>&soLuong=<%=m.getSoLuong() %>&ngaySanXuat=<%=m.getNgaySanXuat() %>&maHang=<%=m.getMaHang() %>">
                    <img src="image/icon_edit.png"></a></td>
                    <td><a href="MayTinhServlet?loai=xoaMayTinh&ma=<%=m.getMa() %>" onclick="return checkDelete();">
                    <img style="margin-left: -80px" src="image/icon_delete.png"></a></td>
                    </tr>
                    <%
                        }
                    }
                    %> 
            </tbody>
        </table>
    </div>
    <div style="clear: both;"></div>
</body>
</html>