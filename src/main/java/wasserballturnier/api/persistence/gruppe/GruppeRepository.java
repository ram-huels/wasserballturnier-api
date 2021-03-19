package wasserballturnier.api.persistence.gruppe;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GruppeRepository extends CrudRepository<Gruppe, Long> {

    List<Gruppe> findAll();
}
