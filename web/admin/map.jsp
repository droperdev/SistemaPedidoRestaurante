<%-- 
    Document   : map
    Created on : 21/04/2021, 10:44:51 PM
    Author     : droperdev
--%>
<%@page import="model.order.OrderDAOImpl"%>
<%@page import="dto.OrderDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="css/map.css" >

    </head>
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
                </div> 
                <div class="col-md-7">
                    <div id="map"></div>
                </div>
            </div>
        </div>
        <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOAAHVDvmTffo2K5ojmW_m42n4paYtrL0&callback=initMap">
        </script>
        <script>
            var map;
            function initMap() {
                map = new google.maps.Map(document.getElementById("map"), {
                    center: {lat: <%=order.getAddress().getLatitude()%>, lng: <%=order.getAddress().getLongitude()%>},
                    zoom: 14,
                    disableDefaultUI: true,
                });

                new google.maps.Marker({
                    position: {lat: <%=order.getAddress().getLatitude()%>, lng: <%=order.getAddress().getLongitude()%>},
                    icon: 'assets/home.png',
                    map,
                    title: "<%=order.getAddress().getAddress()%>"
                });
            }


        </script>
    </body>
</html>
