/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortisto;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author heidi
 */
public class Haku {
    
    private TreeMap<String, Henkilo> henkilot;
    Henkilo henkilo;

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
            if (haettu.etunimi.equalsIgnoreCase(etu)) {
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
            if (haettu.sukunimi.equalsIgnoreCase(suku)) {
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
                if (henkilonTaito.equalsIgnoreCase(taito)) {
                    haetut.add(haettu.sukunimi+" "+haettu.etunimi);
                }
            }
        }
        return haetut;
    }
}
