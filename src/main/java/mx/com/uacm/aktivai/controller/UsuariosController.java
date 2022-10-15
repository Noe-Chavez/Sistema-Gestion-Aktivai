package mx.com.uacm.aktivai.controller;

import mx.com.uacm.aktivai.model.Rol;
import mx.com.uacm.aktivai.model.Usuario;
import mx.com.uacm.aktivai.model.UsuarioRol;
import mx.com.uacm.aktivai.service.usuariosService.RolService;
import mx.com.uacm.aktivai.service.usuariosService.UsuarioRolService;
import mx.com.uacm.aktivai.service.usuariosService.UsuariosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private RolService rolService;
    @Autowired
    private UsuarioRolService usuarioRolService;

    Logger logger = LoggerFactory.getLogger(UsuariosController.class);

    @GetMapping("/tablaUsuarios")
    public String tableUsers(Model model) {
        logger.info("******** Entrando al metodo tableUsers ********");
        model.addAttribute("usuarios", usuariosService.buscarTodosLosUsuarios());
        model.addAttribute("roles", rolService.obtenerTodos());
        return "usuarios/listaUsuarios";
    }

    @GetMapping("/crear")
        public String crearUsuario(Usuario usuario) { // es necesario el parametro para manejar los errores
        logger.info("******** Entrando al metodo crearUsuario ********");
        return "usuarios/formularioUsuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        logger.info("******** Entrando al metodo guardarUsuario ********");
        if (bindingResult.hasErrors()){ // si hay errores renderizamos el mismo formulario.
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });
            return "usuarios/tablaUsuarios";
        }
        usuariosService.guardarUsuario(usuario);
        logger.info("Usuario: " + usuario);
        Rol rol = rolService.buscarRolPorNombre(usuario.getRol());
        logger.info("Rol: " + rol);
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setIdUsuario(usuario.getIdUsuario());
        usuarioRol.setIdRol(rol.getIdRol());
        logger.info("UsuarioRol: " + usuarioRol);
        usuarioRolService.guardarUsuarioRol(usuarioRol);
        redirectAttributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:tablaUsuarios";
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(Usuario usuario) {
        logger.info("******** Entrando al metodo guardarUsuario ********");
        usuariosService.guardarUsuario(usuario);
        return "redirect:tablaUsuarios";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalleUsuario(@PathVariable("id") int idUsuario, Model model) {
        logger.info("******** Entrando al metodo mostrarDetalleUsuario ********");
        Usuario usuario = usuariosService.buscarPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        logger.info("Usuario: " + usuario);
        return "usuarios/detallesUsuario";
    }

    @GetMapping("/eliminar")
    public String eliminarUsuario(@RequestParam("id") int idUsuario) {
        logger.info("******** Entrando al metodo eliminarUsuario ********");
        UsuarioRol usuarioRol = usuarioRolService.obtenerUsuarioRolPorElidUsuario(idUsuario);
        usuarioRolService.eliminarUsuarioRol(usuarioRol);
        usuariosService.eleminarUsuario(idUsuario);
        return "usuarios/listaUsuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUusario(@PathVariable("id") int idUsuario, Model model) {
        logger.info("******** Entrando al metodo editarUusario ********");
        List<Rol> roles = rolService.obtenerTodos();
        model.addAttribute("roles", roles);
        logger.info("Roles: " + roles);
        Usuario usuario = usuariosService.buscarPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        logger.info("Usuario: " + usuario);

        return "usuarios/editarUsuario";
    }

}
