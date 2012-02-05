
package Kortisto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Henkilö on olio, jolla voi olla erilaisia taitoja
 * @author heidi
 */
public class Henkilo implements Serializable {
    String etunimi;
    String sukunimi;
    /**
     * Henkilön Taito-olioiden säilytyspaikka.
     */
    ArrayList<Taito> taidot;
 
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
         taidot = new ArrayList<Taito>();
    }
    
    /**
     * Metodi lisää Henkilö-Oliolle Taito-olion
     * @param osaaminen 
     */
    public void lisaaOsaaminen(String osaaminen) {
        Taito taito = new Taito(osaaminen);
        this.taidot.add(taito);
    }
    
    public String[] haeTaidot() {
        String[] henkilonTaidot = new String[taidot.size()];
        for (int i=0; i<taidot.size(); i++) {
            Taito taito = taidot.get(i);
            henkilonTaidot[i] = taito.getOsaaminen();
        }
        return henkilonTaidot;
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
    /**
     * Metodi palauttaa henkilön taitojen määrän.
     * Antaa taidot-arrayn koon.
     * @return taidot.size();
     */
    public int getMaara() {
        return taidot.size();
    }
    
    public void tyhjennaArray() {
        taidot.clear();
    }
}
