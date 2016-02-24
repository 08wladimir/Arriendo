<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="MasterPages/Script.jsp" %>
        <link rel="stylesheet" href="CSS/Tabla.css">
        <title>Pagos</title>
    </head>

    <body background ="http://www.csd.cl/fondo%20gris.jpg">
        <header>
            <center><img src="Imagenes/Header2.png"></center>
                <%@include file="MasterPages/HearderPagos.jsp"%>

            
            
            
            <form method="post"
            action="PagoEnLinea" target="_self"  class='contacto'>
            <input name="usuarioId" type="hidden" value="111111111">
            <input name="descripcion" type="hidden" value="Pago Arriendo" >
            <input name="refVenta" type="hidden" value="01234">
            <input name="moneda" type="hidden" value="COP">
            <input name="valor" type="hidden" value="1000000">
            <input name="prueba" type="hidden" value="1">
            

            
                <div><label>Nombre:</label><input type='text' name="nombre" value='' onKeyup="chequea(this, this.form.enviar)"></div>
                <div><label>Identificacion:</label><input type='text' name="identificacion" value='' onKeyup="chequea(this, this.form.enviar)"></div>
                <div><label>Correo electrónico:</label><input type='text' name="email" value='' onKeyup="chequea(this, this.form.enviar)"></div>
                <div><label>Tarjeta:</label>Credito: <INPUT type=radio name="tarjeta" value="C" onKeyup="chequea(this, this.form.enviar)"> 
                    <br> 
                    Debito: <INPUT type=radio name="tarjeta" value="D" onKeyup="chequea(this, this.form.enviar)">
                </div>
                <div><label>Numero Cuenta:</label><input type='text' name="numeroCuenta" value='' onKeyup="chequea(this, this.form.enviar)"></div>
                <div><label>Valor a Pagar:</label> <label>$ 1'000.000 </label> </div>
                
                <div><input type='submit' value='Pagar' name="enviar" disabled=true></div>
            </form>
            
            <script language="javascript" type="text/javascript">
                function chequea(campo, boton) {
                    if (campo.value != "") {
                        boton.disabled = false;
                    } else {
                        boton.disabled = true;
                    }
                }
            </script>


        </header>

        <%@include file="MasterPages/Footer.jsp"%>
        <br><br>

    </body>
</html>
