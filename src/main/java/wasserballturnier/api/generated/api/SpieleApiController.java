package wasserballturnier.api.generated.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wasserballturnier.api.generated.model.SpielArrayTO;
import wasserballturnier.api.generated.model.SpielTO;
import wasserballturnier.api.generated.model.Spielwert;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.services.SpielService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class SpieleApiController implements SpieleApi {

    private static final Logger log = LoggerFactory.getLogger(SpieleApiController.class);

    private final SpielService spielService;

    public SpieleApiController(SpielService spielService) {
        this.spielService = spielService;
    }

    public void spielePut(@Valid SpielTO body) {
        this.spielService.updateSpiel(body);
    }

    public ResponseEntity<Spiel> finalePost(Mannschaftsklasse mannschaftsklasse) {
        return ResponseEntity.ok(spielService.getFinale(mannschaftsklasse));
    }

    public ResponseEntity<List<Spiel>> halbfinalePost(Mannschaftsklasse mannschaftsklasse) {
        return ResponseEntity.ok(spielService.getSpieleBySpielwertAndMannschaftsklasse(Spielwert.HALBFINALE, mannschaftsklasse));
    }

}
