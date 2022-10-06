package mx.com.uacm.aktivai.controller;

import mx.com.uacm.aktivai.model.Usuario;
import mx.com.uacm.aktivai.service.usuariosService.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/tablaUsuarios")
    public String tableUsers(Model model) {
        model.addAttribute("usuarios", usuariosService.buscarTodosLosUsuarios());
        return "usuarios/listaUsuarios";
    }

    @GetMapping("/crear")
        public String crearUsuario(Usuario usuario) { // es necesario el parametro para manejar los errores
        return "usuarios/formularioUsuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){ // si hay errores renderizamos el mismo formulario.
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });
            return "usuarios/formularioUsuario";
        }
        usuariosService.guardarUsuario(usuario);
        redirectAttributes.addFlashAttribute("msg", "Registro Guardado");
        System.out.println(usuario);
        return "redirect:/usuarios/tablaUsuarios";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalleUsuario(@PathVariable("id") int idUsuario, Model model) {
        Usuario usuario = usuariosService.buscarPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        System.out.println(usuario);
        return "usuarios/detallesUsuario";
    }

    @GetMapping("/eliminar")
    public String eliminarUsuario(@RequestParam("id") int idUsuario) {
        System.out.println("borrando el usuario con id " + idUsuario);
        usuariosService.eleminarUsuario(idUsuario);
        return "usuarios/listaUsuarios";
    }

}
