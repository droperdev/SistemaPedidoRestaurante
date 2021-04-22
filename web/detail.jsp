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

    <body>
        <% int orderId = Integer.parseInt(request.getParameter("orderId"));%>
        <% OrderDTO order = new OrderDAOImpl().get(orderId);%>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div class="form-group">
                        <label>Cliente</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=order.getClient().getFullName()%>">
                    </div>
                    <div class="form-group">
                        <label>Dirección</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=order.getAddress().getAddress()%>">
                    </div>
                    <div class="form-group">
                        <label>Referencia</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=order.getAddress().getReference()%>">
                    </div>
                    <div class="form-group">
                        <label>Tipo de pago</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=order.getPaymentMethod().getName()%>">
                    </div>
                    <div class="form-group">
                        <label>Comprobante</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=order.getVoucher().getName()%>">
                    </div>
                    <div class="form-group">
                        <label>Tipo de pedido</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=order.getOrderType().getName()%>">
                    </div>
                </div> 
                <% Double sum = 0.0; %>
                <div class="col-md-7">
                    <% List<OrderDetailDTO> orderDetails = new OrderDetailDAOImpl().get(orderId);%>
                    <label>Productos</label>    
                    <div class="table-responsible">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Cantidad</th>
                                    <th>Producto</th>
                                    <th>Precio</th>
                                    <th>Monto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%! OrderDetailDTO orderDetail;%>
                                <% for (int i = 0; i < orderDetails.size(); i++) {%>
                                <% orderDetail = orderDetails.get(i);%>
                                <% sum = sum + (orderDetail.getQuantity() * orderDetail.getPrice());%>
                                <tr >
                                    <td class="align-middle"><%=orderDetail.getQuantity()%></td>
                                    <td class="align-middle">
                                        <%=orderDetail.getProduct().getName()%><br>
                                        <%=orderDetail.getProduct().getDescription()%>
                                    </td>
                                    <td class="align-middle">S/&nbsp;<%=String.format("%.2f", orderDetail.getPrice())%></td>
                                    <td class="align-middle">S/&nbsp;<%=String.format("%.2f", orderDetail.getQuantity() * orderDetail.getPrice())%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>

                    </div>
                    <div class="total">
                        Total S/&nbsp; <%=String.format("%.2f", sum)%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
