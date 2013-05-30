<%-- 
    Document   : index
    Created on : 07-may-2013, 17:11:11
    Author     : Adria
--%>

<%@page import="beans.Usuari"%>
<jsp:useBean id="usuari" class="beans.Usuari" scope="request"></jsp:useBean>
<%
    if (usuari.getNom() == null && usuari.getContrasenya() == null) {
        usuari.setNom("");
        usuari.setContrasenya("");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="foundation-4.1.6/css/foundation.css"/>
        <link rel="stylesheet" type="text/css" href="foundation-4.1.6/css/normalize.css"/>
        <script src="foundation-4.1.6/js/vendor/custom.modernizr.js"></script>
        <script>
            document.write('<script src=foundation-4.1.6/js/vendor/'
                    + ('__proto__' in {} ? 'zepto' : 'jquery')
                    + '.js><\/script>');
        </script>
        <script src="foundation-4.1.6/js/foundation/foundation.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.alerts.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.clearing.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.cookie.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.dropdown.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.forms.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.joyride.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.magellan.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.orbit.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.placeholder.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.reveal.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.section.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.tooltips.js"></script>
        <script src="foundation-4.1.6/js/foundation/foundation.topbar.js"></script>
        <title>Login</title>

    </head>
    <body>
        <div class="row">
            <div class="large-12 large-centered column">
                <nav class="top-bar">
                    <ul class="title-area">
                        <li class="name">
                            <h1><a href="#">Robot LEGO NXT</a></h1>
                        </li>
                    </ul>
<!--                    <section class="top-bar-section">
                        <ul class="left">
                            <li class="divider"></li>
                            <li class="active">
                                <a href="#" data-reveal-id="fotos">Imatges</a>
                            </li>
                        </ul>
                        <ul class="right">
                            <li class="divider"></li>
                        </ul>
                    </section>-->
                </nav>               
            </div>
        </div>

        <div class="row">
            <div class="small-4 small-centered columns">
                <div class="panel">
                    <h2>Login</h2>
                    <form action="ServletUsuari" method="post" class="custom">
                        <div class="row">
                            <div class="large-12 columns">
                                <input type="text" name="nom" value="<jsp:getProperty name="usuari" property="nom"/>" placeholder="Usuari">
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 columns">
                                <input type="password" name="password" value="<jsp:getProperty name="usuari" property="contrasenya"/>" placeholder="Contrasenya">
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 columns">
                                <select id="dropdown" name="control" class="medium">
                                    <option value="fletxes">Moviment per fletxes</option>
                                    <option value="ratoli">Moviment per ratolí</option>
                                    <option value="mobil">Moviment per mòbil</option>
                                </select>
                            </div>
                        </div>
                        <input type="hidden" name="tipus" value="login"/>
                        <div class="row">
                            <div class="large-12 columns">
                                <button class="small button expand" type="submit">Enviar</button>
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="large-12 columns">
                            <button class="small button expand" onclick="window.location.href = 'register.jsp';">Registrar-se</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


<!--        <div id="fotos" class="reveal-modal">
            <h2>Fotos dels robots</h2>
            <div class='orbit-container'>
                <ul data-orbit='' class='orbit-slides-container'>
                    <li>
                        <img src="imgs/dreta.png" />
                        <div class="orbit-caption">Robot base cargándose</div>
                    </li>
                    <li>
                        <img src="imgs/Foto 29-05-13 17 28 29.jpg" />
                        <div class="orbit-caption">Prueba de tiro al ladrillo</div>
                    </li>
                </ul>
            </div>
            <a class="close-reveal-modal">&#215;</a>
        </div>-->
        
        <%
            if (request.getAttribute("nomUsuariIncorrecte") != null) {
        %>
        <script>
            alert("L'usuari introduït no existeix");
        </script>
        <%        } else if (request.getAttribute("passwordIncorrecte") != null) {
        %>
        <script>
            alert("La contrasenya introduida no es correcte");
        </script>
        <%        } else if (request.getAttribute("robotOcupat") != null) {
        %>
        <script>
            alert("El robot està ocupat en aquests moments");
        </script>
        <%        } else if (request.getAttribute("usuariCreat") != null) {
        %>
        <script>
            alert("Usuari creat");
        </script>
        <%            }
        %>

        <script>
            $(function() {
                $(document).foundation();
            });
        </script>
    </body>
</html>
