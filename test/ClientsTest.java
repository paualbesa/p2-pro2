import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.clients.Client;
import prog2.model.clients.LlistaClients;
import prog2.vista.excepcions.ExcepcioReserva;

public class ClientsTest {
    private LlistaClients llistaClients;

    @BeforeEach
    void setUp() {
        llistaClients = new LlistaClients();
    }

    @Test
    void testCrearClientCorrecte() throws ExcepcioReserva {
        Client client = new Client("Pau", "12345678A");
        assertEquals("Pau", client.getNom());
        assertEquals("12345678A", client.getDni());
    }

    @Test
    void testCrearClientDniIncorrecte() {
        assertThrows(ExcepcioReserva.class, () -> new Client("Pau", "1234"));
    }

    @Test
    void testAfegirClient() throws ExcepcioReserva {
        Client client = new Client("Pau", "12345678A");
        llistaClients.afegirClient(client);
        assertEquals(1, llistaClients.getNumClients());
        assertEquals(client, llistaClients.getClient(0));
    }

    @Test
    void testEliminarClient() throws ExcepcioReserva {
        Client client = new Client("Pau", "12345678A");
        llistaClients.afegirClient(client);
        llistaClients.eliminarClient(client);
        assertEquals(0, llistaClients.getNumClients());
    }

    @Test
    void testEliminarClientInexistent() throws ExcepcioReserva {
        Client client1 = new Client("Pau", "12345678A");
        Client client2 = new Client("Eduardo", "87654321B");
        llistaClients.afegirClient(client1);
        llistaClients.eliminarClient(client2);
        assertEquals(1, llistaClients.getNumClients());
    }
}
