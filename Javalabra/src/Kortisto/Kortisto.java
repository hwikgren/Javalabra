
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
     * Lataa mahdolliset olemassa olevat henkilö-oliot tiedostosta Arrayhun.
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
     * Lisää sen henkilöt-TreeSetiin.
     * @param etu
     * @param suku 
     */
    public void lisaaHenkilo(String etu, String suku) {
        henkilo = new Henkilo(etu, suku);
        henkilot.put(suku+" "+etu, henkilo);
        setChanged();
        notifyObservers(kaikkiHenkilot());
    }
    
    public void muutaNimea(String nimi, String etu, String suku) {
        henkilo = henkilot.get(nimi);
        henkilot.remove(nimi);
        henkilo.muutaNimea(etu, suku);
        henkilot.put(suku+" "+etu, henkilo);
        setChanged();
        notifyObservers(kaikkiHenkilot());
    }
    
    public String[] haeNimet(String nimi) {
        String[] nimet = new String[2];
        henkilo = henkilot.get(nimi);
        String etu = henkilo.etunimi;
        String suku = henkilo.sukunimi;
        nimet[0] = etu;
        nimet[1] = suku;
        return nimet;
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
     * Metodi hakee tietyn henkilön taidot.
     * Ensin haetaan henkilo-olio ja sitten tämän taidot string-taulukossa.
     * @param indeksi
     * @return taisot-taulukko (String)
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
     * Metodi poistaa nimen mukaisen henkilön TreeMapista
     * @param etu
     * @param suku 
     */
    public void poistaHenkilo(String nimi) {
        //int indeksi = etsiHenkilo(etu, suku);
        henkilot.remove(nimi);
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
    public void lataaTiedot() throws FileNotFoundException, IOException, ClassNotFoundException {
        henkilot = tallentaja.lataaTiedot();
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
     * Sen mukaan onko parametri tyhjä vai ei, metodi kutsuu erilaisia haku-metodeita. 
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
    
    public Henkilo valitaHenkiloOlio(String nimi) {
        return henkilo = henkilot.get(nimi);
    }
}
