package com.StucomExpress.Model;

public class City {
    // Attributes
    private String postalcode;
    private String name;

    // Constructors
    public City() {
    }
    public City(String postalcode) {
        this.postalcode = postalcode;
    }
    public City(String postalcode, String name) {
        this.postalcode = postalcode;
        this.name = name;
    }

    // Getters & Setters
    public String getPostalcode() {
        return postalcode;
    }
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Methods
    @Override
    public String toString() {
        return "City{" +
                "postalcode='" + postalcode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
