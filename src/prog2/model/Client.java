package prog2.model;

import prog2.vista.ExcepcioReserva;

public class Client {
    String nom;
    String dni; //ha de ternir 9 caràcters

    //el constructor rep els arguments en el mateix ordre que el mètode afegirClient de la classe Camping
    public Client(String nom, String dni) throws ExcepcioReserva {
        /*en cridar setDni() és possible que succeeixi una excepció. Tal i com està dit a la capçalera del constructor Client, aquesta excepció es delegarà a qui invoqui el
        mètode, és a dir a qui instanciï un objecte de la classe Client.
         */
        setDni(dni);

        //more efficient in this way, using the keyword this, as there's no test to pass with the attribute nom.
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public String getDni() {
        return dni;
    }

    //ESBORRAR ????? NO ES FA SERVIR MAI
    public void setNom(String nom) {
        this.nom = nom;
    }

    //a privat method as once we've instanciated an object from Client class, we won't change the dni's value.
    //the dni's value is something forever.
    private void setDni(String dni) throws ExcepcioReserva {
        if(dni.length() != 9){
            //the following two following code lines could be abbreviated by: throw new ExcepcioReserva("DNI incorrecte");
            //as we're leaning we're doing it in a more legible way:
            ExcepcioReserva dniWrong = new ExcepcioReserva("El DNI ha de tenir 9 caràcters.");
            throw dniWrong;
        }
        else{
            this.dni = dni;
        }
    }

    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
