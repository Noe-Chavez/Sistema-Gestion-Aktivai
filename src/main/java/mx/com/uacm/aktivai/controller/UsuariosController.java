package mx.com.uacm.aktivai.controller;

import mx.com.uacm.aktivai.model.Rol;
import mx.com.uacm.aktivai.model.Usuario;
import mx.com.uacm.aktivai.service.usuariosService.RolService;
import mx.com.uacm.aktivai.service.usuariosService.UsuarioRolService;
import mx.com.uacm.aktivai.service.usuariosService.UsuariosService;
import mx.com.uacm.aktivai.utilities.UtileriaImagenesAvatar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Value("${aktivai.ruta.avatars}")
    private String rutaAvatars;

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

    @GetMapping("/tablaUsuariosPaginada")
    public String tablaUsuariosPaginada(Model model, Pageable pageable) {
        logger.info("******** Entrando al metodo  tablaUsuariosPaginada ********");
        Page<Usuario> usuariosPaginados = usuariosService.obtenerTodosLosUsuarioPaginados(pageable);
        model.addAttribute("usuarios", usuariosPaginados);
        return "usuarios/listaUsuarios";
    }

    @GetMapping("/crear")
        public String crearUsuario(Usuario usuario) { // es necesario el parametro para manejar los errores
        logger.info("******** Entrando al metodo crearUsuario ********");
        return "usuarios/formularioUsuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes, @RequestParam("imagenAvatarUsuario") MultipartFile multiPart) {

        logger.info("******** Entrando al metodo guardarUsuario ********");

        if (bindingResult.hasErrors()){ // si hay errores renderizamos el mismo formulario.
            bindingResult.getAllErrors().forEach(error -> {
                logger.error(error.getDefaultMessage());
            });
            return "usuarios/tablaUsuarios";
        }

        if (!multiPart.isEmpty()) {
            String nombreImagen = UtileriaImagenesAvatar.guardarArchivo(multiPart, rutaAvatars);
            if (nombreImagen != null){ // valida si la imagen se subio o no
                usuario.setAvatar(nombreImagen);
            }
        } else {
            usuario.setAvatar("Image_avatar.png");
        }

        // Asignar fecha de creación obteneida del sistema.
        Date fechaSistema = new Date();
        usuario.setFechaCreacion(fechaSistema);
        usuariosService.guardarUsuario(usuario);
        logger.info("Usuario: " + usuario);
        redirectAttributes.addFlashAttribute("msg", "Registro Guardado");

        return "redirect:tablaUsuarios";
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes, @RequestParam("imagenAvatarUsuario") MultipartFile multiPart) {

        logger.info("******** Entrando al metodo guardarUsuario ********");

        if (bindingResult.hasErrors()){ // si hay errores renderizamos el mismo formulario.
            bindingResult.getAllErrors().forEach(error -> {
                logger.error(error.getDefaultMessage());
            });
            return "usuarios/editarUsuario";
        }

        if (!multiPart.isEmpty()) {
            //String uri = "/aktivai/img-avatars/"; // Linux/MAC
            //String uri = "c:/aktivai/img-avatars/"; // Windows
            //String nombreImagen = UtileriaImagenesAvatar.guardarArchivo(multiPart, uri);
            String nombreImagen = UtileriaImagenesAvatar.guardarArchivo(multiPart, rutaAvatars);
            if (nombreImagen != null){ // valida si la imagen se subio o no
                usuario.setAvatar(nombreImagen);
            }
        }

        usuariosService.guardarUsuario(usuario);
        redirectAttributes.addFlashAttribute("msg", "Registro se ha actualizado corectamente");

        return "redirect:tablaUsuarios";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalleUsuario(@PathVariable("id") int idUsuario, Model model) {
        logger.info("******** Entrando al metodo mostrarDetalleUsuario ********");
        Usuario usuario = usuariosService.buscarPorId(idUsuario);
        usuario = usuariosService.buscarPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        logger.info("Usuario: " + usuario);
        return "usuarios/detallesUsuario";
    }

    @GetMapping("/eliminar")
    public String eliminarUsuario(@RequestParam("id") int idUsuario) {
        logger.info("******** Entrando al metodo eliminarUsuario ********");
        usuariosService.eleminarUsuario(idUsuario);
        return "usuarios/listaUsuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsario(@PathVariable("id") int idUsuario, Model model) {
        logger.info("******** Entrando al metodo editarUsario ********");
        List<Rol> roles = rolService.obtenerTodos();
        model.addAttribute("roles", roles);
        logger.info("Roles: " + roles);
        Usuario usuario = usuariosService.buscarPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        logger.info("Usuario: " + usuario);

        return "usuarios/editarUsuario";
    }

    @GetMapping(path = "/buscar")
    public String buscar(@Param("palabraClave") String palabraClave, Model model) {
        logger.info("Entrando al método buscar");
        System.out.println("**** " + palabraClave + " ****");
        List<Usuario> usuarios = usuariosService.buscarPorPalabraClave(palabraClave);
        System.out.println("*****" + usuarios + "*****");
        model.addAttribute("usuarios",usuarios);
        model.addAttribute("roles", rolService.obtenerTodos());
        model.addAttribute("palabraClave", palabraClave);
        return "usuarios/listaUsuarios";
    }

}
