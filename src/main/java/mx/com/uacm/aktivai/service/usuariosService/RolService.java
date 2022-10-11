package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.Rol;

import java.util.List;

public interface RolService {

    public Rol buscarPorId(Integer id);
    public List<Rol> obtenerTodos();

    public void guardarRol(Rol rol);

}
