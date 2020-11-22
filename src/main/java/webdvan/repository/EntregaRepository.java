package webdvan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webdvan.models.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

	public List<Entrega> findByIdCliente(Long id);
	public List<Entrega> findByIdAssociado(Long id);
}
