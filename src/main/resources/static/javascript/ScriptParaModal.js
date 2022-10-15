$(document).ready(function () {
    console.log("javascript y JQuery funcionando.");

    /*$('.botonDetallesUsuario').click(function (e) {
        console.log(e);

        let a = $('.idUsuarioTabla');
        
        console.log("------> " + a);

        let id = 12;
        $.ajax({
            url: `/api/usuario/detalle/${id}`,
            method: 'GET',
            success: data => {
                console.log(data.email);
                console.log(data);
            },
            error: function() {
                console.error("No existe el usario en la DB");
            }
        })
    });*/

    /* 
        Simular que se da click en el botón funcional al dar clik en guardar en el botón ficticio
        y poder guardar en base de datos.

    */
    $('#botonFuncional').hide();
    $('#botonFicticio').click(function (e) { 
        $('#botonFuncional').click();
    });
    
    /** 
     * Para colocar la palabra activa o inactivo en el formulario de detalles usuario
    */
    let switchDestalleUsuario = $('#flexSwitchCheckDefault');
    let switchDestalleUsuarioText = $('#flexSwitchCheckDefaultText');

    // colocar la palabra Activado o Bloqueado como el usaurio actual se encuentra.
    if (switchDestalleUsuario.is(':checked')) {
        switchDestalleUsuarioText.text('Activado');
    } else {
        switchDestalleUsuarioText.text('Bloqueado');
    }

    // cuando se cambia de manera dinámica el valor precionando el switch
    switchDestalleUsuario.change(function (e) {
        if (switchDestalleUsuario.is(':checked')) {
            switchDestalleUsuarioText.text('Activado');
        } else {
            switchDestalleUsuarioText.text('Bloqueado');
        }
    });

});