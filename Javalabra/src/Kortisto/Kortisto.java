
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
    /**
     * Metodi lisää henkilölle taidon.
     * Hakee henkilö-olion Arraysta ja välittää tälle käyttäjän antaman taidon.
     * @param indeksi Henkilön indeksi Arrayssa
     * @param taito 
     */
    public void lisaaOsaaminen(String nimi, String taito, String taso) {
        henkilo = henkilot.get(nimi);
        
        henkilo.lisaaOsaaminen(taito, taso);
    }
    
    /**
     * Metodi hakee tietyn henkilön taidot.
     * Ensin haetaan henkilo-olio ja sitten tämän taidot string-taulukossa.
     * @param indeksi
     * @return taisot-taulukko (String)
     */
    public String[][] haeOsaamiset(String nimi) {
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
    public String[][] poistaTaito(String[][] taidot, String taito) {
        String[][] uusiTaidot = new String[taidot.length-1][2];
        for (int i=0; i<taidot.length; i++) {
            if (!taidot[i][0].equals(taito)) {
                uusiTaidot[i][0] = taidot[i][0];
                uusiTaidot[i][1] = taidot[i][1];
            }
            else {
                i++;
            }
        }
        return uusiTaidot;
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
     * Metodi tulostaa henkilöt.
     * Hakee henkilöt-Arrayn jokaisen henkilön etu- ja sukunimen.
     */
    public String toString() {
        String tulostus = "";
        for (String haettu : henkilot.keySet()) {
            tulostus += haettu+"\n";
        }
        return tulostus;
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
        ArrayList<String> haetut = new ArrayList<String>();
        if (!etu.equals("")) {
            if (!suku.equals("")) {
                haetut = haeKokoNimella(etu, suku);
            }
            else {
                haetut = haeEtunimella(etu);
            }
        }
        else if (!suku.equals("")) {
            haetut = haeSukunimella(suku);
        }
        else {
            haetut = haeTaidolla(taito);
        }
        return haetut;
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
                    haetut.add(haettu.getSukunimi()+" "+haettu.getEtunimi());
                }
            }
        }
        return haetut;
    }
    
    
}
