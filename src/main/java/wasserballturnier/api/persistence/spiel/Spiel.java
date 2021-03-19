package wasserballturnier.api.persistence.spiel;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;
import wasserballturnier.api.persistence.gruppe.Gruppe;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;

import javax.persistence.*;

@Entity
public class Spiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long spielId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft heimmannschaft;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft auswaertsmannschaft;

    @Column()
    private int heimtore = 0;

    @Column()
    private int auswaertstore = 0;

    public Spiel(Mannschaft heimmannschaft, Mannschaft auswaertsmannschaft) {
        super();
        this.heimmannschaft = heimmannschaft;
        this.auswaertsmannschaft = auswaertsmannschaft;
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

    public int getAuswaertstore() {
        return auswaertstore;
    }

    public void updateSpiel(int heimtore, int auswaertstore) {
        this.heimtore = heimtore;
        this.auswaertstore = auswaertstore;
        this.heimmannschaft.setAnzahlSpiele();
        this.auswaertsmannschaft.setAnzahlSpiele();
        this.heimmannschaft.setTore(heimtore);
        this.auswaertsmannschaft.setGegentore(heimtore);
        this.heimmannschaft.setGegentore(auswaertstore);
        this.auswaertsmannschaft.setTore(auswaertstore);
        if (heimtore > auswaertstore) {
            this.heimmannschaft.setAnzahlSiege();
            this.heimmannschaft.setPunkte(3);
            this.auswaertsmannschaft.setAnzahlNiederlagen();
        } else if (auswaertstore > heimtore) {
            this.heimmannschaft.setAnzahlNiederlagen();
            this.auswaertsmannschaft.setAnzahlSiege();
            this.auswaertsmannschaft.setPunkte(3);
        } else {
            this.heimmannschaft.setAnzahlUnterschieden();
            this.auswaertsmannschaft.setPunkte(1);
            this.auswaertsmannschaft.setAnzahlUnterschieden();
            this.auswaertsmannschaft.setPunkte(1);
        }
    }
}
