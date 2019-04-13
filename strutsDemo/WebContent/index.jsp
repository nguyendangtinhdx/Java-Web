<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <s:form action="Login">
    <s:textfield name="name" label="Họ Tên"></s:textfield>
    <s:password name="password" label="Mật khẩu"></s:password>
    <s:submit value="Login"></s:submit>
   </s:form>
</body>
</html>