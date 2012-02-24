/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author hwikgren
 */
public class HenkiloTest {
    
    Henkilo henkilo;
    
    public HenkiloTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        henkilo = new Henkilo("heidi", "jauhiainen");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void KonstruktoriLuoHenkilon() {
        assertEquals( henkilo.getEtunimi(), "heidi");
        assertEquals( henkilo.getSukunimi(), "jauhiainen");
    }
    
    @Test
    public void osaaminenMeneeArrayhun() {
        henkilo.lisaaOsaaminen("java", "Erinomainen");
        henkilo.lisaaOsaaminen("sql", "Hyvä");
        assertEquals( 2, henkilo.getMaara() );
    }
    
    @Test
    public void taitojenHakuToimii() {
        henkilo.lisaaOsaaminen("java", "Erinomainen");
        henkilo.lisaaOsaaminen("sql", "Hyvä");
        ArrayList<String> taidot = henkilo.haePelkatTaidot();
        String on = "";
        for (String taito : taidot) {
            on += taito+" ";
        }
        String pitaisiOlla = "java sql ";
        assertEquals( pitaisiOlla, on );
    }
    
    @Test
    public void jarjestaTaidotToimii() throws FileNotFoundException, IOException, ClassNotFoundException {
        Kortisto kortisto = new Kortisto();
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaTaito("jauhiainen heidi", "java", "Hyvä");
        kortisto.lisaaTaito("jauhiainen heidi", "sql", "Kohtalainen");
        kortisto.lisaaTaito("jauhiainen heidi", "php", "Erinomainen");
        kortisto.lisaaTaito("jauhiainen heidi", "mallintaminen", "Erinomainen");
        kortisto.lisaaTaito("jauhiainen heidi", "testaus", "");
        String[][] taidot = kortisto.haeTaidot("jauhiainen heidi");
        assertEquals ("php", taidot[1][0]);
        assertEquals ("sql", taidot[3][0]);
        assertEquals ("Hyvä", taidot[2][1]);
        assertEquals ("Kohtalainen", taidot[3][1]);
    }
}
