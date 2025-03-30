package prog2.model.allotjaments;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;
    boolean estat;
    String estatIluminacio;

    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa, boolean estat, String estatIluminacio) {
        setNom(nom);
        setId(id);
        setEstadaMinima(estadaMinimaAlta, estadaMinimaBaixa);
    }

    public long getEstadaMinima(InAllotjament.Temp temp) {
        if (temp == InAllotjament.Temp.ALTA) {
            return estadaMinimaAlta;
        } else {
            return estadaMinimaBaixa;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        estadaMinimaAlta = estadaMinimaALTA_;
        estadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isDisponible() {
        return estat;
    }


    @Override
    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: " + estadaMinimaAlta + ", estada mínima en temp BAIXA: " + estadaMinimaBaixa + ".";
    }
}
