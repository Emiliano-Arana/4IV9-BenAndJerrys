function validarLetras(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-z]/;
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
    var verif = true;

    var value = document.getElementById('cCant').value;
    var unit = document.getElementById('cUnit').value;

    var patNum = /[0-9]/;
    var patLetras = /[A-Za-z]/;

    if(value.length<1){
        verif = false;
        alert('Necesitas Ingresar una cantidad');
    }

    if(value.length>3){
        verif = false;
        alert('El maximo de caracteres permitido para cantidad es de 3');
    }

    if(unit.length<1){
        verif = false;
        alert('Necesitas Ingresar una unidad');
    }

    if(unit.length>2){
        verif = false;
        alert('El maximo de caracteres permitido para unidad es de 2');
    }

    for(var i=0;i<value.length;i++){
        if(patNum.test(value[i])){

        }else{
            alert('Ingresaste algun caracter no valido en cantidad');
            verif = false;
        }
    }

    for(var i=0;i<unit.length;i++){
        if(patLetras.test(unit[i])){

        }else{
            alert('Ingresaste algun caracter no valido en unidad');
            verif = false;
        }
    }

    return verif;
}