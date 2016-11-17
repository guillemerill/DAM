import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Equipo {

    private static int numEquipos = 0;
    private final int id;
    private String nombre;
    private String localidad;
    private Date creacion;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String localidad, Date creacion) {
        numEquipos++;
        this.id = numEquipos;
        this.nombre = nombre;
        this.localidad = localidad;
        this.creacion = creacion;
        jugadores = new ArrayList<Jugador>();
    }

    public int getId() {
        return id;
    }

    public static int getNumEquipos() {
        return numEquipos;
    }
    public static void setNumEquipos(int numEquipos) {
        Equipo.numEquipos = numEquipos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getCreacion() {
        return creacion;
    }
    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
