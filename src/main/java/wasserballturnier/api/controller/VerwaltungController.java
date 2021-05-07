package wasserballturnier.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wasserballturnier.api.controller.schemata.CreateGruppeBody;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.services.GruppeService;
import wasserballturnier.api.services.MannschaftService;
import wasserballturnier.api.services.SpielService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/verwaltung")
public class VerwaltungController {

    private GruppeService gruppeService;
    private MannschaftService mannschaftService;
    private SpielService spielService;

    @Autowired
    public VerwaltungController(GruppeService gruppeService, MannschaftService mannschaftService, SpielService spielService) {
        this.gruppeService = gruppeService;
        this.mannschaftService = mannschaftService;
        this.spielService = spielService;
    }

    @PutMapping("/addMannschaft/{mannschaftsname}")
    public void addMannschaft(@RequestParam("mannschaftsname") String mannschaftsname){
        this.mannschaftService.addMannschaft(new Mannschaft(mannschaftsname));
    }

    @PutMapping("/addGruppe")
    public void addGruppe(@RequestBody CreateGruppeBody createGruppeBody) {
        Gruppe gruppe = new Gruppe(createGruppeBody.getGruppenname());
        this.gruppeService.addGruppe(gruppe);
        List<Mannschaft> mannschaftList = createGruppeBody.getMannschaftList();
        for (Mannschaft mannschaft: mannschaftList) {
            gruppe.addMannschaftZurGruppe(mannschaft);
        }
        for (int i = 0; i < mannschaftList.size(); i++) {
            for(int j = i+1; j < mannschaftList.size(); j++){
                gruppe.addSpielZurGruppe(new Spiel(createGruppeBody.getMannschaftList().get(i) , createGruppeBody.getMannschaftList().get(j)));
            }
        }
    }

    @GetMapping("/getMannschaften")
    public List<Mannschaft> getMannschaften(){
        return this.mannschaftService.getMannschaften();
    }

    public ArrayList<List<Mannschaft>> shuffleMannschaften(int gruppengroesse){
        List<Mannschaft> alleMannschaften = this.mannschaftService.getMannschaften();
        Collections.shuffle(alleMannschaften);
        ArrayList<List<Mannschaft>> gruppen = new ArrayList<>();
        while (!alleMannschaften.isEmpty()){
            gruppen.add(alleMannschaften.subList(0, gruppengroesse));
        }
        return gruppen;
    }
}
