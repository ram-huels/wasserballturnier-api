package wasserballturnier.api.persistence.mannschaft;

import javax.persistence.*;

@Entity
public class Mannschaft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String mannschaftsname;

    @Column
    private Mannschaftsklasse mannschaftsklasse;

    @Column()
    private int anzahlSpiele = 0;

    @Column()
    private int anzahlSiege = 0;

    @Column()
    private int anzahlUnentschieden = 0;

    @Column()
    private int anzahlNiederlagen = 0;

    @Column()
    private int tore = 0;

    @Column()
    private int gegentore = 0;

    @Column()
    private int punkte = 0;

    public Mannschaft(String mannschaftsname, String mannschaftsklasse) {
        super();
        this.mannschaftsname = mannschaftsname;
        this.mannschaftsklasse = Mannschaftsklasse.fromValue(mannschaftsklasse);
    }

    public Mannschaft() {}

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {this.id = id;}

    public String getMannschaftsname() {
        return mannschaftsname;
    }

    public void setMannschaftsname(String mannschaftsname) {
        this.mannschaftsname = mannschaftsname;
    }

    public Mannschaftsklasse getMannschaftsklasse() {
        return mannschaftsklasse;
    }

    public void setMannschaftsklasse(Mannschaftsklasse mannschaftsklasse) {
        this.mannschaftsklasse = mannschaftsklasse;
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

    public int getAnzahlUnentschieden() {
        return anzahlUnentschieden;
    }

    public void setAnzahlUnterschieden() {
        this.anzahlUnentschieden += 1;
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
