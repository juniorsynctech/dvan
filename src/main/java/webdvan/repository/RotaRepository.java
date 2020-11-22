package webdvan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webdvan.models.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {

	public List<Rota> findByCidadeDestino(String cidadeDestino);
	
	public List<Rota> findByConsultaContaining(String cidadeDestino);
	
	public List<Rota> findByIdUsuario(Long id);
}
