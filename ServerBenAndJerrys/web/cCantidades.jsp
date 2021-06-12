<%-- 
    Document   : cCantidades
    Created on : Jun 7, 2021, 3:08:41 PM
    Author     : Emiliano
--%>

<%@page import="java.util.Vector"%>
<%@page import="Modelo.Cantidad"%>
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
    <title>Cantidades</title>
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
                    <form name="formAdd" action="actualizarCantidad">
                        <input type="text" value="<%=request.getParameter("id")%>" name="idC" style="display: none;">
                        <label class="labRC">Cantidad:</label>
                        <input type="text" id="cCant" value="<%=request.getParameter("cant")%>" name="cant" class="txtRC" onkeypress="return validarNum(event)">
                        <label class="labRC">Unidad:</label>
                        <input type="text" id="cUnit" value="<%=request.getParameter("unit")%>" name="unit" class="txtRC" onkeypress="return validadLetras(event)">
                        <input type="submit" onclick="return validarDatos()" value="Actualizar" class="addRC">
                    </form>
                    <%
                }else{
                %>
                <form name="formAdd" action="agregarCantidad">
                    <label class="labRC">Cantidad:</label>
                    <input type="text" id="cCant" name="cant" class="txtRC" onkeypress="return validarNum(event)">
                    <label class="labRC">Unidad:</label>
                    <input type="text" id="cUnit" name="unit" class="txtRC" onkeypress="return validadLetras(event)">
                    <input type="submit" onclick="return validarDatos()" value="Agregar" class="addRC">
                </form>
                <%}%>
            </div>
            <form class="form-tabla" name="tablaP">
                <div class="acciones">
                    <label for="edit"><i class="fas fa-edit icon"></i></label>
                    <input type="submit" formaction="actCantidadRP" value="Edit" class="boton-accion" id="edit">
                    <label for="delete"><i class="fas fa-trash-alt icon"></i></label>
                    <input type="submit" formaction="eliminarCantidad" value="Add" class="boton-accion" id="delete">
                </div>
                <table class="tabla">
                    <thead class="titulosCol">
                        <tr>
                            <td id="seleccion"></td>
                            <td>ID</td>
                            <td>Cantidad</td>
                            <td>Unidad</td>
                        </tr>
                    </thead>
                    <tbody class="registros">
                        <%
                            Vector<Cantidad> listaCantidades = new Cantidad().listaCantidades();

                    for(Cantidad cantidad : listaCantidades){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=cantidad.getId_cant()%>" class="radio-button"></td>
                            <td><%=cantidad.getId_cant()%></td>
                            <td><%=cantidad.getValor()%></td>
                            <td><%=cantidad.getUnidad()%></td>
                        </tr>
                                    <%
                    }
            %>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <script src="./js/validacionCCant.js"></script>
</body>
</html>
