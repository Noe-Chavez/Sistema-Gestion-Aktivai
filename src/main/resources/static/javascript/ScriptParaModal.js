$(document).ready(function () {
    console.log("javascript y JQuery funcionando.");

    /*$('.botonDetallesUsuario').click(function (e) {
        $.ajax({
            url: '/usuarios/detalle/1',
            method: 'GET',
            success: data => {
                console.log(data);
            }

        })
    });*/

    /* 
        Simular que se da click en el botón funcional al dar clik en guardar en el botón dicticio
        y poder guardar en base de datos.

    */
    $('#botonFuncional').hide();
    $('#botonFicticio').click(function (e) { 
        $('#botonFuncional').click();
    });

});