/*
a)	Todas las opciones de los jugadores tengan una altura de 120px,  una posición relativa y una posición left:0px y top:0px;
b)	Se modifique el color de fondo de PLAYER1.
c)	Se oculte el botón, los mensajes de ganador y las opciones del jugador de la derecha.  Quedará una imagen como la mostrada a continuación
d)	Cuando el ratón se sitúe sobre una de las opciones, ésta se ha de animar hasta llegar a un tamaño de 140x140px , mientras el resto se ha de animar para conseguir un tamaño de 100x100px.
 Nota: Aprovecha el selector $(this) para hacer referencia a la opción con el ratón encima, detener la animación en curso con .stop() y animarlo correctamente.
 El efecto ha de ser algo parecido a esto:

*/
$("#fight").on('click', function(){
    $("img").css({"height":"120px", "position":"relative", "left":"0px", "top":"0px"});
    $("#jugador1").css("background-color", "green");
    $("#jugador2").hide();
});

$("#jugador1 img").hover(function(){
    $(this).css({"height":"140px", "wifth":"140px"});
});
