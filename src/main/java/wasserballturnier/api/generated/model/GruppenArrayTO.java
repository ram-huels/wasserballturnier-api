package wasserballturnier.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GruppenArrayTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-11T14:40:27.415Z[GMT]")


public class GruppenArrayTO   {
  @JsonProperty("gruppen")
  @Valid
  private List<GruppeTO> gruppen = null;

  public GruppenArrayTO gruppen(List<GruppeTO> gruppen) {
    this.gruppen = gruppen;
    return this;
  }

  public GruppenArrayTO addGruppenItem(GruppeTO gruppenItem) {
    if (this.gruppen == null) {
      this.gruppen = new ArrayList<GruppeTO>();
    }
    this.gruppen.add(gruppenItem);
    return this;
  }

  /**
   * Eine Liste von Gruppen
   * @return gruppen
   **/
  @Schema(description = "Eine Liste von Gruppen")
      @Valid
    public List<GruppeTO> getGruppen() {
    return gruppen;
  }

  public void setGruppen(List<GruppeTO> gruppen) {
    this.gruppen = gruppen;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GruppenArrayTO gruppenArrayTO = (GruppenArrayTO) o;
    return Objects.equals(this.gruppen, gruppenArrayTO.gruppen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gruppen);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GruppenArrayTO {\n");
    
    sb.append("    gruppen: ").append(toIndentedString(gruppen)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
