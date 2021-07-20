package wasserballturnier.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GruppePushTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-11T14:40:27.415Z[GMT]")


public class GruppePushTO   {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("gruppenbezeichung")
  private String gruppenbezeichung = null;

  @JsonProperty("mannschaftList")
  @Valid
  private List<MannschaftTO> mannschaftList = null;

  public GruppePushTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Die vom BackEnd vergebene ID einer Gruppe
   * @return id
   **/
  @Schema(description = "Die vom BackEnd vergebene ID einer Gruppe")
  
    @Valid
    public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public GruppePushTO gruppenbezeichung(String gruppenbezeichung) {
    this.gruppenbezeichung = gruppenbezeichung;
    return this;
  }

  /**
   * Name der Gruppe
   * @return gruppenbezeichung
   **/
  @Schema(description = "Name der Gruppe")
  
    public String getGruppenbezeichung() {
    return gruppenbezeichung;
  }

  public void setGruppenbezeichung(String gruppenbezeichung) {
    this.gruppenbezeichung = gruppenbezeichung;
  }

  public GruppePushTO mannschaftList(List<MannschaftTO> mannschaftList) {
    this.mannschaftList = mannschaftList;
    return this;
  }

  public GruppePushTO addMannschaftListItem(MannschaftTO mannschaftListItem) {
    if (this.mannschaftList == null) {
      this.mannschaftList = new ArrayList<MannschaftTO>();
    }
    this.mannschaftList.add(mannschaftListItem);
    return this;
  }

  /**
   * Eine Liste von Mannschaften in der Gruppe
   * @return mannschaftList
   **/
  @Schema(description = "Eine Liste von Mannschaften in der Gruppe")
      @Valid
    public List<MannschaftTO> getMannschaftList() {
    return mannschaftList;
  }

  public void setMannschaftList(List<MannschaftTO> mannschaftList) {
    this.mannschaftList = mannschaftList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GruppePushTO gruppePushTO = (GruppePushTO) o;
    return Objects.equals(this.id, gruppePushTO.id) &&
        Objects.equals(this.gruppenbezeichung, gruppePushTO.gruppenbezeichung) &&
        Objects.equals(this.mannschaftList, gruppePushTO.mannschaftList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gruppenbezeichung, mannschaftList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GruppePushTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    gruppenbezeichung: ").append(toIndentedString(gruppenbezeichung)).append("\n");
    sb.append("    mannschaftList: ").append(toIndentedString(mannschaftList)).append("\n");
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
