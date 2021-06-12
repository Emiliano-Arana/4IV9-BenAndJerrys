<%-- 
    Document   : productos
    Created on : Jun 8, 2021, 7:32:25 PM
    Author     : Emiliano
--%>

<%@page import="Modelo.ProductoTabla"%>
<%@page import="Modelo.Producto"%>
<%@page import="Modelo.Tamano"%>
<%@page import="Modelo.Presentacion"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.TipoHelado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/styleProducto.css">
    <link rel="stylesheet" href="./css/styleNavFoot.css">
    <link rel="stylesheet" href="./css/estilos.css">
    <script src="https://kit.fontawesome.com/f6124530ac.js" crossorigin="anonymous"></script>
    <title>Productos</title>
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
                <a href="./conocenos.html" class="nav-menu-link">Conocenos</a>
                </li>
                <li id="tre" class="btn btn--4">
                <a href="#" class="nav-menu-link">Productos</a>
                </li>
                <li id="tre" class="btn btn--4">
                <a href="#" class="nav-menu-link">Carrito</a>
                </li>
                <li id="tre" class="btn btn--4">
                    <a href="inicioSesion.html" class="nav-menu-link">Acceder</a>
                </li>
            </ul>
            </nav>
        </header>
        <div class="body-container">
            <form name="filtrarP" class="formB" action="filtProductosUsu">
                <div class="filters">
                    <div class="filtro">
                            <label>Sabor:</label>
                            <select name="sab" class="filt">
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
                        <div class="filtro">
                            <label>Presentacion:</label>
                            <select name="pre" class="filt">
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
                        <div class="filtro">
                            <label>Tamaño:</label>
                            <select name="tam" class="filt">
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
                        <div class="filtro">
                            <input type="submit" value="Aplicar" class="botonFilt">
                        </div>
                </div>
            </form>
            <div class="product-container">
                <%
                if(Boolean.parseBoolean(request.getParameter("filt"))){
                            Vector<ProductoTabla> listaPro = new Producto().listaProductosFilt(request.getParameter("sab"),request.getParameter("pre"),request.getParameter("tam"));

                            for(ProductoTabla producto : listaPro){
                                %>
                                <div class="conte">
                            <form>
                            <div class="card chocolate">
                                <img width="100%" src="https://images.vexels.com/media/users/3/143612/isolated/preview/203946c7d983f9461795dff9e878f5a8-ilustraci-oacute-n-de-dibujos-animados-de-helado-by-vexels.png">
                            </div>
                            <div class="informacion">
                                <h1>Helado de <%=producto.getSabor()%></h1>
                                <h1><%=producto.getTam()%></h1>
                                <h1><%=producto.getPresentacion()%></h1>
                            </div>
                            <div class="precio">
                                <div class="box-precio">
                                    <%
                                    if(producto.getPromo().equals("no")){
                                        %>
                                    
                                        <span class="precio1"></span>
                                    
                                    <%
                                    }else{
%>
                                        <span class="precio1"><%=producto.getPromo()%></span>
                                        <%
                                    }
                                    %>
                                    <span class="precio2"><%=producto.getPrecio()%></span>
                                </div>
                                <label for="carrito"><span class="shoping"><i class="fas fa-cart-plus"></i></span></label>
                                <input type="submit" id="carrito" style="display: none;">
                            </div>
                            </form>
                        </div>
                                <%
                                    }
                            }else{
                            Vector<ProductoTabla> listaPro = new Producto().listaProductos();

                    for(ProductoTabla producto : listaPro){
                        %>
                        <div class="conte">
                            <form>
                            <div class="card chocolate">
                                <img width="100%" src="https://images.vexels.com/media/users/3/143612/isolated/preview/203946c7d983f9461795dff9e878f5a8-ilustraci-oacute-n-de-dibujos-animados-de-helado-by-vexels.png">
                            </div>
                            <div class="informacion">
                                <h1>Helado de <%=producto.getSabor()%></h1>
                                <h1><%=producto.getTam()%></h1>
                                <h1><%=producto.getPresentacion()%></h1>
                            </div>
                            <div class="precio">
                                <div class="box-precio">
                                    <%
                                    if(producto.getPromo().equals("no")){
                                        %>
                                    
                                        <span class="precio1"></span>
                                    
                                    <%
                                    }else{
%>
                                        <span class="precio1"><%=producto.getPromo()%></span>
                                        <%
                                    }
                                    %>
                                    <span class="precio2"><%=producto.getPrecio()%></span>
                                </div>
                                <label for="carrito"><span class="shoping"><i class="fas fa-cart-plus"></i></span></label>
                                <input type="submit" id="carrito" style="display: none;">
                            </div>
                            </form>
                        </div>
                         <%
                        }
                    }
            %>
            </div>
        </div>
        <footer>
            <h1 id=con>Contactanos</h1>
            <div class=formulario>
                <form action="" >
                    <p id=dis>Formulario de contacto</p>
                    <input type="text" name="nombre" placeholder="Nombre" required>
                    <input type="text" name="apellido" placeholder="Apellido" required>
                    <input type="email" name="correo" placeholder="Correo" required>
                    <textarea name="mensaje" placeholder="Escriba su mensaje" cols="30" rows="10" required></textarea>
                    <input type="submit" value="Enviar" id="boton">
                </form>
            </div>
            <div class="redes-sociales">
                <ul>
                    <li><a href="https://es-la.facebook.com/benandjerrys/"><p id=facebook><i class="fab fa-facebook-square fa-3x"></i></p></a></li>
                    <li><a href="https://www.instagram.com/benandjerrys/?hl=es"><p id="instagram"><i class="fab fa-instagram-square  fa-3x"></i></p></a></li>
                    <li><p id="correo"><i class="fas fa-envelope fa-3x"></i></p></li>
                    <li><a href="https://twitter.com/benandjerrys"><p id="twitter"><i class="fab fa-twitter-square fa-3x" ></i></p></a></li>
                </ul>
            </div>
            <div class=nombres>
                <p id="nom">Hecho por</p>
                <br>
                <p id="nom">Arana Chavez Emiliano</p>
                <br>
                <p id="nom">Lizarraga Anguiano Jesus Adrian</p>
                <br>
                <p id="nom">Núñez Manrique Cuauhtemoc Emmanuel</p>
            </div>
        </footer>
    </div>
    <script src="./js/main.js"></script>
</body>
</html>
