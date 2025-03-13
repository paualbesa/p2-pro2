package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping{
    private String nom;
    private LlistaReserves llistaReserves;
    private ArrayList<Allotjament> llistaAllotjaments; //llista dels allotjaments DISPONIBLES
    private ArrayList<Client> llistaClients; //llista dels clients del càmping

    public Camping(String nom){
        this.nom = nom;
        this.llistaReserves = new LlistaReserves();
        this.llistaAllotjaments = new ArrayList<Allotjament>();
        this.llistaClients = new ArrayList<Client>();
    }

    //the following function returns one of the two values from the enum defined at the InAllotjament interface: ALTA or BAIXA.
    public static InAllotjament.Temp getTemporada(LocalDate date) {
        int dayOfYear = date.getDayOfYear();

        //only the month and the day are constants to change the season: day/month -> 21/09 to 31/12
        if (dayOfYear >= LocalDate.of(date.getYear(), 3, 21).getDayOfYear() && dayOfYear <= LocalDate.of(date.getYear(), 9, 20).getDayOfYear() ){
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return this.llistaReserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return this.llistaAllotjaments;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return this.llistaClients;
    }

    @Override
    public int getNumAllotjaments() {
        return this.llistaAllotjaments.size();
    }

    @Override
    public int getNumReserves() {
        return this.llistaReserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return this.llistaClients.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {
        /*the following function call can return an exception, so as it's said in th function's headder, we'll be delegating it to
        who call the afegirClient() method to handle it.*/
        Client c = new Client(nom_, dni_);
        //if we didn't have an exception, the following code line will be executed:
        this.llistaClients.add(c);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela p = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        this.llistaAllotjaments.add(p);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow b = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.llistaAllotjaments.add(b);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bp = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        this.llistaAllotjaments.add(bp);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping g = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        this.llistaAllotjaments.add(g);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mh = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        this.llistaAllotjaments.add(mh);
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        boolean clientFounded = false;
        Client ourClient = null;

        //escric Iterator<Client> en comptes de només Iterator, ja que sinó l'iterador em retornaria els objectes com a instàncies de la classe Object, i no podria fer servir el mètode getDnie() de la classe Client
        Iterator<Client> itrClients = llistaClients.iterator();
        while (itrClients.hasNext() && !clientFounded) {
            //el guardo a una variable, el Client de la iteració actual, degut a que en cas que sí sigui el que m'interessa, després del condicional if no podré tornar a fer servir next() perquè me'l retorni de nou.
            ourClient = itrClients.next();
            if ( dni_.equals( ourClient.getDni() ) ){
                //next() retorna l'objecte, a més de moure's al següent Client després
                clientFounded = true;
            }
        }

        boolean allotjFounded = false;
        Allotjament ourAllotj = null;
        Iterator<Allotjament> itrAllotjaments = llistaAllotjaments.iterator();
        while (itrAllotjaments.hasNext() && !allotjFounded) {
            ourAllotj = itrAllotjaments.next();
            if ( id_.equals( ourAllotj.getId() ) ){
                allotjFounded = true;
            }
        }

        //si no hem trobat el client que vol fer la reserva o l'allotjament on la vol fer:
        if(!clientFounded || !allotjFounded){
            throw new ExcepcioReserva("L'usuari o allotjament desitjat, no es troba a la nostra base de dades.");
        }
        //en cas que sí, procedim a intentar afegir la reserva:
        this.llistaReserves.afegirReserva(ourAllotj, ourClient, dataEntrada, dataSortida);


    }

    @Override
    public float calculMidaTotalParceles() {

        Allotjament someAllotjament;
        float midaTotal = 0;

        Iterator<Allotjament> itrAllotj = this.llistaAllotjaments.iterator();
        while (itrAllotj.hasNext()){
            someAllotjament = itrAllotj.next();
            //És someAllotjament una instància de Parcela o és un altre tipus d' Allotjament ?
            if (someAllotjament instanceof Parcela){
                /*
                instanceof actúa como una verificación de seguridad. Te asegura que el casteo solo se realizará si el objeto es realmente una Parcela.
                Esto debido a que todos los elementos del ArrayList llistaAllotjaments son considerados por el compilador como instancias de Allotjament, de manera que con ellos no podríamos usar métodos de la subclase Parcela.
                instanceof verifica el tipo del objeto, sirve para entrar en el if, pero el objeto para el compilador sigue tratándose como un mero Allotjament, así que necesitamos del casteo que le dice al compilador que trate ese objeto como el tipo verificado.
                */
                Parcela p = (Parcela) someAllotjament;
                midaTotal += p.getMida();
            }
        }
        return midaTotal;
    }

    @Override
    public int calculAllotjamentsOperatius() {
        Iterator<Allotjament> itrAllotj = this.llistaAllotjaments.iterator();
        Allotjament someAllotjament;
        int counter = 0;

        while (itrAllotj.hasNext()){
            someAllotjament = itrAllotj.next();
            if (someAllotjament instanceof Parcela){
                Parcela p = (Parcela) someAllotjament;
                if (p.correcteFuncionament()){
                    counter++;
                }
            }

            else if (someAllotjament instanceof Bungalow){
                Bungalow b = (Bungalow) someAllotjament;
                if (b.correcteFuncionament()){
                    counter++;
                }
            }

            else if (someAllotjament instanceof BungalowPremium){
                BungalowPremium bp = (BungalowPremium) someAllotjament;
                if (bp.correcteFuncionament()){
                    counter++;
                }
            }
            else if (someAllotjament instanceof Glamping){
                Glamping g = (Glamping) someAllotjament;
                if (g.correcteFuncionament()){
                    counter++;
                }
            }
            else if (someAllotjament instanceof MobilHome){
                MobilHome h = (MobilHome) someAllotjament;
                if (h.correcteFuncionament()){
                    counter++;
                }
            }
        }

        return counter;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta() {
        Iterator<Allotjament> itrAllotj = this.llistaAllotjaments.iterator();
        Allotjament someAllotjament;
        long someEstada;
        Allotjament elQueVolem = null;
        long estadaMinimaMesCurta = Long.MAX_VALUE;

        while (itrAllotj.hasNext()){
            someAllotjament = itrAllotj.next();
            someEstada = someAllotjament.getEstadaMinima(InAllotjament.Temp.BAIXA);

            //si hi ha diversos amb la mateixa mínima estada ens quedem amb la primera trobada, ja que no hem posat >= sinó que només > a la condició de l'if.
            if( estadaMinimaMesCurta > someEstada){
                elQueVolem = someAllotjament;
                estadaMinimaMesCurta = someEstada;
            }
        }
        return elQueVolem;
    }
}
