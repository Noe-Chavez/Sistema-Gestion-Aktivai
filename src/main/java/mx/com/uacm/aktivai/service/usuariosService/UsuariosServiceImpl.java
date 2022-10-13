package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Rol;
import mx.com.uacm.aktivai.model.Usuario;
import mx.com.uacm.aktivai.model.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import javax.naming.NameNotFoundException;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    private List<Usuario> usuarioList;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuariosServiceImpl() {
    	Rol rol1 = new Rol((long) 1,"INSTALADOR","instalador");
    	Rol rol2 = new Rol((long) 2,"VENTAS","ventas");
    	Rol rol3 = new Rol((long) 3,"ADMIN","administrador");
    	Rol rol4 = new Rol((long) 4,"INGENIERIA","soporte/ingenieria");

        usuarioList = new ArrayList<>(4);

        Usuario a = new Usuario();
        a.setId((long)1);
        a.setNombre("Javier López");
        a.setRol(rol1);
        a.setFechaCreacion("23/08/2016");
        a.setEstatus(true);

        Usuario b = new Usuario();
        b.setId((long)2);
        b.setNombre("María Estrada");
        b.setRol(rol2);
        b.setFechaCreacion("14/02/2015");
        b.setEstatus(false);

        Usuario c = new Usuario();
        c.setId((long)3);
        c.setNombre("Rodolfo Escutia");
        c.setRol(rol3);
        c.setFechaCreacion("25/06/2020");
        c.setEstatus(true);

        Usuario d = new Usuario();
        d.setId((long)4);
        d.setNombre("Laura Martinez");
        d.setRol(rol4);
        d.setFechaCreacion("09/09/2009");
        d.setEstatus(true);

        usuarioList.add(a);
        usuarioList.add(b);
        usuarioList.add(c);
        usuarioList.add(d);
    }

    @Override
    public List<Usuario> buscarTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long idUsuario) throws NameNotFoundException {
    	Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
    	if(usuario.isEmpty()) {
			throw new NameNotFoundException("Usuario no encontrado");
		}
    	return usuario.get();
    }

	@Override
	public List<Usuario> buscarPorNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}
    
    

}
