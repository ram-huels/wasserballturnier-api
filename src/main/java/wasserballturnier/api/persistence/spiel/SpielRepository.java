package wasserballturnier.api.persistence.spiel;

import org.springframework.data.repository.CrudRepository;
import wasserballturnier.api.generated.model.Spielwert;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;

import java.util.List;

public interface SpielRepository extends CrudRepository<Spiel, Long> {

    List<Spiel> findAll();

    List<Spiel> findAllBySpielwert(Spielwert spielwert);

    List<Spiel> findAllBySpielwertAndHeimmannschaft_Mannschaftsklasse(Spielwert spielwert, Mannschaftsklasse mannschaftsklasse);
}
