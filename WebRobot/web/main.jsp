<%-- 
    Document   : main
    Created on : 07-may-2013, 19:34:19
    Author     : Adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuari" class="beans.Usuari" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="js/robotAjax.js"></script>
        <title>Controlador del robot</title>
    </head>
    <body>
        <h1>Controlador robot</h1>
        
        <div>
            <button class="btn primary" onmousedown="enviarOrdre('endavant');" onmouseup="enviarOrdre('parar');">Endavant</button>
        </div>
        <div>
            <button class="btn primary" onmousedown="enviarOrdre('esquerra');" onmouseup="enviarOrdre('parar');">Esquerra</button>
            <button class="btn primary" onmousedown="enviarOrdre('enrrere');" onmouseup="enviarOrdre('parar');">Enrrere</button>
            <button class="btn primary" onmousedown="enviarOrdre('dreta');" onmouseup="enviarOrdre('parar');">Dreta</button>
        </div>
        
        <form action="ServletUsuari" method="post">
            <input type="hidden" name="tipus" value="logout"/>
            <button class="btn primary" onmousedown="enviarOrdre('tancarConnexio')" type="submit">Tancar sessió</button>
        </form>
    </body>
</html>
