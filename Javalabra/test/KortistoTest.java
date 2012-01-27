/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Kortisto.Kortisto;
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author hwikgren
 */
public class KortistoTest {
    Kortisto kortisto;
    
    public KortistoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        kortisto = new Kortisto();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void KortistonLuominenLuoArrayn() {
        assertEquals( 0, kortisto.getKoko() );
    }
    
    @Test
    public void LisayksenJalkeenArrayEiTyhja() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertEquals( 1, kortisto.getKoko() );
    }
    
    @Test
    public void etsiHenkiloToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        assertEquals( 0, kortisto.etsiHenkilo("heidi", "jauhiainen") );
    }
    
    @Test
    public void etsiHenkiloToimiiKunArrayssaUseampia() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        assertEquals( 1, kortisto.etsiHenkilo("tommi", "jauhiainen") );
    }
    
    @Test
    public void toStringToimii() {
        kortisto.lisaaHenkilo("heidi", "jauhiainen");
        kortisto.lisaaHenkilo("tommi", "jauhiainen");
        kortisto.lisaaHenkilo("kalle", "koehenkilo");
        String tulostus = "heidi jauhiainen\n"
                + "tommi jauhiainen\n"
                + "kalle koehenkilo\n";
        assertEquals( kortisto.toString(), tulostus );
    }
}
