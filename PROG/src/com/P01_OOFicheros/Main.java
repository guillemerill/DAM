package com.P01_OOFicheros;


import static com.P01_OOFicheros.EntradaDatos.*;

/**
 * Created by DAM on 11/10/16.
 */
public class Main {
    // Variable que contiene nuestra lista de juegos
    private static ClienteList cliente;
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

    public void nuevoCliente() {
        Integer codigoCliente = inputInt("Código de cliente: ");
        String nombre = inputString("Nombre: ");
        String apellidos = inputString("Apellidos: ");
        String telefono = inputString("Telefono: ");

        String respuesta;
        boolean descuento = false;
        do {
            respuesta = inputString("¿Lo tienes (SI/NO)?");
            if (respuesta.equalsIgnoreCase("si")) {
                descuento = true;
            } else if (respuesta.equalsIgnoreCase("no")) {
                descuento = false;
            } else {
                System.out.println("Respuesta incorrecta. Escribe SI o NO");
            }
        } while (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("no"));
        Cliente c = new Cliente(codigoCliente, nombre, apellidos, telefono, descuento);
        cliente.altaCliente(c);
        //miFichero.save(misJuegos);
        System.out.println("Cliente dado de alta.");
    }

    public void nuevoPresupuesto() {
        Integer codigoCliente = inputInt("Código de cliente: ");
        Integer nPresupuesto = inputInt("Número de presupuesto: ");
        String concepto = inputString("Concepto: ");
        Double precioTotal = inputDouble("Precio total: ");
        String estado = inputString("Estado: ");
        Double precioFinalDesc = 00.0;
        Double precioFinalIVA = 00.0;

        /*
        TODO: precioDescuento, precioIVA
         */

        Presupuesto p = new Presupuesto(codigoCliente, nPresupuesto, concepto,precioTotal,precioFinalDesc, precioFinalIVA, estado);
        cliente.altaPresupuesto(p);
        //miFichero.save(misJuegos);
        System.out.println("Cliente dado de alta.");
    }


    public void mostrarPendientes() {
        cliente.obtenerPendientes();
    }

    private static void mostrarMenu() {
        System.out.println(" PRESUPUESTOS ");
        System.out.println("1. Alta cliente");
        System.out.println("2. Nuevo presupuesto");
        System.out.println("3. Presupuestos pendientes (de aceptar o rechazar)");
        System.out.println("4. Listado de presupuestos de un cliente determinado");
        System.out.println("5. Listado de presupuestos rechazados");
        System.out.println("6. Listado de clientes, donde aparezca también el total de presupuestos que tiene cada uno");
        System.out.println("7. Cambiar estado de un presupuesto");
        System.out.println("8. Salir");
    }
}
