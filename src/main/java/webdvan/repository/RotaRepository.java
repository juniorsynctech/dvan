package webdvan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webdvan.models.Rota;

@Repository
public interface RotaRepository extends CrudRepository<Rota, String> {

}
