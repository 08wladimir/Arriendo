

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Cotactenos</title>
        <meta charset = "utf-8">
        <link rel="stylesheet" href="CSS/Styles.css">
    </head>
    <body background ="http://www.csd.cl/fondo%20gris.jpg">
        <div class="margen">
            <%@include file="MasterPages/HeaderPrincipal.jsp"%>
        </div>

    <center>
        <script type="text/javascript">var servicedomain = "www.123contactform.com";
            var frmRef = '';
            try {
                frmRef = window.top.location.href;
            } catch (err) {
            }
            ;
            var cfJsHost = (("https:" == document.location.protocol) ? "https://" : "http://");
            document.write(unescape("%3Cscript src='" + cfJsHost + servicedomain + "/includes/easyXDM.min.js' type='text/javascript'%3E%3C/script%3E"));
            frmRef = encodeURIComponent(frmRef).replace('%26', '[%ANDCHAR%]');
            document.write(unescape("%3Cscript src='" + cfJsHost + servicedomain + "/jsform-1619138.js?ref=" + frmRef + "' type='text/javascript'%3E%3C/script%3E"));</script>
    </center>
    <%@include file="MasterPages/Footer.jsp" %>
</html>   
