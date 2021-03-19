package wasserballturnier.api.persistence.spiel;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpielRepository extends CrudRepository<Spiel, Long> {

    List<Spiel> findAll();
}
