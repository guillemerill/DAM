import java.util.Date;


public class Jugador {

    private final int id;
    private String nombre;
    private Date nacimiento;
    private int canastas;
    private int asistencias;
    private int rebotes;
    private String posicion;
    private static int contador = 0;

    public Jugador(String nombre, Date nacimiento) {
        contador++;
        this.id = contador;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
    }

    public Jugador(String nombre, Date nacimiento, int canastas, int asistencias, int rebotes, String posicion) {
        this(nombre, nacimiento);
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getCanastas() {
        return canastas;
    }
    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public int getAsistencias() {
        return asistencias;
    }
    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getRebotes() {
        return rebotes;
    }
    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
