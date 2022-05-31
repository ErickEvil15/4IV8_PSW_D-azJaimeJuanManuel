function validarl(e){
    var teclado = (document.all)? e.keyCode : e.which;
    if(teclado == 8) return true;
    var patron = /[0-9\d .]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function validarn(e){
    var teclado = (document.all)? e.keyCode : e.which;
    if(teclado == 8) return true;
    var patron = /[0-9\d .]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function validarLetras(palabra, campo){
    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm"+" ";

    var checkStr = palabra;
    
    if (checkStr == ""){
        alert("Debe ingresar un valor en el campo "+campo+":");
        document.getElementsByName("'"+campo+"'").focus();
        return false;
    }

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
        alert("Escriba unicamente letras en el campo "+campo+":");
        document.getElementsByName("'"+campo+"'").focus();
        return false;
    }
    return true;
}

function validarNumeros(numero, campo){
    var checkOk = "1234567890";
    var checkStr = numero;  

    if (checkStr == ""){
        alert("Debe ingresar un valor en el campo "+campo+":");
        document.getElementsByName("'"+campo+"'").focus();
        return false;
    }

    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOk.length; j++){
            if(ch == checkOk.charAt(j)){
                break;
            }
        }

        if(j == checkOk.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente números enteros en " + nombreCampo);
        return false;
    }
    return true;
}

function validarRegistro(){
    var lab = document.getElementsByName("laboratorio")[0].value.trim();
    //var id_lab = document.getElementsByName("idlab")[0].value.trim();
    //var id_re = document.getElementsByName("idre")[0].value.trim();
    var fecha = document.getElementsByName("fecha")[0].value.trim();
    var hora = document.getElementsByName("hora")[0].value.trim();
    var etiquta = document.getElementsByName("etiqueta")[0].value.trim();
    var serial = document.getElementsByName("serial")[0].value.trim();
    var cpu = document.getElementsByName("cpu")[0].value.trim();
    var marca = document.getElementsByName("marca")[0].value.trim();
    var monitor = document.getElementsByName("monitor")[0].value.trim();
    var accesorios = document.getElementsByName("accesoriosfal")[0].value.trim();
    var alumno = document.getElementsByName("alumno")[0].value.trim();
    var boleta = document.getElementsByName("boleta")[0].value.trim();
    var grupo = document.getElementsByName("grupo")[0].value.trim();
    var asignatura = document.getElementsByName("asignatura")[0].value.trim();
    var docente = document.getElementsByName("docente")[0].value.trim();

    alert("XD3");
    if(validarNumeros(lab, "laboratorio") == false){
        alert("XD");
        if(lab.length < 2 || lab.length > 5){
            alert("Debes ingresar una palabra entre 3 y 5 letras");
            document.getElementsByName("laboratorio").focus();
            return false;
        }
        alert("XD2");
        return false; 
    }
    
    else if(validarLetras(fecha, "fecha")){
        if(fecha.length < 2 || fecha.length > 5){
            alert("Debes ingresar una palabra entre 3 y 5 letras");
            document.getElementsByName("laboratorio").focus();
            return false;
        }
        return false;
    }
    else{
        alert("XD4");
        return false;
    }
}