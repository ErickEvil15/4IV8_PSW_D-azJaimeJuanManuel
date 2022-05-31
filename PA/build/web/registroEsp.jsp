<%-- 
    Document   : registroP
    Created on : 22-may-2022, 21:59:17
    Author     : dagra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro del Especialista</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="bg-dark text-secondary px-4 py-5 text-center">
    <h1>Registrarse</h1>
    <form method="post" action="RegistroEspecialista">
    <label for=""> Ingrese el nombre de usuario</label>
    <br><br>
    <input type="text" name="usuario" id="usuario" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for=""> Ingrese la contraseña</label>
    <br><br>
    <input type="password" name="password" id="password" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for="">Ingrese nombre</label>
    <br><br>
    <input type="text" name="nombre" id="nombre" class="btn btn-outline-light btn-lg px-4">                             
    <br><br>
    <label for="">Ingrese el apellido paterno</label>
    <br><br>
    <input type="text" name="appat" id="appat" class="btn btn-outline-light btn-lg px-4">        
    <br><br>
    <label for="">Ingrese el apellido materno</label>
    <br><br>
    <input type="text" name="apmat" id="apmat" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for="">Ingrese su Sexo</label>
    <br><br>
    <select name="sexo" id="sexo" class="btn btn-outline-light btn-lg px-4">
        <option value="Femenino">Femenino</option>
        <option value="Masculino" >Masculino</option>
    </select>
    <br><br>
    <label for="">Ingrese su CURP</label>
    <br><br>
    <input type="text" name="curp" id="curp" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for="">Ingrese su Edad</label>
    <br><br>
    <input type="text" name="edad" id="edad" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for=""> Ingrese su cedula profesional</label>
    <br><br>
    <input type="text" name="cedula" id="cedula" class="btn btn-outline-light btn-lg px-4">
    <br><br><br>
    <input type="date" name="fecha_nac" id="fecha_nac" id="start" name="trip-start" value="2022-07-22" min="1950-01-01" max="2022-12-31" class="btn btn-outline-light btn-lg px-4">
    <br>
    <br>
    <label for=""> Ingrese su fecha de nacimiento</label>
    <br><br>
    <input type="submit" value="Registrar Especialista" class="btn btn-success">
    <br><br>
    </form>
    <label for="">Registrarse con:</label>
    <br><br>
    <input type="button" value="Iniciar con Google" class="btn btn-danger btnsepar">
    <input type="button" value="Iniciar con Facebook" class="btn btn-danger btnsepar">
    <br><br>
    <a href="index.html"><input type="button" value="Atrás" class="btn btn-danger"></a>
</body>
</html>