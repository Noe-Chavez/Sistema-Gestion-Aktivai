package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuariosService {
    List<Usuario> buscarTodosLosUsuarios();
    Usuario buscarPorId(Integer idUsuario);
    void guardarUsuario(Usuario usuario);
    void eleminarUsuario(int id);
    Page<Usuario> obtenerTodosLosUsuarioPaginados(Pageable pageable);
    public List<Usuario> buscarPorPalabraClave(String email);
}
