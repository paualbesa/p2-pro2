package prog2.model;

public class BungalowPremium extends Bungalow{
    private boolean serveisExtra;
    private String codiWifi;

    private static final long ESTADA_MINIMA_ALTA = 7;
    private static final long ESTADA_MINIMA_BAIXA = 4;

    public BungalowPremium(String nom, String id, String mida, int numHabitacions, int numPlacesPersones, int numPlacesParquing, boolean isTerrassa, boolean isTV, boolean isAireFred, boolean serveisExtra, String codiWifi) {
        super(nom, id, mida, numHabitacions, numPlacesPersones, numPlacesParquing, isTerrassa, isTV, isAireFred);
        super.setEstadaMinima(ESTADA_MINIMA_ALTA, ESTADA_MINIMA_BAIXA);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    public boolean isServeisExtra() {
        return serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    @Override
    public boolean correcteFuncionament() { // codiWifi.length() > 0
        return isAireFred() && codiWifi.length() >= 8 && codiWifi.length() <= 16;
    }

    @Override
    public String toString() {
        return "Nom= " + super.getNom() + ", Id= " + super.getId() + ", estada mínima en temp ALTA: " + ESTADA_MINIMA_ALTA + ", estada mínima en temp BAIXA: " +
                ESTADA_MINIMA_BAIXA + ", Bungalow_Premium{ pàrquing amb places= " + super.getPlacesParquing() + ", amb aire fred= " + super.isAireFred() + ", amb terrassa= " + super.isTerrassa() +
                ", amb televisió= " + super.isTv() + ", amb serveis extres com tovalloles i llençols inclosos= "+ isServeisExtra()+", codi wifi gratuit= "+getCodiWifi() +" }";
    }

}
