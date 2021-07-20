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

    public ResponseEntity<SpielTO> finalePost() {
        return ResponseEntity.ok(spielService.getFinale());
    }

    public ResponseEntity<SpielArrayTO> halbfinalePost() {
        return new ResponseEntity<SpielArrayTO>(HttpStatus.NOT_IMPLEMENTED);
    }

}
