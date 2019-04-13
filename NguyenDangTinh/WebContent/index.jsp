<%@page import="Bean.MayTinhBean"%>
<%@page import="Bean.HangBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%
NumberFormat nf = NumberFormat.getIntegerInstance();
nf.setMinimumIntegerDigits(0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bán máy tính</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<style>
body {
    margin:0 20px 0 20px;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
  <a class="navbar-brand" href="XuLyServlet">Trang chủ</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="ThongKeServlet">Thống kê <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="XuLyServlet" method="post">
      <input class="form-control" type="text" placeholder="Từ khóa..." name="key" >
                    <button class="btn btn-success" type="submit">Tìm kiếm</button>
    </form>
  </div>
</nav>

    <div class="row">
        <div class="col-sm-2">
            <table align="center" class='table table-responsive table-hover'>
                <tr>
                    <td align="center" width="200px"><b>Hãng</b></td>
                </tr>
                <%
                        if (request.getAttribute("ListHang") != null) {
                            ArrayList<HangBean> dshang= (ArrayList<HangBean>) request.getAttribute("ListHang");
                            for (HangBean hang : dshang) {
                %>
                <tr>
                    <td align="center"><a href="XuLyServlet?mh=<%=hang.getMaHang()%>&th=<%=hang.getTenHang() %>"><%=hang.getTenHang()%></a>
                    </td>
                </tr>
                <%
                    }
                    }
                %>

            </table>
        </div>
      <div class="col-sm-10">
        <%if(request.getParameter("th") != null)  {%>
            <center><h2 style="margin-bottom: 20px;color: red"><%=request.getParameter("th") %></h2></center>
            <%} %>
                <div class="row">
                <%
                    if(request.getAttribute("List") != null){
                    ArrayList<MayTinhBean> dsmaytinh = (ArrayList<MayTinhBean>)request.getAttribute("List");
                        for(MayTinhBean maytinh : dsmaytinh){
                %>
                     <div class="col-sm-4" style="margin-bottom: 20px;">
                        <div>
                            <b>Tên: </b><%=maytinh.getTen() %> <br>
                            <b>Giá: </b><%=nf.format(maytinh.getGia()) %> đ<br>
                            <b>Số lượng: </b><%=maytinh.getSoLuong() %><br>
                            <b>Ngày sản xuất: </b><%=maytinh.getNgaySanXuat() %><br>
                             <a href="MuaHang"><button class="btn btn-success">Mua</button></a>
                        </div>
                    </div>
                <%
                }
                }
                %>
            </div>
        </div> 
    </div>

</body>
</html>