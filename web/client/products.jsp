<%-- 
    Document   : products
    Created on : 18/05/2021, 11:48:34 PM
    Author     : droperdev
--%>

<%@page import="model.product.Product"%>
<%@page import="model.product.ProductDAOImpl"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/products.css" >
    </head>
    <body>
        <h4>Productos</h4>
        <% int categoryId = Integer.parseInt(request.getParameter("categoryId"));%>
        <div class="content-products">
            <% List<Product> products = new ProductDAOImpl().getAll(categoryId); %>
            <%! Product product;%>
            <% for (int i = 0; i < products.size(); i++) { %>
            <% product = products.get(i);%>
            <div class="card flex-row flex-wrap">
                <img class="card-img-top" src="https://tipsparatuviaje.com/wp-content/uploads/2019/08/papa-a-la-huancaina.jpg">
                <div class="card-body">
                    <h5 class="card-title"><%=product.getName()%></h5>
                    <p class="card-text"><%=product.getDescription()%></p>
                    <div class="price text-success text-right"><h5 class="mt-4 mb-4">S/ <%=String.format("%.2f", product.getPrice())%></h5></div>
                    <input class="btn btn-primary btn-block" type="button" value="Agregar">
                </div>
            </div>
            <% }%>
        </div>
    </body>
</html>
