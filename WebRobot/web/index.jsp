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
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <script src="bootstrap/js/bootstrap.js"></script>
        <title>Login</title>
    </head>
    <body>

        <div class="container">
            <div class="content">
                <div class="row">
                    <div class="login-form">
                        <h2>Login</h2>
                        <fieldset> 
                            <form action="ServletUsuari" method="post" name="login">
                                <div class="clearfix">
                                    <input type="text" name="nom" placeholder="Usuari">
                                </div>
                                <div class="clearfix">
                                    <input type="password" name="password" placeholder="Contrasenya">
                                </div>
                                <input type="hidden" name="tipus" value="login"/>
                                <button class="btn primary" type="submit">Enviar</button>
                            </form>
                            <button class="btn primary" onclick="window.location.href='register.jsp'">Registrar-se</button>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
        <%
            if (request.getAttribute("nomUsuariIncorrecte") != null) {
        %>
        <script>
            alert("L'usuari introduït no existeix");
        </script>
        <%        
            } else if (request.getAttribute("passwordIncorrecte") != null) {
        %>
        <script>
            alert("La contrasenya introduida no es correcte");
        </script>
        <%        
            } else if (request.getAttribute("robotOcupat") != null) {
        %>
        <script>
            alert("El robot està ocupat en aquests moments");
        </script>
        <%        
            } else if (request.getAttribute("usuariCreat") != null) {
        %>
        <script>
            alert("Usuari creat");
        </script>
        <%
            }
        %>
        
    </body>
</html>
