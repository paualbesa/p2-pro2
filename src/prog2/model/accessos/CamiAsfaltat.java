package prog2.model.accessos;

public class CamiAsfaltat extends AccesAsfaltat{
    public CamiAsfaltat(String nom, boolean estat, float asfalt) {
        super(nom, estat, asfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
