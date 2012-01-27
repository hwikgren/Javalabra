
package Kortisto;

import java.util.ArrayList;

/**
 * Henkilö on olio, jolla voi olla erilaisia taitoja
 * @author heidi
 */
public class Henkilo {
    String etunimi;
    String sukunimi;
    /**
     * Henkilön Taito-olioiden säilytyspaikka.
     */
    static ArrayList<Taito> taidot = new ArrayList<Taito>();
 
    public Henkilo() {
    }
    
    /**
     * Luo Henkilö-olion jolla on nimi.
     * @param etu
     * @param suku 
     */
    public Henkilo(String etu, String suku) {
         this.etunimi = etu;
         this.sukunimi = suku;
    }
    
    /**
     * Metodi lisää Henkilö-Oliolle Taito-olion
     * @param osaaminen 
     */
    public void lisaaOsaaminen(String osaaminen) {
        Taito taito = new Taito(osaaminen);
        taidot.add(taito);
    }
    
    /**
     * Palauttaa henkilön etunimen.
     * @return etunimi
     */
    public String getEtunimi() {
        return this.etunimi;
    }
    
    /**
     * Palauttaa henkilön sukunimen.
     * @return sukunimi
     */
    public String getSukunimi() {
        return this.sukunimi;
    }
    
    public int getMaara() {
        return taidot.size();
    }
    
    
}
