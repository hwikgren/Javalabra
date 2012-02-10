
package Kortisto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 * Sovelluslogiikka-olio
 * @author heidi
 */
public class Kortisto extends Observable {
    
    /**
     * Henkilö-olioiden säilytyspaikka
     */
    public ArrayList<Henkilo> henkilot;
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
        henkilot = new ArrayList<Henkilo>();
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
     * Medodi palauttaa indeksin osoittaman henkilö-olion Arraysta.
     * @param indeksi
     * @return Henkilo
     */
    public Henkilo getHenkilo(int indeksi) {
        return henkilot.get(indeksi);
    }
    /**
     * Metodi luo uuden Henkilö-olion.
     * Lisää sen henkilöt-ArrayListiin.
     * @param etu
     * @param suku 
     */
    public void lisaaHenkilo(String etu, String suku) {
        henkilo = new Henkilo(etu, suku);
        henkilot.add(henkilo);
        setChanged();
        notifyObservers(kaikkiHenkilot());
    }
    /**
     * Metodi lisää henkilölle taidon.
     * Hakee henkilö-olion Arraysta ja välittää tälle käyttäjän antaman taidon.
     * @param indeksi Henkilön indeksi Arrayssa
     * @param taito 
     */
    public void lisaaOsaaminen(int indeksi, String taito, String taso) {
        henkilo = henkilot.get(indeksi);
        
        henkilo.lisaaOsaaminen(taito, taso);
    }
    
    /**
     * Metodi hakee tietyn henkilön taidot.
     * Ensin haetaan henkilo-olio ja sitten tämän taidot string-taulukossa.
     * @param indeksi
     * @return taisot-taulukko (String)
     */
    public HashMap<String, String> haeOsaamiset(int indeksi) {
        henkilo = henkilot.get(indeksi);
        return henkilo.haeTaidot();
    }
    
    /**
     * Metodi etsii poistettavan henkilö-olion indeksin.
     * Kutsuu poistaHenkiloArraysta-metodia.
     * @param etu
     * @param suku 
     */
    public void poistaHenkilo(String etu, String suku) {
        int indeksi = etsiHenkilo(etu, suku);
        poistaHenkiloArraysta(indeksi);
    }
    
    /**
     * Metodi poistaa indeksin mukaisen henkilön arraysta.
     * @param indeksi 
     */
    public void poistaHenkiloArraysta(int indeksi) {
        henkilot.remove(indeksi);
    }
    
    /**
     * Metodi tyhjentää henkilön taidot.
     * Ensin haetaan henkilo-olio ja sitten tyhjennetään henkilön taidot-taulukko.
     * Metodia käytetään kun lisäys-ikkunassa on lisätty henkilölle taitoja.
     * @param indeksi 
     */
    public void tyhjennaHenkilonTiedot(int indeksi) {
        henkilo = henkilot.get(indeksi);
        henkilo.tyhjennaArray();
    }
    /**
     * Metodi palauttaa henkilön indeksin Arrayssa.
     * Käy läpi henkilot-Arrayn ja vertaa kunkin olion etu- ja sukunimeä parametreihin.
     * @param etu
     * @param suku
     * @return i indeksi Arrayssa
     */
    public int etsiHenkilo(String etu, String suku) {
       for (int i=0; i<henkilot.size(); i++) {
           henkilo = henkilot.get(i);
           if (henkilo.getSukunimi().equals(suku)) {
               if (henkilo.getEtunimi().equals(etu)) {
                   return i;
               }
               
           }
       }
       return -1;
         
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
     * Metodi tulostaa henkilöt.
     * Hakee henkilöt-Arrayn jokaisen henkilön etu- ja sukunimen.
     */
    
    public String[] kaikkiHenkilot() {
        String[]  palautus = new String[henkilot.size()];
        for (int i=0; i<henkilot.size(); i++) {
            Henkilo haettu = henkilot.get(i);
            palautus[i] = haettu.getEtunimi()+" "+haettu.getSukunimi();
        }
        return palautus;
    }
    public String toString() {
        String tulostus = "";
        for (Henkilo haettu : henkilot) {
            tulostus += haettu.getEtunimi()+" "+haettu.getSukunimi()+"\n";
        }
        return tulostus;
    }
    
    /**
     * Metodi palauttaa henkilön nimen Stringinä.
     * @param indeksi
     * @return string
     */
    public String henkilonNimi(int indeksi) {
        return henkilot.get(indeksi).getEtunimi()+" "+henkilot.get(indeksi).getSukunimi();
    }
    
    
}
