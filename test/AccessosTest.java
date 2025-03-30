
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.accessos.*;

public class AccessosTest {
    private AccesAsfaltat accesAsfaltat;
    private AccesTerra accesTerra;
    private CamiAsfaltat camiAsfaltat;
    private CamiTerra camiTerra;
    private CarreteraAsfaltada carreteraAsfaltada;
    private CarreteraTerra carreteraTerra;

    @BeforeEach
    void setUp() {
        accesAsfaltat = new AccesAsfaltat("Acces Asfaltat", true, 5.0f);
        accesTerra = new AccesTerra("Acces Terra", true, 10.0f);
        camiAsfaltat = new CamiAsfaltat("Cami Asfaltat", true, 3.0f);
        camiTerra = new CamiTerra("Cami Terra", true, 8.0f);
        carreteraAsfaltada = new CarreteraAsfaltada("Carretera Asfaltada", true, 6.0f, 20.0f);
        carreteraTerra = new CarreteraTerra("Carretera Terra", true, 12.0f, 5.0f);
    }

    @Test
    void testAccesEstat() {
        accesAsfaltat.tancarAcces();
        assertFalse(accesAsfaltat.isEstat());
        accesAsfaltat.obrirAcces();
        assertTrue(accesAsfaltat.isEstat());
    }

    @Test
    void testIsAccessibilitat() {
        assertFalse(accesAsfaltat.isAccessibilitat());
        assertFalse(accesTerra.isAccessibilitat());
        assertFalse(camiAsfaltat.isAccessibilitat());
        assertFalse(camiTerra.isAccessibilitat());
        assertTrue(carreteraAsfaltada.isAccessibilitat());
        assertTrue(carreteraTerra.isAccessibilitat());
    }

    @Test
    void testGetters() {
        assertEquals("Acces Asfaltat", accesAsfaltat.getNom());
        assertEquals(5.0f, accesAsfaltat.getAsfalt());
        assertEquals(10.0f, accesTerra.getLongitud());
        assertEquals(6.0f, carreteraAsfaltada.getAsfalt());
    }
}
