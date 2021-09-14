package wasserballturnier.api.persistence.mannschaft;

public enum Mannschaftsklasse {

    HERREN(0),
    DAMEN(1),
    JUGEND(2);

    private int value;

    private Mannschaftsklasse(int value) {
        this.value = value;
    }

    public static Mannschaftsklasse assertMannschaftsklasse(int mannschaftsklasse) {
        if (mannschaftsklasse == 0){
            return Mannschaftsklasse.HERREN;
        } else {
            return mannschaftsklasse == 1 ? Mannschaftsklasse.DAMEN : Mannschaftsklasse.JUGEND;
        }
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}