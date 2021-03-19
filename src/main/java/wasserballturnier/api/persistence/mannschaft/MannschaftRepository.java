package wasserballturnier.api.persistence.mannschaft;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MannschaftRepository extends CrudRepository<Mannschaft, Long> {

    List<Mannschaft> findAll();
}
