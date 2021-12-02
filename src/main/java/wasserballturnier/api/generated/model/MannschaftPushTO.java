package wasserballturnier.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MannschaftPushTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-11T14:40:27.415Z[GMT]")


public class MannschaftPushTO   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("mannschaftsname")
  private String mannschaftsname = null;

  @JsonProperty("mannschaftsklasse")
  private Mannschaftsklasse mannschaftsklasse = null;

  public MannschaftPushTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Die vom BackEnd vergebene ID einer Mannschaft
   * @return id
   **/
  @Schema(description = "Die vom BackEnd vergebene ID einer Mannschaft")
  
    @Valid
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MannschaftPushTO mannschaftsname(String mannschaftsname) {
    this.mannschaftsname = mannschaftsname;
    return this;
  }

  /**
   * Name der Mannschaft
   * @return mannschaftsname
   **/
  @Schema(description = "Name der Mannschaft")
  
    public String getMannschaftsname() {
    return mannschaftsname;
  }

  public void setMannschaftsname(String mannschaftsname) {
    this.mannschaftsname = mannschaftsname;
  }

  /**
   * Name der Mannschaft
   * @return mannschaftsname
   **/
  @Schema(description = "Klasse der Mannschaft")

  public Mannschaftsklasse getMannschaftsklasse() {
    return mannschaftsklasse;
  }

  public void setMannschaftsklasse(Mannschaftsklasse mannschaftsklasse) {
    this.mannschaftsklasse = mannschaftsklasse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MannschaftPushTO mannschaftPushTO = (MannschaftPushTO) o;
    return Objects.equals(this.id, mannschaftPushTO.id) &&
        Objects.equals(this.mannschaftsname, mannschaftPushTO.mannschaftsname) && Objects.equals(this.mannschaftsklasse, mannschaftPushTO.mannschaftsklasse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, mannschaftsname, mannschaftsklasse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MannschaftPushTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    mannschaftsname: ").append(toIndentedString(mannschaftsname)).append("\n");
    sb.append("    mannschaftsklasse: ").append(toIndentedString(mannschaftsklasse)).append("\n");
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
