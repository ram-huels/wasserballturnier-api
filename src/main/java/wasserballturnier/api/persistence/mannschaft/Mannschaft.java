package wasserballturnier.api.persistence.mannschaft;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class Mannschaft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String mannschaftsname;

    @Column()
    private int anzahlSiege;

    @Column()
    private int anzahlUnterschieden;

    @Column()
    private int anzahlNiederlagen;

    @Column()
    private int tore;

    @Column()
    private int gegentore;

    @Column()
    private int punkte;

    public Mannschaft(String mannschaftsname, int anzahlSiege, int anzahlUnterschieden, int anzahlNiederlagen, int tore, int gegentore, int punkte) {
        this.mannschaftsname = mannschaftsname;
        this.anzahlSiege = anzahlSiege;
        this.anzahlUnterschieden = anzahlUnterschieden;
        this.anzahlNiederlagen = anzahlNiederlagen;
        this.tore = tore;
        this.gegentore = gegentore;
        this.punkte = punkte;
    }

    protected Mannschaft() {}

    public long getId() {
        return id;
    }

    public String getMannschaftsname() {
        return mannschaftsname;
    }

    public void setMannschaftsname(String mannschaftsname) {
        this.mannschaftsname = mannschaftsname;
    }

    public int getAnzahlSiege() {
        return anzahlSiege;
    }

    public void setAnzahlSiege(int anzahlSiege) {
        this.anzahlSiege = anzahlSiege;
    }

    public int getAnzahlUnterschieden() {
        return anzahlUnterschieden;
    }

    public void setAnzahlUnterschieden(int anzahlUnterschieden) {
        this.anzahlUnterschieden = anzahlUnterschieden;
    }

    public int getAnzahlNiederlagen() {
        return anzahlNiederlagen;
    }

    public void setAnzahlNiederlagen(int anzahlNiederlagen) {
        this.anzahlNiederlagen = anzahlNiederlagen;
    }

    public int getTore() {
        return tore;
    }

    public void setTore(int tore) {
        this.tore = tore;
    }

    public int getGegentore() {
        return gegentore;
    }

    public void setGegentore(int gegentore) {
        this.gegentore = gegentore;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
