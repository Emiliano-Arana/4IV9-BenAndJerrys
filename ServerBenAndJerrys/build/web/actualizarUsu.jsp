<%-- 
    Document   : actualizarUsu
    Created on : Jun 7, 2021, 5:12:00 PM
    Author     : Emiliano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/341b72a6e8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/styleAdminForm.css">
    <link rel="stylesheet" href="./css/styleNavFoot.css">
    <title>Actualizar Usuario</title>
</head>
<body>
    <header class="header">
        <nav class="nav">
          <a href="index.html" class="logo nav-link"><img src="./img/logo-small.png" ></a>
    </header>
    <div class="main-container">
        <form class="formularioProductos" action="actualizarUsuAdmin">
            <p class="title">Actualizar Usuario</p>
            <div class="non-combobox">
                <input type="text" value="<%=request.getParameter("id")%>" name="idU" style="display: none">
                <div class="container-campo">
                    <label class="error" id="errUsu"></label>
                    <label class="nombre-campo" for="Cusu">Usuario:</label>
                    <input type="text" id="Cusu" value="<%=request.getParameter("nom")%>" name="usu" onkeypress="return validarUsu(event)" class="text-campoNom">
                </div>
                <div class="container-campo">
                    <label class="error" id="errPass"></label>
                    <label class="nombre-campo" for="Cpass">Contraseña:</label>
                    <input type="text" id="Cpass" value="<%=request.getParameter("pass")%>" name="pass" onkeypress="return validarPass(event)" class="text-campoNom">
                </div>
            </div>
            <div class="container-boton">
                <input type="submit" onclick="return validarDatos()" value="Actualizar" class="boton">
            </div>
            <a class="return" href="adminUsu.jsp?busc=false">Regresar</a>
        </form>
    </div>
    <script src="./js/validacionIS.js"></script>
</body>
</html>
