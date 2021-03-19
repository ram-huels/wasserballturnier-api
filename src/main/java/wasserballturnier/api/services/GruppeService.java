package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.gruppe.GruppeRepository;

import java.util.List;

@Service
public class GruppeService {

    private GruppeRepository gruppeRepository;

    public GruppeService(GruppeRepository gruppeRepository) {
        this.gruppeRepository = gruppeRepository;
    }

    public void setGruppe(Gruppe gruppe){
        this.gruppeRepository.save(gruppe);
    }

    public List<Gruppe> getGruppen(){
        return this.gruppeRepository.findAll();
    }
}
