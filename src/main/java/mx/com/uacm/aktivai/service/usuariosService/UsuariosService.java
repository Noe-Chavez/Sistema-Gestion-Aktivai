package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.naming.NameNotFoundException;

@Service
public interface UsuariosService {
    List<Usuario> buscarTodosLosUsuarios();
    Usuario buscarPorId(Long idUsuario) throws NameNotFoundException;
    List<Usuario> buscarPorNombre(String nombre);
}
