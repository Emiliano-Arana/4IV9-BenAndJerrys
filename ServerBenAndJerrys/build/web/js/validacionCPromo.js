function validarNom(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-z%-]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarDatos(){
    var verif = true;

    var promo = document.getElementById('cPromo').value;

    var patNom = /[A-Za-z%-]/;

    if(promo.length<1){
        verif = false;
        alert('Necesitas Ingresar una promocion');
    }

    if(promo.length>5){
        verif = false;
        alert('El maximo de caracteres permitido es de 5');
    }

    for(var i=0;i<promo.length;i++){
        if(patNom.test(promo[i])){

        }else{
            alert('Ingresaste algun caracter no valido');
            verif = false;
        }
    }

    return verif;
}