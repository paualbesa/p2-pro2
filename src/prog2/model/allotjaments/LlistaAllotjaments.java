package prog2.model.allotjaments;
import prog2.vista.excepcions.ExcepcioCamping;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

    }

    @Override
    public void buidar() {

    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
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
