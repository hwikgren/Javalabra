
package Kortisto;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

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
    public TreeMap<String, Henkilo> lataaTiedot() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("henkilot.oma");
        if (!f.exists()) {
            f.createNewFile();
        }
        TreeMap<String, Henkilo> henkilot = new TreeMap<String, Henkilo>();
        if (f.length() > 0) {
            FileInputStream tiedosto = new FileInputStream("henkilot.oma");
            ObjectInputStream lukija = new ObjectInputStream(tiedosto);


            try {
                henkilot = (TreeMap<String, Henkilo>)lukija.readObject();
                /*Object obj;

                while ((obj = lukija.readObject()) != null) {
                    if (obj instanceof Henkilo) {
                        henkilo = (Henkilo)obj;
                        henkilot.put(henkilo);
                    }
                }*/ 
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
        }
        return henkilot;
    }
    /**
     * Metodi kirjoittaa henkilö-oliot tiedostoon.
     * @param lista
     * @throws IOException 
     */
    public void talletaTiedot(TreeMap<String, Henkilo> lista) throws IOException {
        FileOutputStream henkiloTiedosto = new FileOutputStream("henkilot.oma");
        ObjectOutputStream kirjoittaja = new ObjectOutputStream(henkiloTiedosto);

        kirjoittaja.writeObject((Object)lista);
        
        kirjoittaja.flush();
        henkiloTiedosto.close();
    }
}
