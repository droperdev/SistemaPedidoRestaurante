<%-- 
    Document   : main
    Created on : 13/05/2021, 02:59:46 AM
    Author     : droperdev
--%>

<%@page import="model.order.OrderDAOImpl"%>
<%@page import="dto.OrderDTO"%>
<%@page import="dto.ClientDTO"%>
<%@page import="model.category.CategoryDAOImpl"%>
<%@page import="model.category.Category"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ClientDTO client = (ClientDTO) session.getAttribute("client");
    if (client != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/menu.css" >
        <link rel="stylesheet" href="css/header.css" >
        <link rel="stylesheet" href="css/common.css" >
        <link rel="stylesheet" href="css/main.css" >
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

                    <li class="nav-item show">
                        <a class="nav-link" href="../Main?action=listOrders">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Mis Pedidos</span>
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
                <span class="title">Mis Pedidos</span>
            </div>

        </div>
        <div class="content">
            <% int[] ids = {1, 2, 3}; %>
            <% List<OrderDTO> orders = new OrderDAOImpl().getAll(client.getId()); %>
            <div class="card table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Dirección</th>
                            <th>Método de Pago</th>
                            <th>Voucher</th>
                            <th>Tipo de pedido </th>
                            <th>Distribuidor</th>
                            <th>Total</th>
                            <th class="text-center">Estado</th>


                        </tr>
                    </thead>
                    <tbody>
                        <%! OrderDTO order;%>
                        <% for (int i = 0; i < orders.size(); i++) { %>
                        <% order = new OrderDTO();
                            order = orders.get(i);%>
                        <tr>
                            <td><%=order.getId()%></td>

                            <td><%=order.getClient().getName()%></td>
                            <td><%=order.getClient().getLastName()%></td>
                            <td>
                                <%=order.getAddress().getAddress()%> <br>
                                <%=order.getAddress().getReference()%>
                            </td>
                            <td><%=order.getPaymentMethod().getName()%></td>
                            <td><%=order.getVoucher().getName()%></td>
                            <td><%=order.getOrderType().getName()%></td>
                            <% if (order.getDistributor().getName() != null) {%>
                            <td class="font-weight-bold"><%=order.getDistributor().getName() + " " + order.getDistributor().getLastName()%></td>
                            <% } else {%>
                            <td class="font-weight-bold">-</td>
                            <%}%>
                            <td class="font-weight-bold text-success">S/&nbsp;<%=String.format("%.2f", order.getTotal())%></td>
                            <td class="text-center"><span class="<%=order.getStatus().getClassName()%>"><%=order.getStatus().getName()%></span></td>

                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
            <div class="modal fade" id="MyModal2" tabindex="-1" role="dialog" aria-labelledby="MyModalLabel2" >
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="MyModalLabel2"></h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body" id="content-modal">

                        </div>
                    </div>
                </div>
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