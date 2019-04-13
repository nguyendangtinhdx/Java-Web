<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link re>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if(request.getParameter("txta")!=null && request.getParameter("txtb")!=null){
		//out.print(request.getParameter("btnc"));
		int a = Integer.parseInt(request.getParameter("txta"));
		int b = Integer.parseInt(request.getParameter("txtb"));
		if(request.getParameter("btnc")!=null)
		out.print(a + b);
		if(request.getParameter("btnt")!=null)
			out.print(a - b);
		if(request.getParameter("btnn")!=null)
			out.print(a * b);
		if(request.getParameter("btnchia")!=null)
			out.print(a / b);
	}
	%>
	<form method = 'post' action='GuiNhapData.jsp'>
		a =<input type = 'text' name="txta" placeholder="nhap a" value = '<%=request.getParameter("txta")==null?"":request.getParameter("txta")%>'><br>
		b =<input type = 'text' name="txtb" placeholder="nhap b" value = '<%=request.getParameter("txtb")==null?"":request.getParameter("txtb")%>'><br>

		<input type='submit' name='btnc' value ='+'>
		<input type='submit' name='btnt' value ='-'>
		<input type='submit' name='btnn' value ='x'>
		<input type='submit' name='btnchia' value ='/'> <br>
	</form>
</body>
</html>