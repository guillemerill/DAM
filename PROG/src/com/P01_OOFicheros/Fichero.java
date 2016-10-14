package com.P01_OOFicheros;

/**
 * Created by DAM on 7/10/16.
 */

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fichero {

    // Variable para guardar el nombre del fichero
    private String name;

    // Inicializamos el nombre del fichero
    public Fichero(String in) {
        this.name = in;
    }

    // Función para guardar datos en un fichero (XML)
    public void save(Object o) {
        try {
            // Creamos el codificador
            XMLEncoder codificador = new XMLEncoder(new FileOutputStream(new File(name)));
            // Escribimos el objeto que nos pasan en el fichero (en XML).
            codificador.writeObject(o);
            codificador.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Función para leer datos de un fichero (XML)
    public Object read() {
        try {
            // Creamos el decodificador
            XMLDecoder decodificador = new XMLDecoder(new FileInputStream(new File(name)));
            // Leemos el objeto del fichero (XML)
            return decodificador.readObject();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }



}