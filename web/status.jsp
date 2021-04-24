<%-- 
    Document   : status
    Created on : 23/04/2021, 10:24:33 AM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% int orderId = Integer.parseInt(request.getParameter("orderId"));%>
        <div class="container">
            <h5>¿Realmente desea cambiar de estado?</h5>
            <br>
            <form method="POST" action="Main?action=status&orderId=<%=orderId%>">
                <input type="submit" class="btn btn-primary btn-block" value="Aceptar">
            </form>
        </div>
    </body>
</html>
