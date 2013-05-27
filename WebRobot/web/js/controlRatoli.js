/* 
 * Gestiona tots els events que ha d'enviar controlRatoli.jsp mitjançant el ratolí
 * per a controlar el robot
 */

var resolucioX;
var resolucioY;
var sentit = "endavant";
var ultimaDireccio;

/**
 * Envia l'ordre de posarse en moviment en el sentit que estigui assignat
 */
function moure () {
    enviarOrdre(sentit);
}

/**
 * Envia l'ordre de canviar el sentit 
 */
function canviarSentit () {
    sentit === "endavant" ? sentit = "enrere" : sentit = "endavant";
}

/**
 * Envia l'ordre d' aturar el robot
 */
function parar () {
    enviarOrdre("parar");
}

/**
 * Rep l'event de la crida i si es multiple de 5 envia l'ordre de fer un gir depenent
 * de la posició del ratolí
 * @param event Event de la crida
 */
function processarGir (event) {
    var x = Math.round((event.clientX*100)/resolucioX);
    var y = Math.round((event.clientY*100)/resolucioY);
    
    document.getElementById("x").value = x;
    document.getElementById("y").value = y;
    
    if (x%5 === 0 && x !== ultimaDireccio) {
        ultimaDireccio = x;
        enviarOrdre(x);
    }
}

/**
 * Obté la resolució del client
 */
function obtindreResolucio () {
    resolucioX = screen.width;
    resolucioY = screen.height;
}