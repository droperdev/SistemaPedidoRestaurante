<%-- 
    Document   : main
    Created on : 13/05/2021, 02:59:46 AM
    Author     : droperdev
--%>

<%@page import="dto.ClientDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ClientDTO client = (ClientDTO) session.getAttribute("client");
    if (client != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Main</h1>
    </body>
</html>
<%
    } else {
        response.sendRedirect("admin/index.jsp");
    }
%>