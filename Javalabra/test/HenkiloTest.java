/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Henkilo;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author hwikgren
 */
public class HenkiloTest {
    
    Henkilo henkilo;
    
    public HenkiloTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        henkilo = new Henkilo("heidi", "jauhiainen");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void KonstruktoriLuoHenkilon() {
        assertEquals( henkilo.getEtunimi(), "heidi");
        assertEquals( henkilo.getSukunimi(), "jauhiainen");
    }
    
    @Test
    public void osaaminenMeneeArrayhun() {
        henkilo.lisaaOsaaminen("java");
        assertEquals( 1, henkilo.getMaara() );
    }
}
