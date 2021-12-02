package test;


import org.junit.Test;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.mannschaft.Mannschaftsklasse;
import static org.junit.Assert.assertEquals;


public class EnumTest {

    @Test
    public void testEnumMannschaftsklasse(){
        Mannschaft mannschaft = new Mannschaft("Test", "HERREN");
        assertEquals(Mannschaftsklasse.HERREN, mannschaft.getMannschaftsklasse());
        assertEquals("Test", mannschaft.getMannschaftsname());
    }
}
