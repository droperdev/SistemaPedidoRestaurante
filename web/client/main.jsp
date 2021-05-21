<%-- 
    Document   : main
    Created on : 13/05/2021, 02:59:46 AM
    Author     : droperdev
--%>

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
                    <li class="nav-item show">
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
                <span class="title">Catálogo</span>
                <button type="button" class="btn btn-primary" onclick="openCart(1);">Carrito (0)</button>
            </div>

        </div>
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <h4>Categorias</h4>
                        <% List<Category> categories = new CategoryDAOImpl().getAll();%>
                        <ul>
                            <%! Category category;%>
                            <% for (int i = 0; i < categories.size(); i++) { %>
                            <% category = categories.get(i);%>
                            <li class="card p-2">
                                <a onclick="loadProducts(<%=category.getId()%>)">
                                    <span clasS="text-wrap"><%=category.getName()%></span>
                                </a>
                            </li>
                            <% }%>
                        </ul>
                    </div>
                    <div class="col-md-8">
                        <div id="products">

                        </div>
                    </div>

                </div>
            </div>
            <div class="modal fade modal-right" id="MyModal" tabindex="-1" role="dialog" aria-labelledby="MyModalLabel" >
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