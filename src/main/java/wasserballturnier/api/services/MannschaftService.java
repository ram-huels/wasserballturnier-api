package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.mannschaft.MannschaftRepository;

import java.util.List;

@Service
public class MannschaftService {

    private MannschaftRepository mannschaftRepository;

    public MannschaftService(MannschaftRepository mannschaftRepository) {
        this.mannschaftRepository = mannschaftRepository;
    }

    public void addMannschaft(Mannschaft mannschaft){
        this.mannschaftRepository.save(mannschaft);
    }

    public List<Mannschaft> getMannschaften(){
        return this.mannschaftRepository.findAll();
    }
}
