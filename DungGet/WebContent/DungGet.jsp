<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dùng get</title>
<style type="text/css">
	table,td{
		border: 1px solid black;
		width: 50%;
		border-collapse: collapse;
	}
	.title{
		text-align: center;
		color: #ff0000;
		font-size: 30px;
	}
	.content{
		height: 200px;
	}
	td > a{
		font-size: 20px;
		color: blue;
	}
	.td{text-align: center;}
</style>
</head>
<body>
	<table align="center">
		<tr>
			<td class="title" colspan="2">Menu</td>
		</tr>
		<tr>
			<td class="td"><a href="DungGet.jsp?p=l">Link</a></td>
			<td class="content td" rowspan="3">
				<%
					String st = request.getParameter("p");
					if(st != null)
					{
						if(st.equals("l"))
							out.print("<a href='http://facebook.com' target='blank'> Facebook</a>");
						if(st.equals("a"))
							out.print("<img src = 1.jpg style='width:200px;height:200px'>");
						if(st.equals("s"))
							out.print("<marquee><mark>Bạn đã chọn style</mark></marquee>");
					}
				%>
			</td>
		</tr>
		<tr>
			<td class="td"><a href="DungGet.jsp?p=a">Ảnh</a></td>
		</tr>
		<tr>
			<td class="td"><a href="DungGet.jsp?p=s">Style</a></td>
		</tr>
	</table>
</body>
</html>