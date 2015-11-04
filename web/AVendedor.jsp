<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="MasterPages/Script.jsp" %>
        <title>Administrador</title>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#personasTabla').jtable({
                    title: 'Crup Vendedor',
                    useBootstrap: true,
                    actions: {
                        listAction: 'PersonaController?action=vendedor',
                        createAction: 'PersonaController?action=create',
                        updateAction: 'PersonaController?action=update',
                        deleteAction: 'PersonaController?action=delete'
                    },
                    fields: {
                        Identificacion: {
                            title: 'Id',
                            key: true,
                            list: true,
                            create: true
                        },
                        Nombre: {
                            title: 'Nombre',
                            width: '10%',
                            edit: true
                        },
                        Apellido: {
                            title: 'Apellido',
                            width: '10%',
                            edit: true
                        },
                        Celular: {
                            title: 'Celular',
                            width: '10%',
                            edit: true
                        },
                        Telefono: {
                            title: 'Telefono',
                            width: '13%',
                            edit: true
                        },
                        Correo: {
                            title: 'Correo',
                            width: '10%',
                            edit: true
                        },
                        Usuario: {
                            title: 'Usuario',
                            width: '10%',
                            edit: true
                        },
                        Contrasena: {
                            title: 'Contrasena',
                            width: '10%',
                            edit: true
                        },
                        Rol: {
                            title: 'Rol',
                            width: '10%',
                            edit: false
                        }

                    }
                });
                $('#personasTabla').jtable('load');
            });
        </script>

    </head>
    <body background ="http://www.csd.cl/fondo%20gris.jpg">
        <header>
            <center><img src="Imagenes/Header2.png"></center>
            <%@include file="MasterPages/HearderAdm.jsp"%>
        </header>
        <div style="width:90%;margin-right:5%;margin-left:5%;text-align:center;">
            <h1>Vendedores</h1>
            <div  id="personasTabla"></div>
            <br><br><br><br>
        </div>
        
        <%@include file="MasterPages/Footer.jsp"%>
        <br><br>

    </body>
</html>