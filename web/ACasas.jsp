<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="MasterPages/Script.jsp" %>
        <title>Administrador</title>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#casasTabla').jtable({
                    title: 'Crup Casas',
                    actions: {
                        listAction: 'CasaController?action=list',
                        createAction: 'CasaController?action=create',
                        updateAction: 'CasaController?action=update',
                        deleteAction: 'CasaController?action=delete'
                    },
                    fields: {
                        IdInmueble: {
                            title: 'S.NO',
                            key: true,
                            list: true,
                            create: false
                        },
                        Direccion: {
                            title: 'Dirección',
                            width: '10%',
                            edit: true
                        },
                        Barrio: {
                            title: 'Barrio',
                            width: '10%',
                            edit: true
                        },
                        NHabitaciones: {
                            title: '# Habitaciones',
                            width: '10%',
                            edit: true
                        },
                        NPisos: {
                            title: '# Pisos',
                            width: '10%',
                            edit: true
                        },
                        Estrato: {
                            title: 'Estrato',
                            width: '10%',
                            edit: true
                        },
                        ValorOfrecido: {
                            title: 'Valor ofrecido',
                            width: '10%',
                            edit: true
                        },
                        IdPersonaDueno: {
                            title: 'Dueño',
                            width: '10%',
                            edit: true
                        },
                        Foto: {
                            title: 'Foto',
                            width: '10%',
                            edit: false
                        },
                        Descripcion: {
                            title: 'Descripción',
                            width: '10%',
                            edit: true
                        }
                      
                    }
                });
                $('#casasTabla').jtable('load');
            });
        </script>

    </head>
    <body background ="http://www.csd.cl/fondo%20gris.jpg">
        <header>
            <center><img src="Imagenes/Header2.png"></center>
            <%@include file="MasterPages/HearderAdm.jsp"%>
        </header>
        <div style="width:90%;margin-right:5%;margin-left:5%;text-align:center;">
            <h1>Casa</h1>
            <div id="casasTabla"></div>
            <br><br><br><br>
        </div>
        
        <%@include file="MasterPages/Footer.jsp"%>
        <br><br>

    </body>
</html>