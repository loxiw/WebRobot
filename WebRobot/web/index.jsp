<%-- 
    Document   : index
    Created on : 07-may-2013, 17:11:11
    Author     : Adria
--%>

<%@page import="beans.Usuari"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuari" class="beans.Usuari" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Robot</title>
    </head>
    <body>
        <h1>Introdueix el teu usuari i contrasenya</h1>
        <form action="ServletUsuari" method="post">
            Nom:
            <input type="text" name="nom" value="<%= usuari.getNom() %>">
            Contrasenya:
            <input type="password" name="password" value="<%= usuari.getContrasenya() %> "></br>
            <input type="hidden" name="tipus" value="login">
            <input type="submit" value="Enviar"> 
        </form>
            
        <%
            if (request.getAttribute("nomUsuariIncorrecte") != null) {
        %>
            <!-- CÓDIGO DE "USUARIO INEXISTENTE" -->
            <div>No existeix cap usuari amb aquest nom</div>
        <%
            } else if (request.getAttribute("passwordIncorrecte") != null) {
        %>
            <!-- CÓDIGO DE "PASSWORD INCORRECTA" -->
            <div>La contrasenya introduida es incorrecte</div>
        <%
            }
        %>
        
        
    </body>
</html>
