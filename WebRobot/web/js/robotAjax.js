/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function enviarOrdre (ordre) {
    request = newRequest();
    request.open("GET", "ServletMovimentRobot?ordre="+ordre);
    request.send();
}

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