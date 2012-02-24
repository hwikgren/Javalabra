/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortisto;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Haku-olio suorittaa erilaiset haut kortistosta.
 * @author heidi
 */
public class Haku {
    /**
     * TreeMap pitää henkilöt aakkosjärjestyksessä
     */
    private TreeMap<String, Henkilo> henkilot;
    
    /**
     * Henkilö olio
     */
    Henkilo henkilo;

    /**
     * kostruktori saa henkilöt-treeMapin parametrina
     * @param henkilot 
     */
    public Haku(TreeMap<String, Henkilo> henkilot) {
        this.henkilot = henkilot;
    }
    
    /**
     * Metodi hakee etu ja sukunimen mukaisen henkilön.
     * Palauttaa ArrayListin.
     * @param etu
     * @param suku
     * @return haettu
     */
    public ArrayList<String> haeKokoNimella(String etu, String suku) {
        ArrayList<String> haettu = new ArrayList<String>();
        String kokoNimi = suku+" "+etu;
        if (henkilot.get(kokoNimi) != null) {
            henkilo = henkilot.get(kokoNimi);
            haettu.add(henkilo.sukunimi+" "+henkilo.etunimi);
        }
        return haettu;
    }

    /**
     * Metodi hakee etunimen mukaiset henkilöt.
     * Palauttaa ArrayListin
     * @param etu
     * @return haetut
     */
    public ArrayList<String> haeEtunimella(String etu) {
        ArrayList<String> haetut = new ArrayList<String>();
        for (String nimi : henkilot.keySet()) {
            Henkilo haettu = henkilot.get(nimi);
            if (haettu.etunimi.indexOf(etu) != -1) {
                haetut.add(haettu.sukunimi+" "+haettu.etunimi);
            }
        }
        return haetut;
    }

    /**
     * Metodi hakee sukunimen mukaiset henkilöt.
     * Palauttaa arraylistin.
     * @param suku
     * @return haetut
     */
    public ArrayList<String> haeSukunimella(String suku) {
        ArrayList<String> haetut = new ArrayList<String>();
        for (String nimi : henkilot.keySet()) {
            Henkilo haettu = henkilot.get(nimi);
            if (haettu.sukunimi.equals(suku)) {
                haetut.add(haettu.sukunimi+" "+haettu.etunimi);
            }
        }
        return haetut;
    }

    /**
     * Metodi hakee kaikki henkilöt joilla on annettu taito.
     * Palauttaa Arraylistin.
     * @param taito
     * @return haetut
     */
    public ArrayList<String> haeTaidolla(String taito) {
        ArrayList<String> haetut = new ArrayList<String>();
        for (String nimi : henkilot.keySet()) {
            Henkilo haettu = henkilot.get(nimi);
            ArrayList<String> taidot = haettu.haePelkatTaidot();
            for (String henkilonTaito : taidot) {
                if ((taito.length() == 1 && henkilonTaito.equals(taito)) || (taito.length()>1 && henkilonTaito.indexOf(taito) == 0)) {
                    haetut.add(haettu.sukunimi+" "+haettu.etunimi);
                }
            }
        }
        return haetut;
    }
}
