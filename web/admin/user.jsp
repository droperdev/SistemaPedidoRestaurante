<%-- 
    Document   : orders
    Created on : 17/04/2021, 04:33:53 AM
    Author     : droperdev
--%>
<%@page import="model.user.UserDAOImpl"%>
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
        <link rel="stylesheet"  href="css/menu.css" >
        <link rel="stylesheet"  href="css/header.css" >
        <link rel="stylesheet"  href="css/common.css" >
        <link rel="stylesheet"  href="css/main.css" >
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
                    <li class="nav-item show">
                        <a class="nav-link" href="../Main?action=users">
                            <img class="icon" src="assets/order.svg">
                            <span clasS="text-wrap">Usuarios</span>
                        </a>
                    </li>
                    <li class="nav-item ">
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
                <span class="title">Usuarios</span>
                <button type="button" class="btn btn-primary" onclick="openUser();">
                    Crear Usuario</button>
            </div>

        </div>

        <div class="content">
            <% int[] ids = {1, 2, 3}; %>
            <% List<UserDTO> users = new UserDAOImpl().getAll(); %>
            <div class="card table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>

                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Usuario</th>
                            <th>Rol </th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%! UserDTO user;%>
                        <% for (int i = 0; i < users.size(); i++) { %>
                        <% user = new UserDTO();
                            user = users.get(i);%>
                        <tr>
                            <td><%=user.getId()%></td>

                            <td><%=user.getName()%></td>
                            <td> <%=user.getLastName()%></td>
                            <td><%=user.getUserName()%></td>
                            <td><strong><%=user.getRole().getName()%></strong></td>
                            <td class="text-center">
                                <div class="dropdown">
                                    <a class="btn fa fa-ellipsis-v" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                        <button class="dropdown-item" onclick="openDeleteUser('<%=user.getId()%>');"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;&nbsp;Eliminar</button>
                                    </div>
                                </div>
                            </td>
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