<%-- 
    Document   : cancel
    Created on : 23/04/2021, 10:41:56 AM
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
            <h5>¿Realmente desea anular el pedido?</h5>
            <br>
            <form method="POST" action="Main?action=cancel&orderId=<%=orderId%>">
                <input type="submit" class="btn btn-primary btn-block" value="Aceptar">
            </form>
        </div>
    </body>
</html>
