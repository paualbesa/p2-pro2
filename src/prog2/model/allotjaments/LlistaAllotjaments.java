package prog2.model.allotjaments;
import prog2.vista.excepcions.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament> llistaAllotjaments = new ArrayList<>();

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (llistaAllotjaments.contains(allotjament)) {
            throw new ExcepcioCamping("L'allotjament ja existeix.");
        }
        llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {

    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return null;
    }


    @Override
    public boolean containsAllotjamentOperatiu() {
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return false;
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        return null;
    }
}
