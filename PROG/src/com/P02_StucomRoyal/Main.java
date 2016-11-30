package com.P02_StucomRoyal;

import java.util.ArrayList;
import java.util.List;
import static com.P02_StucomRoyal.EntradaDatos.*;

/**
 * Un grupo de alumnos de Stucom ha decidido hacer una aplicación para simular un juego de estrategia al que le gusta jugar mucho.
 Es un juego donde cada jugador tiene una serie de cartas que represen tan diferentes tipos de ataques o defensas que permiten “luchar”
 en batallas con otros jugadores.

 Crea las clases necesarias para poder guardar los datos de los jugadores y las cartas.



 3. Crea un menú principal con las siguien tes opciones:

     b. Batalla. Deberán autentifiCarse dos jugadores mediante usuario y password. Una vez autentificados los dos, cada jugador deberá escoger tres cartas entre sus cartas disponibles
        para hacer la batalla. La suma del elixir de las cartas que escoja no podrá ser superior a 10. Una vez escogidas las cartas de los dos jugadores empezará la batalla.
        Se decidirá aleatoriamente quien es el que ataca primero. Se calculará entonces el daño causado por cada jugador en el orden en que hayan seleccionado las cartas.
        Ganará el jugador cuyas cartas tengan más vida al finalizar la batalla. Obtendrá 5 trofeos.
     c. Obtener el ranking de jugadores por nº de trofeos. Deberá mostrarse el nombre del jugador y el nº de trofeos que tiene, ordenador de mayor a menor.

 Se valorará que el di seño de las clases y el código estén optimi zados.
 */
public class Main {
    // Variable con la lista de Jugadores y Cartas
    private static List<Jugador> jugadores;
    private static List<Carta> cartas;

    public static void main(String[] args) {
        jugadores = new ArrayList<>();
        cartas = new ArrayList<>();

        //  1. En el método principal de la aplicación , crea al menos 3 cartas de cada tipo (tropa, estructura y hechizo) y guárdalas como las cartas disponibles para el juego.
        Tropa tropa1 = new Tropa("Montapuercos", 4, 968, 120);
        Tropa tropa2 = new Tropa("Gólem", 8, 3200, 78);
        Tropa tropa3 = new Tropa("Mago", 5, 411, 98);

        Estructura estructura1 = new Estructura("Lápida", 3, 319, 125);
        Estructura estructura2 = new Estructura("Horno", 4, 798, 320);
        Estructura estructura3 = new Estructura("Ballesta", 6, 1000, 400);

        Hechizo hechizo1 = new Hechizo("Descarga", 2, 1, 128, "ataque");
        Hechizo hechizo2 = new Hechizo("Furia", 2, 1, 35, "defensa");
        Hechizo hechizo3 = new Hechizo("Veneno", 4, 1, 42, "ataque");

        cartas.add(tropa1);
        cartas.add(tropa2);
        cartas.add(tropa3);
        cartas.add(estructura1);
        cartas.add(estructura2);
        cartas.add(estructura3);
        cartas.add(hechizo1);
        cartas.add(hechizo2);
        cartas.add(hechizo3);

        // 2. Crea al menos 4 jugadores . Inicialmente su nº de trofeos debe ser 0 y no deben tener ninguna carta disponible.
        Jugador j1 = new Jugador("Jugador 1", "1234", 0, new ArrayList<>());
        Jugador j2 = new Jugador("Jugador 2", "1234", 0, new ArrayList<>());
        Jugador j3 = new Jugador("Jugador 3", "1234", 0, new ArrayList<>());
        Jugador j4 = new Jugador("Jugador 4", "1234", 0, new ArrayList<>());



        int opcion;
        do {
         // 3
         menuPrincipal();
         opcion = inputInt("Escoge una opción");
         switch (opcion) {
          case 1:
           // 3 a
           conseguirCartas();
           break;
          case 2:
           nuevoPresupuesto();
           break;
          case 3:
           mostrarPendientes();
           break;
          case 4:
           System.out.println("Hasta la próxima");
           break;
          default:
           System.out.println("Opción incorrecta.");
         }
        } while (opcion != 4);

    }

