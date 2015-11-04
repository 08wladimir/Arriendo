
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
                $('#casasTabla').jtable({
                    title: 'Table de Casas',
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
    <body>
        <div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
            <h1>Wladimir</h1>
            <div id="casasTabla"></div>
        </div>
    </body>
</html>
