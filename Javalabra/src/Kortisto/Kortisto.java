
package Kortisto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.TreeMap;

/**
 * Sovelluslogiikka-olio
 * @author heidi
 */
public class Kortisto extends Observable {
    
    /**
     * Henkilö-olioiden säilytyspaikka
     */
    public TreeMap<String, Henkilo> henkilot;
    Tallennus tallentaja;
    Haku hakija;
    
    /**
     * Henkilö-olio
     */
    private Henkilo henkilo;
    /**
     * Konstuktori luo kortisto-olion.
     * Lataa mahdolliset olemassa olevat henkilö-oliot tiedostosta TreeMapiin.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Kortisto() throws FileNotFoundException, IOException, ClassNotFoundException {
        henkilot = new TreeMap<String, Henkilo>();
        tallentaja = new Tallennus();
        henkilot = tallentaja.lataaTiedot();
        hakija = new Haku(henkilot);
    }
    /**
     * Metodi palauttaa henkilö-olioiden määrän.
     * @return henkilot.size()
     */
    public int getKoko() {
        return henkilot.size();
    }
    
    /**
     * Metodi luo uuden Henkilö-olion.
     * Lisää sen henkilöt-TreeMapiin.
     * @param etu
     * @param suku 
     */
    public void lisaaHenkilo(String etu, String suku) {
        henkilo = new Henkilo(etu, suku);
        String nimi = suku+" "+etu;
        if (suku.equals("")) {
            nimi.trim();
        }
        henkilot.put(nimi, henkilo);
        setChanged();
        notifyObservers(kaikkiHenkilot());
    }
    
    /**
     * Metodi lisää henkilölle taidon.
     * Hakee henkilö-olion Arraysta ja välittää tälle käyttäjän antaman taidon.
     * @param indeksi Henkilön indeksi Arrayssa
     * @param taito 
     */
    public void lisaaTaito(String nimi, String taito, String taso) {
        henkilo = henkilot.get(nimi);
        henkilo.lisaaOsaaminen(taito, taso);
    }
    
    /**
     * Metodi muuttaa henkilön etu- ja sukunimet annetuiksi.
     * Hakee annetun nimen mukaisen olion ja muutaa sen nimet. Poistaa kyseisen olion TreeMapista.
     * Panee olion takaisin TreeMapiin uusilla nimillä.
     * Kertoo muutoksesta Paaikkunalle, joka observoi.
     * @param nimi
     * @param etu
     * @param suku 
     */
    public void muutaNimea(String nimi, String etu, String suku) {
        henkilo = henkilot.get(nimi);
        henkilo.muutaNimea(etu, suku);
        henkilot.remove(nimi);
        henkilot.put(suku+" "+etu, henkilo);
        setChanged();
        notifyObservers(kaikkiHenkilot());
    }
    
    /**
     * Metodi palauttaa henkilön nimet taulussa.
     * @param nimi
     * @return 
     */
    public String[] haeNimet(String nimi) {
        String[] nimet = new String[2];
        henkilo = henkilot.get(nimi);
        nimet[0] = henkilo.getEtunimi();
        nimet[1] = henkilo.getSukunimi();
        return nimet;
    }
    
    /**
     * Metodi hakee tietyn henkilön taidot.
     * Ensin haetaan henkilo-olio ja sitten tämän taidot string-taulukossa.
     * @param indeksi
     * @return taidot-taulukko (String)
     */
    public String[][] haeTaidot(String nimi) {
        henkilo = henkilot.get(nimi);
        return henkilo.haeTaidot();
    }
    
    /**
     * Metodi poistaa annetusta taulukosta annetun taidon.
     * Palauttaa yhtä pienemmän taulun. 
     * @param taidot
     * @param taito
     * @return uusiTaidot
     */
    public void poistaTaito(String nimi, String taito) {
        henkilo = henkilot.get(nimi);
        henkilo.poistaTaito(taito);
    }
    
