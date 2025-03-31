package prog2.vista;

import prog2.model.Camping;
import prog2.vista.excepcions.ExcepcioCamping;
import java.util.Scanner;

public class VistaCamping {
    // En aquest mateix fitxer, defineix l'enum com a classe interna estàtica
    public static enum OpcionsMenu {
        LLISTAR_TOTS_ALLOTJAMENTS,
        LLISTAR_OPERATIUS,
        LLISTAR_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_INCIDENCIES,
        AFEGIR_INCIDENCIA,
        ELIMINAR_INCIDENCIA,
        CALCULAR_ACCESSOS_COTXE,
        CALCULAR_METRES_ASFALT,
        GUARDAR_CAMPING,
        CARREGAR_CAMPING,
        SORTIR
    }

    private Camping camping;

    public VistaCamping(String nomCamping) {
        // Inicialitza el càmping
        camping = new Camping(nomCamping);
        // Si el càmping necessita més inicialització, fes-ho aquí
    }

    public void gestioCamping() {
        Scanner scanner = new Scanner(System.in);
        OpcionsMenu[] opcions = OpcionsMenu.values();
        // Instancia el menú passant l'array d'opcions de l'enum
        Menu<OpcionsMenu> menu = new Menu<>("Menú del Càmping", opcions);

        // Assigna les descripcions corresponents a cada opció,
        // l'ordre ha de coincidir amb les constants definides a l'enum
        menu.setDescripcions(new String[]{
                "Llistar la informació de tots els allotjaments",
                "Llistar la informació dels allotjaments operatius",
                "Llistar la informació dels allotjaments no operatius",
                "Llistar la informació dels accessos oberts",
                "Llistar la informació dels accessos tancats",
                "Llistar la informació de les incidències actuals",
                "Afegir una incidència",
                "Eliminar una incidència",
                "Calcular el número total d’accessos amb cotxe",
                "Calcular el total de metres quadrats d’asfalt",
                "Guardar càmping",
                "Recuperar càmping",
                "Sortir de l’aplicació"
        });

        OpcionsMenu opcio;
        do {
            // Mostra el menú
            menu.mostrarMenu();
            // Demana a l'usuari que introdueixi l'opció
            opcio = menu.getOpcio(scanner);

            // Executa l'acció corresponent segons l'opció triada
            switch (opcio) {
                case LLISTAR_TOTS_ALLOTJAMENTS:
                    camping.llistarAllotjaments("Tots");
                    break;
                case LLISTAR_OPERATIUS:
                    camping.llistarAllotjaments("Disponible");
                    break;
                case LLISTAR_NO_OPERATIUS:
                    camping.llistarAllotjaments("NoDisponible");
                    break;
                case LLISTAR_ACCESSOS_OBERTS:
                    camping.llistarAccessos("Obert");
                    break;
                case LLISTAR_ACCESSOS_TANCATS:
                    camping.llistarAccessos("Tancat");
                    break;
                case LLISTAR_INCIDENCIES:
                    camping.llistarIncidencies();
                    break;
                case AFEGIR_INCIDENCIA:
                    try {
                        System.out.print("Introdueix el número de la incidència: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); // Consumeix la nova línia

                        System.out.print("Introdueix el tipus d'incidència: ");
                        String tipus = scanner.nextLine();

                        System.out.print("Introdueix l'ID de l'allotjament on s'ha produït la incidència: ");
                        String idAllotjament = scanner.nextLine();

                        System.out.print("Introdueix la data de la incidència (per exemple, 2025-03-31): ");
                        String data = scanner.nextLine();

                        // Crida al mètode afegirIncidencia()
                        camping.afegirIncidencia(numero, tipus, idAllotjament, data);
                        System.out.println("Incidència afegida correctament.");
                    } catch (ExcepcioCamping e) {
                        System.err.println("Error al afegir la incidència: " + e.getMessage());
                    }
                    break;
                case ELIMINAR_INCIDENCIA:
                    try {
                        // Mostrem les incidències actuals
                        String incidencies = camping.llistarIncidencies();
                        System.out.println("Incidències actuals:");
                        System.out.println(incidencies);

                        // Demanem a l'usuari el número de la incidència a eliminar
                        System.out.print("Introdueix el número de la incidència que vols eliminar: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();  // Consumeix la nova línia que queda

                        // Cridem el mètode per eliminar la incidència
                        camping.eliminarIncidencia(num);
                        System.out.println("Incidència eliminada correctament.");
                    } catch (ExcepcioCamping e) {
                        System.err.println("Error al eliminar la incidència: " + e.getMessage());
                    }
                    break;

                case CALCULAR_ACCESSOS_COTXE:
                    camping.calculaAccessosAccessibles();
                    break;
                case CALCULAR_METRES_ASFALT:
                    camping.calculaMetresQuadratsAsfalt();
                    break;
                case GUARDAR_CAMPING:
                    try {
                        camping.save("dataCamping.txt");
                    } catch (ExcepcioCamping e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case CARREGAR_CAMPING:
                    try {
                        camping = Camping.load("dataCamping.txt");
                    } catch (ExcepcioCamping e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case SORTIR:
                    System.out.println("Sortint de l'aplicació...");
                    //no cal fer res més, ja es surt del bucle do-while, per haver escollit l'opció.
                    break;
                default:
                    System.out.println("Opció no reconeguda. Torna-hi.");
            }
        } while (opcio != OpcionsMenu.SORTIR);

        scanner.close();
    }
}
