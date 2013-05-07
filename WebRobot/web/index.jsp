<%-- 
    Document   : index
    Created on : 07-may-2013, 17:11:11
    Author     : Adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Robot</title>
    </head>
    <body>
        <h1>Introdueix el teu usuari i contrasenya</h1>
        <form action="../src/java/servlets/ServletLogin.jsp" method="post" name="login">
            <input type="text" name="nom" size="10">
            <input type="password" name="password" size="10">
            <input type="submit" name="enviar" value="Enviar">        
         </form>
    </body>
</html>
