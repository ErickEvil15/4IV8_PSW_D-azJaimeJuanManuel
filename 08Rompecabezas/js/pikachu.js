

var piezas = document.getElementsByClassName('movil');

var tamWitdh= [134,192,134,163,134,163,134,192,134];
var tamHeigth= [163,134,163,134,192,134,163,134];

//asignarlos a las piezas
for(var i=0; i < piezas.length; i++ ){

    piezas [i].setAttribute('width', tamWitdh);
    piezas [i].setAttribute('height', tamHeigth);
    piezas[i].setAttribute("x", Math.floor((Math.random()*10)+i));
    piezas[i].setAttribute("x", Math.floor((Math.random()*400)+i));
    piezas[i].setAttribute("onmousedown", "seleccionarElemento(evt)");

}
    
var elementSelect=0;
var currentX= 0;
var currentY= 0;
var currentPosX= 0;
var currentPosY= 0;

function seleccionar(evt){
    elementSelect = reordenar(evt);
    currentX = evt.clienteX;
    currentY = evt.clienteY;
    currentPosX = parseFloat(elementSelect.getAttribute('x'));
    currentPosX = parseFloat(elementSelect.getAttribute('y'));
    elementSelect.setAttribute("onmousemove","moverElemento(evt)");

}

function moverElemento(evt){

    var dx = evt.clienteX - currentX;
    var dy = evt.clienteY - currentY;

    currentPosX = currentPosX + dx;
    currentPosY = currentPosY + dy;

    elementSelect.setAttribute("x", currrentPosX);
    elementSelect.setAttribute("y", currrentPosY);

    currentX = evt.clienteX;
    currentY = evt.clienteY;

    elementSelect.setAttribute("onmouseout", "desseleccionarElemento(evt)");
    elementSelect.setAttribute("onmouseup", "desseleccionarElemento(evt)");
    iman();
}

function desseleccionarElemento(evt){
    //saber si ya estaen donde debe estar la pieza
    if(elementSelect != 0){
        elementSelect.removeAttribute("onmousemove");
        elementSelect.removeAttribute("onmouseout");
        elementSelect.removeAttribute("onmouseup");
        elementSelect=0;
    }
}

var entorno = document.getElementById('entrno');

function reordenar(evt){
    var padre = evt.target.parentNode;
    var clone = padre.CloneNode(true);
    var id = padre.getAttribute("id");

    entorno.removeChild(document.getElementById("id"));
    return entorno.lastChild.firstChild;

}

var origX= [200, 304, 466, 200, 333, 437, 200, 304, 466];
var origY= [100,100,100,233,204,233,337,336,337];

function iman(){
    for(i = 0; i < piezas.length; i++){
        if(Math.abs(currentPosX-origX[i])  < 15 
        && Math.abs(currentPosY-origY[i])  < 15){
            elementSelect.setAttribute("x", origX[i]);
            elementSelect.setAttribute("y", origY[i]);
        } 
    }
}

var win = document.getElementById("win");

function testing(){
    var bien_ubicada = 0;
    var padres = document.getElementsByClassName("padre");
    for(var i = 0; i < piezas.length; i++){
        var posx = parseFloat(padres[i].firstChild.getAttribute("x"));
        var posy = parseFloat(padres[i].firstChild.getAttribute("y"));

        var ide = padres[i].getAttribute("id");
        if(origX[ide]== posx && origY[ide]== posy){
            bien_ubicada = bien_ubicada + 1;
        }
    }
    if(bien_ubicada)
}