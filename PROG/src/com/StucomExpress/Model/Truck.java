package com.StucomExpress.Model;

public class Truck {
    // Attributes
    private String idtruck;
    private String model;
    private int capacity;
    private Truckdriver driver;

    // Constructors
    public Truck() {
    }
    public Truck(String idtruck, String model, int capacity, Truckdriver driver) {
        this.idtruck = idtruck;
        this.model = model;
        this.capacity = capacity;
        this.driver = driver;
    }

    // Getters & Setters
    public String getIdtruck() {
        return idtruck;
    }
    public void setIdtruck(String idtruck) {
        this.idtruck = idtruck;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Truckdriver getDriver() {
        return driver;
    }
    public void setDriver(Truckdriver driver) {
        this.driver = driver;
    }


    // Methods
    @Override
    public String toString() {
        return "Camión " + idtruck +
                ", " + model +
                ". Capacidad: " + capacity +
                ". Conductor: " + driver.getName() +
                "\n";
    }
}

