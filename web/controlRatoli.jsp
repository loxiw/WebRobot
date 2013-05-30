<%-- 
    Document   : controlRatoli
    Created on : 23-may-2013, 19:09:45
    Author     : Adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 95%">
    <head>
        <title></title>
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
        <script src="js/controlRatoli.js"></script>
        <script src="js/robotAjax.js"></script>
    </head>
    <body onload="obtindreResolucio();" onbeforeunload="tancarSessio();" onmousewheel="canviarSentit();" style="height: 95%">
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
                            <li class="active">
                                <a href="ServletUsuari?tipus=logout" onclick="enviarOrdre('tancarConnexio');">Tancar sessió</a>
                            </li>
                        </ul>
                        <ul class="left">
                            <li class="active">
                                <a href="#" data-reveal-id='instruccions'>Instruccions</a>
                            </li>
                        </ul>
                    </section>
                </nav>               
            </div>
        </div>
        <div class="panel" style="height: 95%">
            <div class="row" id="controlador" style="height: 100%" onmousemove="processarGir(event);" onmousedown="moure();" onmouseup="parar();">
                <div class="large-12" style="height: 100%">
                
<!--                    <form action="#">
                        <input type="text" id="x">
                        <input type="text" id="y">
                    </form>-->
                    <div class="row" style='height: 100%'>
                        <div class="small-1 small-offset-6" style="background-color: black; width: 1pt; height: 100%">&nbsp;</div>
                    </div>
                </div>
            </div>
        </div>
        <!--<button class="btn primary" onmousedown="canviarSentit();" type="submit">Canviar de sentit</button>-->
        <div id="instruccions" class="reveal-modal small">
            <ul class="square">
                <li>Moure: Clic apretat</li>
                <li>Aturar: Deixar de clicar</li>
                <li>Canvi de sentit: Scroll amb la rodeta del ratolí</li>
                <li>Direcció: Depenent de la posició del ratolí sobre l'eix de les X</li>
            </ul>
            
            <a class="close-reveal-modal">&#215;</a>
        </div>
        <script>
            $(function() {
                $(document).foundation();
            });
        </script>
    </body>
</html>