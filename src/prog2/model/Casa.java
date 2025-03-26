package prog2.model;

public abstract class  Casa extends Allotjament{

    private String mida; //ho podríem haver implementat com a un enum també, ja que només hi ha 3 possibles opcions.
    private int numHabitacions;
    private int numPlacesPersones;

    /* DEBO ASEGURARME DE QUE SE METE UNA DE LAS 3 OPCIONES POSIBLES, SINO LANZAR INTERRUPCIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOON !!!!!
     */

    public Casa(String nom, String id, String mida, int numHabitacions, int numPlacesPersones){
        super(nom, id, 0,0);
        this.mida = mida;
        this.numHabitacions = numHabitacions;
        this.numPlacesPersones = numPlacesPersones;
    }

    public int getHabitacions() {
        return numHabitacions;
    }

    public String getMida() {
        return mida;
    }

    public int getPlacesPersones() {
        return numPlacesPersones;
    }
}
