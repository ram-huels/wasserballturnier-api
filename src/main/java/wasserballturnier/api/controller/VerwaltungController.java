package wasserballturnier.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.services.GruppeService;
import wasserballturnier.api.services.MannschaftService;
import wasserballturnier.api.services.SpielService;

import javax.validation.Valid;

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

    @PutMapping("/addMannschaft")
    public void setMannschaft(@Valid @RequestBody String mannschaftsname){
        this.mannschaftService.addMannschaft(new Mannschaft(mannschaftsname));
    }
}
