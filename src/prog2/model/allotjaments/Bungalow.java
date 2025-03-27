package prog2.model.allotjaments;

import prog2.model.incidencies.Incidencia;

public class Bungalow extends Casa {
    private int numPlacesParquing;
    private boolean isTerrassa;
    private boolean isTV;
    private boolean isAireFred;
    private static final long ESTADA_MINIMA_ALTA = 7;
    private static final long ESTADA_MINIMA_BAIXA = 4;

    public Bungalow(String nom, String id, String mida, int numHabitacions, int numPlacesPersones, int numPlacesParquing, boolean isTerrassa, boolean isTV, boolean isAireFred) {
        super(nom, id, mida, numHabitacions, numPlacesPersones);
        super.setEstadaMinima(ESTADA_MINIMA_ALTA, ESTADA_MINIMA_BAIXA);
        this.numPlacesParquing = numPlacesParquing;
        this.isTerrassa = isTerrassa;
        this.isTV = isTV;
        this.isAireFred = isAireFred;
    }

    public int getPlacesParquing() {
        return numPlacesParquing;
    }


    public boolean isTerrassa() {
        return isTerrassa;
    }

    public boolean isTv() {
        return isTV;
    }

    public boolean isAireFred() {
        return isAireFred;
    }

    public void setPlacesParquing(int numPlacesParquing) {
        this.numPlacesParquing = numPlacesParquing;
    }

    public void setTerrassa(boolean isTerrassa) {
        this.isTerrassa = isTerrassa;
    }

    public void setTv(boolean isTV) {
        this.isTV = isTV;
    }

    public void setAireFred(boolean isAireFred) {
        this.isAireFred = isAireFred;
    }

    @Override
    public String toString() {
        return "Nom= " + super.getNom() + ", Id= " + super.getId() + ", estada mínima en temp ALTA: " + ESTADA_MINIMA_ALTA + ", estada mínima en temp BAIXA: " +
                ESTADA_MINIMA_BAIXA + ", Bungalow{ pàrquing amb places= " + numPlacesParquing + ", amb aire fred= " + isAireFred + ", amb terrassa= " + isTerrassa +
                ", amb televisió= " + isTV + " }";
    }

    @Override
    public void tancarAllotjament(Incidencia in) {

    }

    @Override
    public void obrirAllotjament() {

    }
}