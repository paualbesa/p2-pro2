import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.allotjaments.Allotjament;
import prog2.model.allotjaments.Bungalow;
import prog2.model.clients.Client;
import prog2.vista.excepcions.ExcepcioReserva;
import prog2.model.reserves.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservesTest {
    private LlistaReserves llistaReserves;
    private Allotjament bungalow;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    @BeforeEach
    void setUp() throws ExcepcioReserva {
        llistaReserves = new LlistaReserves();
        bungalow = new Bungalow("Bungalow 1", "B001", true, "Iluminado", 40, 2, 4, 1, true, true, true);
        client = new Client("Pau", "12345678A");
        dataEntrada = LocalDate.of(2024, 7, 1);
        dataSortida = LocalDate.of(2024, 7, 5);
    }

    @Test
    void testAfegirReservaExitosa() throws ExcepcioReserva {
        assertDoesNotThrow(() -> llistaReserves.afegirReserva(bungalow, client, dataEntrada, dataSortida));
        assertEquals(1, llistaReserves.getNumReserves());
    }

    @Test
    void testAfegirReservaDataInvalida() {
        LocalDate dataSortidaErronea = LocalDate.of(2024, 6, 30);
        assertThrows(ExcepcioReserva.class, () -> llistaReserves.afegirReserva(bungalow, client, dataEntrada, dataSortidaErronea));
    }

    @Test
    void testAfegirReservaAllotjamentNoDisponible() throws ExcepcioReserva {
        llistaReserves.afegirReserva(bungalow, client, dataEntrada, dataSortida);
        Client nouClient = new Client("Edu", "87654321B");
        assertThrows(ExcepcioReserva.class, () -> llistaReserves.afegirReserva(bungalow, nouClient, LocalDate.of(2024, 7, 3), LocalDate.of(2024, 7, 8)));
    }
}
