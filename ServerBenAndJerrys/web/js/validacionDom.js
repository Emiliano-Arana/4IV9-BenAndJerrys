function validarNom(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-zñáéíóú]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarNum(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[0-9]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarDatos(){
    document.getElementById('errCalle').innerHTML = '';
    document.getElementById('errNoExt').innerHTML = '';
    document.getElementById('errNoInt').innerHTML = '';
    var verif = true;

    var calle = document.getElementById('Ccalle').value;
    var noInt = document.getElementById('CnoInt').value;
    var noExt = document.getElementById('CnoExt').value;

    var patNom = /[A-Za-zñáéíóú]/;
    var patNum = /[0-9]/;

    if(calle.length<1){
        verif = false;
        document.getElementById('errCalle').innerHTML = "*Este campo es obligatorio";
    }

    if(calle.length>30){
        verif = false;
        document.getElementById('errCalle').innerHTML= "*El maximo de caracteres es de 30";
    }

    if(noInt.length<1){
        verif = false;
        document.getElementById('errNoInt').innerHTML = "*Este campo es obligatorio";
    }

    if(noInt.length>4){
        verif = false;
        document.getElementById('errNoInt').innerHTML= "*El maximo de caracteres es de 4";
    }

    if(noExt.length<1){
        verif = false;
        document.getElementById('errNoExt').innerHTML = "*Este campo es obligatorio";
    }

    if(noExt.length>4){
        verif = false;
        document.getElementById('errNoExt').innerHTML= "*El maximo de caracteres es de 4";
    }

    for(var i=0;i<calle.length;i++){
        if(patNom.test(calle[i])){

        }else{
            document.getElementById('errCalle').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<noExt.length;i++){
        if(patNum.test(noExt[i])){

        }else{
            document.getElementById('errNoExt').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<noInt.length;i++){
        if(patNum.test(noInt[i])){

        }else{
            document.getElementById('errNoInt').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }
    return verif;
}