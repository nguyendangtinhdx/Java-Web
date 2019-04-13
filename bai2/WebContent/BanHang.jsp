<%@page import="Bo.HangBo"%>
<%@page import="Bean.Hang"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BanHang.jsp" method="post">
		Ten Hang <input type="text" name="txta">
		Gia <input type="text" name="txtb">
		So Luong <input type="text" name="txtc">
		<input type="submit" name="bnt" value = "DAT HANG"> <br> <br>
	</form>
	<strong>DANH SACH CAC MAT HANG</strong>
	<%
		String th = request.getParameter("txta");
		if(th!=null){
		Float Gia = Float.parseFloat(request.getParameter("txtb"));
		int SoLuong = Integer.parseInt(request.getParameter("txtc"));
		HangBo hang = new HangBo();
		if(session.getAttribute("gh")==null)
			session.setAttribute("gh", hang);
		hang = (HangBo) session.getAttribute("gh");
		hang.Them(th, Gia, SoLuong);
		session.setAttribute("gh", hang);
		}
	%>
<table border = "1" cellpadding = "10" cellspacing = "0">
	<%if(session.getAttribute("gh")!=null){
	HangBo giohang = (HangBo)session.getAttribute("gh");
	for (Hang h: giohang.ds){%>
	<tr><td><%=h.getTenHang()%></td>
	<td><%=h.getGia()%></td>
	<td><%=h.getSoLuong() %></td>
	<td><form method ='post' action='Sua.jsp?th=<%=h.getTenHang()%>'>
	<input type='text' name ='txtsua'>
	<input type='submit' name='bnt2' value='Sua'>
	</form></td>
	<td><a href='Xoa.jsp?th=<%=h.getTenHang()%>'> Xoa </a></td>
	</tr>
	<%}
	}
	%>
</table>
</body>
</html>