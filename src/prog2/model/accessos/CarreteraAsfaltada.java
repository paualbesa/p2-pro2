package prog2.model.accessos;

public class CarreteraAsfaltada extends AccesAsfaltat{
    float pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat, float asfalt, float pesMaxim){
        super(nom, estat, asfalt);
        this.pesMaxim = pesMaxim;
    }


    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
