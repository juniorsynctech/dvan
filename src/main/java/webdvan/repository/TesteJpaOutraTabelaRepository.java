package webdvan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webdvan.models.TesteJpaOutraTabela;

@Repository
public interface TesteJpaOutraTabelaRepository extends JpaRepository<TesteJpaOutraTabela, Long> {

	
}
