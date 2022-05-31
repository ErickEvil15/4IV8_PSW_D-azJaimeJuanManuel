<%-- 
    Document   : registroPac
    Created on : 23/05/2022, 03:58:06 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro del Paciente</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="bg-dark text-secondary px-4 py-5 text-center">
    <h1>Registrarse</h1>
    <label for="">Ingrese nombre</label>
    <br><br>
    <input type="text" class="btn btn-outline-light btn-lg px-4">                             
    <br><br>
    <label for="">Ingrese el apellido paterno</label>
    <br><br>
    <input type="text" class="btn btn-outline-light btn-lg px-4">        
    <br><br>
    <label for="">Ingrese el apellido materno</label>
    <br><br>
    <input type="text" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for="">Ingrese el correo electrónico</label>
    <br><br>
    <input type="text" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for=""> Ingrese la contraseña</label>
    <br><br>
    <input type="password" class="btn btn-outline-light btn-lg px-4">
    <br><br>
    <label for="">Ingrese su CURP</label>
    <br><br>
    <input type="text" class="btn btn-outline-light btn-lg px-4">
    <br><br><br>
    <input type="date" id="start" name="trip-start" value="2022-07-22" min="1950-01-01" max="2022-12-31" class="btn btn-outline-light btn-lg px-4">
    <br>
    <br>
    <a href="paciente/paciente.html"><input type="button" value="Registrar Paciente" class="btn btn-success"></a>
    <br><br>
    <label for="">Registrarse con:</label>
    <br><br>
    <input type="button" value="Iniciar con Google" class="btn btn-danger btnsepar">
    <input type="button" value="Iniciar con Facebook" class="btn btn-danger btnsepar">
    <br><br>
    <a href="index.html"><input type="button" value="Atrás" class="btn btn-danger"></a>
</body>
</html>
