
package Kortisto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
    public void lisaaOsaaminen(String osaaminen, String taso) {
        Taito taito = new Taito(osaaminen);
        taito.setTaso(taso);
        this.taidot.add(taito);
    }
    
    public HashMap<String, String> haeTaidot() {
        HashMap<String, String> henkilonTaidot = new HashMap<String, String>();
        for (int i=0; i<taidot.size(); i++) {
            Taito taito = taidot.get(i);
            String henkilonTaito = taito.getOsaaminen();
            String taso = taito.getTaso();
            henkilonTaidot.put(henkilonTaito, taso);
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
