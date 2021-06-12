function validarFE(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[0-9/]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarNom(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-zñáéíóú ]/;
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
    document.getElementById('errNTar').innerHTML = '';
    document.getElementById('errNom').innerHTML = '';
    document.getElementById('errFE').innerHTML = '';
    document.getElementById('errCod').innerHTML = '';
    
    var verif = true;
    var contDiag = 0;

    var numTar = document.getElementById('numTar').value;
    var nom = document.getElementById('nomP').value;
    var fe = document.getElementById('FE').value;
    var cod = document.getElementById('codCvc').value;

    var patNom = /[A-Za-zñáéíóú]/;
    var patNum = /[0-9]/;
    var patFE = /[0-9/]/;

    if(nom.length<1){
        verif = false;
        document.getElementById('errNom').innerHTML = "*Este campo es obligatorio";
    }

    if(nom.length>80){
        verif = false;
        document.getElementById('errNom').innerHTML= "*El maximo de caracteres es de 80";
    }

    if(numTar.length<1){
        verif = false;
        document.getElementById('errNTar').innerHTML = "*Este campo es obligatorio";
    }

    if(numTar.length>19){
        verif = false;
        document.getElementById('errNTar').innerHTML= "*El maximo de caracteres es de 19";
    }

    if(fe.length<1){
        verif = false;
        document.getElementById('errFE').innerHTML = "*Este campo es obligatorio";
    }

    if(fe.length>5){
        verif = false;
        document.getElementById('errFE').innerHTML= "*El maximo de caracteres es de 5";
    }

    if(cod.length<3){
        verif = false;
        document.getElementById('errCod').innerHTML= "*El cvc debe tener por lo menos 3 numeros";
    }

    if(cod.length>4){
        document.getElementById('errCod').innerHTML= "*El maximo de caracteres es de 20";
        verif = false;
    }

    for(var i=0;i<nom.length;i++){
        if(patNom.test(nom[i])){

        }else{
            document.getElementById('errNom').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<numTar.length;i++){
        if(patNum.test(numTar[i])){

        }else{
            document.getElementById('errNTar').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<fe.length;i++){
        if(patFE.test(fe[i])){
            if(fe[i]=='/'){
                contDiag += 1;
            }
        }else{
            document.getElementById('errFE').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<cod.length;i++){
        if(patNum.test(cod[i])){

        }else{
            document.getElementById('errCod').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    if(contDiag>=2){
        document.getElementById('errFE').innerHTML= "*Ingreso mas de 1 vez el caracter '/'";
        verif = false;
    }

    return verif;
}