function controladorTeclaApretada (evnt) {
   var ev = (evnt) ? evnt : event;
   var eventType = evnt.type;
   var keyCode=(ev.which) ? ev.which : event.keyCode;
   
   switch (keyCode) {
       case 87 : 
           eventType === "keydown" ? enviarOrdre('endavant') : enviarOrdre('parar') ;
           break;
       case 68 :
           eventType === "keydown" ? enviarOrdre('esquerra') : enviarOrdre('parar') ;
           break;
       case 65 :
           eventType === "keydown" ? enviarOrdre('dreta') : enviarOrdre('parar') ;
           break;
       case 83 :   
           eventType === "keydown" ? enviarOrdre('enrere') : enviarOrdre('parar') ;
           break;
   }
   
}
if (window.document.addEventListener) {
   window.document.addEventListener("keydown", callkeydownhandler, false);
} else {
   window.document.attachEvent("onkeydown", callkeydownhandler);
}
