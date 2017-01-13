package com.JugadorYEquipoJDBC.Persistence;

import com.JugadorYEquipoJDBC.Model.Jugador;
import com.JugadorYEquipoJDBC.Model.Equipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Clase encargada de la gestión con la BBDD





8) Listado de jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.
9) Listado de jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.
10) Listado de jugadores que pertenezcan a una posición específica, por ejemplo: base.
11) Listado de jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.
12) Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media, el máximo y el mínimo de canastas , asistencias y rebotes.
13) Ranking de jugadores por número de canastas. Debe de devolver un resultado como el siguiente:
    1 Jugador1 24
    2 Jugador2 18
    3 Jugador3 26
    Es decir, deberá devolver un listado indicando posición en el ranking, nombre del jugador y nº de canastas ordenador de mayor a menor número de canastas.
14) Obtener la posición dentro del ranking para un jugador determinado.
15) Listado de equipos existentes en una localidad determinada.
16) Listado de todos los jugadores de un equipo, a partir del nombre completo del equipo.
17) Listado de todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.
18) Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro. */

public class basquetJDBC {
    private Connection conexion;

    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/JugadorYEquipoJDBC";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    // 1) Insertar un equipo nuevo en la bbdd.
    public void insertEquipo(Equipo e) throws SQLException {
        String insert = "INSERT INTO team VALUES (?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, e.getName());
        ps.setString(2, e.getCity());
        ps.setDate(3, java.sql.Date.valueOf(e.getCreation()));
        ps.executeUpdate();
        ps.close();
    }

    // 2) Insertar un nuevo jugador a la bbdd.
    public void insertJugador(Jugador j) throws SQLException {
        String insert = "INSERT INTO player VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, j.getName());
        ps.setDate(2, java.sql.Date.valueOf(j.getBirth()));
        ps.setInt(3, j.getNbaskets());
        ps.setInt(4, j.getNassists());
        ps.setInt(5, j.getNrebounds());
        ps.setString(6, j.getPosition());
        ps.setString(7, j.getTeam().getName());
        ps.executeUpdate();
        ps.close();
    }

    // 3) Modificar canastas, asistencias y rebotes de un jugador determinado.
    public void updateJugador(Jugador j) throws SQLException {
        String insert = "UPDATE jugador SET nbaskets = ?, nassists = ?, nrebounds = ? WHERE name = ?;";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setInt(1, j.getNbaskets());
        ps.setInt(2, j.getNassists());
        ps.setInt(3, j.getNrebounds());
        ps.setString(4, j.getName());
        ps.executeUpdate();
        ps.close();
    }

    // 4) Modificar el equipo de un jugador determinado.
    public void updateEquipoJugador(String name, Equipo e) throws SQLException {
        String insert = "UPDATE jugador SET team = ? WHERE name = ?;";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, e.getName());
        ps.setString(2, name);
        ps.executeUpdate();
        ps.close();
    }

    // 5) Borrar un jugador de la bbdd.
    public void deleteJugador(String name) throws SQLException {
        String delete = "DELETE FROM player WHERE name = ?;";
        PreparedStatement ps = conexion.prepareStatement(delete);
        ps.setString(1, name);
        ps.executeUpdate();
        ps.close();
    }

    // 6) Obtener un objeto Jugador a partir de su nombre.
    public Jugador getJugador(String nombre) throws SQLException {
        Jugador j = new Jugador;
        String query = "SELECT * FROM player WHERE name = ?";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        j.setName(rs.getString("name"));
        j.setBirth(rs.getDate("birth"));
        j.setNbaskets(rs.getInt("nbaskets"));
        j.setNassists(rs.getInt("nassists"));
        j.setNrebounds(rs.getInt("nrebounds"));
        j.setPosition(rs.getString("position"));
        j.setTeam(rs.getString("team"));
        rs.close();
        st.close();

        return j;
    }

    // 7) Obtener el listado de jugadores a partir de un nombre de manera que no haga falta indicar el nombre completo del equipo.
    public List<Jugador> selectJugadoresByTeam(String name) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE team LIKE %?%";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Jugador j = new Jugador();
            j.setName(rs.getString("name"));
            j.setBirth(rs.getDate("birth"));
            j.setNbaskets(rs.getInt("nbaskets"));
            p.getJugador().setNombre(rs.getString("cocinero"));
            jugadores.add(p);
        }
        rs.close();
        st.close();

        return jugadores;
    }
}