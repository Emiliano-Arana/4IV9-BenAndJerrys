function validarNum(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[0-9]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarDatos(){
    var text = document.getElementById('buscarBD').value;
    var verif = true,verifCI = false,verif2 = true;
    var patNum = /[0-9]/;

    if(text.length>5){
        verif = false;
        verif2 = false;
        alert('El ID es un numero muy grande');
    }

    for(var i=0;i<text.length;i++){
        if(patNum.test(text[i])){

        }else{
            verif = false;
            verifCI = true;
        }
    }
    if(verif2){
        if(verifCI){
            alert('Ingreso algun caracter no valido');
        }
    }

    return verif;
}