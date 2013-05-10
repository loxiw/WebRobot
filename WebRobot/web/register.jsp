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
        <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
        <title>Registre</title>
    </head>
    <body>
    <center><h2>Login</h2></center>
        <div class="container">
            <div class="row">
                <div class="span4 offset3">    
                    <form class="form-horizontal">
                        <div class="control-group">
                            
                            <label class="control-label" for="nom">Nom</label>
                            <div class="controls">
                                <input type="text" id="inputNom" placeholder="nom">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Contrasenya
                            </label>
                            <div class="controls">
                                <input type="password" id="inputPassword" placeholder="Password">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn">Enviar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
