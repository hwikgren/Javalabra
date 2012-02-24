
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
    public void getKokoToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertEquals( 1, kortisto.getKoko() );
    }
    @Test
    public void LisayksenJalkeenArrayssaYksiEnemman() {
        int vanha = kortisto.getKoko();
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertEquals( vanha+1, kortisto.getKoko() );
    }
    
    @Test
    public void taidonPoistoToimii() {
        kortisto.lisaaHenkilo("Heidi", "Jauhiainen");
        kortisto.lisaaTaito("Jauhiainen Heidi", "JAVA", "Hyvä");
        kortisto.lisaaTaito("Jauhiainen Heidi", "SQL", "Kohtalainen");
        String[][] taidot = kortisto.haeTaidot("Jauhiainen Heidi");
        assertEquals( 2, taidot.length );
        kortisto.poistaTaito("Jauhiainen Heidi", "SQL");
        String[][] uusi  = kortisto.haeTaidot("Jauhiainen Heidi");
        assertEquals( 1, uusi.length);
    }
    
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
        String pitaisiOlla = "jauhiainen heidi jauhiainen tommi ";
        String on = "";
        String[] henkilot= kortisto.kaikkiHenkilot();
        for (int i=0; i<henkilot.length; i++) {
            on += henkilot[i]+" ";
        }
        assertEquals( on, pitaisiOlla );
    }
    
    @Test
    public void getOsaamisetToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaTaito("jauhiainen heidi", "java", "Hyvä");
        kortisto.lisaaTaito("jauhiainen heidi", "sql", "Kohtalainen");
        String[][] taidot = kortisto.haeTaidot("jauhiainen heidi");
        String haetut = "";
        for (int i=0; i<taidot.length; i++) {
            haetut += taidot[i][0]+" ";
        }
        assertEquals( haetut, "java sql ");
    }
    @Test
    public void getOsaamisTasoToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaTaito("jauhiainen heidi", "java", "Hyvä");
        kortisto.lisaaTaito("jauhiainen heidi", "sql", "Kohtalainen");
        String[][] taidot= kortisto.haeTaidot("jauhiainen heidi");
        String haetut = "";
        for (int i=0; i<taidot.length; i++) {
            haetut += taidot[i][1] +" ";
        }
        assertEquals( haetut, "Hyvä Kohtalainen ");
    }
    @Test
    public void tyhjennaHenkilonTaidotToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaTaito("jauhiainen heidi", "java", "Hyvä");
        kortisto.tyhjennaHenkilonTaidot("jauhiainen heidi");
        String[][] taidot= kortisto.haeTaidot("jauhiainen heidi");
        assertEquals( 0, taidot.length );
    }
    
    @Test
    public void hakuEtunimellaToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "tomera");
        ArrayList<String> haetut = kortisto.hae("tommi", "", "");
        assertEquals( 2, haetut.size() );
    }
    
    @Test
    public void hakuSukunimellaToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "tomera");
        ArrayList<String> haetut = kortisto.hae("", "jauhiainen", "");
        assertEquals( 2, haetut.size() );
    }
    
    @Test
    public void hakuKokonimellaToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "tomera");
        ArrayList<String> haetut = kortisto.hae("tommi", "tomera", "");
        assertEquals( "tomera tommi", haetut.get(0));
    }
    @Test
    public void hakuTaidollaToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaTaito("jauhiainen heidi", "java", "Hyvä");
        kortisto.lisaaTaito("jauhiainen heidi", "sql", "Kohtalainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "tomera");
        kortisto.lisaaTaito("tomera tommi", "java", "Erinomainen");
        ArrayList<String> haetut = kortisto.hae("", "", "java");
        assertEquals( 2, haetut.size() );
    }
    @Test
    public void nimiMuuttuu() {
        kortisto.lisaaHenkilo("heidi", "wikgren");
        kortisto.muutaNimea("wikgren heidi", "heidi", "jauhiainen");
        String pitaisiOlla = "jauhiainen heidi ";
        String on = "";
        String[] henkilot= kortisto.kaikkiHenkilot();
        for (int i=0; i<henkilot.length; i++) {
            on += henkilot[i]+" ";
        }
        assertEquals( on, pitaisiOlla );
    }
    @Test
    public void haeNimetToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "tomera");
        String[] nimet = kortisto.haeNimet("jauhiainen tommi");
        String suku = nimet[1];
        String etu = nimet[0];
        assertEquals ( suku, "jauhiainen" );
        assertEquals ( etu, "tommi" );
    }
    
    @Test
    public void valitaHenkiloOlioToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "tomera");
        assertTrue( kortisto.valitaHenkiloOlio("jauhiainen tommi") != null );        
    }
    @Test
    public void muokkaaNimeaToimii() {
        assertEquals( kortisto.muokkaaNimi("heidi"), "Heidi");
        assertEquals( kortisto.muokkaaNimi("kalle k"), "Kalle K");
        assertEquals( kortisto.muokkaaNimi("toivari-viitala"), "Toivari-Viitala");
        assertEquals( kortisto.muokkaaNimi("lotta maaria"), "Lotta Maaria");
    }
    
    
}
