
function problema1(){

    
    //Creamos las variables de ingreso y meses
    
    var ingreso = parseInt(document.getElementById('ingreso').value);

    var meses = parseInt(document.getElementById('meses').value);
    
    
    // Obtener la referencia del elemento section
    var body = document.getElementsByTagName("section")[0];

    // Crea un elemento <table> y un <tbody>
    var tabla   = document.createElement("table");
    var tblBody = document.createElement("tbody");
    
    // Creamos las celdas
    for (var i = 0; i < 1; i++) {
        // Crea las fila de la tabla
        var hilera = document.createElement("tr");

        for (var j = 0; j < 1; j++) {
        // Crea un elemento <td> y un nodo de texto, haz que el nodo de
        // texto sea el contenido de <td>, ubica el elemento <td> al final
        // de la hilera de la tabla
        var celda = document.createElement("td");
        var textoCelda = document.createTextNode("Ingreso");
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);

        var celda = document.createElement("td");
        var textoCelda = document.createTextNode("Meses");
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);

        var celda = document.createElement("td");
        var textoCelda = document.createTextNode("Ganancia");
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);

        var celda = document.createElement("td");
        var textoCelda = document.createTextNode("Total");
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);
        
        }


        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera);
    }
    var g = parseFloat(ingreso*0.02*meses+ingreso);
    var ganancia=g.toFixed(2);
    for (var i = 0; i < 1; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");
        
        
        for (var j = 0; j < 1; j++) {
            
        var celda = document.createElement("td");
        var textoCelda = document.createTextNode(ingreso);
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);

        var celda = document.createElement("td");
        var textoCelda = document.createTextNode(meses);
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);

        var celda = document.createElement("td");
        var textoCelda = document.createTextNode((ingreso*0.02)*meses);
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);

        var celda = document.createElement("td");
        var textoCelda = document.createTextNode(ganancia);
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);
        }
        tblBody.appendChild(hilera);
    }

    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(tabla);
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("border", "2");
    
}

function problema2(){
    
    //creamos variables 

    //sueldo
    var sueldoB = parseInt(document.getElementById('sueldoB').value);
    //venta 1
    var vent1 = parseInt(document.getElementById('vent1').value);
    //venta 2
    var vent2 = parseInt(document.getElementById('vent2').value);
    //venta 3
    var vent3 = parseInt(document.getElementById('vent3').value);
    //calcular comision
    var com = (vent1+vent2+vent3)*0.1;
    //usar los primeros 2 decimales de comision
    var comis = com.toFixed(2);
    //calcular el sueldo final
    var tot = com + sueldoB;
    //usar primeros 2 decimales de comision
    var total = tot.toFixed(2);

    //Regresamos los datos a la salida
    document.getElementById('p2-salida').textContent = 'Total de Ganancia en comisiones: $' + comis + '\n' + 'Total mensual: $' + total;
}

function problema3(){

    //crear variable precio
    var precio = parseInt(document.getElementById('precio').value);

    //calcular el descuento
    var descuento = precio*0.15;
    //usar primeros 2 decimales de descuento
    var desc = descuento.toFixed(2);

    //calcular el precio final
    var tot = precio-desc;

    //Regresamos los valores a la salida
    document.getElementById('p3-salida').textContent = 'El descuento es de $'+desc+ '\n' + 'El precio final del producto es de $'+tot;

}

function problema4(){

    //creamos variables de calificacion

    var c1 = parseInt(document.getElementById('c1').value);
    var c2 = parseInt(document.getElementById('c2').value);
    var c3 = parseInt(document.getElementById('c3').value);
    
    //variables de examen y trabajo final
    var exa = parseInt(document.getElementById('exa').value);

    var trbj = parseInt(document.getElementById('trbj').value);

    //calculamos porcentajes de calificaciones

    var cf = (((c1+c2+c3)/3)*55)/10;

    var exaF = (exa*30)/10;

    var trbjF = (trbj*15)/10;
    
    //Calificacion final total

    var cft = cf + exaF + trbjF;

    //damos solo 2 decimales a las variables

    var calif = cf.toFixed(2);
    var exam = exaF.toFixed(2);
    var trabaj = trbjF.toFixed(2);
    var cFinal = cft.toFixed(2)

    //Regresamos los valores a la salida

    document.getElementById('p4-salida').textContent =  'El porcentaje obtenido del promedio parcial es de ' + calif + '%' + '\n' + 
                                                        'El porcentaje obtenido del examen es de ' + exam + '%' + '\n' +
                                                        'El porcentaje obtenido del trabajo final es de ' + trabaj + '%' + '\n' +
                                                        'La calificacion final es de ' + cFinal;

}

function problema5(){


    //Creamos variables de alumnos

    var tAlumnos = parseInt(document.getElementById('tAlumnos').value);

    var aMujeres = parseInt(document.getElementById('aMujeres').value);

    var aHombres = parseInt(document.getElementById('aHombres').value);

    //Calculamos los porcentajes

    var pMujeres = aMujeres*100/tAlumnos;

    var pHombres = aHombres*100/tAlumnos;

    //Regresamos los valores a la salida

    document.getElementById('p5-salida').textContent =  'El total es de ' + tAlumnos + '\n' +
                                                        'Hay ' + aMujeres + ' mujeres y ocupan el ' + pMujeres + '% del salon' + '\n' +
                                                        'Hay ' + aHombres + ' hombres y ocupan el ' + pHombres + '% del salon' + '\n';                                             
    
}

function problema6(){

    //Creamos variables d anios

    var aNac = parseInt(document.getElementById('aNac').value);
    
    var act = parseInt(document.getElementById('act').value);

    //Calculamos la edad

    var edad = act-aNac;

    //Regresamos los valores a la salida

    document.getElementById('p6-salida').textContent = 'Tu edad actual es de ' + edad;
}