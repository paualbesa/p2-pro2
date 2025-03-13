package prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;
    private static final long ESTADA_MINIMA_ALTA = 5;
    private static final long ESTADA_MINIMA_BAIXA = 3;

    public Glamping(String nom, String id, String mida, int numHabitacions, int numPlacesPersones, String material, boolean casaMascota) {
        super(nom, id, mida, numHabitacions, numPlacesPersones);
        super.setEstadaMinima(ESTADA_MINIMA_ALTA, ESTADA_MINIMA_BAIXA);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    public String getMaterial() {
        return material;
    }

    //getter de casaMascota:
    public boolean isCasaMascota() {
        return casaMascota;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        return "Nom= " + super.getNom() + ", Id= " + super.getId() + ", estada mínima en temp ALTA: " + ESTADA_MINIMA_ALTA + ", estada mínima en temp BAIXA: " +
                ESTADA_MINIMA_BAIXA + ", Glamping{ material= " + getMaterial() + ", casa per mascotes=" + isCasaMascota()+ " }";
    }
}
