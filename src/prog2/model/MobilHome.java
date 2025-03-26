package prog2.model;

public class MobilHome extends Casa{
    boolean terrassaBarbacoa;
    private static final long ESTADA_MINIMA_ALTA = 5;
    private static final long ESTADA_MINIMA_BAIXA = 3;

    public MobilHome(String nom, String id, String mida, int numHabitacions, int numPlacesPersones, boolean terrassaBarbacoa) {
        super(nom, id, mida, numHabitacions, numPlacesPersones);
        super.setEstadaMinima(ESTADA_MINIMA_ALTA, ESTADA_MINIMA_BAIXA);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    public boolean isTerrassaBarbacoa() {
        return terrassaBarbacoa;
    }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public String toString() {
        return "Nom= " + super.getNom() + ", Id= " + super.getId() + ", estada mínima en temp ALTA: " + ESTADA_MINIMA_ALTA + ", estada mínima en temp BAIXA: " +
                ESTADA_MINIMA_BAIXA + ", Mobil_Home{ terrassa amb barbacoa= " + isTerrassaBarbacoa() + " }";
    }

    @Override
    public void tancarAllotjament(Incidencia in) {

    }

    @Override
    public void obrirAllotjament() {

    }
}
