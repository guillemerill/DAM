package com.Videojuegos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by DAM on 7/10/16.
 */
public class GameList implements Serializable{

    private ArrayList<Game> lista;

    public GameList() {
        lista = new ArrayList<>();
    }

    public void alta(Game g) {
        lista.add(g);
    }

    public void baja(Game g) {
        lista.remove(g);
    }

    public Game obtenerGamePorNombre(String nombre) {
        // REcorremos la lista
        for (Game g : lista) {
            // Si el nombre del juego actual es igual al nombre q me pasan
            if (g.getNombre().equalsIgnoreCase(nombre)) {
                // devolvemos el juego encontrado
                return g;
            }
        }
        // Si llega a este punto es que no ha encontrado
        // ningún juego con el nombre pasado
        return null;
    }

    public ArrayList<Game> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Game> lista) {
        this.lista = lista;
    }

}
