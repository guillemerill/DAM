package com.P02_StucomRoyal;

import java.util.ArrayList;

/**
 * Cada jugador tiene nombre de usuario, password y número de trofeos conseguidos. Además dispone de un grupo de cartas que ha ido
 consiguiendo durante el juego y que podrá utilizar en sus batallas.
 */
public class Jugador {
    // Attributes
    private String usuario;
    private String password;
    private int trofeos;
    private ArrayList<Carta> cartas;

    // Constructor
    public Jugador(String usuario, String password, int trofeos, ArrayList<Carta> cartas) {
        this.usuario = usuario;
        this.password = password;
        this.trofeos = trofeos;
        this.cartas = cartas;
    }

    // Getters & Setters
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrofeos() {
        return trofeos;
    }
    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
}
