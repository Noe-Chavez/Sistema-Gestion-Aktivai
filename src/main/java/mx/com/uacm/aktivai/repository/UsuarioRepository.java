package mx.com.uacm.aktivai.repository;

import mx.com.uacm.aktivai.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE (u.nombre LIKE %?1%) OR (u.apellidoPaterno LIKE %?1%) OR (u.apellidoMaterno LIKE %?1%)")
    public List<Usuario> buscarPorPalabraClave(String palabraClave);

}
