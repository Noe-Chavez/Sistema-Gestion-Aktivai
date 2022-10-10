package mx.com.uacm.aktivai.rest;

import mx.com.uacm.aktivai.model.Usuario;
import mx.com.uacm.aktivai.service.usuariosService.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usuario")
public class DetallesUsuarioRest {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping(path = "/detalle/{id}")
    public Usuario mostrarDetalleUsuario(@PathVariable("id") int idUsuario) {
        return usuariosService.buscarPorId(idUsuario);
    }

}
