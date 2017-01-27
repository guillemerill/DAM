package com.StucomExpress.Model;

public class EnviosDTO {
    // Attributes
    private int position;
    private City city;
    private int nmail;

    // Constructor
    public EnviosDTO() {
    }
    public EnviosDTO(int position, City city, int nmail) {
        this.position = position;
        this.city = city;
        this.nmail = nmail;
    }

    // Getters & Setters
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public int getNmail() {
        return nmail;
    }
    public void setNmail(int nmail) {
        this.nmail = nmail;
    }

    // Methods
    @Override
    public String toString() {
        return position +
                " " + city.getName() +
                " " + nmail +
                "\n";
    }
}
