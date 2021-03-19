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
    private int anzahlSpiele = 0;

    @Column()
    private int anzahlSiege = 0;

    @Column()
    private int anzahlUnterschieden = 0;

    @Column()
    private int anzahlNiederlagen = 0;

    @Column()
    private int tore = 0;

    @Column()
    private int gegentore = 0;

    @Column()
    private int punkte = 0;

    public Mannschaft(String mannschaftsname) {
        super();
        this.mannschaftsname = mannschaftsname;
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

    public int getAnzahlSpiele() {
        return anzahlSpiele;
    }

    public void setAnzahlSpiele() {
        this.anzahlSpiele += 1;
    }

    public int getAnzahlSiege() {
        return anzahlSiege;
    }

    public void setAnzahlSiege() {
        this.anzahlSiege += 1;
    }

    public int getAnzahlUnterschieden() {
        return anzahlUnterschieden;
    }

    public void setAnzahlUnterschieden() {
        this.anzahlUnterschieden += 1;
    }

    public int getAnzahlNiederlagen() {
        return anzahlNiederlagen;
    }

    public void setAnzahlNiederlagen() {
        this.anzahlNiederlagen += 1;
    }

    public int getTore() {
        return tore;
    }

    public void setTore(int tore) {
        this.tore += tore;
    }

    public int getGegentore() {
        return gegentore;
    }

    public void setGegentore(int gegentore) {
        this.gegentore += gegentore;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte += punkte;
    }
}
