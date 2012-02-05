
package Kortisto;

import java.io.Serializable;

/**
 * Taito on osaamis-olio
 * @author heidi
 */

public class Taito implements Serializable {
    String taito;
    
    /**
     * Luo Taito-olion jolla on annettu taito.
     * @param taito 
     */
    public Taito(String taito) {
        this.taito = taito;
    }
    
    /**
     * Palauttaa taidon Stringinä.
     * @return taito
     */
    public String getOsaaminen() {
        return this.taito;
    }
}
