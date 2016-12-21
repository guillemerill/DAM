package com.Restaurante.Persistence;

import com.Restaurante.Model.Cocinero;
import com.Restaurante.Model.Plato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // INSERTS
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

    public void insertPlato(Plato p) throws SQLException {
        String insert = "insert into plato values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        // Vamos dando valores a los interrogantes
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getTipo());
        ps.setDouble(3, p.getPrecio());
        ps.setString(4, p.getCocinero().getNombre());
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
        String delete = "DELETE FROM cocinero WHERE nombre = ?;";
        PreparedStatement ps = conexion.prepareStatement(delete);
        // Vamos dando valores a los interrogantes
        ps.setString(1, cnombre);
        // Ejecutamos la consultas
        ps.executeUpdate();
        ps.close();
    }

    // Función que devuelve todos los datos de todos los cocineros
    public List<Cocinero> selectAllCocineros() throws SQLException {
        List<Cocinero> cocineros = new ArrayList<>();
        String query = "SELECT * FROM cocinero";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Cocinero c = new Cocinero();
            c.setNombre(rs.getString("nombre"));
            c.setTelefono(rs.getString("telefono"));
            c.setSexo(rs.getString("sexo"));
            c.setEdad(rs.getInt("edad"));
            c.setExperiencia(rs.getInt("experiencia"));
            c.setEspecialidad(rs.getString("especialidad"));
            cocineros.add(c);
        }
        rs.close();
        st.close();

        return cocineros;
    }

    public List<Plato> selectAllPlatos() throws SQLException {
        List<Plato> platos = new ArrayList<>();
        String query = "SELECT * FROM plato";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Plato p = new Plato();
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getFloat("precio"));
            p.setTipo(rs.getString("tipo"));
            p.getCocinero().setNombre(rs.getString("cocinero"));
            platos.add(p);
        }
        rs.close();
        st.close();

        return platos;
    }
}