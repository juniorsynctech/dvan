package webdvan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webdvan.models.Cidades;

@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Long> {

}
