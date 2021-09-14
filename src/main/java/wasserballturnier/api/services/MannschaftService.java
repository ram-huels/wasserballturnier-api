package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.generated.model.MannschaftPushTO;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.mannschaft.MannschaftRepository;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;
import wasserballturnier.api.services.mapping.MannschaftMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class MannschaftService {

    private final MannschaftRepository mannschaftRepository;

    private final MannschaftMapper mannschaftMapper;

    public MannschaftService(MannschaftRepository mannschaftRepository, MannschaftMapper mannschaftMapper) {
        this.mannschaftRepository = mannschaftRepository;
        this.mannschaftMapper = mannschaftMapper;
    }

    public Integer addMannschaft(MannschaftPushTO body){
        return mannschaftRepository.save(mannschaftMapper.entityFromPushTO(body)).getId();
    }

    public List<Mannschaft> getMannschaften(){
        return this.mannschaftRepository.findAll();
    }

    public List<Mannschaft> getHerrenMannschaften(){
        return this.mannschaftRepository.findAllByMannschaftsklasse(Mannschaftsklasse.HERREN);
    }

    public List<Mannschaft> getDamenMannschaften(){
        return this.mannschaftRepository.findAllByMannschaftsklasse(Mannschaftsklasse.DAMEN);
    }

    public List<Mannschaft> getJugendMannschaften(){
        return this.mannschaftRepository.findAllByMannschaftsklasse(Mannschaftsklasse.JUGEND);
    }

    public List<List<Mannschaft>> getMannschaftenSortiert(){
        List<List<Mannschaft>> m = new ArrayList<>();
        m.add(this.getHerrenMannschaften());
        m.add(this.getDamenMannschaften());
        m.add(this.getJugendMannschaften());
        return m;
    }
}
