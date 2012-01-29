/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hwikgren
 */
public class KortistoTest {
    Kortisto kortisto;
    ArrayList<Henkilo> apuArray = new ArrayList<Henkilo>();
    
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
        for (int i=kortisto.getKoko()-1; i>=0; i--) {
            apuArray.add(kortisto.getHenkilo(i));
            kortisto.poistaHenkiloArraysta(i);
        }
    }
    
    @After
    public void tearDown() {
        for (int i=kortisto.getKoko()-1; i>=0; i--) {
            kortisto.poistaHenkiloArraysta(i);
        }
        for (int i=apuArray.size()-1; i>=0; i--) {
            kortisto.henkilot.add(apuArray.get(i));
        }
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
    
    @Test
    public void etsiHenkiloToimii() {
        int vanhaPaikka = kortisto.getKoko()-1;
        int uusiPaikka = vanhaPaikka+1;
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertEquals( uusiPaikka, kortisto.etsiHenkilo("heidi", "jauhiainen") );
    }
    
    @Test
    public void etsiHenkiloToimiiKunArrayssaUseampia() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        int paikka = kortisto.getKoko()-2;
        assertEquals( paikka, kortisto.etsiHenkilo("tommi", "jauhiainen") );
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
        kortisto.poistaHenkilo("kalle", "koehenkilo");
        String tulostus = "heidi jauhiainen\n"
                + "tommi jauhiainen\n";
        assertEquals( kortisto.toString(), tulostus );
    }
    
    @Test
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
    }
}
