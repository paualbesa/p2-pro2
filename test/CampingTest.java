import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Camping;
import prog2.model.clients.Client;
import prog2.vista.excepcions.ExcepcioReserva;
import prog2.vista.excepcions.ExcepcioCamping;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CampingTest {
    private Camping camping;

    @BeforeEach
    void setUp() {
        camping = new Camping("Camping Test");
        camping.inicialitzaDadesCamping();
    }

    @Test
    void testGetNomCamping() {
        assertEquals("Camping Test", camping.getNomCamping());
    }

    @Test
    void testAfegirIListarAllotjaments() throws ExcepcioCamping {
        String allotjaments = camping.llistarAllotjaments("100%");
        assertFalse(allotjaments.isEmpty());
    }

    @Test
    void testLlistarAccessos() {
        assertDoesNotThrow(() -> camping.llistarAccessos("Obert"));
        assertDoesNotThrow(() -> camping.llistarAccessos("Tancat"));
    }

    @Test
    void testAfegirIEliminarIncidencia() throws ExcepcioCamping {
        camping.afegirIncidencia(1, "Electrica", "ALL1", "2025-04-01");
        String incidencies = camping.llistarIncidencies();
        assertTrue(incidencies.contains("Electrica"));

        camping.eliminarIncidencia(1);
        incidencies = camping.llistarIncidencies();
        assertFalse(incidencies.contains("Electrica"));
    }

    @Test
    void testCalcularAccessosAccessibles() {
        assertTrue(camping.calculaAccessosAccessibles() > 0);
    }

    @Test
    void testCalcularMetresQuadratsAsfalt() {
        assertTrue(camping.calculaMetresQuadratsAsfalt() > 0);
    }
}
