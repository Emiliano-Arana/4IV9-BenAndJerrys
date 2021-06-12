function validarUsu(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-zñ0-9_-]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarPass(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[$%A-Za-zñáéíóú0-9_-]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

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
    document.getElementById('errNom').innerHTML = '';
    document.getElementById('errAppat').innerHTML = '';
    document.getElementById('errApmat').innerHTML = '';
    document.getElementById('errFN').innerHTML = '';
    document.getElementById('errTel').innerHTML = '';
    document.getElementById('errCel').innerHTML = '';
    document.getElementById('errUsu').innerHTML = '';
    document.getElementById('errPass').innerHTML = '';
    document.getElementById('errPass2').innerHTML = '';
    var verif = true;

    var nom = document.getElementById('Cname').value;
    var appat = document.getElementById('Cappat').value;
    var apmat = document.getElementById('Capmat').value;
    var fn = document.getElementById('Cfn').value;
    var tel = document.getElementById('Ctel').value;
    var cel = document.getElementById('Ccel').value;
    var usu = document.getElementById('Cusu').value;
    var usu = document.getElementById('Cusu').value;
    var contra = document.getElementById('Cpass').value;
    var contra2 = document.getElementById('Cpass2').value;

    var patNom = /[A-Za-zñáéíóú]/;
    var patNum = /[0-9]/;
    var patUsu = /[A-Za-z0-9_-]/;
    var patPass = /[$%A-Za-zñáéíóú0-9_-]/;

    if(contra==contra2){

    }else{
        verif = false;
        document.getElementById('errPass').innerHTML= "*Las contraseñas deben coincidir";
        document.getElementById('errPass2').innerHTML= "*Las contraseñas deben coincidir";
    }

    if(fn==""){
        verif = false;
        document.getElementById('errFN').innerHTML = "*Este campo es obligatorio";
    }

    if(nom.length<1){
        verif = false;
        document.getElementById('errNom').innerHTML = "*Este campo es obligatorio";
    }

    if(nom.length>40){
        verif = false;
        document.getElementById('errNom').innerHTML= "*El maximo de caracteres es de 40";
    }

    if(appat.length<1){
        verif = false;
        document.getElementById('errAppat').innerHTML = "*Este campo es obligatorio";
    }

    if(appat.length>20){
        verif = false;
        document.getElementById('errAppat').innerHTML= "*El maximo de caracteres es de 20";
    }

    if(apmat.length<1){
        verif = false;
        document.getElementById('errApmat').innerHTML = "*Este campo es obligatorio";
    }

    if(apmat.length>20){
        verif = false;
        document.getElementById('errApmat').innerHTML= "*El maximo de caracteres es de 20";
    }

    if(tel.length!=10){
        verif = false;
        document.getElementById('errTel').innerHTML= "*Ingrese un numero valido";
    }

    if(tel.length<1){
        verif = false;
        document.getElementById('errTel').innerHTML = "*Este campo es obligatorio";
    }

    if(cel.length!=10){
        verif = false;
        document.getElementById('errCel').innerHTML= "*Ingrese un numero valido";
    }

    if(cel.length<1){
        verif = false;
        document.getElementById('errCel').innerHTML = "*Este campo es obligatorio";
    }

    if(usu.length<1){
        verif = false;
        document.getElementById('errUsu').innerHTML = "*Este campo es obligatorio";
    }

    if(usu.length>20){
        verif = false;
        document.getElementById('errUsu').innerHTML= "*El maximo de caracteres es de 20";
    }

    if(contra2.length<5){
        verif = false;
        document.getElementById('errPass2').innerHTML= "*La contraseña debe tener por lo menos 5 caracteres";
    }

    if(contra2.length>20){
        document.getElementById('errPass2').innerHTML= "*El maximo de caracteres es de 20";
        verif = false;
    }

    if(contra.length<5){
        verif = false;
        document.getElementById('errPass').innerHTML= "*La contraseña debe tener por lo menos 5 caracteres";
    }

    if(contra.length>20){
        document.getElementById('errPass').innerHTML= "*El maximo de caracteres es de 20";
        verif = false;
    }

    for(var i=0;i<nom.length;i++){
        if(patNom.test(nom[i])){

        }else{
            document.getElementById('errNom').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<appat.length;i++){
        if(patNom.test(appat[i])){

        }else{
            document.getElementById('errAppat').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<apmat.length;i++){
        if(patNom.test(apmat[i])){

        }else{
            document.getElementById('errApmat').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<tel.length;i++){
        if(patNum.test(tel[i])){

        }else{
            document.getElementById('errTel').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<cel.length;i++){
        if(patNum.test(cel[i])){

        }else{
            document.getElementById('errCel').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<usu.length;i++){
        if(patUsu.test(usu[i])){

        }else{
            document.getElementById('errUsu').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<contra.length;i++){
        if(patPass.test(contra[i])){

        }else{
            document.getElementById('errPass').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<contra2.length;i++){
        if(patPass.test(contra2[i])){

        }else{
            document.getElementById('errPass2').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    return verif;
}