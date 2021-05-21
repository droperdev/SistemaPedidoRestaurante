<%-- 
    Document   : orders
    Created on : 17/04/2021, 04:33:53 AM
    Author     : droperdev
--%>
<%@page import="dto.UserDTO"%>
<%@page import="dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.order.OrderDAOImpl"%>
<%@page import="model.user.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO user = (UserDTO) session.getAttribute("user");
    if (user != null) {
%>
<html lang="es">
    <head>
        <meta charset="utf-8" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema Restaurant</title>
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
                        <span class="user"><%= user.getFullName()%></span><br>
                        <span class="role"><%= user.getRole().getName()%></span>
                    </div>
                </div>
                <hr>
                <ul class="sidebar-menu">
                    <li class="nav-item">
                        <a class="nav-link" href="../Main?action=users">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Usuarios</span>
                        </a>
                    </li>
                    <li class="nav-item show">
                        <a class="nav-link" href="../Main?action=orders">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Pedidos</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../Main?action=history">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Historial de pedidos</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../Main?action=logout">
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
            <% int[] ids = {1, 2, 3}; %>
            <% List<OrderDTO> orders = new OrderDAOImpl().getAll(ids); %>
            <div class="card table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Cliente</th>
                            <th>Dirección</th>
                            <th>Método de Pago</th>
                            <th>Voucher</th>
                            <th>Tipo de pedido </th>
                            <th>Distribuidor</th>
                            <th>Total</th>
                            <th class="text-center">Estado</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%! OrderDTO order;%>
                        <% for (int i = 0; i < orders.size(); i++) { %>
                        <% order = orders.get(i);%>
                        <tr>
                            <td><%=order.getId()%></td>
                            <td><%=order.getClient().getName() + " " + order.getClient().getLastName()%></td>
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
                            <td class="text-center">
                                <div class="dropdown">
                                    <a class="btn fa fa-ellipsis-v" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                        <%if (order.getStatus().getId() == 2) {%>
                                        <button class="dropdown-item" onclick="openAssignOrder('<%=order.getId()%>');" ><i class="fa fa-user"></i>&nbsp;&nbsp;&nbsp;Asignar pedido</button>
                                        <%}%>
                                        <button class="dropdown-item" onclick="openDetail('<%=order.getId()%>');"><i class="fa fa-file-text-o"></i>&nbsp;&nbsp;&nbsp;Ver pedido</button>
                                        <button class="dropdown-item" onclick="openMap('<%=order.getId()%>');" ><i class="fa fa-map"></i>&nbsp;&nbsp;&nbsp;Ver mapa</button>
                                        <%if (order.getStatus().getId() != 2) {%>
                                        <button class="dropdown-item" onclick="openChangeStatus('<%=order.getId()%>');" ><i class="fa fa-spinner"></i>&nbsp;&nbsp;&nbsp;Cambiar de estado</button>
                                        <%}%>
                                        <button class="dropdown-item" onclick="openCancelOrder('<%=order.getId()%>');" ><i class="fa fa-spinner"></i>&nbsp;&nbsp;&nbsp;Anular pedido</button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
            <div class="modal fade" id="MyModal" tabindex="-1" role="dialog" aria-labelledby="MyModalLabel" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="MyModalLabel"></h5>
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