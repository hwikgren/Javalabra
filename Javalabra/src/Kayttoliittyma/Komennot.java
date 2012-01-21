
package Kayttoliittyma;

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.util.Scanner;


/**
 *
 * @author heidi
 */
public class Komennot {
    
    public static Scanner lukija = new Scanner(System.in);

    public Komennot() {
    }
    
    public static int paavalikko() {
        System.out.println("");
        System.out.println("HENKILÖOSAAMISKORTISTO");
        System.out.println("----------------------");
        System.out.println("Päävalikko");
        System.out.println(" 1. Lisää henkilö");
        System.out.println(" 2. Muokkaa henkilön tietoja");
        System.out.println(" 3. Listaa henkilöt");
        System.out.println(" 4. Listaa osaamisalueet");
        System.out.println(" 0. Poistu");


        System.out.print("\nValitse: ");
        int valinta = lukija.nextInt();

        return valinta;
    }
    
    public static void lisaaHenkilo() {
        System.out.print("Anna etunimi: ");
        String etunimi = lukija.next();
        System.out.print("Anna sukunimi: ");
        String sukunimi = lukija.next();
        Kortisto.lisaaHenkilo(etunimi, sukunimi);
        System.out.println("Haluatko asettaa henkilölle osaamisalueita? Y(es)/N(o)");
        String valinta = lukija.next();
        if (valinta.equalsIgnoreCase("y")) {
            Kortisto.lisaaOsaaminen(etunimi, sukunimi);
        }
    }
    
    /*void lisaaOsaaminen(int indeksi) {
        henkilo.lisaaOsaaminen(indeksi);   
    }*/
    
    public static String mikaOsaaminen(Henkilo henkilo) {
        System.out.println("Anna henkilön osaamisalue: ");
        return lukija.next();
        
    }
}
