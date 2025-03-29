package prog2.model.incidencies;
import prog2.model.allotjaments.Allotjament;

public class Incidencia {
    String id;
    Allotjament allotjament;
    String data;
    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };

    public Incidencia(String id, Allotjament allotjament, String tipus, String data) {
        this.id = id;
        this.allotjament = allotjament;

        this.data = data;
    }


}
