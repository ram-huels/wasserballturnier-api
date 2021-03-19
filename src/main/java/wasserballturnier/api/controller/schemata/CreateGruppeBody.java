package wasserballturnier.api.controller.schemata;

import wasserballturnier.api.persistence.mannschaft.Mannschaft;

import java.util.List;
import java.util.Objects;

public class CreateGruppeBody {

    private String gruppenname;

    private List<Mannschaft> mannschaftList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateGruppeBody that = (CreateGruppeBody) o;
        return Objects.equals(gruppenname, that.gruppenname) && Objects.equals(mannschaftList, that.mannschaftList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gruppenname, mannschaftList);
    }

    public String getGruppenname() {
        return gruppenname;
    }

    public List<Mannschaft> getMannschaftList() {
        return mannschaftList;
    }

    @Override
    public String toString() {
        return "CreateGruppeBody{" +
                "gruppenname='" + gruppenname + '\'' +
                ", mannschaftList=" + mannschaftList +
                '}';
    }
}