    /**
     * Metodi poistaa nimen mukaisen henkilön TreeMapista.
     * Kertoo muutoksesta Paaikkunalle, joka observoi.
     * @param etu
     * @param suku 
     */
    public void poistaHenkilo(String nimi) {
        henkilot.remove(nimi);
        setChanged();
        notifyObservers(kaikkiHenkilot());
    }
    
    /**
     * Metodi tyhjentää henkilön taidot.
     * Ensin haetaan henkilo-olio ja sitten tyhjennetään henkilön taidot-taulukko.
     * Metodia käytetään kun lisäys-ikkunassa on lisätty henkilölle taitoja.
     * @param indeksi 
     */
    public void tyhjennaHenkilonTaidot(String nimi) {
        henkilo = henkilot.get(nimi);
        henkilo.tyhjennaArray();
    }
    
    
    
    /**
     * Metodi palauttaa String-taulukkona kaikki kortistossa olevat henkilöt.
     * @return palautus
     */
    public String[] kaikkiHenkilot() {
        String[]  palautus = new String[henkilot.size()];
        int i=0;
        for (String haettu : henkilot.keySet()) {
            palautus[i] = haettu;
            i++;
        }
        return palautus;
    }
    
    /**
     * Metodi käy läpi annetut parametrit.
     * Sen mukaan onko parametri tyhjä vai ei, metodi kutsuu erilaisia haku-olion metodeita. 
     * Palauttaa haun tulokset ArrayListina.
     * @param etu
     * @param suku
     * @param taito
     * @return haetut
     */
    public ArrayList<String> hae(String etu, String suku, String taito) {
        ArrayList<String> haetut;
        if (!etu.equals("")) {
            if (!suku.equals("")) {
                haetut = hakija.haeKokoNimella(etu, suku);
            }
            else {
                haetut = hakija.haeEtunimella(etu);
            }
        }
        else if (!suku.equals("")) {
            haetut = hakija.haeSukunimella(suku);
        }
        else {
            haetut = hakija.haeTaidolla(taito);
        }
        return haetut;
    }   
    
    /**
     * Metodi palauttaa nimeä vastaavan olion.
     * @param nimi
     * @return 
     */
    public Henkilo valitaHenkiloOlio(String nimi) {
        return henkilo = henkilot.get(nimi);
    }
    
    /**
     * Metodi kutsuu Tallennus-olion tallennaTiedot-metodia.
     * @throws IOException 
     */
    public void tallennaTiedot() throws IOException {
        tallentaja.talletaTiedot(henkilot);
    }
    /**
     * Metodi kutsuu Tallennus-olion lataaTiedot-metodia.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    private void lataaTiedot() throws FileNotFoundException, IOException, ClassNotFoundException {
        henkilot = tallentaja.lataaTiedot();
    }
    
    /**
     * Metodi varmistaa, että henkilön etu- ja sukunimissä on ensimmäinen kirjain iso ja muut pieniä.
     * Käytetään kun uusi henkilö lisätään tai haetaan tai nimeä muutetaan.
     * @param nimi
     * @return 
     */
    public String muokkaaNimi(String nimi) {
        String uusiN = nimi.substring(0, 1).toUpperCase()+nimi.substring(1).toLowerCase();
        int indeksi;
        if (uusiN.indexOf("-") > -1) {
            indeksi = uusiN.indexOf("-");
            uusiN = uusiN.substring(0, indeksi+1)+uusiN.substring(indeksi+1, indeksi+2).toUpperCase()+uusiN.substring(indeksi+2);
        }
        if (uusiN.indexOf(" ") > -1) {
            indeksi = uusiN.indexOf(" ");
            if (indeksi < uusiN.length()-2) {
                uusiN = uusiN.substring(0, indeksi+1)+uusiN.substring(indeksi+1, indeksi+2).toUpperCase()+uusiN.substring(indeksi+2);
            }
            else {
                uusiN = uusiN.substring(0, indeksi+1)+uusiN.substring(indeksi+1, indeksi+2).toUpperCase();
            }
        }
        return uusiN;
    }
}
