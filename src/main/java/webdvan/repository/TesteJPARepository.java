package webdvan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webdvan.models.TesteJPA;

@Repository
public interface TesteJPARepository extends JpaRepository<TesteJPA, Long> {

	
}
