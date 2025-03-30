import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.excepcions.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import prog2.model.allotjaments.*;

class AllotjamentsTest {

    private LlistaAllotjaments llistaAllotjaments;
    private Bungalow bungalow;
    private BungalowPremium bungalowPremium;
    private Glamping glamping;
    private MobilHome mobilHome;
    private Parcela parcela;

    @BeforeEach
    void setUp() {
        llistaAllotjaments = new LlistaAllotjaments();
        bungalow = new Bungalow("Bungalow 1", "B001", true, "Iluminado", 40, 2, 4, 1, true, true, true);
        bungalowPremium = new BungalowPremium("Bungalow Premium", "B002", true, "Iluminado", 50, 3, 6, 2, true, true, true, true, "Wifi123");
        glamping = new Glamping("Glamping 1", "G001", true, "Iluminado", 30, 1, 2, "Tela", true);
        mobilHome = new MobilHome("Mobil Home 1", "MH001", true, "Iluminado", 40, 2, 4, true);
        parcela = new Parcela("Parcela 1", "P001", true, "Iluminado", 100, true);
    }

    @Test
    void testAfegirAllotjament() throws ExcepcioCamping {
        // Test adding Allotjament
        llistaAllotjaments.afegirAllotjament(bungalow);
        assertTrue(llistaAllotjaments.contains(bungalow));
    }

    @Test
    void testAfegirAllotjamentDuplicado() {
        // Test adding duplicate Allotjament (should throw exception)
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAllotjaments.afegirAllotjament(bungalow);
            llistaAllotjaments.afegirAllotjament(bungalow); // Trying to add the same bungalow
        });
    }

    @Test
    void testLlistarAllotjaments() throws ExcepcioCamping {
        // Test listing Allotjaments
        llistaAllotjaments.afegirAllotjament(bungalow);
        llistaAllotjaments.afegirAllotjament(bungalowPremium);
        String result = llistaAllotjaments.llistarAllotjaments("Tots");
        assertTrue(result.contains("Bungalow 1"));
        assertTrue(result.contains("Bungalow Premium"));
    }

    @Test
    void testLlistarAllotjamentsDisponibles() throws ExcepcioCamping {
        // Test listing available Allotjaments
        llistaAllotjaments.afegirAllotjament(bungalow);
        llistaAllotjaments.afegirAllotjament(glamping);
        llistaAllotjaments.afegirAllotjament(parcela);
        glamping.setEstat(false); // Set glamping as unavailable
        String result = llistaAllotjaments.llistarAllotjaments("Disponible");
        assertTrue(result.contains("Bungalow 1"));
        assertTrue(result.contains("Parcela 1"));
        assertFalse(result.contains("Glamping 1"));
    }

    @Test
    void testLlistarAllotjamentsNoDisponibles() throws ExcepcioCamping {
        // Test listing unavailable Allotjaments
        llistaAllotjaments.afegirAllotjament(bungalow);
        llistaAllotjaments.afegirAllotjament(mobilHome);
        mobilHome.setEstat(false); // Set mobilHome as unavailable
        String result = llistaAllotjaments.llistarAllotjaments("NoDisponible");
        assertTrue(result.contains("Mobil Home 1"));
        assertFalse(result.contains("Bungalow 1"));
    }

    @Test
    void testGetAllotjament() throws ExcepcioCamping {
        // Test retrieving Allotjament by ID
        llistaAllotjaments.afegirAllotjament(bungalow);
        Allotjament result = llistaAllotjaments.getAllotjament("B001");
        assertNotNull(result);
        assertEquals("B001", result.getId());
    }

    @Test
    void testGetAllotjamentNoExistente() {
        // Test retrieving non-existing Allotjament (should throw exception)
        assertThrows(ExcepcioCamping.class, () -> llistaAllotjaments.getAllotjament("NonExistID"));
    }

    @Test
    void testContainsAllotjamentOperatiu() {
        llistaAllotjaments.afegirAllotjament(bungalow);
        llistaAllotjaments.afegirAllotjament(glamping);
        glamping.setEstat(false); // Deshabilitamos solo el glamping
        assertTrue(llistaAllotjaments.containsAllotjamentOperatiu());
    }


    @Test
    void testContainsNoOperatiu() {
        // Test checking if no operational Allotjament exists
        llistaAllotjaments.afegirAllotjament(glamping);
        glamping.setEstat(false); // Set glamping as unavailable
        assertFalse(llistaAllotjaments.containsAllotjamentOperatiu());
    }

    @Test
    void testSetNom() {
        // Test setting name in Allotjament
        bungalow.setNom("Bungalow 2");
        assertEquals("Bungalow 2", bungalow.getNom());
    }

    @Test
    void testSetEstadaMinima() {
        // Test setting estada minima in Allotjament
        assertEquals(7, bungalow.getEstadaMinima(InAllotjament.Temp.ALTA));
    }
}
