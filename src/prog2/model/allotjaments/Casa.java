package prog2.model.allotjaments;

public abstract class  Casa extends Allotjament {

    private float mida; //ho podríem haver implementat com a un enum també, ja que només hi ha 3 possibles opcions.
    private int numHabitacions;
    private int numPlacesPersones;

    /* DEBO ASEGURARME DE QUE SE METE UNA DE LAS 3 OPCIONES POSIBLES, SINO LANZAR INTERRUPCIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOON !!!!!
     */

    public Casa(String nom, String id, boolean estat, String estatIluminacio, float mida, int numHabitacions, int numPlacesPersones){
        super(nom, id, 0,0, estat, estatIluminacio);
        this.mida = mida;
        this.numHabitacions = numHabitacions;
        this.numPlacesPersones = numPlacesPersones;
    }

    public int getHabitacions() {
        return numHabitacions;
    }

    public float getMida() {
        return mida;
    }

    public int getPlacesPersones() {
        return numPlacesPersones;
    }
}
