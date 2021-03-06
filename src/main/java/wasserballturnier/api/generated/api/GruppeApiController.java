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
import wasserballturnier.api.generated.model.GruppePushTO;
import wasserballturnier.api.generated.model.GruppenArrayTO;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.services.GruppeService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class GruppeApiController implements GruppeApi {

    private static final Logger log = LoggerFactory.getLogger(GruppeApiController.class);

    private final GruppeService gruppeService;

    public GruppeApiController(GruppeService gruppeService) {
        this.gruppeService = gruppeService;
    }

    public ResponseEntity<Void> gruppenAutomatic(@Parameter(in = ParameterIn.PATH, description = "Groesse der Gruppen bei der Generation", required=true, schema=@Schema()) @PathVariable("gruppenGroesse") Integer gruppenGroesse) {
        this.gruppeService.randomGruppen(gruppenGroesse);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Gruppe>> gruppenPost() {
        return ResponseEntity.ok(this.gruppeService.getGruppen());
    }

    public ResponseEntity<Void> gruppenPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody GruppePushTO body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
