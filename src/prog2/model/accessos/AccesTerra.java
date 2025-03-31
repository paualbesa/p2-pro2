package prog2.model.accessos;

public abstract class AccesTerra extends Acces{
    float longitud;

    public AccesTerra(String nom, boolean estat, float longitud){
        super(nom, estat);
        this.longitud = longitud;
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    public float getLongitud() {
        return longitud;
    }
}
