package com.StucomExpress.Persistence;

import com.StucomExpress.Model.*;
import com.StucomExpress.Model.Package;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase encargada de la gestión de la BBDD
public class TransportJDBC {
    private Connection conexion;

    public void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/transport";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }
    public void disconnect() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    // 4
    public void insertPackage(Package p) throws SQLException {
        String insert = "INSERT INTO package VALUES (NULL, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, p.getCustomer());
        ps.setString(2, p.getDriver().getDni());
        ps.setString(3, p.getCity().getPostalcode());
        ps.executeUpdate();
        ps.close();
    }

    // 5
    public void updateTruckdriverSalary(double salary, String dni) throws SQLException {
        String insert = "UPDATE truckdriver SET salary = '" + salary + "' WHERE dni = '"+dni+"';";
        Statement ps = conexion.createStatement();
        ps.executeUpdate(insert);
        ps.close();
    }

    // 6
    public List<Truck> getTruckListByDriver(String dni) throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        String query = "SELECT * FROM truck WHERE driver = '" + dni + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            Truck t = new Truck();
            t.setIdtruck(rs.getString("idtruck"));
            t.setModel(rs.getString("model"));
            t.setCapacity(rs.getInt("capacity"));
            t.setDriver(resultToTruckdriver(rs));

            trucks.add(t);
        }
        rs.close();
        ps.close();

        return trucks;
    }

    // 7
    public List<Package> getPackageListByCity(String city) throws SQLException {
        List<Package> packages = new ArrayList<>();
        String query = "SELECT * FROM package WHERE city = '" + city + "'";
        Statement ps = conexion.createStatement();
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            Package p = new Package();
            p.setIdpackage(rs.getInt("idpackage"));
            p.setCustomer(rs.getString("customer"));
            p.setDriver(resultToTruckdriver(rs));
            p.setCity(resultToCity(rs));

            packages.add(p);
        }
        rs.close();
        ps.close();

        return packages;
    }

    // 8
    public List<EnviosDTO> getEnvios() throws SQLException {
        List<EnviosDTO> env = new ArrayList<>();
        int n = 1;
        String query = "SELECT city, COUNT(*) AS envios FROM package GROUP BY city ORDER BY envios DESC";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        while (rs.next()) {
            EnviosDTO e = new EnviosDTO();
            e.setPosition(n);
            e.setCity(resultToCity(rs));
            e.setNmail(rs.getInt("envios"));

            env.add(e);
            n++;
        }
        rs.close();
        ps.close();

        return env;
    }

    private Truckdriver resultToTruckdriver(ResultSet rs) throws  SQLException {
        // Buscamos el Driver en la base de datos
        String query2 = "SELECT * FROM truckdriver WHERE dni = '" + rs.getString("driver") + "'";
        PreparedStatement ps2 = conexion.prepareStatement(query2);
        ResultSet rs2 = ps2.executeQuery(query2);
        Truckdriver t = new Truckdriver();
        while (rs2.next()) {
            t.setDni(rs2.getString("dni"));
            t.setName(rs2.getString("name"));
            t.setPhone(rs2.getString("phone"));
            t.setSalary(rs2.getDouble("salary"));
        }
        return t;
    }

    private City resultToCity(ResultSet rs) throws  SQLException {
        // Buscamos City en la base de datos
        String query2 = "SELECT * FROM city WHERE postalcode = '" + rs.getString("city") + "'";
        PreparedStatement ps2 = conexion.prepareStatement(query2);
        ResultSet rs2 = ps2.executeQuery(query2);
        City c = new City();
        while (rs2.next()) {
            c.setPostalcode(rs2.getString("postalcode"));
            c.setName(rs2.getString("name"));
        }
        return c;
    }
}