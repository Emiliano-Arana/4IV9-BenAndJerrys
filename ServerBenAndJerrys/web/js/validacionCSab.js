function validarNom(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-zñáéíóú]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarDatos(){
    var verif = true;

    var sabor = document.getElementById('cSabor').value;

    var patNom = /[A-Za-zñáéíóú]/;

    if(sabor.length<1){
        verif = false;
        alert('Necesitas Ingresar un sabor');
    }

    if(sabor.length>30){
        verif = false;
        alert('El maximo de caracteres permitido es de 30');
    }

    for(var i=0;i<sabor.length;i++){
        if(patNom.test(sabor[i])){

        }else{
            alert('Ingresaste algun caracter no valido');
            verif = false;
        }
    }

    return verif;
}