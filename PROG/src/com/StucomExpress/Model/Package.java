package com.StucomExpress.Model;

public class Package {
    // Attributes
    private int idpackage;
    private String customer;
    private Truckdriver driver;
    private City city;

    // Constructors
    public Package() {
    }
    public Package(String customer, Truckdriver driver, City city) {
        this.customer = customer;
        this.driver = driver;
        this.city = city;
    }

    // Getters & Setters
    public int getIdpackage() {
        return idpackage;
    }
    public void setIdpackage(int idpackage) {
        this.idpackage = idpackage;
    }

    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Truckdriver getDriver() {
        return driver;
    }
    public void setDriver(Truckdriver driver) {
        this.driver = driver;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    // Methods
    @Override
    public String toString() {
        return "Paquete " + idpackage +
                ", enviado a " + customer +
                ", llevado por " + driver.getName() +
                " a " + city.getName() +
                "\n";
    }
}
