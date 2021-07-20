package wasserballturnier.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SpielTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-11T14:40:27.415Z[GMT]")


public class SpielTO   {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("heimmanschaft")
  private MannschaftTO heimmanschaft = null;

  @JsonProperty("auswaertsmannschaft")
  private MannschaftTO auswaertsmannschaft = null;

  @JsonProperty("heimtore")
  private BigDecimal heimtore = null;

  @JsonProperty("auswaertstore")
  private BigDecimal auswaertstore = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    GRUPPENSPIEL("GRUPPENSPIEL"),
    
    HALBFINALE("HALBFINALE"),
    
    FINALE("FINALE");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  public SpielTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Die vom BackEnd vergebene ID eines Spieles
   * @return id
   **/
  @Schema(description = "Die vom BackEnd vergebene ID eines Spieles")
  
    @Valid
    public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public SpielTO heimmanschaft(MannschaftTO heimmanschaft) {
    this.heimmanschaft = heimmanschaft;
    return this;
  }

  /**
   * Get heimmanschaft
   * @return heimmanschaft
   **/
  @Schema(description = "")
  
    @Valid
    public MannschaftTO getHeimmanschaft() {
    return heimmanschaft;
  }

  public void setHeimmanschaft(MannschaftTO heimmanschaft) {
    this.heimmanschaft = heimmanschaft;
  }

  public SpielTO auswaertsmannschaft(MannschaftTO auswaertsmannschaft) {
    this.auswaertsmannschaft = auswaertsmannschaft;
    return this;
  }

  /**
   * Get auswaertsmannschaft
   * @return auswaertsmannschaft
   **/
  @Schema(description = "")
  
    @Valid
    public MannschaftTO getAuswaertsmannschaft() {
    return auswaertsmannschaft;
  }

  public void setAuswaertsmannschaft(MannschaftTO auswaertsmannschaft) {
    this.auswaertsmannschaft = auswaertsmannschaft;
  }

  public SpielTO heimtore(BigDecimal heimtore) {
    this.heimtore = heimtore;
    return this;
  }

  /**
   * Anzahl der Heimtore
   * @return heimtore
   **/
  @Schema(description = "Anzahl der Heimtore")
  
    @Valid
    public BigDecimal getHeimtore() {
    return heimtore;
  }

  public void setHeimtore(BigDecimal heimtore) {
    this.heimtore = heimtore;
  }

  public SpielTO auswaertstore(BigDecimal auswaertstore) {
    this.auswaertstore = auswaertstore;
    return this;
  }

  /**
   * Anzahl der Auswaertstore
   * @return auswaertstore
   **/
  @Schema(description = "Anzahl der Auswaertstore")
  
    @Valid
    public BigDecimal getAuswaertstore() {
    return auswaertstore;
  }

  public void setAuswaertstore(BigDecimal auswaertstore) {
    this.auswaertstore = auswaertstore;
  }

  public SpielTO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpielTO spielTO = (SpielTO) o;
    return Objects.equals(this.id, spielTO.id) &&
        Objects.equals(this.heimmanschaft, spielTO.heimmanschaft) &&
        Objects.equals(this.auswaertsmannschaft, spielTO.auswaertsmannschaft) &&
        Objects.equals(this.heimtore, spielTO.heimtore) &&
        Objects.equals(this.auswaertstore, spielTO.auswaertstore) &&
        Objects.equals(this.status, spielTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, heimmanschaft, auswaertsmannschaft, heimtore, auswaertstore, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpielTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    heimmanschaft: ").append(toIndentedString(heimmanschaft)).append("\n");
    sb.append("    auswaertsmannschaft: ").append(toIndentedString(auswaertsmannschaft)).append("\n");
    sb.append("    heimtore: ").append(toIndentedString(heimtore)).append("\n");
    sb.append("    auswaertstore: ").append(toIndentedString(auswaertstore)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
