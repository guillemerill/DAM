package com.Videojuegos;
import com.Utilidades.Fichero;
import com.Utilidades.EntradaDatos;
/**
 * Created by Guillem on 7/10/16.
 */
public class VideoJuegos {
    // Variable que contiene nuestra lista de juegos
    private static GameList misJuegos;
    private static Fichero miFichero;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializamos nuestro fichero
        miFichero = new Fichero("juegos.xml");
        // Para inicializar la lista de misJuegos leemos de disco
        misJuegos = (GameList) miFichero.read();
        // Comprobamos si había fichero (o datos en el mismo)
        if (misJuegos == null) {
            // inicializamos la lista como una lista vacía
            misJuegos = new GameList();
        }
        // Menú CRUD
        int opcion;
        do {
            mostrarMenu();
            opcion = EntradaDatos.inputInt("Escoge una opción");
            switch (opcion) {
                case 1:
                    newGame();
                    break;
                case 2:
                    showGames();
                    break;
                case 3:
                    break;
                case 4:
                    deleteGame();
                    break;
                case 0:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);

    }

    private static void deleteGame() {
        // Mostramos los juegos para que el usuario los pueda ver
        showGames();
        String nombre =
                pedirCadenaNoVacia("Indica el nombre del juego que quieras borrar");
        // Paso el nombre q me ha dado el usuario para buscar el juego en la lista
        Game juego = misJuegos.obtenerGamePorNombre(nombre);
        if (juego == null) {
            System.out.println("No existe ningún juego con ese nombre.");
        } else {
            //TODO Preguntar antes confirmación de borrado
            misJuegos.baja(juego);
            // Grabamos en el fichero
            miFichero.save(misJuegos);
            System.out.println("Juego borrado.");
        }
    }

    private static void showGames() {
        System.out.println("Listado de videojuegos en el sistema");
        for (Game g : misJuegos.getLista()) {
            System.out.println(g);
        }
    }

    private static void newGame() {
        String nombre = pedirCadenaNoVacia("Nombre: ");
        String genero = pedirCadenaNoVacia("Género: ");
        int puntos;
        do {
            puntos = EntradaDatos.inputInt("Valoración: ");
            if (puntos < 0 || puntos > 10) {
                System.out.println("Debe estar entre 0 y 10");
            }
        } while (puntos < 0 || puntos > 10);
        double precio;
        do {
            precio = EntradaDatos.inputDouble("Precio: ");
            if (precio < 0) {
                System.out.println("El precio no puede ser negativo");
            }
        } while (precio < 0);
        String respuesta;
        boolean enPropiedad = false;
        do {
            respuesta = EntradaDatos.inputString("¿Lo tienes (SI/NO)?");
            if (respuesta.equalsIgnoreCase("si")) {
                enPropiedad = true;
            } else if (respuesta.equalsIgnoreCase("no")) {
                enPropiedad = false;
            } else {
                System.out.println("Respuesta incorrecta. Escribe si o no");
            }
        } while (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("no"));
        Game g = new Game(nombre, genero, puntos, precio, enPropiedad);
        misJuegos.alta(g);
        miFichero.save(misJuegos);
        System.out.println("Juego dado de alta.");
    }

    private static String pedirCadenaNoVacia(String msg) {
        String cadena;
        do {
            cadena = EntradaDatos.inputString(msg);
            if (cadena.equals("")) {
                System.out.println("No se puede dejar en blanco.");
            }
        } while (cadena.equals(""));
        return cadena;
    }

    private static void mostrarMenu() {
        System.out.println(" VIDEOJUEGOS ");
        System.out.println("1. Alta");
        System.out.println("2. Listado");
        System.out.println("3. Modificar");
        System.out.println("4. Borrar");
        System.out.println("0. Salir");
    }
}
