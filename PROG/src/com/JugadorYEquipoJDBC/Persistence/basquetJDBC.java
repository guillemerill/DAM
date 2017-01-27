package com.JugadorYEquipoJDBC.Persistence;

import com.JugadorYEquipoJDBC.Model.EstadisticaDTO;
import com.JugadorYEquipoJDBC.Model.Jugador;
import com.JugadorYEquipoJDBC.Model.Equipo;
import com.JugadorYEquipoJDBC.Model.RankingDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Clase encargada de la gestión con la BBDD
*/

public class basquetJDBC {
    private Connection conexion;

    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/basket";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public List<Equipo> obtenerTodosEquipos() throws SQLException {
        List<Equipo> equipos = new ArrayList<>();
        String query = "SELECT * FROM team";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            equipos.add(resultToTeam(rs));
        }
        rs.close();
        ps.close();

        return equipos;
    }
    public List<Jugador> obtenerTodosJugadores() throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }
    public void deleteAll() throws SQLException {
        String query = "DELETE FROM player";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.executeUpdate();
        ps.close();

        String query2 = "DELETE FROM team";
        ps = conexion.prepareStatement(query2);
        ps.executeUpdate();
        ps.close();
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
    public void updateJugador(String nombre, int canastas, int asistencias, int rebotes) throws SQLException {
        String insert = "UPDATE player SET nbaskets = '"+canastas+"', nassists = '"+asistencias+"', nrebounds = '"+rebotes+"' WHERE name = '"+nombre+"';";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.executeUpdate();
        ps.close();
    }

    // 4) Modificar el equipo de un jugador determinado.
    public void updateEquipoJugador(String name, Equipo e) throws SQLException {
        String insert = "UPDATE player SET team = ? WHERE name = ?;";
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
    public Jugador obtenerJugador(String nombre) throws SQLException {
        String query = "SELECT * FROM player WHERE name = '" + nombre + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        Jugador j = new Jugador();
        while (rs.next()) {
            j = resultToJugador(rs);
        }
        rs.close();
        ps.close();

        return j;
    }

    // 7) Obtener el listado de jugadores a partir de un nombre de manera que no haga falta indicar el nombre completo del equipo.
    public List<Jugador> obtenerJugadoresContainsEquipo(String name) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE name LIKE  '%" + name + "%'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }

    // 8) Listado de jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.
    public List<Jugador> obtenerJugadoresMasCanastas(int canastas) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE nbaskets >= '" + canastas + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }

    // 9) Listado de jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.
    public List<Jugador> obtenerJugadoresAssistBetween(int maxassist, int minassist) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE '" + minassist + "' <= nassists AND nassists <= '" + maxassist + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }

    // 10) Listado de jugadores que pertenezcan a una posición específica, por ejemplo: base.
    public List<Jugador> selectJugadoresPosicion(String position) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE position = '" + position + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }

    // 11) Listado de jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.
    public List<Jugador> selectJugadoresBirth(LocalDate maxbirth) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE birth < '" + java.sql.Date.valueOf(maxbirth) + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }

    // 12) Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media, el máximo y el mínimo de canastas , asistencias y rebotes.
    public List<EstadisticaDTO> obtenerEstadisticasPosicion() throws SQLException {
        List<EstadisticaDTO> res = new ArrayList<>();
        String query = "SELECT position, AVG(nbaskets) as med1, MAX(nbaskets) as max1, MIN(nbaskets) as min1, AVG(nassists) as med2, MAX(nassists) as max2, MIN(nassists) as min2, AVG(nrebounds) as med3, MAX(nrebounds) as max3, MIN(nrebounds) as min3 FROM player GROUP BY position";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            res.add(resultToEstadistica(rs));
        }
        rs.close();
        ps.close();

        return res;
    }

    /* 13) Ranking de jugadores por número de canastas. Debe de devolver un resultado como el siguiente:
            1 Jugador1 24
            2 Jugador2 18
            3 Jugador3 26
    Es decir, deberá devolver un listado indicando posición en el ranking, nombre del jugador y nº de canastas ordenador de mayor a menor número de canastas.*/
    public List<RankingDTO> obtenerRanking() throws SQLException {
        List<RankingDTO> res = new ArrayList<>();
        int n = 1;
        String query = "SELECT name, nbaskets FROM player ORDER BY nbaskets DESC";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            res.add(resultToRanking(rs, n));
            n++;
        }
        rs.close();
        ps.close();

        return res;
    }

    // 14) Obtener la posición dentro del ranking para un jugador determinado.
    public int buscarJugadorRanking(String name)throws SQLException {
        List<RankingDTO> ranking = obtenerRanking();
        int posicion = 0;
        for (RankingDTO r : ranking) {
            if(r.getName().equals(name)) {
                posicion = r.getRanking();
            }
        }
        return posicion;
    }

    // 15) Listado de equipos existentes en una localidad determinada.
    public List<Equipo> selectEquiposByLocalidad(String localidad) throws SQLException {
        List<Equipo> equipos = new ArrayList<>();
        String query = "SELECT * FROM team WHERE city = '" + localidad + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            equipos.add(resultToTeam(rs));
        }
        rs.close();
        ps.close();

        return equipos;
    }


    // 16) Listado de todos los jugadores de un equipo, a partir del nombre completo del equipo.
    public List<Jugador> selectJugadoresByNombreEquipo(String nombre) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE team = '" + nombre + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }


    // 17) Listado de todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.
    public List<Jugador> selectJugadoresEquipoPosicion(String e, String posicion) throws SQLException {
        List<Jugador> jugadores = new ArrayList<>();
        String query = "SELECT * FROM player WHERE team = '" + e + "' AND position = '" + posicion + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            jugadores.add(resultToJugador(rs));
        }
        rs.close();
        ps.close();

        return jugadores;
    }

    // 18) Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.
    public Jugador getJugadorMaxCanastas(String e) throws SQLException {
        String query = "SELECT * FROM player WHERE nbaskets = (SELECT MAX(nbaskets) FROM player WHERE team = '" + e + "')";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        Jugador j = new Jugador();
        while (rs.next()) {
            j = resultToJugador(rs);
        }
        rs.close();
        ps.close();

        return j;
    }

    private Equipo resultToTeam(ResultSet rs) throws  SQLException {
        Equipo e = new Equipo();
        e.setName(rs.getString("name"));
        e.setCity(rs.getString("city"));
        e.setCreation(rs.getDate("creation").toLocalDate());

        return e;
    }

    private EstadisticaDTO resultToEstadistica(ResultSet rs) throws  SQLException {
        EstadisticaDTO est = new EstadisticaDTO();
        est.setPosition(rs.getString("position"));
        est.setAvg1(rs.getInt("med1"));
        est.setMax1(rs.getInt("max1"));
        est.setMin1(rs.getInt("min1"));
        est.setAvg2(rs.getInt("med2"));
        est.setMax2(rs.getInt("max2"));
        est.setMin2(rs.getInt("min2"));
        est.setAvg3(rs.getInt("med3"));
        est.setMax3(rs.getInt("max3"));
        est.setMin3(rs.getInt("min3"));

        return est;
    }

    private RankingDTO resultToRanking(ResultSet rs, int n) throws  SQLException {
        RankingDTO e = new RankingDTO();
        e.setRanking(n);
        e.setName(rs.getString("name"));
        e.setNbaskets(rs.getInt("nbaskets"));

        return e;
    }

    private Jugador resultToJugador(ResultSet rs) throws  SQLException {
        Jugador j = new Jugador();
        j.setName(rs.getString("name"));
        j.setBirth(rs.getDate("birth").toLocalDate());
        j.setNbaskets(rs.getInt("nbaskets"));
        j.setNassists(rs.getInt("nassists"));
        j.setNrebounds(rs.getInt("nrebounds"));
        j.setPosition(rs.getString("position"));
        j.setTeam(new Equipo(rs.getString("team")));
        return j;
    }
}