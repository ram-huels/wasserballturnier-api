package wasserballturnier.api.services;

import org.springframework.stereotype.Service;
import wasserballturnier.api.generated.model.SpielTO;
import wasserballturnier.api.generated.model.Spielwert;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.persistence.spiel.SpielRepository;
import wasserballturnier.api.services.mapping.SpieleMapper;

import java.util.ArrayList;
import java.util.Comparator;
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

    // Has to be tested
    public void updateSpiel(SpielTO body){
        Spiel sp = this.spieleMapper.entityFromTO(body);
        this.spielRepository.findById(sp.getSpielId().longValue()).ifPresent(spiel -> spiel.updateSpiel(sp.getHeimtore(), sp.getAuswaertstore()));
        this.spielRepository.save(sp);
    }

    public List<Spiel> getSpieleBySpielwertAndMannschaftsklasse(Spielwert spielwert, Mannschaftsklasse mannschaftsklasse){
        return this.spielRepository.findAllBySpielwertAndHeimmannschaft_Mannschaftsklasse(spielwert, mannschaftsklasse);
    }

    public Spiel getFinale(Mannschaftsklasse mannschaftsklasse){
        return this.spielRepository.findBySpielwertAndHeimmannschaft_Mannschaftsklasse(mannschaftsklasse);
    }

    public List<Mannschaft> sortMannschaftsList(List<Mannschaft> toBeSorted) {
        toBeSorted.sort(Comparator.comparing(Mannschaft::getPunkte)
                .thenComparing(m -> m.getTore() - m.getGegentore())
                .thenComparing(Mannschaft::getTore)
                .thenComparing(Mannschaft::getGegentore));
        return toBeSorted;
    }

    /*
    -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    ------------------------------------------------------------------------/ ___|_ __ ___  __ _| |_(_) ___  _ __------------------------------------------------------------------------------------------
    -----------------------------------------------------------------------| |   | '__/ _ \/ _` | __| |/ _ \| '_ \ ----------------------------------------------------------------------------------------
    -----------------------------------------------------------------------| |___| | |  __/ (_| | |_| | (_) | | | |-----------------------------------------------------------------------------------------
    ------------------------------------------------------------------------\____|_|  \___|\__,_|\__|_|\___/|_| |_|-----------------------------------------------------------------------------------------
    -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

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

    /*
    Diese Methode erzeugt die Viertelfinals für die angegebene Mannschaftsklasse für die Gruppenanzahl von 2, 3 und 4
    */
    public void createViertelfinale(Mannschaftsklasse mannschaftsklasse) {
        List<Gruppe> gruppen = this.gruppeService.getGruppen();
        gruppen.removeIf(g -> g.getMannschaftList().get(0).getMannschaftsklasse() != mannschaftsklasse);

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
            List<Mannschaft> erstPlatzierte = new ArrayList<>();
            List<Mannschaft> zweitPlatzierte = new ArrayList<>();
            List<Mannschaft> drittPlatzierte = new ArrayList<>();

            for (Gruppe g: gruppen) {
                erstPlatzierte.add(g.getMannschaftList().get(0));
                zweitPlatzierte.add(g.getMannschaftList().get(1));
                drittPlatzierte.add(g.getMannschaftList().get(2));
            }

            erstPlatzierte = sortMannschaftsList(erstPlatzierte);
            zweitPlatzierte = sortMannschaftsList(zweitPlatzierte);
            drittPlatzierte = sortMannschaftsList(drittPlatzierte);

            addSpiel(new Spiel(erstPlatzierte.get(0), drittPlatzierte.get(1), Spielwert.VIERTELFINALE));
            addSpiel(new Spiel(erstPlatzierte.get(2), zweitPlatzierte.get(2), Spielwert.VIERTELFINALE));
            addSpiel(new Spiel(zweitPlatzierte.get(0), zweitPlatzierte.get(1), Spielwert.VIERTELFINALE));
            addSpiel(new Spiel(erstPlatzierte.get(1), drittPlatzierte.get(0), Spielwert.VIERTELFINALE));
        }
    }

    /*
    Diese Methode erzeugt die Halbfinals für die angegebene Mannschaftsklasse aus den Viertelfinals oder Gruppen.
    Die zulässige Anzahl an Gruppen ist 1, 2, 3 und 4.
     */
    public void createHalbfinale(Mannschaftsklasse mannschaftsklasse) {
        List<Spiel> viertelfinals = this.getSpieleBySpielwertAndMannschaftsklasse(Spielwert.VIERTELFINALE, mannschaftsklasse);

        if (!viertelfinals.isEmpty()) {
            // Es gab Viertelfinals
            addSpiel(new Spiel(viertelfinals.get(0).getSieger(), viertelfinals.get(1).getSieger(), Spielwert.HALBFINALE));
            addSpiel(new Spiel(viertelfinals.get(2).getSieger(), viertelfinals.get(3).getSieger(), Spielwert.HALBFINALE));
        } else {
            /*
             Es gab keine Viertelfinals.
             Diese Funktion funktioniert bei einer Gruppenanzahl von 1,2,3 und 4
             */
            List<Gruppe> gruppen = this.gruppeService.getGruppen();
            gruppen.removeIf(g -> g.getMannschaftList().get(0).getMannschaftsklasse() != mannschaftsklasse);

            if (gruppen.size() == 1) {
                addSpiel(new Spiel(gruppen.get(0).getMannschaftList().get(0), gruppen.get(0).getMannschaftList().get(3), Spielwert.HALBFINALE));
                addSpiel(new Spiel(gruppen.get(0).getMannschaftList().get(1), gruppen.get(0).getMannschaftList().get(2), Spielwert.HALBFINALE));
            } else if (gruppen.size() == 2) {
                addSpiel(new Spiel(gruppen.get(0).getMannschaftList().get(0), gruppen.get(1).getMannschaftList().get(1), Spielwert.HALBFINALE));
                addSpiel(new Spiel(gruppen.get(1).getMannschaftList().get(0), gruppen.get(0).getMannschaftList().get(1), Spielwert.HALBFINALE));
            } else if (gruppen.size() == 4) {
                addSpiel(new Spiel(gruppen.get(0).getMannschaftList().get(0), gruppen.get(1).getMannschaftList().get(0), Spielwert.HALBFINALE));
                addSpiel(new Spiel(gruppen.get(2).getMannschaftList().get(0), gruppen.get(3).getMannschaftList().get(0), Spielwert.HALBFINALE));
                // Es wird davon ausgegangen, dass das Turnier nicht die Größe von 3 Gruppen übersteigt
            } else {
                List<Mannschaft> erstPlatzierte = new ArrayList<>();
                List<Mannschaft> zweitPlatzierte = new ArrayList<>();

                for (Gruppe g: gruppen) {
                    erstPlatzierte.add(g.getMannschaftList().get(0));
                    zweitPlatzierte.add(g.getMannschaftList().get(1));
                }

                sortMannschaftsList(erstPlatzierte);
                sortMannschaftsList(zweitPlatzierte);

                addSpiel(new Spiel(erstPlatzierte.get(0), zweitPlatzierte.get(0), Spielwert.HALBFINALE));
                addSpiel(new Spiel(erstPlatzierte.get(1), erstPlatzierte.get(2), Spielwert.HALBFINALE));
            }
        }
    }

    /*
    Diese Methode erzeugt das Finale für die angegebene Mannschaftsklasse aus den Halbfinals oder Gruppen.
    Die zulässige Anzahl an Gruppen ist 1 und 2.
     */
    public void createFinale(Mannschaftsklasse mannschaftsklasse) {
        List<Spiel> halbfinals = this.getSpieleBySpielwertAndMannschaftsklasse(Spielwert.HALBFINALE, mannschaftsklasse);
        if (!halbfinals.isEmpty()) {
            addSpiel(new Spiel(halbfinals.get(0).getSieger(), halbfinals.get(1).getSieger(), Spielwert.FINALE));
        } else {
            List<Gruppe> g = this.gruppeService.getGruppen();
            if (g.size() == 1) {
                addSpiel(new Spiel(g.get(0).getMannschaftList().get(0), g.get(0).getMannschaftList().get(1), Spielwert.FINALE));
            } else {
                addSpiel(new Spiel(g.get(0).getMannschaftList().get(0), g.get(1).getMannschaftList().get(0), Spielwert.FINALE));
            }
        }

    }
}
