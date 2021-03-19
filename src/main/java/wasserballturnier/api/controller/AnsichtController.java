package wasserballturnier.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.services.GruppeService;
import wasserballturnier.api.services.MannschaftService;
import wasserballturnier.api.services.SpielService;

import java.util.List;

@RestController
@RequestMapping("/ansicht")
public class AnsichtController {

    private GruppeService gruppeService;
    private MannschaftService mannschaftService;
    private SpielService spielService;

    @Autowired
    public AnsichtController(GruppeService gruppeService, MannschaftService mannschaftService, SpielService spielService) {
        this.gruppeService = gruppeService;
        this.mannschaftService = mannschaftService;
        this.spielService = spielService;
    }


    @GetMapping("/getGruppen")
    public List<Gruppe> getGruppen(){
        return this.gruppeService.getGruppen();
    }

}
