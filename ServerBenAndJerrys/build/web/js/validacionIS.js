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

function validarDatos(){
    document.getElementById('errUsu').innerHTML = '';
    document.getElementById('errPass').innerHTML = '';
    var verif = true;

    var usu = document.getElementById('Cusu').value;
    var contra = document.getElementById('Cpass').value;

    var patUsu = /[A-Za-z0-9_-]/;
    var patPass = /[$%A-Za-zñáéíóú0-9_-]/;

    if(usu.length<1){
        verif = false;
        document.getElementById('errUsu').innerHTML = "*Este campo es obligatorio";
    }

    if(usu.length>20){
        verif = false;
        document.getElementById('errUsu').innerHTML= "*Ingreso demasiados caracteres";
    }

    if(contra.length<5){
        verif = false;
        document.getElementById('errPass').innerHTML= "*La contraseña debe tener por lo menos 5 caracteres";
    }

    if(contra.length>20){
        document.getElementById('errPass').innerHTML= "*Ingreso demasiados caracteres";
        verif = false;
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

    return verif;
}