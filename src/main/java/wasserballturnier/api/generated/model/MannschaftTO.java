package wasserballturnier.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MannschaftTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-11T14:40:27.415Z[GMT]")


public class MannschaftTO   {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("mannschaftsname")
  private String mannschaftsname = null;

  @JsonProperty("anzahlSpiele")
  private BigDecimal anzahlSpiele = null;

  @JsonProperty("anzahlSiege")
  private BigDecimal anzahlSiege = null;

  @JsonProperty("anzahlUnentschieden")
  private BigDecimal anzahlUnentschieden = null;

  @JsonProperty("anzahlNiederlagen")
  private BigDecimal anzahlNiederlagen = null;

  @JsonProperty("tore")
  private BigDecimal tore = null;

  @JsonProperty("gegentore")
  private BigDecimal gegentore = null;

  @JsonProperty("punkte")
  private BigDecimal punkte = null;

  public MannschaftTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Die vom BackEnd vergebene ID einer Mannschaft
   * @return id
   **/
  @Schema(description = "Die vom BackEnd vergebene ID einer Mannschaft")
  
    @Valid
    public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public MannschaftTO mannschaftsname(String mannschaftsname) {
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

  public MannschaftTO anzahlSpiele(BigDecimal anzahlSpiele) {
    this.anzahlSpiele = anzahlSpiele;
    return this;
  }

  /**
   * Anzahl der Spiele einer Mannschaft
   * @return anzahlSpiele
   **/
  @Schema(description = "Anzahl der Spiele einer Mannschaft")
  
    @Valid
    public BigDecimal getAnzahlSpiele() {
    return anzahlSpiele;
  }

  public void setAnzahlSpiele(BigDecimal anzahlSpiele) {
    this.anzahlSpiele = anzahlSpiele;
  }

  public MannschaftTO anzahlSiege(BigDecimal anzahlSiege) {
    this.anzahlSiege = anzahlSiege;
    return this;
  }

  /**
   * Anzahl der Siege einer Mannschaft
   * @return anzahlSiege
   **/
  @Schema(description = "Anzahl der Siege einer Mannschaft")
  
    @Valid
    public BigDecimal getAnzahlSiege() {
    return anzahlSiege;
  }

  public void setAnzahlSiege(BigDecimal anzahlSiege) {
    this.anzahlSiege = anzahlSiege;
  }

  public MannschaftTO anzahlUnentschieden(BigDecimal anzahlUnentschieden) {
    this.anzahlUnentschieden = anzahlUnentschieden;
    return this;
  }

  /**
   * Anzahl der Unentschieden einer Mannschaft
   * @return anzahlUnentschieden
   **/
  @Schema(description = "Anzahl der Unentschieden einer Mannschaft")
  
    @Valid
    public BigDecimal getAnzahlUnentschieden() {
    return anzahlUnentschieden;
  }

  public void setAnzahlUnentschieden(BigDecimal anzahlUnentschieden) {
    this.anzahlUnentschieden = anzahlUnentschieden;
  }

  public MannschaftTO anzahlNiederlagen(BigDecimal anzahlNiederlagen) {
    this.anzahlNiederlagen = anzahlNiederlagen;
    return this;
  }

  /**
   * Anzahl der Niederlagen einer Mannschaft
   * @return anzahlNiederlagen
   **/
  @Schema(description = "Anzahl der Niederlagen einer Mannschaft")
  
    @Valid
    public BigDecimal getAnzahlNiederlagen() {
    return anzahlNiederlagen;
  }

  public void setAnzahlNiederlagen(BigDecimal anzahlNiederlagen) {
    this.anzahlNiederlagen = anzahlNiederlagen;
  }

  public MannschaftTO tore(BigDecimal tore) {
    this.tore = tore;
    return this;
  }

  /**
   * Anzahl der gesamten Tore einer Mannschaft
   * @return tore
   **/
  @Schema(description = "Anzahl der gesamten Tore einer Mannschaft")
  
    @Valid
    public BigDecimal getTore() {
    return tore;
  }

  public void setTore(BigDecimal tore) {
    this.tore = tore;
  }

  public MannschaftTO gegentore(BigDecimal gegentore) {
    this.gegentore = gegentore;
    return this;
  }

  /**
   * Anzahl der gesamten Gegentore einer Mannschaft
   * @return gegentore
   **/
  @Schema(description = "Anzahl der gesamten Gegentore einer Mannschaft")
  
    @Valid
    public BigDecimal getGegentore() {
    return gegentore;
  }

  public void setGegentore(BigDecimal gegentore) {
    this.gegentore = gegentore;
  }

  public MannschaftTO punkte(BigDecimal punkte) {
    this.punkte = punkte;
    return this;
  }

  /**
   * Anzahl der Punkte einer Mannschaft
   * @return punkte
   **/
  @Schema(description = "Anzahl der Punkte einer Mannschaft")
  
    @Valid
    public BigDecimal getPunkte() {
    return punkte;
  }

  public void setPunkte(BigDecimal punkte) {
    this.punkte = punkte;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MannschaftTO mannschaftTO = (MannschaftTO) o;
    return Objects.equals(this.id, mannschaftTO.id) &&
        Objects.equals(this.mannschaftsname, mannschaftTO.mannschaftsname) &&
        Objects.equals(this.anzahlSpiele, mannschaftTO.anzahlSpiele) &&
        Objects.equals(this.anzahlSiege, mannschaftTO.anzahlSiege) &&
        Objects.equals(this.anzahlUnentschieden, mannschaftTO.anzahlUnentschieden) &&
        Objects.equals(this.anzahlNiederlagen, mannschaftTO.anzahlNiederlagen) &&
        Objects.equals(this.tore, mannschaftTO.tore) &&
        Objects.equals(this.gegentore, mannschaftTO.gegentore) &&
        Objects.equals(this.punkte, mannschaftTO.punkte);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, mannschaftsname, anzahlSpiele, anzahlSiege, anzahlUnentschieden, anzahlNiederlagen, tore, gegentore, punkte);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MannschaftTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    mannschaftsname: ").append(toIndentedString(mannschaftsname)).append("\n");
    sb.append("    anzahlSpiele: ").append(toIndentedString(anzahlSpiele)).append("\n");
    sb.append("    anzahlSiege: ").append(toIndentedString(anzahlSiege)).append("\n");
    sb.append("    anzahlUnentschieden: ").append(toIndentedString(anzahlUnentschieden)).append("\n");
    sb.append("    anzahlNiederlagen: ").append(toIndentedString(anzahlNiederlagen)).append("\n");
    sb.append("    tore: ").append(toIndentedString(tore)).append("\n");
    sb.append("    gegentore: ").append(toIndentedString(gegentore)).append("\n");
    sb.append("    punkte: ").append(toIndentedString(punkte)).append("\n");
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
