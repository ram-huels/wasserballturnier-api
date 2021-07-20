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
 * SpielArrayTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-11T14:40:27.415Z[GMT]")


public class SpielArrayTO   {
  @JsonProperty("spiele")
  @Valid
  private List<SpielTO> spiele = null;

  public SpielArrayTO spiele(List<SpielTO> spiele) {
    this.spiele = spiele;
    return this;
  }

  public SpielArrayTO addSpieleItem(SpielTO spieleItem) {
    if (this.spiele == null) {
      this.spiele = new ArrayList<SpielTO>();
    }
    this.spiele.add(spieleItem);
    return this;
  }

  /**
   * Eine Liste von Spielen
   * @return spiele
   **/
  @Schema(description = "Eine Liste von Spielen")
      @Valid
    public List<SpielTO> getSpiele() {
    return spiele;
  }

  public void setSpiele(List<SpielTO> spiele) {
    this.spiele = spiele;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpielArrayTO spielArrayTO = (SpielArrayTO) o;
    return Objects.equals(this.spiele, spielArrayTO.spiele);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spiele);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpielArrayTO {\n");
    
    sb.append("    spiele: ").append(toIndentedString(spiele)).append("\n");
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
