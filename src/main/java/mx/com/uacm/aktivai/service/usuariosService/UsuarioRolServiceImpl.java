package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.UsuarioRol;
import mx.com.uacm.aktivai.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Override
    public void guardarUsuarioRol(UsuarioRol usuarioRol) {
        usuarioRolRepository.save(usuarioRol);
    }

    @Override
    public UsuarioRol obtenerUsuarioRolPorElidUsuario(Integer idUsuario) {
        return usuarioRolRepository.findByidUsuario(idUsuario);
    }

    @Override
    public void eliminarUsuarioRol(UsuarioRol usuarioRol) {
        usuarioRolRepository.delete(usuarioRol);
    }
}
