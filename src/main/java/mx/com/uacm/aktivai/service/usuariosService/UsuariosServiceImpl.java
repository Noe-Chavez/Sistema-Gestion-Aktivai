package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Usuario;
import mx.com.uacm.aktivai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuariosServiceImpl() {
    }

    @Override
    public List<Usuario> buscarTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Integer idUsuario) {
        for (Usuario usuario: usuarioRepository.findAll())
            if (usuario.getIdUsuario() == idUsuario) return usuario;
        return null;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eleminarUsuario(int id) {
        Optional<Usuario> usuarioAEliminar = usuarioRepository.findById(id);
        usuarioAEliminar.ifPresent(usuario -> usuarioRepository.delete(usuario));
    }

}
