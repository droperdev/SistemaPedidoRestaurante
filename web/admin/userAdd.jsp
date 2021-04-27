<%-- 
    Document   : userAdd
    Created on : 23/04/2021, 07:18:25 PM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form method="POST" action="../Main?action=registerUser">
                <div >
                    <div class="form-group">
                        <label>Nombres</label>    
                        <input class="form-control" type="text" value="" name="nombre" id="nombre">
                    </div>
                    <div class="form-group">
                        <label>Apellidos</label>    
                        <input class="form-control" type="text" value="" name="apellido" id="apellido">
                    </div>
                    <div class="form-group">
                        <label>Usuario</label>    
                        <input class="form-control" type="text" value="" name="usuario" id="usuario">
                    </div>
                    <div class="form-group">
                        <label>Contraseña</label>    
                        <input class="form-control" type="password" value="" name="password" id="password">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary btn-block" type="submit" value="Guardar Usuario">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
