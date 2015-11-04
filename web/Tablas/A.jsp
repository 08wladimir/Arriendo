
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset = utf-8">
        <title>AJAX based CRUD operations using jTable in Servlet and JSP</title>
        <!-- Include one of jTable styles. -->
        <link href="CSS/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
        <link href="CSS/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <!-- Include jTable script file. -->
        <script src="js/jquery-1.8.2.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="js/jquery.jtable.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#arriendoTabla').jtable({
                    title: 'Table de Arriendo',
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
    <body>
        <div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
            <h1>Wladimir</h1>
            <div id="arriendoTabla"></div>
        </div>
    </body>
</html>