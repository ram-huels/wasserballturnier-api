package wasserballturnier.api.persistence.spiel;

import org.springframework.stereotype.Component;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;

import javax.persistence.*;

@Component
@Table
public class Spiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long spielId;

    @Column()
    private Mannschaft heimmannschaft;

    @Column()
    private Mannschaft auswaertsmannschaft;

    @Column()
    private int heimtore;

    @Column()
    private int auswaertstore;

    public Spiel(Mannschaft heimmannschaft, Mannschaft auswaertsmannschaft, int heimtore, int auswaertstore) {
        this.heimmannschaft = heimmannschaft;
        this.auswaertsmannschaft = auswaertsmannschaft;
        this.heimtore = heimtore;
        this.auswaertstore = auswaertstore;
    }

    protected Spiel() {}

    public long getSpielId() {
        return spielId;
    }

    public Mannschaft getHeimmannschaft() {
        return heimmannschaft;
    }

    public void setHeimmannschaft(Mannschaft heimmannschaft) {
        this.heimmannschaft = heimmannschaft;
    }

    public Mannschaft getAuswaertsmannschaft() {
        return auswaertsmannschaft;
    }

    public void setAuswaertsmannschaft(Mannschaft auswaertsmannschaft) {
        this.auswaertsmannschaft = auswaertsmannschaft;
    }

    public int getHeimtore() {
        return heimtore;
    }

    public void setHeimtore(int heimtore) {
        this.heimtore = heimtore;
    }

    public int getAuswaertstore() {
        return auswaertstore;
    }

    public void setAuswaertstore(int auswaertstore) {
        this.auswaertstore = auswaertstore;
    }
}
