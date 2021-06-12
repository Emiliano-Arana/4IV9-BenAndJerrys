<%-- 
    Document   : adminProducto
    Created on : Jun 7, 2021, 6:44:03 PM
    Author     : Emiliano
--%>

<%@page import="Control.AccionesAdmin"%>
<%@page import="Modelo.Tamano"%>
<%@page import="Modelo.Presentacion"%>
<%@page import="Modelo.TipoHelado"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.ProductoTabla"%>
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
    <title>CRUD Productos</title>
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
                  <a href="#" class="nav-menu-link">Productos</a>
                </li>
                <li id="tre" class="btn btn--4">
                  <a href="adminUsu.jsp?busc=false" class="nav-menu-link">Usuarios</a>
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
            <form id="filtrosForm" action="filtProductos">
            </form>
            <form id="buscarForm" action="buscarIDproducto">
            </form>
            <form class="form-tabla" name="tablaP">
                <div class="acciones">
                    <a href="agregarProducto.jsp"><i class="fas fa-plus icon"></i></a>
                    <label for="edit"><i class="fas fa-edit icon"></i></label>
                    <input type="submit" value="Edit" formaction="actProductoRP" class="boton-accion" id="edit">
                    <label for="delete"><i class="fas fa-trash-alt icon"></i></label>
                    <input type="submit" formaction="eliminarProducto" value="Delete" class="boton-accion" id="delete">
                    <div class="buscarContainer">
                        <label for="buscarP"><i class="fas fa-search iconB"></i></label><input form="buscarForm" onkeypress="return validarNum(event)" name="busqueda" placeholder="Ingrese el ID" type="text" id="buscarBD" class="buscar">
                        <input onclick="return validarDatos()" type="submit" form="buscarForm" id="buscarP">
                    </div>
                </div>
                <div class="filtros">
                        <div class="filtroU">
                            <label>Sabor:</label>
                            <select form="filtrosForm" name="sab" class="opciones" form="filtrosForm">
                                <option value="todos">Todos</option>
                                <%
                            Vector<TipoHelado> listaSabores = new TipoHelado().listaSabores();

                            for(TipoHelado sabor : listaSabores){
                        %>
                            <option value="<%=sabor.getId_tipoH()%>"><%=sabor.getTipoH()%></option>
                                    <%
                    }
            %>
                            </select>
                        </div>
                        <div class="filtroU">
                            <label>Presentacion:</label>
                            <select form="filtrosForm" name="pre" class="opciones">
                                <option value="todos">Todos</option>
                                <%
                            Vector<Presentacion> listaPresentaciones = new Presentacion().listaPresentaciones();

                    for(Presentacion presentacion : listaPresentaciones){
                        %>
                            <option value="<%=presentacion.getId_presentacion()%>"><%=presentacion.getPresentacion()%></option>
                       <%
                    }
            %>
                            </select>
                        </div>
                        <div class="filtroU">
                            <label>Tamaño:</label>
                            <select form="filtrosForm" name="tam" class="opciones">
                                <option value="todos">Todos</option>
                                <%
                            Vector<Tamano> listaTamanos = new Tamano().listaTamanos();

                    for(Tamano tamano : listaTamanos){
                        %>
                            <option value="<%=tamano.getId_tam()%>"><%=tamano.getTam()%></option>
                                    <%
                    }
            %>
                            </select>
                        </div>
                        <div class="filtroU">
                            <input type="submit" form="filtrosForm" value="Aplicar" class="botonFilt">
                        </div>
                </div>
                <table class="tabla">
                    <thead class="titulosCol">
                        <tr>
                            <td id="seleccion"></td>
                            <td>ID</td>
                            <td>Sabor</td>
                            <td class="disappear">Cantidad</td>
                            <td class="disappear">Tamaño</td>
                            <td class="disappear">Presentacion</td>
                            <td>Precio</td>
                            <td class="disappear">Promocion</td>
                            <td>Stock</td>
                        </tr>
                    </thead>
                    <tbody class="registros">
                        <%if(Boolean.parseBoolean(request.getParameter("busc"))){
                            AccionesAdmin acc = new AccionesAdmin();
                            Producto pro = acc.recogerProducto(Integer.parseInt(request.getParameter("id")));
                            
                            ProductoTabla producto = new ProductoTabla();

                            producto.setId_producto(pro.getId_producto());
                            producto.setSabor(acc.recogerSabor(pro.getId_Tipo()).getTipoH());
                            producto.setPromo(acc.recogerPromocion(pro.getId_promocion()).getPromocion());
                            producto.setCantidad(String.valueOf(acc.recogerCantidad(pro.getId_cant()).getValor()) + acc.recogerCantidad(pro.getId_cant()).getUnidad());
                            producto.setTam(acc.recogerTamano(pro.getId_tam()).getTam());
                            producto.setPresentacion(acc.recogerPresentacion(pro.getId_presentacion()).getPresentacion());
                            producto.setPrecio(pro.getPrecio());
                            pro.setStock(pro.getStock());
                            %>
                                <tr>
                                    <td><input type="radio" name="select" value="<%=producto.getId_producto()%>" class="radio-button"></td>
                                    <td><%=producto.getId_producto()%></td>
                                    <td><%=producto.getSabor()%></td>
                                    <td class="disappear"><%=producto.getCantidad()%></td>
                                    <td class="disappear"><%=producto.getTam()%></td>
                                    <td class="disappear"><%=producto.getPresentacion()%></td>
                                    <td><%=producto.getPrecio()%></td>
                                    <td class="disappear"><%=producto.getPromo()%></td>
                                    <td><%=producto.getStock()%></td>
                                </tr>
                            <%
                        }else{
                            if(Boolean.parseBoolean(request.getParameter("filt"))){
                            Vector<ProductoTabla> listaPro = new Producto().listaProductosFilt(request.getParameter("sab"),request.getParameter("pre"),request.getParameter("tam"));

                            for(ProductoTabla producto : listaPro){
                                %>
                                <tr>
                                    <td><input type="radio" name="select" value="<%=producto.getId_producto()%>" class="radio-button"></td>
                                    <td><%=producto.getId_producto()%></td>
                                    <td><%=producto.getSabor()%></td>
                                    <td class="disappear"><%=producto.getCantidad()%></td>
                                    <td class="disappear"><%=producto.getTam()%></td>
                                    <td class="disappear"><%=producto.getPresentacion()%></td>
                                    <td><%=producto.getPrecio()%></td>
                                    <td class="disappear"><%=producto.getPromo()%></td>
                                    <td><%=producto.getStock()%></td>
                                </tr>
                                <%
                                    }
                            }else{
                            Vector<ProductoTabla> listaPro = new Producto().listaProductos();

                    for(ProductoTabla producto : listaPro){
                        %>
                        <tr>
                            <td><input type="radio" name="select" value="<%=producto.getId_producto()%>" class="radio-button"></td>
                            <td><%=producto.getId_producto()%></td>
                            <td><%=producto.getSabor()%></td>
                            <td class="disappear"><%=producto.getCantidad()%></td>
                            <td class="disappear"><%=producto.getTam()%></td>
                            <td class="disappear"><%=producto.getPresentacion()%></td>
                            <td><%=producto.getPrecio()%></td>
                            <td class="disappear"><%=producto.getPromo()%></td>
                            <td><%=producto.getStock()%></td>
                        </tr>
                         <%
                        }
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
