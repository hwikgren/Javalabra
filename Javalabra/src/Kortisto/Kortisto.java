
package Kortisto;

import Kayttoliittyma.Komennot;
import java.util.ArrayList;

/**
 * Sovelluslogiikka-olio
 * @author heidi
 */
public class Kortisto {
    
    /**
     * Henkilö-olioiden säilytyspaikka
     */
    private ArrayList<Henkilo> henkilot;
    
    /**
     * Henkilö-olio
     */
    private Henkilo henkilo;

    public Kortisto() {
        henkilot = new ArrayList<Henkilo>();
    }
    
    public int getKoko() {
        return henkilot.size();
    }
    /**
     * Metodi luo uuden Henkilö-olion.
     * Lisää sen henkilöt-ArrayListiin.
     * @param etu
     * @param suku 
     */
    public void lisaaHenkilo(String etu, String suku) {
        henkilo = new Henkilo(etu, suku);
        henkilot.add(henkilo);
    }
    /**
     * Metodi lisää henkilölle taidon.
     * Hakee henkilö-olion Arraysta ja välittää tälle käyttäjän antaman taidon.
     * @param indeksi Henkilön indeksi Arrayssa
     * @param taito 
     */
    public void lisaaOsaaminen(int indeksi, String taito) {
        henkilo = henkilot.get(indeksi);
        
        henkilo.lisaaOsaaminen(taito);
    }
    /**
     * Metodi palauttaa henkilön indeksin Arrayssa.
     * Käy läpi henkilot-Arrayn ja vertaa kunkin olion etu- ja sukunimeä parametreihin.
     * @param etu
     * @param suku
     * @return i indeksi Arrayssa
     */
    public int etsiHenkilo(String etu, String suku) {
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
    public String toString() {
        String tulostus = "";
        for (Henkilo haettu : henkilot) {
            tulostus += haettu.getEtunimi()+" "+haettu.getSukunimi()+"\n";
        }
        return tulostus;
    }

}
