package com.P01_OOFicheros;


import static com.P01_OOFicheros.EntradaDatos.*;

public class Main {
    // Variable que contiene nuestra lista de juegos
    private static ClienteList clientes;
    private static Fichero miFichero;

    public static void main(String[] args) {
        miFichero = new Fichero("clientes.xml");
        clientes = (ClienteList) miFichero.read();
        if (clientes == null) {
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
                    mostrarPendientes();
                    break;
                case 4:
                    mostrarPresupuestosCliente();
                    break;
                case 5:
                    mostrarRechazados();
                    break;
                case 6:
                    allClientes();
                    break;
                case 7:
                    modificarPresupuesto();
                    break;
                case 8:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 8);

    }

    // 1
    private static void nuevoCliente() {
        String nombre = inputString("Nombre: ");
        String apellidos = inputString("Apellidos: ");
        String telefono = inputString("Telefono: ");

        String respuesta;
        boolean descuento = false;
        do {
            respuesta = inputString("¿Tiene descuento? (SI/NO)?");
            if (respuesta.equalsIgnoreCase("si")) {
                descuento = true;
            } else if (respuesta.equalsIgnoreCase("no")) {
                descuento = false;
            } else {
                System.out.println("Respuesta incorrecta. Escribe SI o NO");
            }
        } while (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("no"));
        Cliente c = new Cliente(nombre, apellidos, telefono, descuento);

        clientes.altaCliente(c);

        miFichero.save(clientes);
        System.out.println("Cliente dado de alta.");
    }

    // 2
    private static void nuevoPresupuesto() {
        String telf = inputString("Introduce el teléfono: ");

        boolean registrado = false;
        for(Cliente carnet : clientes.getLista()) {
            if(carnet.getTelefono().equals(telf)) {
                registrado = true;
            }
        }

        if (!registrado)
            nuevoCliente();

        Integer nPresupuesto = inputInt("Número de presupuesto: ");
        String concepto = inputString("Concepto: ");
        Double precioTotal = inputDouble("Precio total: ");
        String estado;
        do {
            estado = inputString("¿Estado? (Aceptado/Rechazado/Pendiente)?");
        } while (!estado.equalsIgnoreCase("aceptado") && !estado.equalsIgnoreCase("rechazado") && !estado.equalsIgnoreCase("pendiente"));
        Double precioFinalDesc = precioTotal;
         for(Cliente c : clientes.getListaCliente()) {
            if (c.getTelefono().equals(telf)) {
                if (c.isDescuento())
                    precioFinalDesc = precioTotal + (precioTotal * 0.05);
            }
        }
        Double precioFinalIVA = precioFinalDesc + (precioFinalDesc * 0.21);

        Presupuesto p = new Presupuesto( nPresupuesto, concepto, precioTotal, precioFinalDesc, precioFinalIVA, estado);
        clientes.altaPresupuesto(p, telf);
        miFichero.save(clientes);
        System.out.println("Presupuesto dado de alta.");
    }

    // 3
    private static void mostrarPendientes() {
        boolean noPres = true;
        if (clientes.getLista() != null) {
            for (Cliente c : clientes.getLista()) {
                if (c.getPresupuestos().getPresupuestolist() != null) {
                    noPres = false;
                    for (Presupuesto p : c.getPresupuestos().getPresupuestolist()) {
                        if (p.getEstado().equalsIgnoreCase("Pendiente")) {
                            System.out.println(clientes.mostrarClientePresupuesto(c, p));
                        }
                    }
                }
            }
        } else {
            System.out.println("No hay clientes.");
        }

        if (noPres) {
            System.out.println("No hay presupuestos");
        }
    }

    // 4.- Listado de presupuestos de un cliente determinado. Solicitará el teléfono del cliente y mostrará todos los datos de los presupuestos que se hayan emitido para dicho cliente.
    private static void mostrarPresupuestosCliente() {
        String telf = inputString("Introduce el número de teléfono:");
        for(Cliente c : clientes.getLista()) {
            if(c.getTelefono().equals(telf)) {
                for (Presupuesto p : c.getPresupuestos().getPresupuestolist()) {
                    System.out.println(clientes.mostrarClientePresupuesto(c, p));
                }
            }
        }
    }

    // 5
    private static void mostrarRechazados() {
        boolean noPres = true;
        if (clientes.getLista() != null) {
            for(Cliente c : clientes.getLista()) {
                if (c.getPresupuestos().getPresupuestolist() != null) {
                    noPres = false;
                    for (Presupuesto p : c.getPresupuestos().getPresupuestolist()) {
                        if (p.getEstado().equalsIgnoreCase("Rechazado")) {
                            System.out.println(clientes.mostrarClientePresupuesto(c, p));
                        }
                    }
                }
            }
        } else {
            System.out.println("No hay clientes.");
        }

        if (noPres) {
            System.out.println("No hay presupuestos");
        }
    }

    // 6
    private static void allClientes() {
        if (clientes.getLista() != null) {
            for (Cliente c : clientes.getLista()) {
                System.out.println(clientes.listadoCliente(c));
            }
        } else {
            System.out.println("No hay clientes");
        }
    }

    // 7
    private static void modificarPresupuesto() {
        Integer nPresupuesto = inputInt("Número de presupuesto: ");
        String estado;
        do {
            estado = inputString("¿Estado? (Aceptado/Rechazado/Pendiente)?");
        } while (!estado.equalsIgnoreCase("aceptado") && !estado.equalsIgnoreCase("rechazado") && !estado.equalsIgnoreCase("pendiente"));
        clientes.cambiarPresupuesto(nPresupuesto, estado);
        miFichero.save(clientes);
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
