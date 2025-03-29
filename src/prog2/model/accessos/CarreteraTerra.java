package prog2.model.accessos;

public class CarreteraTerra extends AccesTerra{
    float amplada;

    public CarreteraTerra(String nom, boolean accessibilitat, float longitud, float amplada){
        super(nom, accessibilitat, longitud);
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
