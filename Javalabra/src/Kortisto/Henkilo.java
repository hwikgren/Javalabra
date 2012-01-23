
package Kortisto;

import java.util.ArrayList;

/**
 *
 * @author heidi
 */
public class Henkilo {
    String etunimi;
    String sukunimi;
    
    static ArrayList<Taidot> taidot = new ArrayList<Taidot>();
 
    public Henkilo() {
    }
    
    public Henkilo(String etu, String suku) {
         this.etunimi = etu;
         this.sukunimi = suku;
    }
     
    void lisaaOsaaminen(String osaaminen) {
        Taidot taito = new Taidot(osaaminen);
        taidot.add(taito);
    }
    
    String getEtunimi() {
        return this.etunimi;
    }
    
    String getSukunimi() {
        return this.sukunimi;
    }
    
    
    
    
}
