package webdvan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdvan.models.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, String> {

}
