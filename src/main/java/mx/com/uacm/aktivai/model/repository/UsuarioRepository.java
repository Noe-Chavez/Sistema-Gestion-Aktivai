package mx.com.uacm.aktivai.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.uacm.aktivai.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByMail(String mail);
	
	public List<Usuario> findAll();
	
	public List<Usuario> findByNombre(String nombre);
	
	public Optional<Usuario> findById(Long id);

}
