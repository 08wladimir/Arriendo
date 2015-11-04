
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@include file="MasterPages/Script.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset = utf-8">
        <script type="text/javascript">
            $(document).ready(function () {
                $('#personasTabla').jtable({
                    title: 'Table de Personas',
                    actions: {
                        listAction: 'PersonaController?action=list',
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
    <body>
        <div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
            <h1>Wladimir</h1>
            <div id="personasTabla"></div>
        </div>
    </body>
</html>