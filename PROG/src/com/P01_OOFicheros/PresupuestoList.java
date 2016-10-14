package com.P01_OOFicheros;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by DAM on 14/10/16.
 */
public class PresupuestoList implements Serializable {


    public void baja(Cliente c) {
        listaPresupuesto.remove(c);
    }

    public Cliente obtenerGamePorNombre(String nombre) {
        // REcorremos la lista
        for (Cliente g : listaPresupuesto) {
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

    public ArrayList<Cliente> getLista() {
        return listaPresupuesto;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.listaPresupuesto = lista;
    }
}
