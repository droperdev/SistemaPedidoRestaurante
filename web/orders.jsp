<%-- 
    Document   : orders
    Created on : 17/04/2021, 04:33:53 AM
    Author     : droperdev
--%>
<%@page import="dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.order.OrderDAOImpl"%>
<%@page import="model.user.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
%>
<html lang="es">
    <head>
        <meta charset="utf-8" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema Restaurant</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet"  href="css/main.css" >
        <link rel="stylesheet"  href="css/menu.css" >
        <link rel="stylesheet"  href="css/header.css" >
        <link rel="stylesheet"  href="css/common.css" >
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
                        <span class="user"><%= user.getFullName()%></span><br>
                        <span class="role"><%= user.getUserName()%></span>
                    </div>
                </div>
                <hr>
                <ul class="sidebar-menu">
                    <li class="nav-item show">
                        <a class="nav-link" href="Main?action=orders">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Pedidos</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Main?action=history">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Historial de pedidos</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="Main?action=logout">
                            <img class="icon" src="assets/logout.svg">
                            <span clasS="text-wrap">Cerrar sesión</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="header">
            <div class="content-header">
                <span class="title">Pedidos</span>
            </div>
        </div>

        <div class="content">
            <% int[] ids = {1,2,3}; %>
            <% List<OrderDTO> orders = new OrderDAOImpl().getAll(ids); %>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Cliente</th>
                            <th>AddressId</th>
                            <th>Método de Pago</th>
                            <th>Voucher</th>
                            <th>Distribuidor</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%! OrderDTO order;%>
                        <% for (int i = 0; i < orders.size(); i++) { %>
                        <% order = orders.get(i);%>
                        <tr>
                            <td><%=order.getId()%></td>
                            <td><%=order.getClient().getName() + " " + order.getClient().getLastName()%></td>
                            <td><%=order.getAddressId()%></td>
                            <td><%=order.getPaymentMethod().getName()%></td>
                            <td><%=order.getVoucher().getName()%></td>
                            <td><%=order.getDistributor().getName() + " " + order.getDistributor().getLastName()%></td>
                            <td><a href="">Ver</a></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>