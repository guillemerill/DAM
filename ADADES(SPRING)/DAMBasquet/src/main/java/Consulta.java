import java.util.List;

/*
 * Clase auxiliar para tener los métodos con las consultas necesarias
 * para el ejercicio de Alfredo
 */
public class Consulta {

    // Buscar jugadores por nombre, de manera que no sea necesario
    // introducir el nombre completo
    public List<Jugador> findByNombre(List<Equipo> equipos, String nom) {
        for (Equipo e : equipos) {
            if (e.getNombre().equals(nom)){
                return e.getJugadores();
            }
        }

    }
}
