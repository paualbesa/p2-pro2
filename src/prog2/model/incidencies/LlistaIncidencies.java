package prog2.model.incidencies;
import prog2.model.allotjaments.Allotjament;
import prog2.vista.excepcions.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaIncidencies implements InLlistaIncidencies{


    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {

    }

    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {

    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        return "";
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        return null;
    }
}
