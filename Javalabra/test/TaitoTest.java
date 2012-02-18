/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Taito;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hwikgren
 */
public class TaitoTest {
    
    Taito taito;
    public TaitoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        taito = new Taito("java");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TaitoTallessa() {
        assertEquals( "java", taito.getOsaaminen() );
    }
    
    @Test
    public void tasoTallessa() {
        taito.setTaso("Hyvä");
        assertEquals( "Hyvä", taito.getTaso() );
    }
}
