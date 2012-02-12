
package Kortisto;

import java.io.Serializable;

/**
 * Taito on osaamis-olio
 * @author heidi
 */

public class Taito implements Serializable {
    String taito;
    String taso;
    
    /**
     * Luo Taito-olion jolla on annettu taito.
     * @param taito 
     */
    public Taito(String taito) {
        this.taito = taito;
    }
    
    /**
     * Metodi asettaa taidon tason.
     * @param taso 
     */
    public void setTaso(String taso) {
        this.taso = taso;
    }
    
    /**
     * Palauttaa taidon Stringinä.
     * @return taito
     */
    public String getOsaaminen() {
        return this.taito;
    }
    
    /**
     * Palauttaa taidon tason Stringinä.
     * @return taso
     */
    public String getTaso() {
        return this.taso;
    }
}
