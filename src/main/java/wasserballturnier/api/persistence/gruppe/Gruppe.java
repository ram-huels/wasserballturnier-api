package wasserballturnier.api.persistence.gruppe;

import org.springframework.stereotype.Component;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.spiel.Spiel;

import javax.persistence.*;
import java.util.*;

@Entity
public class Gruppe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gruppeId;

    @Column()
    private String gruppenbezeichnung;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft mannschaft1;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft mannschaft2;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft mannschaft3;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft mannschaft4;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft mannschaft5;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mannschaft mannschaft6;

    public Gruppe(String gruppenbezeichnung) {
        this.gruppenbezeichnung = gruppenbezeichnung;
    }

    protected Gruppe() {}

    public long getGruppeId() {
        return gruppeId;
    }

    public String getGruppenbezeichnung() {
        return gruppenbezeichnung;
    }

    public void setGruppenbezeichnung(String gruppenbezeichnung) {
        this.gruppenbezeichnung = gruppenbezeichnung;
    }

    public Mannschaft getMannschaft1() {
        return mannschaft1;
    }

    public void setMannschaft1(Mannschaft mannschaft1) {
        this.mannschaft1 = mannschaft1;
    }

    public Mannschaft getMannschaft2() {
        return mannschaft2;
    }

    public void setMannschaft2(Mannschaft mannschaft2) {
        this.mannschaft2 = mannschaft2;
    }

    public Mannschaft getMannschaft3() {
        return mannschaft3;
    }

    public void setMannschaft3(Mannschaft mannschaft3) {
        this.mannschaft3 = mannschaft3;
    }

    public Mannschaft getMannschaft4() {
        return mannschaft4;
    }

    public void setMannschaft4(Mannschaft mannschaft4) {
        this.mannschaft4 = mannschaft4;
    }

    public Mannschaft getMannschaft5() {
        return mannschaft5;
    }

    public void setMannschaft5(Mannschaft mannschaft5) {
        this.mannschaft5 = mannschaft5;
    }

    public Mannschaft getMannschaft6() {
        return mannschaft6;
    }

    public void setMannschaft6(Mannschaft mannschaft6) {
        this.mannschaft6 = mannschaft6;
    }

    public List<Mannschaft> listeMannschaften(){
        List<Mannschaft> mannschaftList = new ArrayList<>() {};
        mannschaftList.add(mannschaft1);
        mannschaftList.add(mannschaft2);
        mannschaftList.add(mannschaft3);
        mannschaftList.add(mannschaft4);
        mannschaftList.add(mannschaft5);
        mannschaftList.add(mannschaft6);
        mannschaftList.sort(Comparator.comparing(Mannschaft::getPunkte));
        return mannschaftList;
    }
}
