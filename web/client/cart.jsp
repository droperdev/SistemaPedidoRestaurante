<%-- 
    Document   : cart
    Created on : 20/05/2021, 07:52:54 PM
    Author     : droperdev
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.CartDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="content-products">
            <%
                List<CartDTO> carts;
                Object object = session.getAttribute("carts");
                if (object != null) {
                    carts = (List) object;
                } else {
                    carts = new ArrayList();
                }
            %>
            <%! CartDTO cart;%>
            <% for (int i = 0; i < carts.size(); i++) { %>
            <% cart = carts.get(i);%>
            <div class="card flex-row flex-wrap">
                <img class="card-img-top" src="https://tipsparatuviaje.com/wp-content/uploads/2019/08/papa-a-la-huancaina.jpg">
                <div class="card-body">
                    <h5 class="card-title"><%=cart.getProduct().getName()%></h5>
                    <p class="card-text"><%=cart.getProduct().getDescription()%></p>
                    <div class="price text-success text-right"><h5 class="mt-4 mb-4">S/ <%=String.format("%.2f", cart.getProduct().getPrice())%></h5></div>
                    <div class="text-center">
                        <button class="btn btn-primary rounded-circle"><i class="fa fa-minus"></i></button>
                        <span><strong>&nbsp;&nbsp; <%=cart.getQuantity()%> &nbsp;&nbsp;</strong></span>
                        <button class="btn btn-primary rounded-circle"><i class="fa fa-plus"></i></button>
                    </div>
                </div>
            </div>
            <% }%>
            <input  style="width:300px; padding:8px;position: fixed; bottom: 18px;" class="btn btn-primary" type="button" value="Pagar" onclick="openCheckout()">        
        </div>

        <script type="text/javascript" src="scripts/cart.js"/>
    </body>
</html>
