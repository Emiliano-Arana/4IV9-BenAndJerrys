function validarNum(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[0-9]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarNumF(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[0-9.]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarDatos(){
    document.getElementById('errPrecio').innerHTML = '';
    document.getElementById('errStock').innerHTML = '';
    var verif = true;
    var contP = 0;

    var stock = document.getElementById('stockH').value;
    var precio = document.getElementById('precioH').value;

    var patNum = /[0-9]/;
    var patNumF = /[0-9.]/;

    if(stock.length<1){
        verif = false;
        document.getElementById('errStock').innerHTML = "*Este campo es obligatorio";
    }

    if(stock.length>5){
        verif = false;
        document.getElementById('errStock').innerHTML= "*El maximo de digitos es de 5";
    }

    if(precio.length<1){
        verif = false;
        document.getElementById('errPrecio').innerHTML = "*Este campo es obligatorio";
    }

    if(precio.length>7){
        verif = false;
        document.getElementById('errPrecio').innerHTML= "*El maximo de caracteres es de 7";
    }

    for(var i=0;i<precio.length;i++){
        if(patNumF.test(precio[i])){
            if(precio[i]=="."){
                contP += 1;
            }
        }else{
            document.getElementById('errPrecio').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    for(var i=0;i<stock.length;i++){
        if(patNum.test(stock[i])){

        }else{
            document.getElementById('errStock').innerHTML= "*Ingreso algun caracter invalido";
            verif = false;
        }
    }

    if(contP>=2){
        document.getElementById('errPrecio').innerHTML= "*Ingreso mas de 1 vez el punto";
    }

    return verif;
}