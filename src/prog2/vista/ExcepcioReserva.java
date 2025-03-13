
package prog2.vista;

/**
 *
 * @author lauraigual
 */
public class ExcepcioReserva extends Exception {

    public ExcepcioReserva(String message) {
        //detailMessage és un atribut heredat de la super super classe Throwable. L'argument passat pel paràmetre message es desa a l'atribut detailMessage.
        super(message);
    }
    
}
