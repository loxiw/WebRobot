<%-- 
    Document   : main
    Created on : 07-may-2013, 19:34:19
    Author     : Adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuari" class="beans.Usuari" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html onload="//enviarOrdre('fletxes');">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="js/robotAjax.js"></script>
        <script src="js/controlTecles.js"></script>
        <title>Controlador del robot</title>
    </head>
    <body onkeydown="controladorTeclaApretada(event);" onkeyup="controladorTeclaApretada(event);" onbeforeunload="tancarSessio();">
        
        <div class="container">
            <div class="content">
                <fieldset>
                    <h1>Controlador robot</h1>

                    <center>
                        <div>
                        <!--<button class="btn primary" onmousedown="enviarOrdre('endavant');" onmouseup="enviarOrdre('parar');">Endavant</button>-->
                        <img src="imgs/endavant.png" onmousedown="enviarOrdre('endavant');" onmouseup="enviarOrdre('parar');"/>
                        </div>
                        <div style="padding-top: 5px;">
                            <!--<button class="btn primary" onmousedown="enviarOrdre('esquerra');" onmouseup="enviarOrdre('parar');">Esquerra</button>
                            <button class="btn primary" onmousedown="enviarOrdre('enrere');" onmouseup="enviarOrdre('parar');">Enrere</button>
                            <button class="btn primary" onmousedown="enviarOrdre('dreta');" onmouseup="enviarOrdre('parar');">Dreta</button>-->
                            <img src="imgs/esquerra.png" onmousedown="enviarOrdre('esquerra');" onmouseup="enviarOrdre('parar');"/>
                            <img src="imgs/enrere.png" onmousedown="enviarOrdre('enrere');" onmouseup="enviarOrdre('parar');"/>
                            <img src="imgs/dreta.png" onmousedown="enviarOrdre('dreta');" onmouseup="enviarOrdre('parar');"/>
                        </div>

                        <form style="padding-top: 10px" action="ServletUsuari" method="post">
                            <input type="hidden" name="tipus" value="logout"/>
                            <button class="btn primary" onclick="enviarOrdre('tancarConnexio');" type="submit">Tancar sessió</button>
                        </form>
                    </center>
                </fieldset>
            </div>
        </div>
    </body>
</html>
