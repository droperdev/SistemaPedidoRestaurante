<%-- 
    Document   : login
    Created on : 26/04/2021, 09:32:22 PM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("client") == null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión | Restaurant</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link  rel="stylesheet"  href="css/login.css" >
        <link  rel="stylesheet"  href="css/common.css" >
    </head>
    <body>
        <div class="card content-login">
            <%                String message = (String) session.getAttribute("message");
            %>
            <img src="./assets/logo.png" alt="">
            <hr>
            <form method="POST" action="../Login?action=client-login">
                <div class="form-group">
                    <label for="email">Correo electrónico</label>
                    <input id="email" class="form-control" type="email" name="email"/>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <input id="password" class="form-control" maxlength="6" type="password" name="password"/>
                </div>
                <input class="btn btn-primary btn-block" type="submit" value="Iniciar sesion">
                <input id="btn_register" class="btn btn-primary btn-block" type="button" value="Registrar">
                <% if (message != null) {%>
                <br>
                <label class="text-danger"> ${message} </label>
                <%
                        session.removeAttribute("message");
                    }%>           
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <script src="scripts/login.js"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("main.jsp");
    }
%>

