<%-- 
    Document   : controlRatoli
    Created on : 23-may-2013, 19:09:45
    Author     : Adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 97%">
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/controlRatoli.js"></script>
        <script src="js/robotAjax.js"></script>
    </head>
    <body onload="obtindreResolucio();" onbeforeunload="tancarSessio();" onmousewheel="canviarSentit();" style="height: 97%">
        <div onmousedown="moure();" onmouseup="parar();" onmousemove="processarGir(event);" style="width: 99%; height: 97%; border-style: solid">
            <form action="#">
                <label for="x">X: </label><input type="text" id="x">
                <label for="y">Y: </label><input type="text" id="y">
            </form>
            <div style="background-color: black; height: 97%; width: 1pt; margin-left: 50%;">
                
            </div>
        </div>
        <!--<button class="btn primary" onmousedown="canviarSentit();" type="submit">Canviar de sentit</button>-->
        <form action="ServletUsuari" method="post">
            <input type="hidden" name="tipus" value="logout"/>
            <button class="btn primary" onmousedown="enviarOrdre('tancarConnexio');" type="submit">Tancar sessió</button>
        </form>
    </body>
</html>