package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Rol;
import mx.com.uacm.aktivai.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public Rol buscarPorId(Integer id) {
        for (Rol rol: rolRepository.findAll())
            if (rol.getIdRol() == id) return rol;
        return null;
    }

    @Override
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    @Override
    public void guardarRol(Rol rol) {
        rolRepository.save(rol);
    }
}
