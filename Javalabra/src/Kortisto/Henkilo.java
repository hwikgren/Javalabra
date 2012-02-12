
package Kortisto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

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
    
    public String[][] haeTaidot() {
        String[][] henkilonTaidot = new String[taidot.size()][2];
        for (int i=0; i<taidot.size(); i++) {
            Taito taito = taidot.get(i);
            String henkilonTaito = taito.getOsaaminen();
            henkilonTaidot[i][0] = henkilonTaito;
            String taso = taito.getTaso();
            henkilonTaidot[i][1] = taso;
        }
        henkilonTaidot = jarjestaTaidot(henkilonTaidot);
        return henkilonTaidot;
    }
    
    public String[][] jarjestaTaidot(String[][] taidot) {
        TreeMap<String, String> kohtalaiset = new TreeMap<String, String>();
        TreeMap<String, String> hyvat = new TreeMap<String, String>();
        TreeMap<String, String> erinomaiset = new TreeMap<String, String>();
        for (int i=0; i<taidot.length; i++) {
            if (taidot[i][1].equals("Kohtalainen")) {
                kohtalaiset.put(taidot[i][0], "Kohtalainen");
            }
            else if (taidot[i][1].equals("Hyvä")) {
                hyvat.put(taidot[i][0], "Hyvä");
            }
            if (taidot[i][1].equals("Erinomainen")) {
                erinomaiset.put(taidot[i][0], "Erinomainen");
            }
        }
        String[][] palautus = new String[taidot.length][2];
        int koko = erinomaiset.size();
        for (int i=0; i<koko; i++) {
            palautus[i][0] = erinomaiset.firstKey();
            palautus[i][1] = erinomaiset.get(erinomaiset.firstKey());
            erinomaiset.remove(erinomaiset.firstKey());
            
        }
        int koko2 = hyvat.size() + koko;
        for (int i=koko; i<koko2; i++) {
            palautus[i][0] = hyvat.firstKey();
            palautus[i][1] = hyvat.get(hyvat.firstKey());
            hyvat.remove(hyvat.firstKey());
            
        }
        int koko3 = kohtalaiset.size() + koko2;
        for (int i=koko2; i<koko3; i++) {
            palautus[i][0] = kohtalaiset.firstKey();
            palautus[i][1] = kohtalaiset.get(kohtalaiset.firstKey());
            kohtalaiset.remove(kohtalaiset.firstKey());
            
        }
        return palautus;
    }
    
    public ArrayList<String> haePelkatTaidot() {
        ArrayList<String> henkilonTaidot = new ArrayList<String>();
        for (int i=0; i<taidot.size(); i++) {
            Taito taito = taidot.get(i);
            String henkilonTaito = taito.getOsaaminen();
            henkilonTaidot.add(henkilonTaito);
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
