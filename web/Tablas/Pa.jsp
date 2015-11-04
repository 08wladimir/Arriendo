
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
                $('#pagosTabla').jtable({
                    title: 'Table de Pagos',
                    actions: {
                        listAction: 'PagosController?action=list',
                        createAction: 'PagosController?action=create',
                        updateAction: 'PagosController?action=update',
                        deleteAction: 'PagosController?action=delete'
                    },
                    fields: {
                        IdPago: {
                            title: 'Id Pago',
                            key: true,
                            list: true,
                            create: false
                        },
                        FechaPago: {
                            title: 'Fecha Pago',
                            width: '20%',
                            edit: true
                        },
                        ValorPagadoArriendo: {
                            title: 'Valor Pagado',
                            width: '20%',
                            edit: true
                        },
                        ValorInteres: {
                            title: 'ValorInteres',
                            width: '20%',
                            edit: true
                        },
                        IdArriendo: {
                            title: 'IdArriendo',
                            width: '20%',
                            edit: true
                        }
                    }
                });
                $('#pagosTabla').jtable('load');
            });
        </script>
    </head>
    <body>
        <div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
            <h1>Wladimir</h1>
            <div id="pagosTabla"></div>
        </div>
    </body>
</html>
