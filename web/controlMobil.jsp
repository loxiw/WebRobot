<%-- 
    Document   : main
    Created on : 07-may-2013, 19:34:19
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
        <script src="js/robotAjax.js"></script>
        <script src="js/controlTecles.js"></script>
        <title>Controlador per mòbil</title>
    </head>
    <body onbeforeunload="tancarSessio();">
        <div class="row">
            <div class="large-12 large-centered column">
                <nav class="top-bar">
                    <ul class="title-area">
                        <li class="name">
                            <h1><a href="#">Robot LEGO NXT</a></h1>
                        </li>
                    </ul>
                    <section class="top-bar-section">
                        <ul class="left">
                            <li class="active">
                                <a href="#" data-reveal-id="instruccions">Instruccions</a>
                            </li>
                        </ul>
                        <ul class="right">
                            <li class="active">
                                <a href="ServletUsuari?tipus=logout" onclick="enviarOrdre('tancarConnexio');">Tancar sessió</a>
                            </li>
                        </ul>
                    </section>
                </nav>               
            </div>
        </div>
        <div class="row">
            <div class="small-4 small-centered columns">
                <div class="panel">
                    <h1>Control per mòbil</h1>
                    <center>
                        <div class="row">
                            <div class="large-12 large-centered">
                                <img src="imgs/endavant.png" onclick="enviarOrdre('endavant');"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 large-centered" style="padding-top: 5px;">
                                <img src="imgs/aturar.png" onclick="enviarOrdre('parar');"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12" style="padding-top: 5px;">
                                <img src="imgs/esquerra.png" onclick="enviarOrdre('esquerra');"/>
                                <img src="imgs/enrere.png" onmousedown="enviarOrdre('enrere');"/>
                                <img src="imgs/dreta.png" onmousedown="enviarOrdre('dreta');"/>
                            </div>
                        </div>
                    </center>
                </div>
            </div>
        </div>
        <div id="instruccions" class="reveal-modal small">
            <ul class="square">
                <li>Fletxa amunt: Endavant</li>
                <li>Botó aturar: Atura el robot</li>
                <li>Fletxa avall: Enrere</li>
                <li>Fletxa dreta: Girar sobre si mateix cap a la dreta</li>
                <li>Fletxa esquerra: Girar sobre si mateix cap a la esquerra</li>
            </ul>
            <a class="close-reveal-modal">&#215;</a>
        </div>
        </div>
        <script>
            $(function() {
                $(document).foundation();
            });
        </script>
    </body>
</html>
