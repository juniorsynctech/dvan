package webdvan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdvan.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	public Usuario findByEmailAndSenha(String email,String senha);
	
}
