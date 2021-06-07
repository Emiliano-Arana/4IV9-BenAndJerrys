<%-- 
    Document   : cSabores
    Created on : Jun 7, 2021, 2:22:17 AM
    Author     : Emiliano
--%>

<%@page import="java.util.Vector"%>
<%@page import="Modelo.TipoHelado"%>
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
    <title>Sabores</title>
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
                <form name="formAdd" action="actualizarSabor">
                    <label class="labRC">Sabor:</label>
                    <input type="text" value="<%=request.getParameter("id")%>" name="idS" style="display: none;">
                    <input type="text" value="<%=request.getParameter("nom")%>" id="cSabor" name="sabor" class="txtRC" onkeypress="return validarNom(event)">
                    <input type="submit" onclick="return validarDatos()" value="Actualizar" class="addRC">
                </form>
                <%
                }else{
                %>
                <form name="formAdd" action="agregarSabor">
                    <label class="labRC">Sabor:</label>
                    <input type="text" id="cSabor" name="sabor" class="txtRC" onkeypress="return validarNom(event)">
                    <input type="submit" onclick="return validarDatos()" value="Agregar" class="addRC">
                </form>
                <%}%>
            </div>
            <form class="form-tabla" name="tablaP">
                <div class="acciones">
                    <label for="edit"><i class="fas fa-edit icon"></i></label>
                    <input type="submit" formaction="actSaborRP" value="Edit" class="boton-accion" id="edit">
                    <label for="delete"><i class="fas fa-trash-alt icon"></i></label>
                    <input type="submit" formaction="eliminarSabor" value="Add" class="boton-accion" id="delete">
                </div>
                <table class="tabla">
                    <thead class="titulosCol">
                        <tr>
                            <td id="seleccion"></td>
                            <td>ID</td>
                            <td>Sabor</td>
                        </tr>
                    </thead>
                    <tbody class="registros">
                        <%
                            Vector<TipoHelado> listaSabores = new TipoHelado().listaSabores();

                    for(TipoHelado sabor : listaSabores){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=sabor.getId_tipoH()%>" class="radio-button"></td>
                            <td><%=sabor.getId_tipoH()%></td>
                            <td><%=sabor.getTipoH()%></td>
                        </tr>
                                    <%
                    }
            %>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <script src="./js/validacionCSab.js"></script>
</body>
</html>
