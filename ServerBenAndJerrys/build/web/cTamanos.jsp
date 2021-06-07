<%-- 
    Document   : cTamanos
    Created on : Jun 7, 2021, 1:04:27 PM
    Author     : Emiliano
--%>

<%@page import="java.util.Vector"%>
<%@page import="Modelo.Tamano"%>
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
    <title>Tamaños</title>
</head>
<body>
    <div class="main-container">
        <header class="header">
            <nav class="nav">
              <a href="index.html" class="logo nav-link"><img src="./img/logo-small.png" ></a>
              <a href="menuCatalogos.html" class="return">Regresar</a>
            </nav>
        </header>
        <div class="tablaConsulta">
            <div class="miniAdd">
                <%
                boolean act = Boolean.parseBoolean(request.getParameter("act"));
                
                if(act){
                    %>
                    <form name="formAdd" action="actualizarTamano">
                        <label class="labRC">Tamaño:</label>
                        <input type="text" value="<%=request.getParameter("id")%>" name="idT" style="display: none;">
                        <input type="text" value="<%=request.getParameter("nom")%>" id="cTamano" name="tamano" class="txtRC" onkeypress="return validarNom(event)">
                        <input type="submit" onclick="return validarDatos()" value="Actualizar" class="addRC">
                    </form>
                    <%
                    }else{
                    %>
                    <form name="formAdd" action="agregarTamano">
                    <label class="labRC">Tamaño:</label>
                    <input type="text" id="cTamano" name="tamano" class="txtRC" onkeypress="return validarNom(event)">
                    <input type="submit" value="Agregar" onclick="return validarDatos()" class="addRC">
                </form>
                <%}%>
            </div>
            <form class="form-tabla" name="tablaP">
                <div class="acciones">
                    <label for="edit"><i class="fas fa-edit icon"></i></label>
                    <input type="submit" formaction="actTamanoRP" value="Edit" class="boton-accion" id="edit">
                    <label for="delete"><i class="fas fa-trash-alt icon"></i></label>
                    <input type="submit" formaction="eliminarTamano" value="Add" class="boton-accion" id="delete">
                </div>
                <table class="tabla">
                    <thead class="titulosCol">
                        <tr>
                            <td id="seleccion"></td>
                            <td>ID</td>
                            <td>Tamaño</td>
                        </tr>
                    </thead>
                    <tbody class="registros">
                        <%
                            Vector<Tamano> listaTamanos = new Tamano().listaTamanos();

                    for(Tamano tamano : listaTamanos){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=tamano.getId_tam()%>" class="radio-button"></td>
                            <td><%=tamano.getId_tam()%></td>
                            <td><%=tamano.getTam()%></td>
                        </tr>
                                    <%
                    }
            %>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <script src="./js/validacionCTam.js"></script>
</body>
</html>
