package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.generated.model.SpielTO;
import wasserballturnier.api.generated.model.Spielwert;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.persistence.spiel.SpielRepository;

import java.util.ArrayList;
import java.util.Collections;
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

    public SpielTO getFinale(){
        return new SpielTO();
    }

    public Spiel getHalbfinale(){ return new Spiel();}

    /*
    Diese Methode erzeugt Spiele in fairer Reihenfolge für 3er, 4er und 5er-Gruppen
     */
    public void createSpiele(Gruppe gruppe){
        List<Spiel> spielList = new ArrayList<>();

        if (gruppe.getMannschaftList().size() == 3) {
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(1), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(2), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(1), gruppe.getMannschaftList().get(2), Spielwert.GRUPPENSPIEL));
        }
        else if (gruppe.getMannschaftList().size() == 4){
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(1), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(2), gruppe.getMannschaftList().get(3), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(2), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(1), gruppe.getMannschaftList().get(3), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(3), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(1), gruppe.getMannschaftList().get(2), Spielwert.GRUPPENSPIEL));
        } else if (gruppe.getMannschaftList().size() == 5) {
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(1), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(2), gruppe.getMannschaftList().get(3), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(1), gruppe.getMannschaftList().get(4), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(2), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(3), gruppe.getMannschaftList().get(4), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(1), gruppe.getMannschaftList().get(2), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(3), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(2), gruppe.getMannschaftList().get(4), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(1), gruppe.getMannschaftList().get(3), Spielwert.GRUPPENSPIEL));
            spielList.add(new Spiel(gruppe.getMannschaftList().get(0), gruppe.getMannschaftList().get(4), Spielwert.GRUPPENSPIEL));
        }

        for (Spiel spiel: spielList) {
            addSpiel(spiel);
        }
        gruppe.setSpielList(spielList);
    }
}
