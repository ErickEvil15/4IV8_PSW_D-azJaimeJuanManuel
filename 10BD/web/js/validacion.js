
function validar(formulario){

    //Validar nombre
    if(formulario.nombre.value.length < 5){
        alert("Escriba por lo menos 5 Caracteres para el nombre");
        formulario.nombre.focus();
        return false;
    }

    if (formulario.nombre.value.trim() == ""){
        alert("Debe ingresar un valor en el campo nombre");
        return false;
    }

    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm"+" ";

    var checkStr = formulario.nombre.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo de nombre");
        formulario.nombre.focus();
        return false;
    }

    //validar apellido paterno

    if(formulario.appat.value.length < 2){
        alert("Escriba por lo menos 2 Caracteres para el apellido");
        formulario.appat.focus();
        return false;
    }

    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = formulario.appat.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo de apellido");
        formulario.appat.focus();
        return false;
    }

    //validar apellido materno

    if(formulario.apmat.value.length < 2){
        alert("Escriba por lo menos 2 Caracteres para el apellido");
        formulario.apmat.focus();
        return false;
    }

    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = formulario.apmat.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo de apellido");
        formulario.apmat.focus();
        return false;
    }

    //validar boleta
    var checkOK = "0123456789";
    if (formulario.boleta.value.trim() == ""){
    alert("Debe ingresar un valor en el campo boleta");
        return false
    }
    var checkStr = formulario.boleta.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente numeros en el campo de boleta y mayores a los ya existentes");
        formulario.boleta.focus();
        return false;
    }

    //validar telefono
    var checkOK = "0123456789";

    var checkStr = formulario.telefono.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente numeros en el campo de telefono");
        formulario.telefono.focus();
        return false;
    }
}

function validar2(elimina){

    //validar boleta
    var checkOK = "0123456789";
    if (elimina.boletaelimina.value.trim() == ""){
    alert("Debe ingresar un valor en el campo boleta");
        return false
    }
    var checkStr = elimina.boletaelimina.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }
    
    if(!allValido){
        alert("Escriba unicamente numeros en el campo de boleta");
        actualizar.boleta.focus();
        return false;
    }
}

function validar3(actualizar){

    //validar boleta
    var checkOK = "0123456789";
    if (actualizar.boleta.value.trim() == ""){
    alert("Debe ingresar un valor en el campo boleta");
        return false
    }
    var checkStr = actualizar.boleta.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente numeros en el campo de boleta");
        actualizar.boleta.focus();
        return false;
    }

    //Validar nombre
    if(actualizar.nombre.value.length < 5){
        alert("Escriba por lo menos 5 Caracteres para el nombre");
        actualizar.nombre.focus();
        return false;
    }

    if (actualizar.nombre.value.trim() == ""){
        alert("Debe ingresar un valor en el campo nombre");
        return false;
    }

    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm"+" ";

    var checkStr = actualizar.nombre.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo de nombre");
        actualizar.nombre.focus();
        return false;
    }

    //validar apellido paterno

    if(actualizar.appat.value.length < 2){
        alert("Escriba por lo menos 2 Caracteres para el apellido");
        actualizar.appat.focus();
        return false;
    }

    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = actualizar.appat.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo de apellido");
        actualizar.appat.focus();
        return false;
    }

    //validar apellido materno

    if(actualizar.apmat.value.length < 2){
        alert("Escriba por lo menos 2 Caracteres para el apellido");
        actualizar.apmat.focus();
        return false;
    }

    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = actualizar.apmat.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo de apellido");
        actualizar.apmat.focus();
        return false;
    }

    //validar telefono
    var checkOK = "0123456789";

    var checkStr = actualizar.telefono.value;

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente numeros en el campo de telefono");
        actualizar.telefono.focus();
        return false;
    }
}