package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.generated.model.Spielwert;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.gruppe.GruppeRepository;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.persistence.spiel.SpielRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class GruppeService {

    private GruppeRepository gruppeRepository;

    private MannschaftService mannschaftService;

    private SpielRepository spielRepository;

    public GruppeService(GruppeRepository gruppeRepository, MannschaftService mannschaftService, SpielRepository spielRepository) {
        this.gruppeRepository = gruppeRepository;
        this.mannschaftService = mannschaftService;
        this.spielRepository = spielRepository;
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

        createGruppenSpiele();
    }

    /*
Diese Methode erzeugt alle Spiel ohne Reihenfolge für eine Gruppe
 */
    public void createGruppenSpiele(){

        List<Gruppe> gruppen = this.gruppeRepository.findAll();

        for (Gruppe gruppe: gruppen) {

            List<Spiel> spielList = new ArrayList<>();

            for(int i = 0; i < gruppe.getMannschaftList().size(); i++){
                for (int j = i+1; j < gruppe.getMannschaftList().size(); j++){
                    // Alle Spiele einer Gruppe ohne Sortierung
                    spielList.add(new Spiel(gruppe.getMannschaftList().get(i), gruppe.getMannschaftList().get(j), Spielwert.GRUPPENSPIEL));
                }
            }

            // Spiele speichern
            for (Spiel spiel: spielList) {
                this.spielRepository.save(spiel);
            }

            // Spiele der Gruppe hinzufügen
            gruppe.setSpielList(spielList);
        }
    }
}
