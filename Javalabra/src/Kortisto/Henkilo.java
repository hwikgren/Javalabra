package Kortisto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heidi
 */
public class Henkilo {
    String etunimi;
    String sukunimi;

    public Henkilo(String etu, String suku) {
        this.etunimi = etu;
        this.sukunimi = suku;
    }
    
    void lisaaOsaaminen(String osaaminen) {
        Taidot taito = new Taidot();
        taito.lisaaOsaaminen(osaaminen);
    }
    
    String getEtunimi() {
        return this.etunimi;
    }
    
    String getSukunimi() {
        return this.sukunimi;
    }
}
