package prog2.model.incidencies;
import prog2.model.allotjaments.Allotjament;
import prog2.vista.excepcions.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaIncidencies implements InLlistaIncidencies{
    private final ArrayList<Incidencia> llistaIncidencies;

    public LlistaIncidencies(){
        llistaIncidencies = new ArrayList<>();
    }

    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        for (Incidencia incidencia : llistaIncidencies) {
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("L'allotjament ja té una incidència.");
            }
        }
        Incidencia novaIncidencia = new Incidencia(num, tipus, allotjament, data);
        llistaIncidencies.add(novaIncidencia);
    }

    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        if (!llistaIncidencies.contains(in)) {
            throw new ExcepcioCamping("L'incidència no existeix.");
        }
        llistaIncidencies.remove(in);
    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        if (llistaIncidencies.isEmpty()) {
            throw new ExcepcioCamping("No hi ha incidències registrades.");
        }
        String llista = "";
        for (Incidencia incidencia : llistaIncidencies) {
            llista += incidencia.toString() + "\n";
        }
        return llista;
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia incidencia : llistaIncidencies) {
            if (incidencia.getNum() == num) {
                return incidencia;
            }
        }
        throw new ExcepcioCamping("L'incidència no existeix.");
    }
}
