<%-- 
    Document   : detail
    Created on : 21/04/2021, 01:05:49 PM
    Author     : droperdev
--%>

<%@page import="dto.OrderDTO"%>
<%@page import="model.order.OrderDAOImpl"%>
<%@page import="dto.OrderDetailDTO"%>
<%@page import="model.orderDetail.OrderDetailDAOImpl"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int orderId = Integer.parseInt(request.getParameter("orderId"));%>
        <%  OrderDTO order = new OrderDAOImpl().get(orderId); %>
        <% List<OrderDetailDTO> orderDetail = new OrderDetailDAOImpl().get(orderId);%>
        <span><%=orderId%></span>
        
        
    </body>
</html>
