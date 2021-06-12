<%-- 
    Document   : adminUsu.jsp
    Created on : Jun 7, 2021, 4:13:32 PM
    Author     : Emiliano
--%>

<%@page import="java.util.Vector"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/341b72a6e8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/styleNavFoot.css">
    <link rel="stylesheet" href="./css/styleAdminTable.css">
    <title>CRUD Usuarios</title>
</head>
<body>
    <div class="main-container">
        <header class="header">
            <nav class="nav">
              <a href="index.html" class="logo nav-link"><img src="./img/logo-small.png" ></a>
              <button class="nav-toggle" aria-label="Abrir menú">
                <i class="fas fa-bars"></i>
              </button>
              <ul class="nav-menu">
                <li id="tre" class="btn btn--4">
                  <a href="adminProductos.jsp?busc=false&filt=false" class="nav-menu-link">Productos</a>
                </li>
                <li id="tre" class="btn btn--4">
                  <a href="#" class="nav-menu-link">Usuarios</a>
                </li>
                <li id="tre" class="btn btn--4">
                  <a href="consultaVentas.html" class="nav-menu-link">Ventas</a>
                </li>
                <li id="tre" class="btn btn--4">
                    <a href="menuCatalogos.html" class="nav-menu-link">Catalogos</a>
                  </li>
              </ul>
            </nav>
        </header>
        <div class="tablaConsulta">
            <form id="buscarID" action="buscarIDusu">
            </form>
            <form class="form-tabla" name="tablaP" id="tableU">
                <div class="acciones">
                    <label for="edit"><i class="fas fa-edit icon"></i></label>
                    <input type="submit" formaction="actUsuRP" value="Edit" class="boton-accion" id="edit">
                    <label for="delete"><i class="fas fa-trash-alt icon"></i></label>
                    <input type="submit" formaction="eliminarUsuAdmin" value="Add" class="boton-accion" id="delete">
                    <div class="buscarContainer">
                        <label for="buscarP"><i class="fas fa-search iconB"></i></label><input form="buscarID" onkeypress="return validarNum(event)" id="buscarBD" name="busqueda" placeholder="Ingrese el ID" type="text" class="buscar">
                        <input form="buscarID" type="submit" onclick="return validarDatos()" id="buscarP">
                    </div>
                </div>
                <table class="tabla">
                    <thead class="titulosCol">
                        <tr>
                            <td id="seleccion"></td>
                            <td>ID</td>
                            <td>Usuario</td>
                            <td>Contraseña</td>
                        </tr>
                    </thead>
                    <tbody class="registros">
                        <%if(Boolean.parseBoolean(request.getParameter("busc"))){
                            %>
                            <td><input type="radio" name="select" value="<%=request.getParameter("idusu")%>" class="radio-button"></td>
                            <td><%=request.getParameter("idusu")%></td>
                            <td><%=request.getParameter("nomusu")%></td>
                            <td><%=request.getParameter("passusu")%></td>
                        <%
                        }else{
                            Vector<Usuario> listaUsu = new Usuario().listaUsu();

                    for(Usuario usu : listaUsu){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=usu.getId_usu()%>" class="radio-button"></td>
                            <td><%=usu.getId_usu()%></td>
                            <td><%=usu.getUsu()%></td>
                            <td><%=usu.getPass()%></td>
                        </tr>
                                    <%
                        }
                    }
            %>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <script src="./js/main.js"></script>
    <script src="./js/validarBusquedasID.js"></script>
</body>
</html>
