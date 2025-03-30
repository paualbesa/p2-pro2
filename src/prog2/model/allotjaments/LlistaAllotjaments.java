package prog2.model.allotjaments;
import prog2.vista.excepcions.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private final ArrayList<Allotjament> llistaAllotjaments;

    public LlistaAllotjaments() {
        llistaAllotjaments = new ArrayList<>();
    }
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (llistaAllotjaments.contains(allotjament)) {
            throw new ExcepcioCamping("L'allotjament ja existeix.");
        }
        llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        llistaAllotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        if(estat == "Tots"){
            String llista = "";
            for (Allotjament allotjament : llistaAllotjaments) {
                llista += allotjament.toString() + "\n";
            }
            if(!llista.isEmpty()){
                return llista;
            }
            else{
                throw new ExcepcioCamping("No hi ha allotjaments");
            }
        }
        else if(estat == "Disponible"){
            String llista = "";
            for (Allotjament allotjament : llistaAllotjaments) {
                if(allotjament.isDisponible()){
                    llista += allotjament.toString() + "\n";
                }
            }
            if(!llista.isEmpty()){
                return llista;
            }
            else{
                throw new ExcepcioCamping("No hi ha allotjaments");
            }
        }
        else if(estat == "NoDisponible"){
            String llista = "";
            for (Allotjament allotjament : llistaAllotjaments) {
                if(!allotjament.isDisponible()){
                    llista += allotjament.toString() + "\n";
                }
            }
            if(!llista.isEmpty()){
                return llista;
            }
            else{
                throw new ExcepcioCamping("No hi ha allotjaments");
            }
        }
        else{
            throw new ExcepcioCamping("Estat no vàlid");
        }
    }


    @Override
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament allotjament : llistaAllotjaments) {
            if(allotjament.isDisponible()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return llistaAllotjaments.contains(allotjament);
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament allotjament : llistaAllotjaments) {
            if(allotjament.getId().equals(id)){
                return allotjament;
            }
        }
        throw new ExcepcioCamping("L'allotjament no existeix");
    }
}
