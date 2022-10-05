package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    private List<Usuario> usuarioList;

    public UsuariosServiceImpl() {

        usuarioList = new ArrayList<>(4);

        Usuario a = new Usuario();
        a.setId(1);
        a.setNombre("Javier López");
        a.setRol("Instalador");
        a.setFechaCreacion("23/08/2016");
        a.setEstatus(true);

        Usuario b = new Usuario();
        b.setId(2);
        b.setNombre("María Estrada");
        b.setRol("Ventas");
        b.setFechaCreacion("14/02/2015");
        b.setEstatus(false);

        Usuario c = new Usuario();
        c.setId(3);
        c.setNombre("Rodolfo Escutia");
        c.setRol("Cobranza");
        c.setFechaCreacion("25/06/2020");
        c.setEstatus(true);

        Usuario d = new Usuario();
        d.setId(4);
        d.setNombre("Laura Martinez");
        d.setRol("Soporte/Ingeniería");
        d.setFechaCreacion("09/09/2009");
        d.setEstatus(true);

        usuarioList.add(a);
        usuarioList.add(b);
        usuarioList.add(c);
        usuarioList.add(d);
    }

    @Override
    public List<Usuario> buscarTodosLosUsuarios() {
        return usuarioList;
    }

    @Override
    public Usuario buscarPorId(Integer idUsuario) {
        for (Usuario usuario: usuarioList)
            if (usuario.getId() == idUsuario) return usuario;
        return null;
    }

}
