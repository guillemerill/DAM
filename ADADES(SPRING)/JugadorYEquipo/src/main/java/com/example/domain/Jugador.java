package com.example.domain;

import javax.persistence.*;

@Entity
public class Jugador {
    /*
    Empezaremos con la entidad jugador. La entidad jugador tendrá los siguientes atributos: un identificador,
    un nombre, una fecha de nacimiento, un número de canastas totales, un número de asistencias totales, un
    número de rebotes totales y una posición en el campo por defecto (alero, base, etc.).
     */
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String nacim;
    private int nCanastas;
    private int nAsistencias;
    private int nRebotes;
    private String posicion;

    // Constructors
    public Jugador() {
    }

    public Jugador(String nombre, String nacim, int nCanastas, int nAsistencias, int nRebotes, String posicion) {
        this.nombre = nombre;
        this.nacim = nacim;
        this.nCanastas = nCanastas;
        this.nAsistencias = nAsistencias;
        this.nRebotes = nRebotes;
        this.posicion = posicion;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacim() {
        return nacim;
    }
    public void setNacim(String nacim) {
        this.nacim = nacim;
    }

    public int getnCanastas() {
        return nCanastas;
    }
    public void setnCanastas(int nCanastas) {
        this.nCanastas = nCanastas;
    }

    public int getnAsistencias() {
        return nAsistencias;
    }
    public void setnAsistencias(int nAsistencias) {
        this.nAsistencias = nAsistencias;
    }

    public int getnRebotes() {
        return nRebotes;
    }
    public void setnRebotes(int nRebotes) {
        this.nRebotes = nRebotes;
    }

    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    // Methods

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacim='" + nacim + '\'' +
                ", nCanastas=" + nCanastas +
                ", nAsistencias=" + nAsistencias +
                ", nRebotes=" + nRebotes +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}
