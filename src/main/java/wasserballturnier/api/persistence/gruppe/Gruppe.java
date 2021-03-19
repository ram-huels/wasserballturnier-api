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

    @OneToMany
    private List<Mannschaft> mannschaftList;

    @OneToMany
    private List<Spiel> spielList;

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

    public List<Mannschaft> getMannschaftList() {
        return mannschaftList;
    }

    public void setMannschaftList(List<Mannschaft> mannschaftList) {
        this.mannschaftList = mannschaftList;
    }

    public List<Spiel> getSpielList() {
        return spielList;
    }

    public void setSpielList(List<Spiel> spielList) {
        this.spielList = spielList;
    }

    public void addMannschaftZurGruppe(Mannschaft mannschaft){
        this.mannschaftList.add(mannschaft);
    }

    public void addSpielZurGruppe(Spiel spiel){
        this.spielList.add(spiel);
    }
}
