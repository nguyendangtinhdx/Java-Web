<%@page import="Entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sửa</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <style>
     body{width: 700px;margin: auto;}
    </style>
</head>
<body>
    <%
    ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
    Product product = products.get(Integer.parseInt(request.getParameter("index")));

    String name = request.getParameter("name");
    String quantity = request.getParameter("quantity");
    String price = request.getParameter("price");
    String index = request.getParameter("index");

    if (name != null && quantity != null && price != null) {
        if (!name.equals("") && !quantity.equals("") && !price.equals("")) {
            Product item = new Product(name, Integer.parseInt(price),Integer.parseInt(quantity));
            products.remove(Integer.parseInt(index));
            products.add(Integer.parseInt(index), item);
            session.setAttribute("products", products);
            response.sendRedirect("Index.jsp");
        }
    }
%>

    <form action="Edit.jsp" method="POST">
        <div class="form-group" style="margin-top: 20px">
                <input class="form-control input-sm" type="text" name="index" required value="<%=(request.getParameter("index")) %>" style="display:none"/>
                <label>Tên hàng:</label>
                <input class="form-control input-sm" type="text" name="name" required value="<%=(product.Name) %>"/>
                <label>Giá:</label>
                <input class="form-control input-sm" type=text name="price" required value="<%=(product.Price) %>" />
                <label>Số lượng:</label>
                <input class="form-control input-sm" type="text" name="quantity" required value="<%=(product.Quantity) %>"/>
                <button class="btn btn-success" style="margin-top:24px">Sửa</button>
                <a class="btn btn-danger" style="margin-top:24px" href="Index.jsp">Hủy</a>
        </div>
    
    </form>
</body>
</html>