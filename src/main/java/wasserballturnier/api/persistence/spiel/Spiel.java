package wasserballturnier.api.persistence.spiel;

import com.sun.istack.Nullable;
import wasserballturnier.api.generated.model.Spielwert;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Spiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spielId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft heimmannschaft;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft auswaertsmannschaft;

    @Column()
    private int heimtore = 0;

    @Column()
    private int auswaertstore = 0;

    @Column
    private Spielwert spielwert;

    @ManyToOne(fetch = FetchType.EAGER)
    @Nullable
    private Mannschaft protokoll;

    public Spiel(Mannschaft heimmannschaft, Mannschaft auswaertsmannschaft, Spielwert spielwert) {
        super();
        this.heimmannschaft = heimmannschaft;
        this.auswaertsmannschaft = auswaertsmannschaft;
        this.spielwert = spielwert;
    }

    public Spiel() {}

    public Integer getSpielId() {
        return spielId;
    }

    public void setSpielId(Integer spielId) {this.spielId = spielId;}

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

    public void setHeimtore(int heimtore) {
        this.heimtore = heimtore;
    }

    public void setAuswaertstore(int auswaertstore) {
        this.auswaertstore = auswaertstore;
    }

    public Spielwert getSpielwert() {
        return spielwert;
    }

    public void setSpielwert(Spielwert spielwert) {
        this.spielwert = spielwert;
    }

    public Mannschaft getProtokoll() {
        return protokoll;
    }

    public void setProtokoll(Mannschaft protokoll) {
        this.protokoll = protokoll;
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
            this.heimmannschaft.setPunkte(1);
            this.auswaertsmannschaft.setAnzahlUnterschieden();
            this.auswaertsmannschaft.setPunkte(1);
        }
    }
}
