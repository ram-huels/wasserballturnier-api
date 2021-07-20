/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package wasserballturnier.api.generated.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;
import wasserballturnier.api.generated.model.MannschaftArrayTO;
import wasserballturnier.api.generated.model.MannschaftPushTO;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Validated
public interface MannschaftApi {

    @Operation(summary = "Speichert eine Mannschaft", description = "Wenn eine ID im Request-Body gesetzt ist, dann wird eine bestehende Mannschaft aktualisiert; ansonsten wird eine neue Mannschaft erstellt", tags={ "Mannschaften" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Die Mannschaft wurde erfolgreich gespeichert"),
        
        @ApiResponse(responseCode = "400", description = "Ein Feld oder mehrere Felder der Mannschaft sind ungültig"),
        
        @ApiResponse(responseCode = "404", description = "Die im Request-Body angegebene ID konnte keiner Rechnung zugeordnet werden") })
    @RequestMapping(value = "/mannschaft",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Integer> mannschaftPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody MannschaftPushTO body);


    @Operation(summary = "Gibt alle Mannschaften zurück", description = "", tags={ "Mannschaften" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Es werden alle Mannschaften zurückgegeben", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MannschaftArrayTO.class))) })
    @RequestMapping(value = "/mannschaft",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<MannschaftArrayTO> mannschaftenPost();

}

