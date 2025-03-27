package prog2.model.clients;

public class LlistaClients implements InLlistaClients {
    private Client[] clients;
    private int numClients;

    public LlistaClients() {
        clients = new Client[100];
        numClients = 0;
    }

    public void afegirClient(Client client) {
        clients[numClients] = client;
        numClients++;
    }

    public void eliminarClient(Client client) {
        int i = 0;
        while (i < numClients && clients[i] != client) {
            i++;
        }
        if (i < numClients) {
            for (int j = i; j < numClients - 1; j++) {
                clients[j] = clients[j + 1];
            }
            numClients--;
        }
    }

    public Client getClient(int i) {
        return clients[i];
    }

    public int getNumClients() {
        return numClients;
    }
}
