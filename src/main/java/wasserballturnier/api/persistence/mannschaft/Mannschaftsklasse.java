package wasserballturnier.api.persistence.mannschaft;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import wasserballturnier.api.generated.model.Spielwert;

public enum Mannschaftsklasse {

    HERREN("HERREN"),
    DAMEN("DAMEN"),
    JUGEND("JUGEND");

    private String value;

    Mannschaftsklasse(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Mannschaftsklasse fromValue(String text) {
        for (Mannschaftsklasse b : Mannschaftsklasse.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}