<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
    String name = request.getParameter("name");
    String quantity = request.getParameter("quantity"); 
    String price = request.getParameter("price");
    
    if(!name.equals("") && !quantity.equals("") && !price.equals("")){
        Product item = new Product(name,Integer.parseInt(price),Integer.parseInt(quantity));
        
        if(session.getAttribute("products") != null){
            ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
            Boolean check = true;
            for(int i = 0;i < products.size();i++){
                if(products.get(i).Name.equals(item.Name)){
                    Product tmp = products.get(i);
                    tmp.Quantity += item.Quantity;
                    products.remove(i);
                    products.add(tmp);
                    check = false;
                    break;
                }
            }
            if(check == true){
                products.add(item);
            }
            session.setAttribute("products", products);
        }else{
            ArrayList<Product> products = new ArrayList<Product>();
            products.add(item);
            session.setAttribute("products", products);
        }
    }
    response.sendRedirect("Index.jsp");
%>
</body>
</html>