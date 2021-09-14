package wasserballturnier.api.generated.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Spielwert {
    GRUPPENSPIEL("GRUPPENSPIEL"),

    HALBFINALE("HALBFINALE"),

    FINALE("FINALE");

    private String value;

    Spielwert(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Spielwert fromValue(String text) {
        for (Spielwert b : Spielwert.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
