<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width = '1000' align ="center" border = "2" cellpadding = "10" cellspacing = "0">
	<tr><td colspan='2'> Menu </td></tr>
	<tr>
		<td valign='top' width ='200'>
		<a href='ptGet.jsp?ts=db'>Doc Bao</a>  <hr> <a href='ptGet.jsp?ts=tt'>The Thao</a>  <hr> <a href='ptGet.jsp?ts=vc'>Vui Cuoi</a> 
		</td>
		<td>
		<%String gt = request.getParameter("ts");
		if(gt!=null){
		if(gt.equals("db"))
			out.print("<marquee> aaaa </marquee>");
		if(gt.equals("tt"))
			out.print("<marquee> bbbb </marquee>");
		//out.print<img src ='a.jpg'";
		if(gt.equals("vc"))
			out.print("<marquee> cccc </marquee>");
		}
		%>
		</td>
</table>
</body>
</html>