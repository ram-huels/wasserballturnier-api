package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.persistence.spiel.SpielRepository;

import java.util.List;

@Service
public class SpielService {

    private SpielRepository spielRepository;

    public SpielService(SpielRepository spielRepository) {
        this.spielRepository = spielRepository;
    }

    public void addSpiel(Spiel spiel){
        this.spielRepository.save(spiel);
    }

    public List<Spiel> getSpiele(){
        return this.spielRepository.findAll();
    }

    public void updateSpiel(long id, int heimtore, int auswaertstore){
        Spiel spiel = this.spielRepository.findById(id).orElse(null);
        spiel.updateSpiel(heimtore, auswaertstore);
    }
}
