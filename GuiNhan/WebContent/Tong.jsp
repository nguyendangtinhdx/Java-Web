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
    //nhận dữ liệu gửi lên từ client bằng phương thức get hoặc post 
    int a = Integer.parseInt(request.getParameter("txta"));
    int b = Integer.parseInt(request.getParameter("txtb"));
    int kq = a+b;
    out.print(kq); 
%>
    
</body>
</html>