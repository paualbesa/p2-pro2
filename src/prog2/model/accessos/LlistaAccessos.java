package prog2.model.accessos;
import prog2.vista.excepcions.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos {
    private final ArrayList<Acces> llistaAccessos;

    public LlistaAccessos() {
        llistaAccessos = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        for (Acces acces : llistaAccessos) {
            if (acces.equals(acc)) {
                throw new ExcepcioCamping("L'acces ja existeix.");
            }
        }
        llistaAccessos.add(acc);
    }

    @Override
    public void buidar() {
        llistaAccessos.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String llista = "";
        for (Acces acces : llistaAccessos) {
            if (acces.isEstat() == estat) {
                llista += acces.toString() + "\n";
            }
        }
        return llista;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces acces : llistaAccessos) {
            if (acces.isEstat()) {
                acces.obrirAcces();
            } else {
                acces.tancarAcces();
            }
        }
    }

    @Override
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int accessibles = 0;
        for (Acces acces : llistaAccessos) {
            if (acces.isAccessibilitat()) {
                accessibles++;
            }
        }
        return accessibles;
    }

    @Override
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        float metres = 0;
        for (Acces acces : llistaAccessos) {
            if (acces instanceof AccesAsfaltat) {
                metres += ((AccesAsfaltat) acces).getAsfalt();
            }
        }
        return metres;
    }
}
