<%-- 
    Document   : actualizarProducto
    Created on : Jun 7, 2021, 10:28:35 PM
    Author     : Emiliano
--%>

<%@page import="Modelo.Producto"%>
<%@page import="Control.AccionesAdmin"%>
<%@page import="Modelo.Promocion"%>
<%@page import="Modelo.Presentacion"%>
<%@page import="Modelo.Tamano"%>
<%@page import="Modelo.Cantidad"%>
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
    <link rel="stylesheet" href="./css/styleAdminForm.css">
    <link rel="stylesheet" href="./css/styleNavFoot.css">
    <title>Actualizar Producto</title>
</head>
<body>
    <header class="header">
        <nav class="nav">
          <a href="index.html" class="logo nav-link"><img src="./img/logo-small.png" ></a>
    </header>
    <div class="main-container">
        <form class="formularioProductos" action="actualizarProducto">
            <%
            String idP = request.getParameter("idP");
            AccionesAdmin acc = new AccionesAdmin();
            
            Producto pro = acc.recogerProducto(Integer.parseInt(idP));
            %>
            <p class="title">Actualizar Producto</p>
            <div class="yes-combobox">
                <div class="container-campo">
                    <label for="saborH" class="nombre-campo">Sabor:</label>
                        <select name="sabor" id="saborH" class="combobox">
                            <option value="-">-</option>
                            <%
                            Vector<TipoHelado> listaSabores = new TipoHelado().listaSabores();

                            for(TipoHelado sabor : listaSabores){
                                if(sabor.getId_tipoH()==pro.getId_Tipo()){
                                    %>
                                    <option value="<%=sabor.getId_tipoH()%>" selected="true"><%=sabor.getTipoH()%></option>
                     
                            <%
                                }else{
                        %>
                            <option value="<%=sabor.getId_tipoH()%>"><%=sabor.getTipoH()%></option>
                     
                            <%
                                }
                    }
            %>
                        </select>
                </div>
                <div class="container-campo">
                    <label for="cantidadH" class="nombre-campo">Cantidad:</label>
                        <select name="cantidad" id="cantidadH" class="combobox">
                            <option value="-">-</option>
                            <%
                            Vector<Cantidad> listaCantidades = new Cantidad().listaCantidades();

                            for(Cantidad cantidad : listaCantidades){
                                if(cantidad.getId_cant()==pro.getId_cant()){
                                    %>
                                    <option value="<%=cantidad.getId_cant()%>" selected="true"><%=cantidad.getValor()+cantidad.getUnidad()%></option>
                     
                            <%
                                }else{
                        %>
                            <option value="<%=cantidad.getId_cant()%>"><%=cantidad.getValor()+cantidad.getUnidad()%></option>
                                    <%
                                        }
                    }
            %>
                        </select>
                </div>
                <div class="container-campo">
                    <label for="tamanoH" class="nombre-campo">Tamaño:</label>
                        <select name="tamano" id="tamanoH" class="combobox">
                            <option value="-">-</option>
                            <%
                            Vector<Tamano> listaTamanos = new Tamano().listaTamanos();

                            for(Tamano tamano : listaTamanos){
                                if(tamano.getId_tam()==pro.getId_tam()){
                                    %>
                                    <option value="<%=tamano.getId_tam()%>" selected="true"><%=tamano.getTam()%></option>
                     
                            <%
                                }else{
                        %>
                            <option value="<%=tamano.getId_tam()%>"><%=tamano.getTam()%></option>
                                    <%
                                        }
                    }
            %>
                        </select>
                </div>
                <div class="container-campo">
                    <label for="presentacionH" class="nombre-campo">Presentacion:</label>
                        <select name="presentacion" id="presentacionH" class="combobox">
                            <option value="-">-</option>
                            <%
                            Vector<Presentacion> listaPresentaciones = new Presentacion().listaPresentaciones();

                            for(Presentacion presentacion : listaPresentaciones){
                                if(presentacion.getId_presentacion()==pro.getId_presentacion()){
                                    %>
                                    <option value="<%=presentacion.getId_presentacion()%>" selected="true"><%=presentacion.getPresentacion()%></option>
                     
                            <%
                                }else{
                        %>
                            <option value="<%=presentacion.getId_presentacion()%>"><%=presentacion.getPresentacion()%></option>
                                    <%
                                        }
                    }
            %>
                        </select>
                </div>
                <div class="container-campo">
                    <label for="promocionH" class="nombre-campo">Promocion:</label>
                        <select name="promocion" id="promocionH" class="combobox">
                            <option value="-">-</option>
                            <%
                            Vector<Promocion> listaPromociones = new Promocion().listaPromociones();

                            for(Promocion promo : listaPromociones){
                                if(promo.getId_promocion()==pro.getId_promocion()){
                                    %>
                                    <option value="<%=promo.getId_promocion()%>" selected="true"><%=promo.getPromocion()%></option>
                     
                            <%
                                }else{
                        %>
                            <option value="<%=promo.getId_promocion()%>"><%=promo.getPromocion()%></option>
                                    <%
                                        }
                    }
            %>
                        </select>
                </div>
            </div>
            <div class="non-combobox">
                <input type="text" style="display: none" name="idP" value="<%=pro.getId_producto()%>">
                <div class="container-campo">
                    <label class="error" id="errPrecio"></label>
                    <label for="precioH" class="nombre-campo">Precio:</label>
                    <input type="text" value="<%=pro.getPrecio()%>" id="precioH" name="precio" onkeypress="return validarNumF(event)" class="text-campo">
                </div>
                <div class="container-campo">
                    <label class="error" id="errStock"></label>
                    <label for="stockH" class="nombre-campo">Stock:</label>
                    <input type="text" value="<%=pro.getStock()%>" id="stockH" name="stock" onkeypress="validarNum(event)" class="text-campo">
                </div>
            </div>
            <div class="container-boton">
                <input type="submit" onclick="return validarDatos()" value="Actualizar" class="boton">
            </div>
            <a class="return" href="adminProductos.html">Regresar</a>
        </form>
    </div>
    <script src="./js/validacionPro.js"></script>
</body>
</html>
