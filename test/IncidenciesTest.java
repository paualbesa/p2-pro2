import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.allotjaments.Allotjament;
import prog2.model.allotjaments.Parcela;
import prog2.model.incidencies.Incidencia;
import prog2.model.incidencies.LlistaIncidencies;
import prog2.vista.excepcions.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class IncidenciesTest {
    private LlistaIncidencies llistaIncidencies;
    private Allotjament parcela;

    @BeforeEach
    void setUp() {
        llistaIncidencies = new LlistaIncidencies();
        parcela = new Parcela("Parcela 1", "P1", true, "100%", 20.0f, true);
    }

    @Test
    void testAfegirIncidencia() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", parcela, "2024-03-30");
        assertEquals(1, llistaIncidencies.getIncidencia(1).getNum());
    }

    @Test
    void testAfegirIncidenciaRepetida() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", parcela, "2024-03-30");
        assertThrows(ExcepcioCamping.class, () ->
                llistaIncidencies.afegirIncidencia(2, "Neteja", parcela, "2024-03-31")
        );
    }

    @Test
    void testEliminarIncidencia() throws ExcepcioCamping {
        Incidencia incidencia = new Incidencia(1, "Reparacio", parcela, "2024-03-30");
        llistaIncidencies.afegirIncidencia(1, "Reparacio", parcela, "2024-03-30");
        llistaIncidencies.eliminarIncidencia(llistaIncidencies.getIncidencia(1));
        assertThrows(ExcepcioCamping.class, () -> llistaIncidencies.getIncidencia(1));
    }

    @Test
    void testLlistarIncidencies() throws ExcepcioCamping {
        llistaIncidencies.afegirIncidencia(1, "Reparacio", parcela, "2024-03-30");
        assertFalse(llistaIncidencies.llistarIncidencies().isEmpty());
    }

    @Test
    void testLlistarIncidenciesBuida() {
        assertThrows(ExcepcioCamping.class, () -> llistaIncidencies.llistarIncidencies());
    }
}