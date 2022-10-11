package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Usuario;

import java.util.List;

public interface UsuariosService {
    List<Usuario> buscarTodosLosUsuarios();
    Usuario buscarPorId(Integer idUsuario);
    void guardarUsuario(Usuario usuario);
    void eleminarUsuario(int id);
}
