function validar(ingresarDatos){

    var checkOK = "1234567890";

    var checkStr = ingresarDatos.precio.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j)){
                break;
            }
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente numeros");
        ingresarDatos.precio.focus();
        return false;
    }

    var checkStr = ingresarDatos.cuotaIn.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j)){
                break;
            }
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente numeros");
        ingresarDatos.cuotaIn.focus();
        return false;
    }

}

if(allValido=true){

const form = document.getElementById('ingresarDatos');
form.addEventListener("submit", function(event) {
    event.preventDefault();
    let data  = new FormData(form);
    let tablaRef = document.getElementById('tablaAuto')
    let newRowRef = tablaRef.insertRow(-1);

    let filaRef = newRowRef.insertCell(0);
    filaRef.textContent= ingresarDatos.precio.value;
    
    filaRef = newRowRef.insertCell(1);
    filaRef.textContent= ingresarDatos.precio.value/ingresarDatos.cuotaIn.value;
    
    filaRef = newRowRef.insertCell(2);
    filaRef.textContent= ingresarDatos.periodo.value;
    
    filaRef = newRowRef.insertCell(3);
    filaRef.textContent= ingresarDatos.precio.value*0.0394;

    filaRef = newRowRef.insertCell(4);
    filaRef.textContent= (ingresarDatos.precio.value)*(1 + 0.0394)*(ingresarDatos.periodo.value);
    
})
}
