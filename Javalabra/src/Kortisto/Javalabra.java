
package Kortisto;

import Kayttoliittyma.Komennot;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Sisältää main-luokan.
 * @author heidi
 * 
 */
public class Javalabra {
    
    /**
     * Luo käyttöliittymän.
     * Huolehtii käyttäjän valinnoista. Ohjelma toimii kunnes valinta on 0.
     * @param args 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Komennot komennot = new Komennot();
        
        while (true) {
            int valinta = komennot.paavalikko();

            if (valinta == 0) {
                komennot.tallennaTiedot();
                break;
            }

            if (valinta == 1) {
                komennot.lisaaHenkilo();
            }
            
            if (valinta == 2) {
                komennot.poistaHenkilo();
            }

            if (valinta == 3) {
                System.out.println("Valitsit henkilön tietojen muokkaamisen");
            }

            if (valinta == 4) {
                komennot.tulostaHenkilot();
            }

            if (valinta == 5) {
                System.out.println("Valitsit osaamisalueiden listaamisen");
            }
            if (valinta == 6) {
                System.out.println("Valitsit etsimisen henkilön nimen perusteella");
            }
            if (valinta == 7) {
                System.out.println("Valitsit etsimisen taidon perusteella");
            }

        }
    }
    
}
