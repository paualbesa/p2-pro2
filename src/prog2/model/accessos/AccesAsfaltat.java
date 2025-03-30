package prog2.model.accessos;

public class AccesAsfaltat extends Acces{
    private float asfalt;

    public AccesAsfaltat(String nom, boolean estat, float asfalt){
        super(nom, estat);
        this.asfalt = asfalt;
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    public float getAsfalt() {
        return asfalt;
    }

    public void setAsfalt(float asfalt) {
        this.asfalt = asfalt;
    }
}
