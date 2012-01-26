
package Kortisto;

import Kayttoliittyma.Komennot;

/**
 * Sisältää main-luokan.
 * @author heidi
 * 
 */
public class Javalabra {
    
    /**
     * Huolehtii käyttäjän valinnoista.
     * Ohjelma toimii kunnes valinta on 0.
     * @param args 
     */
    public static void main(String[] args) {
        
        while (true) {
            int valinta = Komennot.paavalikko();

            if (valinta == 0) {
                System.out.println("Valitsit poistumisen");
                break;
            }

            if (valinta == 1) {
                Komennot.lisaaHenkilo();
            }

            if (valinta == 2) {
                System.out.println("Valitsit henkilön tietojen muokkaamisen");
            }

            if (valinta == 3) {
                Kortisto.tulostaHenkilot();
            }

            if (valinta == 4) {
                System.out.println("Valitsit osaamisalueiden listaamisen");
            }
            if (valinta == 5) {
                System.out.println("Valitsit etsimisen henkilön nimen perusteella");
            }
            if (valinta == 6) {
                System.out.println("Valitsit etsimisen taidon perusteella");
            }

        }
    }
    
}
