package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{

    private ArrayList<Reserva> llistaReserves = new ArrayList<>();


    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        //comprovem si està disponible per a quan el volem:
        if( !allotjamentDisponible(allotjament, dataEntrada, dataSortida) ){
            ExcepcioReserva solapament = new ExcepcioReserva("L’allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada " + dataEntrada + " pel client " +client.getNom() + " amb DNI: "+ client.getDni()+".");
            throw solapament;
        }

        if( !isEstadaMinima(allotjament, dataEntrada, dataSortida) ){
            ExcepcioReserva minDays = new ExcepcioReserva("Les dates sol·licitades pel client "+client.getNom() + client.getDni()+" no compleixen l'estada mínima per l'allotjament amb identificador "+allotjament.getId()+".");
            throw minDays;
        }

        //so we proceed to add the new reservation:
        Reserva newReserv = new Reserva(allotjament, client, dataEntrada, dataSortida);
        llistaReserves.add(newReserv);
    }

    private boolean allotjamentDisponible(Allotjament accommodation, LocalDate dataEntrada, LocalDate dataSortida) {
        //hem de verificar si en qualsevol dels dies en que es vol reservar el nostre allotjament anomenat accommodation, ja teníem alguna altre reserva feta.

        //bucle for-each para buscar si ya hay reservas hechas en el mismo alojamiento donde queremos crear la reserva:
        for (Reserva i : llistaReserves) {
            if ( i.getAllotjament_().equals(accommodation) ){
                LocalDate dataReservaPreviaIn = i.getDataEntrada();
                LocalDate dataReservaPreviaOut = i.getDataSortida();

                /*si la data d'entrada que volem és abans de que hagi acabat la reserva ja existent, o
                  si la data de sortida és després de que hagi començat la reserva ja existent:                             */
                if (dataEntrada.isBefore( dataReservaPreviaOut ) || dataSortida.isBefore(dataReservaPreviaIn)){
                    return false;
                }
            }
        }

        //aleshores l'allotjament està disponibe:
        return true;
    }



    /*
    ChronoUnit es un enum.
    LocalDate es una clase que implementa a la interfaz Temporal, y el ChronoUnit está diseñado para trabajar con todos aquellos objeto instanciados de
    clases que implementen a la interfaz Temporal, aunque no acabo de entender muy bien por qué.
     */
    private boolean isEstadaMinima(Allotjament accommodation, LocalDate dataEntrada, LocalDate dataSortida){
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        //let's check the season, en qué temporada estamos?
        /*
        Como InAllotjament.java y LlistaReserves.java están ambos en el mismo paquete (model), podemos usar el enum Temp de la interfaz InAllotjament sin
        la necesidad de importar nada. Tampoco hace falta implementar la interfaz para tenero.
         */
        InAllotjament.Temp temporada = Camping.getTemporada(dataEntrada);

        if (estada >= accommodation.getEstadaMinima(temporada)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int getNumReserves() {
        return llistaReserves.size();
    }
}
