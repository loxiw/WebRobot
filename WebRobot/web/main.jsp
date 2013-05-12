<%-- 
    Document   : main
    Created on : 07-may-2013, 19:34:19
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="ServletUsuari" method="post">
            <input type="hidden" name="tipus" value="logout"/>
            <button class="btn primary" type="submit">Tancar sessió</button>
        </form>
        
    </body>
</html>
