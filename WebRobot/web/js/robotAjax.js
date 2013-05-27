/* 
 * Controlador d'Ajax
 */

/**
 * Envia una ordre al robot
 * @param ordre per al robot
 */
function enviarOrdre (ordre) {
    request = newRequest();
    request.open("GET", "ServletMovimentRobot?ordre="+ordre);
    request.send();
}

/**
 * Tanca la sessió de l'usuari
 */
function tancarSessio () {
    request = newRequest();
    request.open("GET", "ServletUsuari?tipus=logout");
    request.send();
}

function newRequest () {
    if (window.XMLHttpRequest) {
            return (new XMLHttpRequest());
        } else {
            return (new ActiveXObject("Microsoft.XMLHTTP"));
    }
}