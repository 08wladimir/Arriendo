<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="MasterPages/Script.jsp" %>
        <link rel="stylesheet" href="CSS/Tabla.css">
        <title>Servlet PagoEnLinea</title>
    </head>

    <body background ="http://www.csd.cl/fondo%20gris.jpg">
        <header>
            <center><img src="Imagenes/Header2.png"></center>
                <%@include file="MasterPages/HearderPagos.jsp"%>
            
            <h1>Servlet PagoEnLinea at </h1>
            <h2>Su pago se a hecho efectivo </h2>
            <h2>Valor: $ 1'000.000 </h2>
            
           
        </header>

        <%@include file="MasterPages/Footer.jsp"%>
        <br><br>

    </body>
</html>

