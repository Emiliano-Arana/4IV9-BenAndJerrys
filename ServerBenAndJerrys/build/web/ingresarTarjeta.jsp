<%-- 
    Document   : ingresarTarjeta
    Created on : 9/06/2021, 10:06:21 PM
    Author     : adrai
--%>

<%@page import="Modelo.TipoTarjeta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.Banco"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/341b72a6e8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/gestionUsuStyle.css">
    <link rel="stylesheet" href="./css/styleNavFoot.css">
    <link rel="stylesheet" href="./css/estilos.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <title>Datos Tarjeta</title>
</head>
<body>
    <div class="main-container">
        <header class="header">
            <nav class="nav">
              <a href="index.html" class="logo nav-link"><img src="./img/logo-small.png" ></a>
            </nav>
        </header>
        <form action="agregarTarjeta">
        <section class="form-tarjeta">
            <h5>Tarjeta</h5>
            Tipo de Tarjeta:
            <select name="ttarjeta" class="control_0" id="tipoT">
                <option value="-">Ninguna</option>
                <%
                Vector<TipoTarjeta> listaTTarjeta  = new TipoTarjeta().listaTTarjeta();
                
                for(TipoTarjeta Id_tar : listaTTarjeta){
                    
            %>
            <option value="<%=Id_tar.getId_tipoTar()%>"><%=Id_tar.getTipo()%></option>
            <%
            }
            %>
            </select>
            <br>
            Nombre del banco:
            <select name="nbanco" class="control_0" id="nBanco">
                <option value="-">Ninguno</option>
                <%
                Vector<Banco> listaBanco  = new Banco().listaBanco();
                
                for(Banco nombre : listaBanco){
                    
            %>
            <option value="<%=nombre.getNombre()%>"><%=nombre.getNombre()%></option>
            <%
            }
            %>
            </select>
            <br>
            Numero de Tarjeta:
            <label class="error" id="errNTar"></label>
            <input class="control_1" type="text" name="ntarjeta" value="" onkeypress="return validarNum(event)" id="numTar" placeholder="Número de la tarjeta de crédito/débito">
            <br>
            Nombre:
            <label class="error" id="errNom"></label>
            <input class="control_1" type="text" name="nombre" value="" onkeypress="return validarNom(event)" id="nomP" placeholder="Nombre del propietario">
            <br>
            Fecha de expiración:
            <label class="error" id="errFE"></label>
            <input class="control_2" type="datetime" name="Fechaexp" onkeypress="return validarFE(event)" id="FE" value="" placeholder="MM/AA">
            <br>
            Código:
            <label class="error" id="errCod"></label>
            <input class="control_2" type="text" name="cvc"  value="" placeholder="cvc" id="codCvc">
            <input class="buttons" type="submit" onclick="return validarDatos()" name="enviar" value="Enviar">
            <input class="buttons" type="reset" onclick="" name="delete" value="Borrar Tarjeta">
            <h4><a href="gestionarUsu.html">Regresar</a></h4>
            </section>
            </form>
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
    <script src="./js/validacionTar.js"></script>
</body>
</html>