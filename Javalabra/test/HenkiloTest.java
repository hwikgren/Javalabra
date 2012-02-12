/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        assertEquals( 1, henkilo.getMaara() );
    }
    
    @Test
    public void jarjestaTaidotToimii() throws FileNotFoundException, IOException, ClassNotFoundException {
        Kortisto kortisto = new Kortisto();
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "java", "Hyvä");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "sql", "Kohtalainen");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "php", "Erinomainen");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "mallintaminen", "Erinomainen");
        String[][] taidot = kortisto.haeOsaamiset("jauhiainen heidi");
        assertEquals ("mallintaminen", taidot[0][0]);
    }
}
