
package Kortisto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.TreeMap;

/**
 * Henkilö on olio, jolla voi olla erilaisia taitoja
 * @author heidi
 */
public class Henkilo extends Observable implements Serializable {
    
    /**
     * Henkilön Taito-olioiden säilytyspaikka.
     */
    ArrayList<Taito> taidot;
    String etunimi;
    String sukunimi;
 
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
    
    /**
     * Metodi palauttaa henkilön taidot String-taulukossa.
     * Taidot haetaan taidot-arraylistista ja sitten metodi kutsuu jarjestaTaidot-metodia.
     * @return henkilonTaidot
     */
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
    
    /**
     * Metodi järjestää taidot.
     * Taidot järjestetään ensisijaisesti taidon tason mukaan, toissijaisesti aakkosten mukaan.
     * @param taidot
     * @return 
     */
    public String[][] jarjestaTaidot(String[][] taidot) {
        TreeMap<String, String> kohtalaiset = new TreeMap<String, String>();
        TreeMap<String, String> hyvat = new TreeMap<String, String>();
        TreeMap<String, String> erinomaiset = new TreeMap<String, String>();
        TreeMap<String, String> tyhjat = new TreeMap<String, String>();
        for (int i=0; i<taidot.length; i++) {
            if (taidot[i][1].equals("Kohtalainen")) {
                kohtalaiset.put(taidot[i][0], "Kohtalainen");
            }
            else if (taidot[i][1].equals("Hyvä")) {
                hyvat.put(taidot[i][0], "Hyvä");
            }
            else if (taidot[i][1].equals("Erinomainen")) {
                erinomaiset.put(taidot[i][0], "Erinomainen");
            }
            else if (taidot[i][1].equals("")) {
                tyhjat.put(taidot[i][0], "");
            }
        }
        String[][] palautus = new String[taidot.length][2];
        int koko = erinomaiset.size();
        palautus = palauta(palautus, erinomaiset, 0, koko);
        int koko2 = hyvat.size() + koko;
        palautus = palauta(palautus, hyvat, koko, koko2);
        int koko3 = kohtalaiset.size() + koko2;
        palautus = palauta(palautus, kohtalaiset, koko2, koko3);
        int koko4 = tyhjat.size() + koko3;
        palautus = palauta(palautus, tyhjat, koko3, koko4);
        return palautus;
    }
    
    private String[][] palauta(String[][] palautus, TreeMap<String, String> map, int koko1, int koko2) {
        for (int i=koko1; i<koko2; i++) {
            palautus[i][0] = map.firstKey();
            palautus[i][1] = map.get(map.firstKey());
            map.remove(map.firstKey());
        }
        return palautus;
    }
    
    /**
     * Metodi palauttaa henkilon taidot ilman tasoja.
     * @return 
     */
    public ArrayList<String> haePelkatTaidot() {
        ArrayList<String> henkilonTaidot = new ArrayList<String>();
        for (int i=0; i<taidot.size(); i++) {
            Taito taito = taidot.get(i);
            String henkilonTaito = taito.getOsaaminen();
            henkilonTaidot.add(henkilonTaito);
        }
        return henkilonTaidot;
    }
    public void setEtunimi(String etu) {
        this.etunimi = etu;
    }
    
    public void setSukunimi(String suku) {
        this.sukunimi = suku;
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
   
    public void muutaNimea(String etu, String suku) {
        this.etunimi = etu;
        this.sukunimi = suku;
        String nimi = sukunimi+" "+etunimi;
        setChanged();
        notifyObservers(nimi);
    }
    /**
     * Metodi palauttaa henkilön taitojen määrän.
     * Antaa taidot-arrayn koon.
     * @return taidot.size();
     */
    public int getMaara() {
        return taidot.size();
    }
    
    public void poistaTaito(String poistettava) {
        for (Taito taito : taidot) {
            if (taito.getOsaaminen().equalsIgnoreCase(poistettava)) {
                taidot.remove(taito);
                break;
            }
        }
    }
    
    /**
     * Metodi tyhjentää henkilon taidot-arrayn.
     * Käytetään ennen kuin tallennetaan henkiloikkuna, jossa tiedot saattavat olla muuttuneet.
     */
    public void tyhjennaArray() {
        taidot.clear();
    }
}
