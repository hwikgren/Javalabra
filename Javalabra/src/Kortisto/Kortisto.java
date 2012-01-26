
package Kortisto;

import Kayttoliittyma.Komennot;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Kortisto {
    
    public static Scanner lukija = new Scanner(System.in);
      
    static ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
    static Henkilo henkilo;

    public Kortisto() {
    }
    /**
     * Metodi luo uuden Henkilö olion ja lisää sen henkilöt ArrayListiin
     * @param etu
     * @param suku 
     */
    public static void lisaaHenkilo(String etu, String suku) {
        henkilo = new Henkilo(etu, suku);
        henkilot.add(henkilo);
    }
    /**
     * Metodi pyytää etsiHenkilo-metodilta Henkilö-olion,
     * pyytää Komentoja kysymään mikä taito lisätään
     * ja lisää Henkilö-oliolle kyseisen taidon
     * @param etu
     * @param suku 
     */
    public static void lisaaOsaaminen(String etu, String suku) {
        henkilo = henkilot.get(etsiHenkilo(etu, suku));
        String osaaminen = Komennot.mikaOsaaminen(henkilo);
        henkilo.lisaaOsaaminen(osaaminen);
    }
    /**
     * Metodi käy läpi henkilot-Arrayn,
     * vertaa kunkin olion etu- ja sukunimeä parametreihin
     * @param etu
     * @param suku
     * @return henkilön indeksi Arrayssa
     */
    public static int etsiHenkilo(String etu, String suku) {
       for (int i=0; i<henkilot.size(); i++) {
           henkilo = henkilot.get(i);
           if (henkilo.getSukunimi().equals(suku) || henkilo.getEtunimi().equals(etu)) {
               return i;
           }
       }
       return -1;
         
     }
    /**
     * Metodi tulostaa henkilot-Arrayn henkilot
     * hakemalla kunkin etu- ja sukunimen
     */
    public static void tulostaHenkilot() {
        for (Henkilo haettu : henkilot) {
            System.out.println(haettu.getEtunimi()+" "+haettu.getSukunimi());
        }
    }

}
