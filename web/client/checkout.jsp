<%-- 
    Document   : checkout
    Created on : 21/05/2021, 04:11:54 PM
    Author     : droperdev
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.CartDTO"%>
<%@page import="model.paymentMethod.PaymentMethod"%>
<%@page import="model.clientAddress.ClientAddressDAOImpl"%>
<%@page import="model.clientAddress.ClientAddress"%>
<%@page import="dto.ClientDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ClientDTO client = (ClientDTO) session.getAttribute("client");
    if (client != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/menu.css" >
        <link rel="stylesheet" href="css/header.css" >
        <link rel="stylesheet" href="css/common.css" >
        <link rel="stylesheet" href="css/main.css" >
        <link rel="stylesheet" href="css/checkout.css">
    </head>
    <body>
        <div class="sidebar">
            <div class="sidebar-inner">
                <div class="sidebar-user">
                    <div class="image">
                        <img class="image-circle" 
                             src="https://www.seekpng.com/png/full/356-3562377_personal-user.png"
                             alt="icono de perfil">
                    </div>
                    <div class="info">
                        <span class="user"><%= client.getFullName()%></span><br>
                        <span class="role"><%= client.getEmail()%></span>
                    </div>
                </div>
                <hr>
                <ul class="sidebar-menu">
                    <li class="nav-item">
                        <a class="nav-link" href="../Main?action=main">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Catálogos</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../Main?action=logout-client">
                            <img class="icon" src="assets/logout.svg">
                            <span clasS="text-wrap">Cerrar sesión</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="header">
            <div class="content-header">
                <span class="title">Checkout</span>
            </div>

        </div>
        <% ClientAddress address = new ClientAddressDAOImpl().getAddress(client.getId());%>
        <div class="content">
            <div class="container card">
                <form method="POST" action="../Main?action=checkout&addressId=<%=address.getId()%>">
                    <div class="row">

                        <div class="col-md-6">

                            <h4>Datos del cliente</h4>
                            <div class="form-group">
                                <label>Dirección</label>    
                                <input class="form-control" type="text" disabled="true" value="<%= address.getAddress()%>" >
                            </div>
                            <div class="form-group">
                                <label>Referencia</label>    
                                <input class="form-control" type="text" disabled="true" value="<%= address.getReference()%>">
                            </div>
                            <div class="form-group">
                                <label>Método de pago</label>
                                <select class="form-control" name="paymentMethodId">
                                    <option value="1">Efectivo</option>
                                    <option value="2">Tarjeta</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Comprobante</label>
                                <select class="form-control" name="voucherId">
                                    <option value="1">Boleta</option>
                                    <option value="2">Factura</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Tipo de pedido</label>
                                <select class="form-control" name="orderTypeId">
                                    <option value="1">Delivery</option>
                                    <option value="2">Recojo en tienda</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4>Productos</h4>
                            <% Double sum = 0.0; %>
                            <%
                                List<CartDTO> carts;
                                Object object = session.getAttribute("carts");
                                if (object != null) {
                                    carts = (List) object;
                                } else {
                                    carts = new ArrayList();
                                }
                            %>
                            <div class="d-flex flex-row justify-content-center">
                                <%! CartDTO cart;%>
                                <% for (int i = 0; i < carts.size(); i++) { %>
                                <% cart = carts.get(i);%>
                                <% sum = sum + (cart.getQuantity() * cart.getProduct().getPrice());%>
                                <div class="flex-row flex-wrap" style="width: 10rem;">
                                    <img class="card-img-top rounded-circle" src="https://tipsparatuviaje.com/wp-content/uploads/2019/08/papa-a-la-huancaina.jpg">
                                    <div class="card-body">
                                        <h5 class="card-title"><%=cart.getProduct().getName()%></h5>
                                    </div>
                                </div>
                                <% }%>
                            </div> 
                            <div class="offset-md-6 col-md-6">
                                <div class="form-group">
                                    <label>Costo de productos</label>    
                                    <input class="form-control" type="text" disabled="true" value="<%=String.format("%.2f", sum)%>">
                                </div>
                            </div>
                            <div class="offset-md-6 col-md-6">
                                <div class="form-group">
                                    <label>Costo de envio</label>    
                                    <input class="form-control" type="text" disabled="true" value="5,00">
                                </div>
                            </div>

                            <div class="offset-md-3 col-md-6">
                                <div class="form-group">
                                    <input class="btn btn-primary btn-block" type="submit" value="Registrar pedido">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="scripts/main.js"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>