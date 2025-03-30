package prog2.model.incidencies;
import prog2.model.allotjaments.Allotjament;

public class Incidencia {
    int num;
    Allotjament allotjament;
    String data;
    TipusIncidencia tipus;
    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };

    public Incidencia(int num, String tipus, Allotjament allotjament, String data) {
        this.num = num;
        this.allotjament = allotjament;
        this.data = data;
        this.tipus = TipusIncidencia.valueOf(tipus);
    }

    public int getNum() {
        return num;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public String getData() {
        return data;
    }

    public TipusIncidencia getTipus() {
        return tipus;
    }

    public void setId(int num) {
        this.num = num;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTipus(TipusIncidencia tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return "Incidencia " + num + " de tipus " + tipus + " a l'allotjament " + allotjament.getId() + " en data " + data;
    }

    public String getIluminacioAllotjament(){
        if(tipus == TipusIncidencia.Reparacio){
            return "100%";
        }
        else if(tipus == TipusIncidencia.Neteja){
            return "50%";
        }
        else if(tipus == TipusIncidencia.Tancament){
            return "0%";
        }
        else{
            return "No s'ha pogut determinar l'estat de la il·luminació";
        }
    }
}
