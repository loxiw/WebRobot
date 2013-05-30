<%-- 
    Document   : register
    Created on : 07-may-2013, 19:59:13
    Author     : Adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="foundation-4.1.6/css/foundation.css"/>
        <link rel="stylesheet" type="text/css" href="foundation-4.1.6/css/normalize.css"/>
        <script src="foundation-4.1.6/js/vendor/custom.modernizr.js"></script>
        <script>
            document.write('<script src=foundation-4.1.6/js/vendor/'
                    + ('__proto__' in {} ? 'zepto' : 'jquery')
                    + '.js><\/script>');
        </script>
        <script src="foundation-4.1.6/js/foundation/foundation.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.alerts.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.clearing.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.cookie.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.dropdown.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.forms.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.joyride.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.magellan.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.orbit.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.placeholder.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.reveal.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.section.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.tooltips.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.topbar.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <title>Registre</title>
    </head>
    <body>
        <div class="row">
            <div class="large-12 large-centered column">
                <nav class="top-bar">
                    <ul class="title-area">
                        <li class="name">
                            <h1><a href="#">Robot LEGO NXT</a></h1>
                        </li>
                    </ul>
                    <section class="top-bar-section">
                        <ul class="right">
                            <li class="divider"></li>
                            <li class="active">
                                <a href="index.jsp">Tornar</a>
                            </li>
                        </ul>
                        <ul class="right">
                            <li class="divider"></li>
                        </ul>
                    </section>
                </nav>               
            </div>
        </div>
        <div class="row">
            <div class="small-4 small-centered columns">
                <div class="panel">
                    <h2>Registrar-se</h2>

                    <form action="ServletUsuari" method="post">
                        <div class="row">
                            <div class="large-12 columns">
                                <input type="text" name="nom" placeholder="Usuari">
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 columns">
                                <input type="password" name="password" placeholder="Contrasenya">
                            </div>    
                        </div>
                        <input type="hidden" name="tipus" value="registre"/>
                        <div class="row">
                            <div class="large-12 columns">
                                <button class="small button expand" type="submit">Enviar</button>
                            </div>
                        </div>
                    </form>  
                </div>
            </div>
        </div>
    </div>
    <%
        if (request.getAttribute("usuariExistent") != null) {
    %>
    <script>
            alert("Usuari ja existent");
    </script>
    <%            
        }
    %>
    <script>
        $(function() {
            $(document).foundation();
        });
    </script>
</body>
</html>
