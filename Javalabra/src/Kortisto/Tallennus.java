
package Kortisto;

import java.io.*;
import java.util.ArrayList;

/**
 * Tallennus-olio hoitaa tietojen tallennuksen ja lataamisen.
 * Tiedot luetaan tiedostosta kun ohjelma käynnistyy ja tallennetaan sinne kun käyttäjä painaa lopeta.
 * @author heidi
 */
public class Tallennus implements Serializable {

    private Kortisto kortisto;
    private Henkilo henkilo;

    public Tallennus() throws FileNotFoundException {
        
    }
    /**
     * Metodi lukee tiedot tiedostosta.
     * Palauttaa henkilot-Arrayn
     * @return henkilot
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Henkilo> lataaTiedot() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream tiedosto = new FileInputStream("henkilot.oma");
        ObjectInputStream lukija = new ObjectInputStream(tiedosto);
        ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
        
        try {
            Object obj;
        
            while ((obj = lukija.readObject()) != null) {
                if (obj instanceof Henkilo) {
                    henkilo = (Henkilo)obj;
                    henkilot.add(henkilo);
                }
            } 
        } catch (EOFException ex) {
        
        } finally {
            try {
                if (lukija != null){
                    lukija.close();
                }
            } catch (IOException ex) {
            }
        }
        
        
        tiedosto.close();
        return henkilot;
    }
    /**
     * Metodi kirjoittaa henkilö-oliot tiedostoon.
     * @param lista
     * @throws IOException 
     */
    public void talletaTiedot(ArrayList<Henkilo> lista) throws IOException {
        FileOutputStream henkiloTiedosto = new FileOutputStream("henkilot.oma");
        ObjectOutputStream kirjoittaja = new ObjectOutputStream(henkiloTiedosto);
        for (int i=0; i<lista.size(); i++) {
            kirjoittaja.writeObject((Object)lista.get(i));
        }
        
        kirjoittaja.flush();
        henkiloTiedosto.close();
    }
}
