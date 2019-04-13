<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       <%
       String kq = request.getParameter("kq");
       if(kq != null){
          out.print("kq from Parameter " + request.getParameter("kq"));  // cách 1
           out.print("<br> kq from Session: " + session.getAttribute("kq")); // cách 1 
       }
       
       if(request.getAttribute("kq") != null)
       {
           out.print("<br> kq from RequestDispatcher: " + request.getAttribute("kq")); // cách 1
       }
       %>
     <form action="Test" method="post" >
        a = <input type="text" name="txta"><br>
        b = <input type="text" name="txtb"><br>
        Result : <input type="text" name="kq" value="<%=kq %>">
         <input type="submit" name="btn" value="Cộng">
    </form>
    <a href="Test?ts">link</a>
    <%

    %>
</body>
</html>