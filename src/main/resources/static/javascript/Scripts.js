$(document).ready(function () {
    console.log("javascript y JQuery funcionando.");
    
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

    // Ocultar la sección que muestra el id del usuario en detalles Usuario.
    $('#idUsuario').hide();
    
    // Ocultar el inputNameAvatar para que el usuario no pueda modificar el nombre.
    $('#inputNameAvatar').hide();

});