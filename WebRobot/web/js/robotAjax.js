/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function enviarOrdre (id) {
    request = newRequest();
    request.open("GET", "ServletMovimentRobot?accio="+id);
    request.send();
}

function newRequest () {
    if (window.XMLHttpRequest)
        {
            return (new XMLHttpRequest());
        } else {
            return (new ActiveXObject("Microsoft.XMLHTTP"));
   
    }
}