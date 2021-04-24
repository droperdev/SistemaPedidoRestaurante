<%-- 
    Document   : userDelete
    Created on : 23/04/2021, 07:46:58 PM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% int userId = Integer.parseInt(request.getParameter("userId"));%>
        <div class="container">
            <h5>¿Realmente desea eliminar al usuario?</h5>
            <br>
            <form method="POST" action="Main?action=userDelete&userId=<%=userId%>">
                <input type="submit" class="btn btn-primary btn-block" value="Aceptar">
            </form>
        </div>
    </body>
</html>
