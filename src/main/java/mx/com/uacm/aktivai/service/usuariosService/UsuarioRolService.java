package mx.com.uacm.aktivai.service.usuariosService;

import mx.com.uacm.aktivai.model.UsuarioRol;

public interface UsuarioRolService {

    public void guardarUsuarioRol(UsuarioRol usuarioRol);

    public UsuarioRol obtenerUsuarioRolPorElidUsuario(Integer idUsuario);

    public void eliminarUsuarioRol(UsuarioRol usuarioRol);

}
