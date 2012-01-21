package Kortisto;

/**
 *
 * @author heidi
 */
import Kayttoliittyma.Komennot;
import java.util.ArrayList;
import java.util.Scanner;

public class Kortisto {
    
    public static Scanner lukija = new Scanner(System.in);
    
    static ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();

    public Kortisto() {
    }
    
    public static void lisaaHenkilo(String etu, String suku) {
        Henkilo henkilo = new Henkilo(etu, suku);
        henkilot.add(henkilo);
    }
    
    public static void lisaaOsaaminen(String etu, String suku) {
        Henkilo henkilo = henkilot.get(etsiHenkilo(etu, suku));
        String osaaminen = Komennot.mikaOsaaminen(henkilo);
        henkilo.lisaaOsaaminen(osaaminen);
    }
    
    public static int etsiHenkilo(String etu, String suku) {
       for (int i=0; i<henkilot.size(); i++) {
           Henkilo haettava = henkilot.get(i);
           if (haettava.getSukunimi().equals(suku) || haettava.getEtunimi().equals(etu)) {
               return i;
           }
       }
       return -1;
        
    }
}
