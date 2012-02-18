
package Kayttoliittyma;

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hoitaa Scannerin avulla yhteyden käyttäjään kunnes käyttöliittymä on valmis.
 * @author heidi
 */
public class Komennot {
    public static Scanner lukija = new Scanner(System.in);
    
    Kortisto kortisto;
    public static String[] lista;

    public Komennot() throws FileNotFoundException, IOException, ClassNotFoundException {
        kortisto = new Kortisto();
    }
    
    public int paavalikko() {
        System.out.println("");
        System.out.println("HENKILÖOSAAMISKORTISTO");
        System.out.println("----------------------");
        System.out.println("Päävalikko");
        System.out.println(" 1. Lisää henkilö");
        System.out.println(" 2. Poista henkilö");
        System.out.println(" 3. Muokkaa henkilön tietoja");
        System.out.println(" 4. Listaa henkilöt");
        System.out.println(" 5. Listaa osaamisalueet");
        System.out.println(" 6. Etsi henkilö");
        System.out.println(" 7. Etsi taito");
        System.out.println(" 0. Poistu");


        System.out.print("\nValitse: ");
        int valinta = lukija.nextInt();

        return valinta;
    }
    
    public void lisaaHenkilo() {
        System.out.print("Anna etunimi: ");
        String etunimi = lukija.next();
        System.out.print("Anna sukunimi: ");
        String sukunimi = lukija.next();
        kortisto.lisaaHenkilo(etunimi, sukunimi);
        System.out.println("Haluatko asettaa henkilölle osaamisalueita? Y(es)/N(o)");
        String valinta = lukija.next();
        if (valinta.equalsIgnoreCase("y")) {
            mikaOsaaminen(etunimi, sukunimi);
        }
    }
    
    public void poistaHenkilo(String nimi) {
        /*System.out.println("Anna poistettavan henkilön etunimi: ");
        String etu = lukija.next();
        System.out.println("Anna poistettavan henkilön sukunimi: ");
        String suku = lukija.next();
        int indeksi = kortisto.etsiHenkilo(etu, suku);*/
        kortisto.poistaHenkilo(nimi);
    }
    
    
    /*void lisaaTaito(int indeksi) {
        henkilo.lisaaTaito(indeksi);   
    }*/
    
    public String mikaOsaaminen(String etunimi, String sukunimi) {
        //int indeksi = kortisto.etsiHenkilo(etunimi, sukunimi);
        System.out.println("Anna henkilön osaamisalue: ");
        return lukija.next();
        
    }
    
    public String[] listaaHenkilot() {
        lista = kortisto.kaikkiHenkilot();
        return lista;
    }

    public void tulostaHenkilot() {
        System.out.println(kortisto.toString());
    }

    public void tallennaTiedot() throws IOException {
        kortisto.tallennaTiedot();
    }
}
