
package Kortisto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Sovelluslogiikka-olio
 * @author heidi
 */
public class Kortisto {
    
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
    }
    /**
     * Metodi lisää henkilölle taidon.
     * Hakee henkilö-olion Arraysta ja välittää tälle käyttäjän antaman taidon.
     * @param indeksi Henkilön indeksi Arrayssa
     * @param taito 
     */
    public void lisaaOsaaminen(int indeksi, String taito) {
        henkilo = henkilot.get(indeksi);
        
        henkilo.lisaaOsaaminen(taito);
    }
    
    /**
     * Metodi etsii poistettavan henkilö-olion indeksi.
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
    public String toString() {
        String tulostus = "";
        for (Henkilo haettu : henkilot) {
            tulostus += haettu.getEtunimi()+" "+haettu.getSukunimi()+"\n";
        }
        return tulostus;
    }

}
