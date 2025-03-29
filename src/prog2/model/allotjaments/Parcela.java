package prog2.model.allotjaments;

import prog2.model.incidencies.Incidencia;

public class Parcela extends Allotjament {
    private float mida;
    boolean connexioElectrica;
    private static final long ESTADA_MINIMA_ALTA = 4;
    private static final long ESTADA_MINIMA_BAIXA = 2;

    public Parcela(String nom, String id, boolean estat, String estatIluminacio, float mida, boolean connexioElectrica) {
        super(nom, id, ESTADA_MINIMA_ALTA, ESTADA_MINIMA_BAIXA, estat, estatIluminacio);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida() {
        return mida;
    }

    public void setMida(float mida) {
        this.mida = mida;
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica;
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    @Override
    public String toString() {
        return "Nom=" + super.getNom() + ", Id=" + super.getId() + ", estada mínima en temp ALTA: " + ESTADA_MINIMA_ALTA + ", estada mínima en temp BAIXA: " +
                ESTADA_MINIMA_BAIXA + ".";
    }

    @Override
    public void tancarAllotjament(Incidencia in) {

    }

    @Override
    public void obrirAllotjament() {

    }
}
