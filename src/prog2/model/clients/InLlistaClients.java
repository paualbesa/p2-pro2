package prog2.model.clients;

public interface InLlistaClients {
    public void afegirClient(Client client);
    public void eliminarClient(Client client);
    public Client getClient(int i);
    public int getNumClients();
}
