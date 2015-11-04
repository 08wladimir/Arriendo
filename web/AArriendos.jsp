<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="MasterPages/Script.jsp" %>
        <title>Arriendos</title>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#arriendoTabla').jtable({
                    title: 'Crup Arriendos',
                    actions: {
                        listAction: 'ArriendoController?action=list',
                        createAction: 'ArriendoController?action=create',
                        updateAction: 'ArriendoController?action=update',
                        deleteAction: 'ArriendoController?action=delete'
                    },
                    fields: {
                        IdArriendo: {
                            title: 'Id Arriendo',
                            key: true,
                            list: true,
                            create: true
                        },
                        FechaIngreso: {
                            title: 'Fecha',
                            width: '10%',
                            edit: true
                        },
                        PermanenciaMinima: {
                            title: 'Permanencia Minima',
                            width: '10%',
                            edit: true
                        },
                        PorcentajeInteresMora: {
                            title: 'Interes Mora',
                            width: '10%',
                            edit: true
                        },
                        Renta: {
                            title: 'Renta',
                            width: '13%',
                            edit: true
                        },
                        DiaCorte: {
                            title: 'Dia Corte',
                            width: '10%',
                            edit: true
                        },
                        IdInquilino: {
                            title: 'Id Inquilino',
                            width: '10%',
                            edit: true
                        },
                        IdCasa: {
                            title: 'Id Casa',
                            width: '10%',
                            edit: true
                        },
                        Estado: {
                            title: 'Estado',
                            width: '10%',
                            edit: true
                        }
                      
                    }
                });
                $('#arriendoTabla').jtable('load');
            });
        </script>

    </head>
    <body background ="http://www.csd.cl/fondo%20gris.jpg">
        <header>
            <center><img src="Imagenes/Header2.png"></center>
            <%@include file="MasterPages/HearderAdm.jsp"%>
        </header>
        <div style="width:90%;margin-right:5%;margin-left:5%;text-align:center;">
            <h1>Arriendos</h1>
            <div id="arriendoTabla"></div>
            <br><br><br><br><br>
        </div>

        <%@include file="MasterPages/Footer.jsp"%>
        <br><br>

    </body>
</html>