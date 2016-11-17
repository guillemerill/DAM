import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DAM on 15/11/16.
 */
public class Basquet {
    public static void main(String[] args) {
        // Clase de test para probar que funciona todo
        // Creamos algunos jugadores
        Jugador j1 = new Jugador("Manolo", new Date(1995, 2, 27));
        Jugador j2 = new Jugador("Sara", new Date(1992, 11, 13));
        Jugador j3 = new Jugador("Antonio", new Date(1994, 3, 30));
        Jugador j4 = new Jugador("Ambrosio", new Date(1997, 1, 1));

        Equipo e1 = new Equipo("Stucom", "Barcelona", new Date(2012, 9, 14));
        e1.getJugadores().add(j1);
        e1.getJugadores().add(j2);
        Equipo e2 = new Equipo("Linkia", "Hospitalet", new Date(2013, 9, 1));
        e2.getJugadores().add(j3);
        e2.getJugadores().add(j4);

        List<Equipo> liga = new ArrayList<Equipo>();
        liga.add(e1);
        liga.add(e2);
    }
}