    /*
     3. Crea un menú principal con las siguientes opciones:
        a. Conseguir cartas.
        b. Batalla.
        c. Obtener el ranking de jugadores por nº de trofeos.
      */
    private static void menuPrincipal() {
        System.out.println("------ StucomRoyal ------");
        System.out.println("a. Conseguir cartas");
        System.out.println("b. Batalla");
        System.out.println("c. Ranking de jugadores");
        System.out.println("d. Salir");
    }

    /*
       a. Conseguir cartas. Se pedirá usuario y password del jugador.
           - Si los datos no son correctos se dará el correspondiente mensaje de error y se le mandará al menú principal.
           - Si el usuario se autentifica correctamente se le mostrará el listado de cartas y se le permitirá añadir cartas a su listado de cartas disponibles.
           - Cada vez que escoja una carta se comprobará que no la tenga. Si ya la tiene se le informará de que ya dispone de dicha carta.
               Si no la tiene se le incorporará a su grupo de cartas disponibles . En cualquier caso, se le dará opción al usuario a obtener más cartas siempre que no haya llegado al máximo permitido.
               Un jugador puede tener como máximo 6 cartas disponibles.  Cuando se tenga lleno su cupo de cartas se le informará de ello, se le mostrarán todas sus cartas y se le mandará al menú principal.
     */
    private static void conseguirCartas() {
       boolean login = false;
       System.out.println("------ Conseguir cartas ------");
       System.out.println("Debes iniciar sesión!");
       String usuario = inputString("Usuario: ");
       String password = inputString("Password: ");
       for (Jugador j : jugadores) {
           if (j.getUsuario().equals(usuario) && j.getPassword().equals(password)) {
               login = true;
               for (Carta c : cartas) {
                   System.out.println(c);
               }
               String nombreCarta = inputString("Nombre de la carta: ");
               boolean carta_usada = false;
               for (Carta c : cartas) {
                   if (c.getNombre().equals(nombreCarta)) {
                       if (!j.getCartas().isEmpty()) {
                            for (Carta usada : j.getCartas()) {
                                if (nombreCarta.equals(usada.getNombre())) {
                                    carta_usada = true;
                                }
                            }
                       }

                       if (!carta_usada) {
                           j.getCartas().add(c);
                       }

                   }
               }

           }
       }
       if (!login) {
           System.out.println("Login incorrecto.");
       }
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

       if (clientes.altaCliente(c)) {
        miFichero.save(clientes);
        System.out.println("Cliente dado de alta.");
       } else
        System.out.println("El teléfono ya está registrado");

    }

    // 2
    private static void nuevoPresupuesto() {
     System.out.println("**** NUEVO PRESUPUESTO ****");
     String telf = inputString("Introduce el teléfono: ");

     if (!clientes.comprobarTelf(telf)) {
      nuevoCliente();
     }

     Integer nPresupuesto = inputInt("Número de presupuesto: ");
     String concepto = inputString("Concepto: ");
     Double precioTotal = inputDouble("Precio total: ");
     String estado;
     do {
      estado = inputString("¿Estado? (Aceptado/Rechazado/Pendiente)?");
     } while (!estado.equalsIgnoreCase("aceptado") && !estado.equalsIgnoreCase("rechazado") && !estado.equalsIgnoreCase("pendiente"));
     Double precioFinalDesc = precioTotal;
     if (clientes.esVIP(telf))
      precioFinalDesc = precioTotal + (precioTotal * 0.05);
     Double precioFinalIVA = precioFinalDesc + (precioFinalDesc * 0.21);

     Presupuesto p = new Presupuesto( nPresupuesto, concepto, precioTotal, precioFinalDesc, precioFinalIVA, estado);

     if (clientes.altaPresupuesto(p, telf)) {
      miFichero.save(clientes);
      System.out.println("Presupuesto dado de alta.");
     } else
      System.out.println("Ha ocurrido un error.");
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
     if (clientes.comprobarTelf(telf)) {
      for (Cliente c : clientes.getLista()) {
       if (c.getTelefono().equals(telf)) {
        for (Presupuesto p : c.getPresupuestos().getPresupuestolist()) {
         System.out.println(clientes.mostrarClientePresupuesto(c, p));
        }
       }
      }
     } else {
      System.out.println("No se ha encontrado el cliente");
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

     if (clientes.cambiarPresupuesto(nPresupuesto, estado)) {
      miFichero.save(clientes);
      System.out.println("Presupuesto modificado");
     } else
      System.out.println("No se ha encontrado el presupuesto seleccionado.");
    }
}
