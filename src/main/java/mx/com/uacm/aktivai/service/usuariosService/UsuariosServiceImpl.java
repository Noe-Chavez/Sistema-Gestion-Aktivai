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

    //private List<Usuario> usuarioList;

    public UsuariosServiceImpl() {

        /*usuarioList = new ArrayList<>();

        Usuario a = new Usuario();
        a.setIdUsuario(1);
        a.setNombre("Javier López");
        a.setRol("Instalador");
        a.setEmail("23/08/2016");
        a.setEstatus(true);

        Usuario b = new Usuario();
        b.setIdUsuario(2);
        b.setNombre("María Estrada");
        b.setRol("Ventas");
        b.setEmail("14/02/2015");
        b.setEstatus(false);

        Usuario c = new Usuario();
        c.setIdUsuario(3);
        c.setNombre("Rodolfo Escutia");
        c.setRol("Cobranza");
        c.setEmail("25/06/2020");
        c.setEstatus(true);

        Usuario d = new Usuario();
        d.setIdUsuario(4);
        d.setNombre("Laura Martinez");
        d.setRol("Soporte/Ingeniería");
        d.setEmail("09/09/2009");
        d.setEstatus(true);

        usuarioList.add(a);
        usuarioList.add(b);
        usuarioList.add(c);
        usuarioList.add(d);*/
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
