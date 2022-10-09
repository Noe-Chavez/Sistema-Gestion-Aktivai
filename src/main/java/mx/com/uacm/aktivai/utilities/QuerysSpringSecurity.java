package mx.com.uacm.aktivai.utilities;

public class QuerysSpringSecurity {

    public static String QueryParaUsuario() {
        return "SELECT usuario, password, estatus \n" +
                "FROM Usuarios\n" +
                "WHERE usuario = ?";
    }

    public static String queryParaRolesPorUsuario() {
        return "SELECT u.usuario, r.rol FROM usuarios_roles ur\n" +
                "INNER JOIN Usuarios u ON u.id_usuario = ur.usuario_id\n" +
                "INNER JOIN roles r ON id_rol = ur.rol_id\n" +
                "WHERE u.usuario = ?";
    }

}
