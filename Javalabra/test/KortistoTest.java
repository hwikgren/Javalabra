
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author hwikgren
 */
public class KortistoTest {
    Kortisto kortisto;
    TreeMap<String, Henkilo> apuArray = new TreeMap<String, Henkilo>();
    
    public KortistoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws FileNotFoundException, IOException, ClassNotFoundException {
        kortisto = new Kortisto();
        for (String haettu : kortisto.henkilot.keySet()) {
            apuArray.put(haettu, kortisto.henkilot.get(haettu));
        }
        kortisto.henkilot.clear();
    }
    
    @After
    public void tearDown() {
        for (String haettu : kortisto.henkilot.keySet()) {
            apuArray.put(haettu, kortisto.henkilot.get(haettu));
        }
        kortisto.henkilot.clear();
        for (String haettu : apuArray.keySet()) {
            kortisto.henkilot.put(haettu, apuArray.get(haettu));
        }
        apuArray.clear();
    }
    
    
    @Test
    public void KortistonLuominenLuoArrayn() {
        assertTrue( kortisto.getKoko() >=0 );
    }
    
    @Test
    public void LisayksenJalkeenArrayssaYksiEnemman() {
        int vanha = kortisto.getKoko();
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertEquals( vanha+1, kortisto.getKoko() );
    }
    
    /*@Test
    public void etsiHenkiloToimii() {
        int vanhaPaikka = kortisto.getKoko()-1;
        int uusiPaikka = vanhaPaikka+1;
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertEquals( uusiPaikka, kortisto.etsiHenkilo("heidi", "jauhiainen") );
    }*/
    
    /*@Test
    public void etsiHenkiloToimiiKunArrayssaUseampia() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        int paikka = kortisto.getKoko()-2;
        assertEquals( paikka, kortisto.etsiHenkilo("tommi", "jauhiainen") );
    }*/
    
    @Test
    public void toStringToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        assertTrue( kortisto.toString().length() > 0 );
    }
    
    @Test
    public void henkilonPoistoToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.poistaHenkilo("koehenkilo kalle");
        String tulostus = "jauhiainen heidi\n"
                + "jauhiainen tommi\n";
        assertEquals( kortisto.toString(), tulostus );
    }
    
    /*@Test
    public void tiedostonLataaminenPalauttaaOliot() throws IOException, FileNotFoundException, ClassNotFoundException {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        kortisto.tallennaTiedot();
        int koko = kortisto.getKoko();
        for (int i=koko-1; i>=0; i--) {
            kortisto.poistaHenkiloArraysta(i);
        }
        assertEquals( 0, kortisto.getKoko() );
        kortisto.lataaTiedot();
        assertEquals( 3, kortisto.getKoko() );
    }
    
    @Test
    public void tiedostonLataaminenPalauttaaTiedot() throws IOException, FileNotFoundException, ClassNotFoundException {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        kortisto.tallennaTiedot();
        int koko = kortisto.getKoko();
        for (int i=koko-1; i>=0; i--) {
            kortisto.poistaHenkiloArraysta(i);
        }
        kortisto.lataaTiedot();
        String tulostus = "heidi jauhiainen\n"
                + "tommi jauhiainen\n"
                + "kalle koehenkilo\n";
        assertEquals( kortisto.toString(), tulostus );
    }*/
    
    /*@Test
    public void getHenkiloToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertTrue( kortisto.getHenkilo(0) != null);
    }*/
    
    @Test
    public void getOsaamisetToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "java", "Hyvä");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "sql", "Kohtalainen");
        String[][] taidot = kortisto.haeOsaamiset("jauhiainen heidi");
        String haetut = "";
        for (int i=0; i<taidot.length; i++) {
            haetut += taidot[i][0]+" ";
        }
        assertEquals( haetut, "java sql ");
    }
    @Test
    public void getOsaamisTasoToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "java", "Hyvä");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "sql", "Kohtalainen");
        String[][] taidot= kortisto.haeOsaamiset("jauhiainen heidi");
        String haetut = "";
        for (int i=0; i<taidot.length; i++) {
            haetut += taidot[i][1] +" ";
        }
        assertEquals( haetut, "Hyvä Kohtalainen ");
    }
    @Test
    public void tyhjennaHenkilonTaidotToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaOsaaminen("jauhiainen heidi", "java", "Hyvä");
        kortisto.tyhjennaHenkilonTaidot("jauhiainen heidi");
        String[][] taidot= kortisto.haeOsaamiset("jauhiainen heidi");
        assertEquals( 0, taidot.length );
    }
}
