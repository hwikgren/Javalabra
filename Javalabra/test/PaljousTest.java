/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author heidi
 */
public class PaljousTest {
    Kortisto kortisto;
    TreeMap<String, Henkilo> apuArray = new TreeMap<String, Henkilo>();
    
    public PaljousTest() {
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
    public void sataHenkiloa() throws FileNotFoundException, IOException, ClassNotFoundException {
        String aakkoset = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String etunimi = null;
        String sukunimi = null;
        String nimi = null;
        for (int i=0; i<100; i++) {
            String etu = "";
            for (int j=0; j<7; j++) {
                int indeksi = r.nextInt(26);
                etu += aakkoset.charAt(indeksi);
            }
            String suku = "";
            for (int k=0; k<15; k++) {
                int indeksi = r.nextInt(26);
                suku += aakkoset.charAt(indeksi);
            }
            if (i==21) {
                etunimi = etu;
                sukunimi = suku;
                nimi = suku+" "+etu;
            }
            kortisto.lisaaHenkilo(etu, suku);
        }
        assertTrue( kortisto.getKoko() == 100);
        String[] nimet = kortisto.haeNimet(nimi);
        assertEquals( nimet[1]+" "+nimet[0], nimi);
        long start = System.currentTimeMillis();
        String[] henkilot = kortisto.kaikkiHenkilot();
        long end = System.currentTimeMillis();
        System.out.println("Sadalla aika: "+(end-start));
        assertTrue( henkilot.length == 100);
        start = System.currentTimeMillis();
        ArrayList<String> haetut = kortisto.hae(etunimi, "", "");
        end = System.currentTimeMillis();
        System.out.println("Sadalla etsintäaika: "+(end-start));
    }
    @Test
    public void tuhansillaHenkiloilla() throws FileNotFoundException, IOException, ClassNotFoundException {
        String aakkoset = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String etunimi = null;
        String sukunimi = null;
        String nimi = null;
        for (int i=0; i<1000; i++) {
            String etu = "";
            for (int j=0; j<7; j++) {
                int indeksi = r.nextInt(26);
                etu += aakkoset.charAt(indeksi);
            }
            String suku = "";
            for (int k=0; k<15; k++) {
                int indeksi = r.nextInt(26);
                suku += aakkoset.charAt(indeksi);
            }
            if (i==21) {
                etunimi = etu;
                sukunimi = suku;
                nimi = suku+" "+etu;
            }
            kortisto.lisaaHenkilo(etu, suku);
        }
        assertTrue( kortisto.getKoko() == 1000);
        String[] nimet = kortisto.haeNimet(nimi);
        assertEquals( nimet[1]+" "+nimet[0], nimi);
        long start = System.currentTimeMillis();
        String[] henkilot = kortisto.kaikkiHenkilot();
        long end = System.currentTimeMillis();
        System.out.println("Tuhansilla aika: "+(end-start));
        assertTrue( henkilot.length == 1000);
        start = System.currentTimeMillis();
        ArrayList<String> haetut = kortisto.hae(etunimi, "", "");
        end = System.currentTimeMillis();
        System.out.println("Tuhansilla etsintäaika: "+(end-start));
    }
    @Test
    public void kymmenillaTuhansilla() throws FileNotFoundException, IOException, ClassNotFoundException {
        String aakkoset = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String etunimi = null;
        String sukunimi = null;
        String nimi = null;
        for (int i=0; i<10000; i++) {
            String etu = "";
            for (int j=0; j<7; j++) {
                int indeksi = r.nextInt(26);
                etu += aakkoset.charAt(indeksi);
            }
            String suku = "";
            for (int k=0; k<15; k++) {
                int indeksi = r.nextInt(26);
                suku += aakkoset.charAt(indeksi);
            }
            if (i==21) {
                etunimi = etu;
                sukunimi = suku;
                nimi = suku+" "+etu;
            }
            kortisto.lisaaHenkilo(etu, suku);
        }
        assertTrue( kortisto.getKoko() == 10000);
        String[] nimet = kortisto.haeNimet(nimi);
        assertEquals( nimet[1]+" "+nimet[0], nimi);
        long start = System.currentTimeMillis();
        String[] henkilot = kortisto.kaikkiHenkilot();
        long end = System.currentTimeMillis();
        System.out.println("Kymmenillätuhansilla aika: "+(end-start));
        assertTrue( henkilot.length == 10000);
        start = System.currentTimeMillis();
        ArrayList<String> haetut = kortisto.hae(etunimi, "", "");
        end = System.currentTimeMillis();
        System.out.println("Kymmenillätuhansilla etsintäaika: "+(end-start));
    }
}
