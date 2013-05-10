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
        <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
        <title>Login</title>
    </head>
    <body>

        <div class="container">
            <div class="content">
                <div class="row">
                    <div class="login-form">
                        <h2>Login</h2>
                        
                        <form action="ServletUsuari" method="post" name="login">
                        <fieldset>    
                                <div class="clearfix">
                                    <input type="text" placeholder="Usuari">
                                </div>
                                <div class="clearfix">
                                    <input type="password" placeholder="Contrasenya">
                                </div>
                            <span><button class="btn primary" type="submit">Enviar</button>
                          </fieldset>
                        </form>    
                                
                        
<button class="btn primary" onclick="window.location.href='registro.jsp'">Registrar</button></span>
                        
                        
                            
                            
                        
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="container">  
            <div class="row">  
                <div class="span4">  
                    <div class="alert">
                        <a class="close" data-dismiss="alert">×</a>
                        
  

        <%
            if (request.getAttribute("nomUsuariIncorrecte") != null) {
        %>
        <!-- CÓDIGO DE "USUARIO INEXISTENTE" -->
        <div class="container">  
            <div class="row">  
                <div class="span4">  
                    <div class="alert">
                        <a class="close" data-dismiss="alert">×</a>
                        <strong>Usuari no existeix</strong>
                        </div>  
</div>  
</div>  
</div>
          
                      
        <%        } else if (request.getAttribute("passwordIncorrecte") != null) {
        %>
        <!-- CÓDIGO DE "PASSWORD INCORRECTA" -->
        <%        } else if (request.getAttribute("usuariExistent") != null) {
        %>
        <!-- CÓDIGO DE "USUARI YA EXISTE" -->
        <%        } else if (request.getAttribute("usuariCreat") != null) {
        %>
        <!-- CÓDIGO DE "USUARI CREAT" -->
        <%            }
        %>
        
    </body>
</html>
