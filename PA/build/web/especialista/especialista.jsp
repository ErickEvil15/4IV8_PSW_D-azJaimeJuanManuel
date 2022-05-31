<%-- 
    Document   : especialista
    Created on : 26-may-2022, 2:51:23
    Author     : dagra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/especialista/";
%>
<base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Especialista</title>
    <link rel="stylesheet" href="<%=basePath%>../css/bootstrap.min.css">
</head>
<body class="bg-dark text-secondary px-4 py-5 text-center">
    <h1>Bienvenido ${usuario.nombre} ${usuario.appat} ${usuario.apmat} de ${usuario.edad} años</h1>
    <h1>¿Qué desea consultar?</h1>
    
    
    <a href="<%=basePath%>seguimiento.html" class="btnsepar">
        <button class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">
            Dar seguimiento<br>
            <img src="<%=basePath%>../img/lupa.webp" alt="" width="170" height="170">
        </button>
    </a><a href="<%=basePath%>calandarioespecialista.html" class="btnsepar">
        <button class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">
            Calendario<br>
            <img src="<%=basePath%>../img/calendario.jpg" alt="" width="170" height="170">
        </button>
    </a>
    <br>
    <a href="<%=basePath%>nuevoanalisis.html">
        <button class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">
            Nuevo analisis <br>
            <img src="<%=basePath%>../img/notas.png" alt="" width="170" height="170">
        </button>
    </a>
        <a href="<%=basePath%>../logout"><input type="button" value="Log out"></a>
</body>
</html>
