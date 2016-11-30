package com.baloncesto.domain;

import javax.persistence.*;

@Entity
public class Player {

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
    @ManyToOne
    private Team equipo;

    // Constructors
    public Player(String nombre, String nacim, int nCanastas, int nAsistencias, int nRebotes, String posicion, Team equipo) {
        this.nombre = nombre;
        this.nacim = nacim;
        this.nCanastas = nCanastas;
        this.nAsistencias = nAsistencias;
        this.nRebotes = nRebotes;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public Player(){
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

    public Team getEquipo() {
        return equipo;
    }
    public void setEquipo(Team equipo) {
        this.equipo = equipo;
    }

    // Methods
    @Override
    public String  toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacim='" + nacim + '\'' +
                ", nCanastas=" + nCanastas +
                ", nAsistencias=" + nAsistencias +
                ", nRebotes=" + nRebotes +
                ", posicion='" + posicion + '\'' +
                '}'+System.lineSeparator();
    }
}