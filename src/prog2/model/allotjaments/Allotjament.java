package prog2.model.allotjaments;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
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

    public void setEstadaMinima(int alta, int baixa) {
        estadaMinimaAlta = alta;
        estadaMinimaBaixa = baixa;
    }

    //we need to write: equals(Object o) instead of equals(Allotjament o) because to override we need to write de exactly same head of the function.
    @Override
    public boolean equals(Object o) {
        Allotjament accommodation = (Allotjament) o;
        return accommodation.getId().equals( this.getId() ); //esta invocación a equals es al de la clase String.
    }

    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: " + estadaMinimaAlta + ", estada mínima en temp BAIXA: " + estadaMinimaBaixa + ".";
    }
}
