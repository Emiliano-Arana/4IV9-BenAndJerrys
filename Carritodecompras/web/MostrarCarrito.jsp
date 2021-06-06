<%-- 
    Document   : MostrarCarrito
    Created on : 6/06/2021, 01:37:41 PM
    Author     : mercu
--%>

<%@page import="Modelo.DCompra"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.MProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<%
    String usuario = "";
    HttpSession sesionusu = request.getSession();
    if(sesionusu.getAttribute("usuario")==null){
        
        %>
    
        <jsp:forward page="index.html">
            <jsp:param name="error" value="Es obligatorio iniciar sesion" ></jsp:param>
        </jsp:forward>
        
        <%
    }else{
        //si hay una sesion
        usuario = (String)sesionusu.getAttribute("usuario");

    }
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
        
        <h1>imprimir una tabla con los productos que se estan agregando al carrito(detalle)</h1>
        <%
            Vector<DCompra> detallecompra = (Vector<DCompra>)sesionusu.getAttribute("detallecompraproductos");
            Vector<MProducto> stockproductos = null;
            %>
    </body>
</html>
