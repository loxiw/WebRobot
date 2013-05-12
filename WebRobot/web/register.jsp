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
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <script src="bootstrap/js/bootstrap.js"></script>
        <title>Registre</title>
    </head>
    <body>
        
    <div class="container">
            <div class="content">
                <div class="row">
                    <div class="login-form">
                        <h2>Registrar-se</h2>
                        
                        <form action="ServletUsuari" method="post">
                        <fieldset>    
                                <div class="clearfix">
                                    <input type="text" name="nom" placeholder="Usuari">
                                </div>
                                <div class="clearfix">
                                    <input type="password" name="password" placeholder="Contrasenya">
                                </div>
                                <input type="hidden" name="tipus" value="registre"/>
                                <button class="btn primary" type="submit">Enviar</button>
                          </fieldset>
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
    </body>
</html>
