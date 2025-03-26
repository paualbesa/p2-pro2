
package prog2.model;

/**
 * Interfície que defineix les operacions bàsiques d'un accés.
 */
public interface InAcces {
    
    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     * @param allotjament
     */
    public void afegirAllotjament(Allotjament allotjament);
    
    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces();
    
    /**
     * Canvia l'estat de l'accés a obert 
     */
    public void obrirAcces();
    
        
    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return 
     */
    public boolean isAccessibilitat();
}
