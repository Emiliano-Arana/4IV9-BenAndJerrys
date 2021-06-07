function validarNom(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-zñáéíóú]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarDatos(){
    var verif = true;

    var tam = document.getElementById('cTamano').value;

    var patNom = /[A-Za-zñáéíóú]/;

    if(tam.length<1){
        verif = false;
        alert('Necesitas Ingresar un tamaño');
    }

    if(tam.length>15){
        verif = false;
        alert('El maximo de caracteres permitido es de 15');
    }

    for(var i=0;i<tam.length;i++){
        if(patNom.test(tam[i])){

        }else{
            alert('Ingresaste algun caracter no valido');
            verif = false;
        }
    }

    return verif;
}