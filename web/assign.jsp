<%-- 
    Document   : assign
    Created on : 22/04/2021, 11:57:06 PM
    Author     : droperdev
--%>

<%@page import="dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.user.UserDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% int orderId = Integer.parseInt(request.getParameter("orderId"));%>
        <% List<UserDTO> users = new UserDAOImpl().getDistributors(2);%>
        <div class="container">
            <form method="POST" action="Main?action=assign&orderId=<%=orderId%>">
                <div class="form-group">
                    <label>Distribuidores</label>
                    <select name="distributorId" class="form-control">
                        <%for (UserDTO user : users) {%>
                        <option value="<%=user.getId()%>"><%=user.getFullName()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="form-group">
                    <input class="btn btn-primary btn-block" type="submit" value="Asignar">
                </div>   
            </form>

        </div>
    </body>
</html>
