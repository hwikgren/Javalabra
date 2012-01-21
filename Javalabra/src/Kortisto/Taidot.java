/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortisto;

/**
 *
 * @author heidi
 */
import java.util.ArrayList;

public class Taidot {
    
    static ArrayList<String> taidot = new ArrayList<String>();

    public Taidot() {
    }
    
    public void lisaaOsaaminen(String taito) {
        taidot.add(taito);
    }
}
