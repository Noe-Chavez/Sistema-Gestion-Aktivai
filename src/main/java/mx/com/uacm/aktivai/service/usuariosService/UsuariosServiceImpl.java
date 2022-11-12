package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Usuario;
import mx.com.uacm.aktivai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

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

    @Override
    public Page<Usuario> obtenerTodosLosUsuarioPaginados(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public List<Usuario> buscarPorPalabraClave(String palabraClave) {
        return usuarioRepository.buscarPorPalabraClave(palabraClave);
    }

}
