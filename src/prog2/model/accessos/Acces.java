package prog2.model.accessos;
import prog2.model.allotjaments.Allotjament;

import java.util.ArrayList;

public class Acces implements InAcces {
    private String nom;
    private boolean estat;
    private ArrayList<Allotjament> llistaAllotjaments;

    public Acces(String nom, boolean estat){
        this.nom = nom;
        this.estat = estat;
    }


    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        if(llistaAllotjaments.contains(allotjament)){
            System.out.println("L'allotjament ja existeix");
        }else{
            llistaAllotjaments.add(allotjament);
        }
    }

    @Override
    public void tancarAcces() {
        estat = false;
        System.out.println("Acces tancat");
    }

    @Override
    public void obrirAcces() {
        estat = true;
        System.out.println("Acces obert");
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
