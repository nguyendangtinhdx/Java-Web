<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery-1.11.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tính tổng</title>
</head>
<body>
    <form method="post" action="TinhTong.jsp">
        <table width="300" align="center" style="margin-top: 20px;">
            <tr>
                <td><input type="text" name="txtNum" class="form-control"placeholder="Nhập vào 1 số"></td>
            </tr>
            <tr>
                <td><input type="submit" name="btnTong" value="Tính tổng"
                    class="btn btn-primary"></td>
            </tr>
            <tr>
                <td align="center">
                    <%
                        String n = request.getParameter("txtNum");
                        if (n != null) {
                            if (session.getAttribute("a") == null)
                                session.setAttribute("a", 0); // gắn giá trị ban đầu = 0 
                            int s = (int) session.getAttribute("a"); // b1: tạo biến và ép kiểu
                            s += Integer.parseInt(n); // b2: thực hiện tính tổng
                            session.setAttribute("a", s); // b3: Lưu biến vào session
                            out.print(s);
                        }
                    %>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>