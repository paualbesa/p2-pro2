package prog2.model.reserves;

//importem una classe de l'API de JAava: LocalDate
import prog2.model.allotjaments.Allotjament;
import prog2.model.clients.Client;
import prog2.vista.excepcions.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        this.allotjament = allotjament;
        this.client = client;
        if(dataSortida.isBefore(dataEntrada)){
            throw new ExcepcioReserva("La data de sortidad no pot ser abans de la data d'entrada");
        }
        else {
            this.dataEntrada = dataEntrada;
            this.dataSortida = dataSortida;
        }
    }

    public Allotjament getAllotjament_() {
        return allotjament;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public void setAllotjament_(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

    @Override
    public String toString() {
        return "Reserva{" + "allotjament=" + allotjament + ", client=" + client + ", dataEntrada=" + dataEntrada + ", dataSortida=" + dataSortida + '}';
    }
}
