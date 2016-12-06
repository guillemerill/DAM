package com.P02_StucomRoyal;

import java.util.*;

import static com.P02_StucomRoyal.EntradaDatos.*;

/**
 * Un grupo de alumnos de Stucom ha decidido hacer una aplicación para simular un juego de estrategia al que le gusta jugar mucho.
 Es un juego donde cada jugador tiene una serie de cartas que represen tan diferentes tipos de ataques o defensas que permiten “luchar”
 en batallas con otros jugadores.

 Crea las clases necesarias para poder guardar los datos de los jugadores y las cartas.

 Se valorará que el diseño de las clases y el código estén optimizados.
 */
public class Main {
    // Variable con la lista de Jugadores y Cartas
    private static List<Jugador> jugadores;
    private static List<Carta> cartas;

    private static Jugador jugador1;
    private static Jugador jugador2;

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

        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        jugadores.add(j4);


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
              // 3 b
              batalla();
              break;
          case 3:
               // 3 c
               showRanking();
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
        System.out.println("1. Conseguir cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking de jugadores");
        System.out.println("4. Salir");
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
        if (existeJugador(usuario, password, false)) {
               int cartas_usu;
               do {
                   cartas_usu = jugador1.getCartas().size();
                   for (Carta c : cartas) {
                       System.out.println(c);
                   }
                   String nombreCarta = inputString("Nombre de la carta: ");
                   boolean carta_usada = false;
                   for (Carta c : cartas) {
                       if (c.getNombre().equals(nombreCarta)) {
                           if (!jugador1.getCartas().isEmpty()) {
                               for (Carta usada : jugador1.getCartas()) {
                                   if (nombreCarta.equals(usada.getNombre())) {
                                       carta_usada = true;
                                   }
                               }
                           }

                           if (!carta_usada) {
                               jugador1.getCartas().add(c);
                           } else {
                               System.out.println("Ya tienes esta carta!");
                           }

                       }
                   }
               } while (cartas_usu < 6);
               System.out.println("Ya has llenado tu cupo de cartas, estas son tus cartas:");
               for (Carta c : jugador1.getCartas()) {
                   System.out.println(c.toString());
               }
        }
    }


    /* b. Batalla. Deberán autentificarse dos jugadores mediante usuario y password. Una vez autentificados los dos, cada jugador deberá escoger tres cartas entre sus cartas disponibles
        para hacer la batalla. La suma del elixir de las cartas que escoja no podrá ser superior a 10. Una vez escogidas las cartas de los dos jugadores empezará la batalla.
        Se decidirá aleatoriamente quien es el que ataca primero. Se calculará entonces el daño causado por cada jugador en el orden en que hayan seleccionado las cartas.
        Ganará el jugador cuyas cartas tengan más vida al finalizar la batalla. Obtendrá 5 trofeos.
     */
    private static void batalla() {
        boolean login1 = false;
        boolean login2 = false;
        System.out.println("------ Batalla ------");
        System.out.println("Debéis iniciar sesión!");
        System.out.println("Jugador 1:");
        String usuario1 = inputString("Usuario: ");
        String password1 = inputString("Password: ");
        List<Carta> jugador1_cartas = new ArrayList<>();
        System.out.println("Jugador 2:");
        String usuario2 = inputString("Usuario: ");
        String password2 = inputString("Password: ");
        List<Carta> jugador2_cartas = new ArrayList<>();

        int elixirtotal;
        if (existeJugador(usuario1, password1, false)) {
            if (existeJugador(usuario2, password2, true)) {
                jugador1_cartas = escoger(jugador1);
                jugador2_cartas = escoger(jugador2);
            }

        }

                        // Empieza la papaya
                        int j = new Random().nextInt(1); // Si j=0 empieza el jugador1, si j=1 empieza el jugador2
                        if (j == 0) {
                            for (Carta c1 : jugador1_cartas) {
                                if (c1.getClass().equals(Tropa.class)) {
                                    c1.utilizar(jugador2_cartas.get(0));
                                } else if (c1.getClass().equals(Estructura.class)) {
                                    for (Carta cartas : jugador1_cartas) {
                                        c1.utilizar(cartas);
                                    }
                                } else if (c1.getClass().equals(Hechizo.class)) {

                                }
                            }

                        } else if (j == 2) {

                        }





    }

   // 3 c. Obtener el ranking de jugadores por nº de trofeos. Deberá mostrarse el nombre del jugador y el nº de trofeos que tiene, ordenador de mayor a menor.
    private static void showRanking() {
        List<Jugador> jugadores_sort = jugadores;
        Collections.sort(jugadores_sort);
        int p = 1;
        for (Jugador j : jugadores_sort) {
            System.out.println(p + ". " + j.getUsuario() + " - " + j.getTrofeos());
            p++;
        }
    }

    private static boolean existeJugador(String usuario, String password, boolean extra) {
        for (Jugador j : jugadores) {
            if (j.getUsuario().equals(usuario) && j.getPassword().equals(password)) {
                if (extra)
                    jugador2 = j;
                else
                    jugador1 = j;

                return true;
            }
        }
        System.out.println(usuario + " no encontrado o password incorrecta.");
        return false;
    }

    private static List<Carta> escoger(Jugador jug) {
        int elixirtotal = 0;
        List<Carta> cartas_esc = new ArrayList<>();
        System.out.println(jug.getUsuario() + ", escoge 3 cartas para batallar (El elixir total no debe superar los 10 pts)");
        for (Carta c : jug.getCartas()) {
            System.out.println(c);
        }
        do {
            String nombreCarta = inputString("Nombre de la carta: ");
            for (Carta c : cartas) {
                if (c.getNombre().equals(nombreCarta)) {
                    if ((elixirtotal + c.getCoste()) <= 10) {
                        if (!cartas_esc.contains(c)) {
                            cartas_esc.add(c);
                            elixirtotal += c.getCoste();
                        } else
                            System.out.println("Ya has usado esta carta");
                    } else {
                        System.out.println("El coste total supera los 10 pts.");
                    }
                }
            }
        } while (cartas_esc.size() < 3);
        return cartas_esc;
     }
}
