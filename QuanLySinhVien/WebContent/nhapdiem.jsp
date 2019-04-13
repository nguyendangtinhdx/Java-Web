<%@page import="model.sinhvien"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nhập điểm sinh viên</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<!-- header -->
	<div id="header">
	
	</div><!--end header -->
	
	<!-- menu -->
	<div id="menu">
		<ul>
			<li><a href="themsv.jsp">Thêm thông tin sinh viên</a></li>		
		</ul>
		<ul>
			<li><a href="getDS.jsp">Nhập điểm sinh viên</a></li>		
		</ul>
	</div><!--end menu -->
	
	<!-- content -->
	<div id="content">
	<%
		Vector<sinhvien> vtsv = (Vector<sinhvien>)request.getAttribute("listsv");
	%>
		<center>
			Danh sách sinh viên
			<table>
				<tr>
					<th>Họ tên</th>
					<th>Lớp</th>
					<th>Giới tính</th>
					<th>Chuyên ngành</th>
					<th>Điểm chuyên cần</th>
					<th>Điểm giữa kỳ</th>
					<th>Điểm cuối kỳ</th>
				</tr>
				<%
					for(int i=0;i<vtsv.size();i++){
						String gioitinh = "Nam";
						String cn = "Công nghệ thông tin";
						if(vtsv.get(i).getGioitinh() == "0"){
							gioitinh = "Nữ";
						}
						switch(vtsv.get(i).getChuyennganh()){
							case 2: cn = "Điện tử viễn thông"; break;
							case 3: cn = "Mạng truyền thông"; break;
 						}
					
				%>
				<tr>
					<td><%=vtsv.get(i).getHoten() %></td>
					<td><%=vtsv.get(i).getLop() %></td>
					<td><%=gioitinh %></td>
					<td><%=cn %></td>
					<td><%=vtsv.get(i).getDcc() %></td>
					<td><%=vtsv.get(i).getDgk() %></td>
					<td><%=vtsv.get(i).getDck() %></td>
				</tr>
				<%
					}
				%>
				
			</table>
		</center>
	</div><!--end content -->
	
	<!-- footer -->
	<div id="footer">
	
	</div><!--end footer-->
</body>
</html>