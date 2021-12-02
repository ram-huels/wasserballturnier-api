package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.gruppe.GruppeRepository;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class GruppeService {

    private GruppeRepository gruppeRepository;

    private MannschaftService mannschaftService;

    private SpielService spielService;

    public GruppeService(GruppeRepository gruppeRepository, MannschaftService mannschaftService, SpielService spielService) {
        this.gruppeRepository = gruppeRepository;
        this.mannschaftService = mannschaftService;
        this.spielService = spielService;
    }

    public void addGruppe(Gruppe gruppe){
        this.gruppeRepository.save(gruppe);
    }

    public List<Gruppe> getGruppen(){
        List<Gruppe> toBeSorted = this.gruppeRepository.findAll();

        // Check if it works
        for (Gruppe g: toBeSorted) {
            // Sorting list after Punkte, Tordifferenz, Tore and Gegentore in descending weight
            g.getMannschaftList().sort(Comparator.comparing(Mannschaft::getPunkte)
                    .thenComparing(m -> m.getTore() - m.getGegentore())
                    .thenComparing(Mannschaft::getTore)
                    .thenComparing(Mannschaft::getGegentore));
        }

        return toBeSorted;
    }

    public List<Gruppe> getXGruppen(Mannschaftsklasse mannschaftsklasse) {
        List<Gruppe> alleGruppen = getGruppen();

        alleGruppen.removeIf(gruppe -> gruppe.getMannschaftList().get(0).getMannschaftsklasse() != mannschaftsklasse);

        return alleGruppen;
    }

    public void randomGruppen(int gruppengroesse) {
        this.gruppeRepository.deleteAll();
        List<List<Mannschaft>> listAll = this.mannschaftService.getMannschaftenSortiert();

        for (List<Mannschaft> mannschaftenToBeGroups: listAll) {
            Collections.shuffle(mannschaftenToBeGroups);

            for (int i = 0; i+1 < mannschaftenToBeGroups.size(); i += gruppengroesse){
                Gruppe gruppe = new Gruppe();
                if (i+gruppengroesse < mannschaftenToBeGroups.size()){
                    gruppe.setMannschaftList(mannschaftenToBeGroups.subList(i, i+gruppengroesse));
                } else {
                    gruppe.setMannschaftList(mannschaftenToBeGroups.subList(i, mannschaftenToBeGroups.size()));
                }

                addGruppe(gruppe);
            }
        }

        this.spielService.createGruppenSpiele(this.gruppeRepository.findAll());
    }
}
