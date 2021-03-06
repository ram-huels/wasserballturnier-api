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
import wasserballturnier.api.generated.model.SpielArrayTO;
import wasserballturnier.api.generated.model.SpielTO;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;
import wasserballturnier.api.persistence.spiel.Spiel;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Validated
public interface SpieleApi {

    @Operation(summary = "Aktualisiert die Spiele", description = "Aktualisiert die Spiele des Turniers", tags = { "Spiele" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Es wird ein Spiel aktualisiert") })
    @RequestMapping(value = "/spiele/spiele",
    produces = { "application/json" },
    method = RequestMethod.PUT)
    void spielePut(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody SpielTO body);

    @Operation(summary = "Gibt das Finale zur??ck", description = "Gibt das Finale des Turniers zur??ck", tags={ "Spiele" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Es wird das Finale zur??ckgegeben", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SpielTO.class))) })
    @RequestMapping(value = "/spiele/finale",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Spiel> finalePost(Mannschaftsklasse mannschaftsklasse);


    @Operation(summary = "Gibt alle Halbfinale zur??ck", description = "Gibt alle Halbfinale vom Turnier zur??ck", tags={ "Spiele" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Es werden alle Halbfinals zur??ckgegeben", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SpielArrayTO.class))) })
    @RequestMapping(value = "/spiele/halbfinale",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<Spiel>> halbfinalePost(Mannschaftsklasse mannschaftsklasse);

}

