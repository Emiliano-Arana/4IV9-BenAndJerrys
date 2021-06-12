<%-- 
    Document   : cPresentaciones
    Created on : Jun 7, 2021, 11:51:56 AM
    Author     : Emiliano
--%>

<%@page import="java.util.Vector"%>
<%@page import="Modelo.Presentacion"%>
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
    <title>Presentaciones</title>
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
                
                if(act){%>
                    <form name="formAdd" action="actualizarPresentacion">
                        <label class="labRC">Presentacion:</label>
                        <input type="text" value="<%=request.getParameter("id")%>" name="idP" style="display: none;">
                        <input type="text" value="<%=request.getParameter("nom")%>" id="cPresentacion" name="presentacion" class="txtRC" onkeypress="return validarNom(event)">
                        <input type="submit" onclick="return validarDatos()" value="Actualizar" class="addRC">
                    </form>
                <%
                }else{
                %>
                    <form name="formAdd" action="agregarPresentacion">
                        <label class="labRC">Presentacion:</label>
                        <input type="text" id="cPresentacion" name="presentacion" onkeypress="return validarNom(event)" class="txtRC">
                        <input type="submit" value="Agregar" onclick="return validarDatos()" class="addRC">
                    </form>
                <%
                }
                %>
            </div>
            <form class="form-tabla" name="tablaP">
                <div class="acciones">
                    <label for="edit"><i class="fas fa-edit icon"></i></label>
                    <input type="submit" formaction="actPresentacionRP"value="Edit" class="boton-accion" id="edit">
                    <label for="delete"><i class="fas fa-trash-alt icon"></i></label>
                    <input type="submit" formaction="eliminarPresentacion" value="Add" class="boton-accion" id="delete">
                </div>
                <table class="tabla">
                    <thead class="titulosCol">
                        <tr>
                            <td id="seleccion"></td>
                            <td>ID</td>
                            <td>Presentacion</td>
                        </tr>
                    </thead>
                    <tbody class="registros">
                        <%
                            Vector<Presentacion> listaPresentaciones = new Presentacion().listaPresentaciones();

                    for(Presentacion presentacion : listaPresentaciones){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=presentacion.getId_presentacion()%>" class="radio-button"></td>
                            <td><%=presentacion.getId_presentacion()%></td>
                            <td><%=presentacion.getPresentacion()%></td>
                        </tr>
                       <%
                    }
            %>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <script src="./js/validacionCPre.js"></script>
</body>
</html>
