package com.JugadorYEquipoJDBC.Model;

import java.time.LocalDate;

public class Equipo {
    // Attributes
    private String name;
    private String city;
    private LocalDate creation;

    // Constructors
    public Equipo() {
    }
    public Equipo(String name) {
        this.name = name;
    }
    public Equipo(String name, String city, LocalDate creation) {
        this.name = name;
        this.city = city;
        this.creation = creation;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getCreation() {
        return creation;
    }
    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    // Methods
    @Override
    public String toString() {
        return  name +
                " (" + city +
                ", " + creation +
                ')' + "\n";
    }
}
