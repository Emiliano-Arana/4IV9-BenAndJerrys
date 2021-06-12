<%-- 
    Document   : domicilio
    Created on : 9/06/2021, 11:26:57 PM
    Author     : adrai
--%>

<%@page import="Modelo.Colonia"%>
<%@page import="Modelo.Alcaldia"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <title>Datos Direccion</title>
</head>
<body>
    <div class="main-container">
        <header class="header">
            <nav class="nav">
              <a href="index.html" class="logo nav-link"><img src="./img/logo-small.png" ></a>
            </nav>
        </header>
        <form action="agregarDireccion">
            <section class="form-tarjeta">
                <h5>Direccion</h5>
                <div class="container-campo">
                    <label class="error" id="errCalle"></label>
                    <div class="campo">
                        <label for="Cname">Calle:</label>
                        <input type="text" placeholder="Calle" id="Ccalle" name="Calle" onkeypress="return validarNom(event)" class="control_1">
                    </div>
                </div>
                <div class="container-campo">
                    <label class="error" id="errNoExt"></label>
                    <div class="campo">
                        <label for="Cappat">No Exterior:</label>
                        <input type="text" placeholder="Numero Exterior" id="CnoExt" name="noExt" onkeypress="return validarNum(event)" class="control_2">
                    </div>
                </div>
                <div class="container-campo">
                    <label class="error" id="errNoInt"></label>
                    <div class="campo">
                        <label for="Capmat">No Interior:</label>
                        <input type="text" placeholder="Numero Interior" id="CnoInt" name="noInt" onkeypress="return validarNum(event)" class="control_2">
                    </div>
                </div>
                <div class="container-campo">
                    <label class="error" id="errAlc"></label>
                    <div class="campo">
                        <label for="Cfn">Alcaldia:</label>
                        <select name="alcaldia" class="control_0" id="Calcaldia">
                            
                            <%
                Vector<Alcaldia> listaAlcaldias  = new Alcaldia().listaAlcaldias();
                
                for(Alcaldia nombre : listaAlcaldias){ 
                    
            %>
            <option value="<%=nombre.getNombre()%>"><%=nombre.getNombre()%></option>
            <%
            }
            %>
                        </select>
                    </div>
                </div>
                <div class="container-campo">
                    <label class="error" id="errCol"></label>
                    <div class="campo">
                        <label for="Ctel">Colonia:</label>
                        <select name="colonia" class="control_0" id="Ccolonia">
                            
                            <%
                Vector<Colonia> listaColonias  = new Colonia().listaColonias();
                
                for(Colonia nombre : listaColonias){
                    
            %>
            <option value="<%=nombre.getNombre()%>"><%=nombre.getNombre()%></option>
            <%
            }
            %>
                        </select>
                    </div>
                </div>
                <input class="buttons" onclick="return validarDatos()" type="submit" name="" value="Enviar">
                <input class="buttons" type="reset" onclick="" name="delete" value="Borrar Dirección">
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
    <script src="./js/validacionDom.js"></script>
</body>
</html>
