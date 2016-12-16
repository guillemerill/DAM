package com.Restaurante.Persistence;

import com.Restaurante.Model.Cocinero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Clase encargada de la gestión con la BBDD
 */

// TODO: update cocinero (nombre no), delete cocinero
public class RestaurantJDBC {
    private Connection conexion;

    // Función que conecta con la bbdd
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/restaurant";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }

    // Función que desconecta de la bbdd
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    // Función que inserta un cocinero en la bbdd
    public void insertCocinero(Cocinero c) throws SQLException {
        String insert = "insert into cocinero values (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        // Vamos dando valores a los interrogantes
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getTelefono());
        ps.setString(3, c.getSexo());
        ps.setInt(4, c.getEdad());
        ps.setInt(5, c.getExperiencia());
        ps.setString(6, c.getEspecialidad());
        // Ejecutamos la consultas
        ps.executeUpdate();
        ps.close();
    }

    // Función que modifica un cocinero en la bbdd
    public void updateCocinero(Cocinero c) throws SQLException {
        String insert = "UPDATE cocinero SET telefono = ?, sexo = ?, edad = ?, experiencia = ?, especialidad = ? WHERE nombre = ?;";
        PreparedStatement ps = conexion.prepareStatement(insert);
        // Vamos dando valores a los interrogantes
        ps.setString(1, c.getTelefono());
        ps.setString(2, c.getSexo());
        ps.setInt(3, c.getEdad());
        ps.setInt(4, c.getExperiencia());
        ps.setString(5, c.getEspecialidad());
        ps.setString(6, c.getNombre());
        // Ejecutamos la consultas
        ps.executeUpdate();
        ps.close();
    }

    // Función que elimina un cocinero en la bbdd
    public void deleteCocinero(String cnombre) throws SQLException {
        String delete = "DELETE FROM cocinero WHERE nombre = ?);";
        PreparedStatement ps = conexion.prepareStatement(delete);
        // Vamos dando valores a los interrogantes
        ps.setString(1, cnombre);
        // Ejecutamos la consultas
        ps.executeUpdate();
        ps.close();
    }

}