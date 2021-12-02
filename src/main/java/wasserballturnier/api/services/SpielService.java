package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.generated.model.SpielTO;
import wasserballturnier.api.generated.model.Spielwert;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.persistence.spiel.SpielRepository;
import wasserballturnier.api.services.mapping.SpieleMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpielService {

    private SpielRepository spielRepository;

    private SpieleMapper spieleMapper;

    private GruppeService gruppeService;

    public SpielService(SpielRepository spielRepository, SpieleMapper spieleMapper, GruppeService gruppeService) {
        this.spielRepository = spielRepository;
        this.spieleMapper = spieleMapper;
        this.gruppeService = gruppeService;
    }

    public void addSpiel(Spiel spiel){
        this.spielRepository.save(spiel);
    }

    public List<Spiel> getSpiele(){
        return this.spielRepository.findAll();
    }

    // Has to be tested
    public void updateSpiel(SpielTO body){
        Spiel sp = this.spieleMapper.entityFromTO(body);
        this.spielRepository.findById(sp.getSpielId().longValue()).ifPresent(spiel -> spiel.updateSpiel(sp.getHeimtore(), sp.getAuswaertstore()));
        this.spielRepository.save(sp);
    }

    public SpielTO getFinale(){
        return new SpielTO();
    }

    public Spiel getHalbfinale(){ return new Spiel();}

    public void createViertelfinaleHerren() {
        List<Gruppe> gruppen = this.gruppeService.getXGruppen(Mannschaftsklasse.HERREN);

        if (gruppen.size() == 2) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 3; j >= 0; j--) {
                    addSpiel(new Spiel(gruppen.get(0).getMannschaftList().get(i), gruppen.get(1).getMannschaftList().get(j), Spielwert.VIERTELFINALE));
                }
            }
        } else if (gruppen.size() == 4) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 3; j >= 0; j--) {
                    addSpiel(new Spiel(gruppen.get(0).getMannschaftList().get(1), gruppen.get(1).getMannschaftList().get(2), Spielwert.VIERTELFINALE));
                    addSpiel(new Spiel(gruppen.get(i).getMannschaftList().get(2), gruppen.get(j).getMannschaftList().get(1), Spielwert.VIERTELFINALE));
                }
            }
            // Es wird davon ausgegangen, dass das Turnier nicht die Größe von 3 Gruppen übersteigt
        } else {
            // 2 Besten 1. gegen 2 besten 3.
            // Schlechtester 1. gegen schlechtesten 2.
            // 2 Besten 2. gegen einande

            // Ausmachung der beiden besten 3.
        }

        // TODO: Zusammensetzung von Viertelfinalen je nach Anzahl der Gruppen
        /*
        2 Gruppen -> 1. 2. 3. und 4.
        3 Gruppen -> 1. 2. und 2 besten 3.
        4 Gruppen -> 1. und 2.
         */
    }

    /*
    Diese Methode erzeugt alle Spiel ohne Reihenfolge für eine Gruppe
     */
    public void createGruppenSpiele(List<Gruppe> gruppen){

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
                addSpiel(spiel);
            }

            // Spiele der Gruppe hinzufügen
            gruppe.setSpielList(spielList);
        }
    }
}
