<%-- 
    Document   : register
    Created on : 13/05/2021, 02:52:47 AM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="css/register.css"/>
        <link rel="stylesheet" href="css/common.css"/>
        <link rel="stylesheet"  href="css/map.css" >
    </head>
    <body>
        <div class="card content-register">
            <%String message = (String) session.getAttribute("message");%>
            <img src="./assets/logo.png" alt="">
            <hr>
            <form method="POST" action="../Login?action=register">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="name">Nombre</label>
                                <input id="name" class="form-control" type="text" name="name"/>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Apellidos</label>
                                <input id="lastName" class="form-control" type="text" name="lastName"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Correo electrónico</label>
                                <input id="email" class="form-control" type="email" name="email"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Contraseña</label>
                                <input id="password" class="form-control" maxlength="6" type="password" name="password"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="address">Dirección</label>
                                <input id="address" class="form-control" type="text" name="address"/>
                            </div>
                            <div class="form-group">
                                <label for="reference">Referencia</label>
                                <input id="reference" class="form-control" type="text" name="reference"/>
                            </div>
                            <input id="latitude" class="form-control" type="hidden" name="latitude"/>
                            <input id="longitude" class="form-control" type="hidden" name="longitude"/>
                            <div class="form-group">
                                <div id="map"></div>
                            </div>
                        </div>
                        <input class="btn btn-primary btn-block" type="submit" value="Registrar">
                        <% if (message != null) {%>
                        <br>
                        <label class="text-danger"> ${message} </label>
                        <%
                                session.removeAttribute("message");
                            }%>     
                    </div>
                </div>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOAAHVDvmTffo2K5ojmW_m42n4paYtrL0&callback=initMap">
        </script>
        <script>

            function initMap() {
                document.getElementById("latitude").value = -12.049163;
                document.getElementById("longitude").value = -76.967201;

                var map = new google.maps.Map(document.getElementById("map"), {
                    center: {lat: -12.049163, lng: -76.967201},
                    zoom: 14,
                    disableDefaultUI: true,
                });

                var marker = new google.maps.Marker({
                    position: {lat: -12.049163, lng: -76.967201},
                    icon: 'assets/home.png',
                    map,
                    draggable: true
                });

                google.maps.event.addListener(marker, 'dragend', function (event) {
                    document.getElementById("latitude").value = event.latLng.lat();
                    document.getElementById("longitude").value = event.latLng.lng();
                });
            }



        </script>
    </body>
</html>
