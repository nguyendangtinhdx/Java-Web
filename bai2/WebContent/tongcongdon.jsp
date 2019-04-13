<%@page import="bai2.biens"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	//int c=0;
	if(request.getParameter("txta")!=null)
	{
		int a = Integer.parseInt(request.getParameter("txta"));
		biens.s=biens.s+a;
		if(request.getParameter("btnc")!=null)
			out.print(biens.s);
	}
	%>
	<form method = 'post' action ="tongcongdon.jsp">
		a = <input type="text" name="txta" placeholder="nhap a" value = '<%=request.getParameter("txta")==null?"":request.getParameter("txta")%>'>
		<input type='submit' name='btnc' value ='+'>
	</form>
	<p>
	Java Static
	</p>
	
</body>
</html>