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
 * MannschaftArrayTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-11T14:40:27.415Z[GMT]")


public class MannschaftArrayTO   {
  @JsonProperty("mannschaften")
  @Valid
  private List<MannschaftTO> mannschaften = null;

  public MannschaftArrayTO mannschaften(List<MannschaftTO> mannschaften) {
    this.mannschaften = mannschaften;
    return this;
  }

  public MannschaftArrayTO addMannschaftenItem(MannschaftTO mannschaftenItem) {
    if (this.mannschaften == null) {
      this.mannschaften = new ArrayList<MannschaftTO>();
    }
    this.mannschaften.add(mannschaftenItem);
    return this;
  }

  /**
   * Get mannschaften
   * @return mannschaften
   **/
  @Schema(description = "")
      @Valid
    public List<MannschaftTO> getMannschaften() {
    return mannschaften;
  }

  public void setMannschaften(List<MannschaftTO> mannschaften) {
    this.mannschaften = mannschaften;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MannschaftArrayTO mannschaftArrayTO = (MannschaftArrayTO) o;
    return Objects.equals(this.mannschaften, mannschaftArrayTO.mannschaften);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mannschaften);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MannschaftArrayTO {\n");
    
    sb.append("    mannschaften: ").append(toIndentedString(mannschaften)).append("\n");
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
