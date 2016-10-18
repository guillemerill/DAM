package com.P01_OOFicheros;


import static com.P01_OOFicheros.EntradaDatos.*;

public class Main {
    // Variable que contiene nuestra lista de juegos
    private static ClienteList clientes;
    private static Fichero miFichero;

    public static void main(String[] args) {
        // Inicializamos nuestro fichero
        miFichero = new Fichero("clientes.xml");
        clientes = new ClienteList();
        // Para inicializar la lista de misJuegos leemos de disco
        clientes = (ClienteList) miFichero.read();
        // Comprobamos si había fichero (o datos en el mismo)
        if (miFichero == null) {
            // inicializamos la lista como una lista vacía
            clientes = new ClienteList();
        }
        // Menú CRUD
        int opcion;
        do {
            mostrarMenu();
            opcion = inputInt("Escoge una opción");
            switch (opcion) {
                case 1:
                    nuevoCliente();
                    break;
                case 2:
                    nuevoPresupuesto();
                    break;
                case 3:
                    break;
                case 4:
                    mostrarPresupuestosCliente();
                    break;
                case 0:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);

    }

    private static void showGames() {
        System.out.println("Listado de videojuegos en el sistema");
        for (Game g : misJuegos.getLista()) {
            System.out.println(g);
        }
    }

    private static void nuevoCliente() {
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
        clientes.altaCliente(c);
        //miFichero.save(misJuegos);
        System.out.println("Cliente dado de alta.");
    }

    private static void nuevoPresupuesto() {
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
        clientes.altaPresupuesto(p);
        //miFichero.save(misJuegos);
        System.out.println("Cliente dado de alta.");
    }

    // 4.- Listado de presupuestos de un cliente determinado. Solicitará el teléfono del cliente y mostrará todos los datos de los presupuestos que se hayan emitido para dicho cliente.
    private static void mostrarPresupuestosCliente() {
        String telf = inputString("Introduce el número de teléfono:");
        for(Cliente c : clientes.getLista()) {
            if(c.getTelefono().equals(telf)) {
                for (Presupuesto p : c.getPresupuestos()) {
                    clientes.mostrarClientePresupuesto(c, p);
                }
            }
        }
    }

    public static void modificarPresupuesto() {
        Integer nPresupuesto = inputInt("Número de presupuesto: ");
        String estado = inputString("Estado: ");
        clientes.obtenerPresupuesto(nPresupuesto, estado);
    }

    public void mostrarPendientes() {
        for(Cliente c : clientes.getLista()) {
            for (Presupuesto p : c.getPresupuestos()) {
                if (p.getEstado().equals("Pendiente")) {
                    clientes.mostrarClientePresupuesto(c, p);
                }
            }
        }
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

    // 8.- Salir: El programa deberá finalizar. Los datos quedarán guardados.
}
