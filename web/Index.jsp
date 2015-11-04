<%@page contentType="text/html" pageEncoding="UTF-8" import="Tablas.*" import="Utility.*" import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Arrendamientos</title>
        <meta charset = "utf-8">
        <link rel="stylesheet" href="CSS/Styles.css">
    </head>
    <body background ="http://www.csd.cl/fondo%20gris.jpg">

        <form action="Index.jsp" method="post">
            <div ALIGN="RIGHT" valign="top" class="margenLogin"> 
                <table border="0">
                    <thead>
                        <tr>
                            <td>User:</td>
                            <td>Pass:</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                    <div id="cajas">
                        <td><input type="text" name="usua" Usuario ="Usuario"></td>
                        <td><input type="password" name="contra" Password ="Contraseña"></td>
                    </div>
                    </tr>
                    <tr>
                    <div id="button">
                        <td></td>
                        <td><input type="submit" name="login" target="_blank" value="Ingresar" class="btn"/></td>
                    </div>
                    </tr>
                    </tbody>
                </table>
            </div>
        </form>
        <div class="margenIndex">
            <%@include file="MasterPages/HeaderPrincipal.jsp"%>
        </div>
        
        <div>
            <p>
                
            </p>
        </div>
        
        
        <%@include file="MasterPages/Footer.jsp" %>
        <br><br><br>
        
        <%
            if (request.getParameter("login") != null) {
                Conexion con = new Conexion();
                Connection cn = con.Conexion();

                String usuario = (request.getParameter("usua"));
                String contraseña = (request.getParameter("contra"));

                Personas persona = new Personas();
                String rol = persona.Login(cn, usuario, contraseña);

                response.sendRedirect(rol + ".jsp");

            };

        %>
        
        <%  
            Conexion con = new Conexion();
            Connection cn = Conexion.Conexion();

            String dato = request.getParameter("usua");
            String datofinal = con.entrada(dato);

            session.setAttribute("usua", datofinal);


        %>
        
    </body>
</html>
