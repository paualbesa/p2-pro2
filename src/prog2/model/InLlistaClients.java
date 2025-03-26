package prog2.model;

public interface InLlistaClients {
    public void afegirClient(Client client);
    public void eliminarClient(Client client);
    public Client getClient(int i);
    public int getNumClients();
}
