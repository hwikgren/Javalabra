
package Kortisto;

import Kayttoliittyma.Komennot;
import java.util.ArrayList;

/**
 * Sovellus-olio
 * @author heidi
 */
public class Kortisto {
    
    /**
     * Henkilö-olioiden säilytyspaikka
     */
    static ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
    
    /**
     * Henkilö-olio
     */
    static Henkilo henkilo;

    public Kortisto() {
    }
    /**
     * Metodi luo uuden Henkilö-olion.
     * Lisää sen henkilöt-ArrayListiin.
     * @param etu
     * @param suku 
     */
    public static void lisaaHenkilo(String etu, String suku) {
        henkilo = new Henkilo(etu, suku);
        henkilot.add(henkilo);
    }
    /**
     * Metodi lisää henkilölle taidon.
     * Pyytää etsiHenkilo-metodilta Henkilö-olion, saa Komennolta käyttäjän antaman taidon 
     * ja välittää sen Henkilö-oliolle.
     * @param etu
     * @param suku 
     */
    public static void lisaaOsaaminen(String etu, String suku) {
        henkilo = henkilot.get(etsiHenkilo(etu, suku));
        /**
         * Käyttäjältä saatu taito.
         */
        String osaaminen = Komennot.mikaOsaaminen(henkilo);
        henkilo.lisaaOsaaminen(osaaminen);
    }
    /**
     * Metodi palauttaa henkilön indeksin Arrayssa.
     * Käy läpi henkilot-Arrayn ja vertaa kunkin olion etu- ja sukunimeä parametreihin.
     * @param etu
     * @param suku
     * @return i indeksi Arrayssa
     */
    public static int etsiHenkilo(String etu, String suku) {
       for (int i=0; i<henkilot.size(); i++) {
           henkilo = henkilot.get(i);
           if (henkilo.getSukunimi().equals(suku)) {
               if (henkilo.getEtunimi().equals(etu)) {
                   return i;
               }
               
           }
       }
       return -1;
         
     }
    /**
     * Metodi tulostaa henkilöt.
     * Hakee henkilöt-Arrayn jokaisen henkilön etu- ja sukunimen.
     */
    public static void tulostaHenkilot() {
        for (Henkilo haettu : henkilot) {
            System.out.println(haettu.getEtunimi()+" "+haettu.getSukunimi());
        }
    }

}
