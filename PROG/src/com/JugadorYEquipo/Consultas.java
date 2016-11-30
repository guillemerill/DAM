package com.JugadorYEquipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultas {

    /**
     * En el menú de consultas de jugadores deben de aparecer las siguientes consultas:
     */
    // 1. Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.
    public static List<Jugador> buscarJugadoresPorNombre(List<Equipo> todosEquipos, String nombre) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                // Problema de Mayúsculas y minúsculas
                String nombreCompleto = j.getNombre().toLowerCase();
                String nombreMinusculas = nombre.toLowerCase();
                // Miramos si contiene una parte del nombre
                if (nombreCompleto.contains(nombreMinusculas)) {
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    // 2. Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.
    public static List<Jugador> buscarJugadoresPorCanastasMayorOIgual(List<Equipo> todosEquipos, int canastas) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getCanastas() >= canastas){
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    // 3. Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.
    public static List<Jugador> buscarJugadoresEntreAsistencias(List <Equipo> todosEquipos, int asistenciasMin, int asistenciasMax){
        List<Jugador> jugadoresAsistencias = new ArrayList<>();
        for (Equipo e : todosEquipos){
            for (Jugador j : e.getJugadores()){
                if(j.getAsistencias()>= asistenciasMin && j.getAsistencias() <= asistenciasMax ){
                    jugadoresAsistencias.add(j);
                }
            }
        }
        return jugadoresAsistencias;
    }

    // 4. Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base.
    public static List<Jugador> buscarJugadoresPorPosicion(List <Equipo> todosEquipos, String posicion) {
        List<Jugador> jugadoresPosicion = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getPosicion().equals(posicion)) {
                    jugadoresPosicion.add(j);
                }
            }
        }
        return jugadoresPosicion;
    }

    // 5. Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.
    public static List<Jugador> buscarJugadoresPorNacimientoAnterior(List <Equipo> todosEquipos, LocalDate fecha) {
        List<Jugador> jugadoresNacimiento = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getNacimiento().isBefore(fecha)) {
                    jugadoresNacimiento.add(j);
                }
            }
        }
        return jugadoresNacimiento;
    }

    // 6. Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes.
    public static List<Estadistica> buscarMediaPorPosicion(List <Equipo> todosEquipos, String posicion) {
        List<Estadistica> estadisticasPosicion = new ArrayList<>();
        boolean creada = false;
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                creada = false;
                for (Estadistica est : estadisticasPosicion) {
                    if (est.getPosicion().equals(posicion)) {
                        creada = true;
                    }

                    if (creada) {
                        est.setCanastas(est.getCanastas()+j.getCanastas());
                        est.setAsistencias(est.getAsistencias()+j.getAsistencias());
                        est.setRebotes(est.getRebotes()+j.getRebotes());
                        est.setJugadores(est.getJugadores()+1);
                    } else {
                        est.setPosicion(posicion);
                        est.setCanastas(j.getCanastas());
                        est.setAsistencias(j.getAsistencias());
                        est.setRebotes(j.getRebotes());
                        est.setJugadores(1);
                    }
                    estadisticasPosicion.add(est);
                }
            }
        }

        for (Estadistica est : estadisticasPosicion) {
            est.setCanastas(est.getCanastas()/est.getJugadores());
            est.setAsistencias(est.getAsistencias()/est.getJugadores());
            est.setRebotes(est.getRebotes()/est.getJugadores());
        }
        return estadisticasPosicion;
    }

    // 7. Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.
    public static List<EstadisticaCompleta> buscarMediaAsistenciasRebotesPorPosicion(List <Equipo> todosEquipos, String posicion) {
        List<EstadisticaCompleta> estadisticasPosicion = new ArrayList<>();
        boolean creada = false;
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                creada = false;
                for (EstadisticaCompleta est : estadisticasPosicion) {
                    if (est.getPosicion().equals(posicion)) {
                        creada = true;
                    }

                    if (creada) {
                        if (j.getCanastas() > est.getMaxcanastas())
                            est.setMaxcanastas(j.getCanastas());
                        if (j.getCanastas() < est.getMincanastas())
                            est.setMincanastas(j.getCanastas());

                        if (j.getAsistencias() > est.getMaxasistencias())
                            est.setMaxasistencias(j.getAsistencias());
                        if (j.getAsistencias() < est.getMinasistencias())
                            est.setMinasistencias(j.getAsistencias());

                        if (j.getRebotes() > est.getMaxrebotes())
                            est.setMaxrebotes(j.getRebotes());
                        if (j.getRebotes() < est.getMinrebotes())
                            est.setMaxrebotes(j.getRebotes());

                        est.setCanastas(est.getCanastas()+j.getCanastas());
                        est.setAsistencias(est.getAsistencias()+j.getAsistencias());
                        est.setRebotes(est.getRebotes()+j.getRebotes());
                        est.setJugadores(est.getJugadores()+1);
                    } else {
                        est.setPosicion(posicion);
                        est.setMaxcanastas(j.getCanastas());
                        est.setMaxasistencias(j.getAsistencias());
                        est.setMaxrebotes(j.getRebotes());
                        est.setMincanastas(j.getCanastas());
                        est.setMinasistencias(j.getAsistencias());
                        est.setMinrebotes(j.getRebotes());
                        est.setCanastas(j.getCanastas());
                        est.setAsistencias(j.getAsistencias());
                        est.setRebotes(j.getRebotes());
                        est.setJugadores(1);
                    }
                    estadisticasPosicion.add(est);
                }
            }
        }

        for (EstadisticaCompleta est : estadisticasPosicion) {
            est.setCanastas(est.getCanastas()/est.getJugadores());
            est.setAsistencias(est.getAsistencias()/est.getJugadores());
            est.setRebotes(est.getRebotes()/est.getJugadores());
        }
        return estadisticasPosicion;
    }

    /**
     * En el menú de consultas de equipos deben de aparecer las siguientes consultas:
     */
    // 1. Consulta los equipos existentes en una localidad determinada.
    public static List<Equipo> buscarEquposporLocalidad(List<Equipo> todosEquipos, String localidad) {
        List<Equipo> equipos = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            // Problema de Mayúsculas y minúsculas
            String nombreCompleto = e.getLocalidad().toLowerCase();
            String nombreMinusculas = localidad.toLowerCase();
            // Miramos si contiene una parte del nombre
            if (nombreCompleto.equals(nombreMinusculas)) {
                equipos.add(e);
            }

        }
        return equipos;
    }

    // 2. Devuelve todos los jugadores de un equipo , a partir del nombre completo del equipo.
    public static List<Jugador> buscarJugadoresPorEquipo(List<Equipo> todosEquipos, String nombre) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            // Problema de Mayúsculas y minúsculas
            String nombreCompleto = e.getNombre().toLowerCase();
            String nombreMinusculas = nombre.toLowerCase();
            // Miramos si contiene una parte del nombre
            if (nombreCompleto.equals(nombreMinusculas)) {
                jugadores = e.getJugadores();
            }
        }
        return jugadores;
    }

    // 3. Devuelve todos los jugadores  de un equipo, que además  jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.
    public static List<Jugador> buscarJugadoresPorEquipoYPosicion(List<Equipo> todosEquipos, String nombre, String posicion) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            // Problema de Mayúsculas y minúsculas
            String nombreCompleto = e.getNombre().toLowerCase();
            String nombreMinusculas = nombre.toLowerCase();
            for (Jugador j : e.getJugadores()) {
                if (nombreCompleto.equals(nombreMinusculas)) {
                    String posicionCompleta = j.getPosicion().toLowerCase();
                    String posicionMin = posicion.toLowerCase();
                    if (posicionCompleta.equals(posicionMin))
                        jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    //  4. Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.
    public static Jugador buscarJugadorMaxCanastasPorEquipo(List<Equipo> todosEquipos, String nombre) {
        Jugador jugador = new Jugador();
        int max = 0;
        for (Equipo e : todosEquipos) {
            // Problema de Mayúsculas y minúsculas
            String nombreCompleto = e.getNombre().toLowerCase();
            String nombreMinusculas = nombre.toLowerCase();
            if (nombreCompleto.equals(nombreMinusculas)) {
                for (Jugador j : e.getJugadores()) {
                    if (j.getCanastas() > max)
                        jugador = j;
                }
            }
        }
        return jugador;
    }

}
