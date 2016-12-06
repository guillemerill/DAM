package com.JugadorYEquipo;

import java.time.LocalDate;

/*
Empezaremos con la entidad jugador.
La entidad jugador tendrá los siguientes atributos:
un identificador , un nombre , una fecha de nacimiento , un número de canastas totales , un número de
asistencias totales , un número de rebotes totales y una posición en el campo por defecto (alero , base , etc.) .
 */
public class Jugador implements Cloneable {

    // Atributos
    private static int contador = 0;

    private int identificador;
    private String nombre;
    private LocalDate nacimiento;
    private int canastas;
    private int asistencias;
    private int rebotes;
    private String posicion;
    private Equipo equipo;

    // Constructores
    public Jugador() {
    }

    public Jugador(String nombre, LocalDate nacimiento, int canastas, int asistencias, int rebotes, String posicion, Equipo equipo) {
        contador++;
        this.identificador = contador;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(LocalDate nacimiento) {
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

    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // Métodos

    @Override
    public String toString() {
        return "Jugador{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", canastas=" + canastas +
                ", asistencias=" + asistencias +
                ", rebotes=" + rebotes +
                ", posicion='" + posicion + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
