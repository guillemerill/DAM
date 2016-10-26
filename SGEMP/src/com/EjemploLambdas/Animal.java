package com.EjemploLambdas;

public class Animal {
    private boolean potSaltar;
    private boolean potVolar;
    private boolean potNadar;
    private boolean potCaminar;

    public Animal(boolean potSaltar, boolean potVolar, boolean potNadar, boolean potCaminar) {
        this.potSaltar = potSaltar;
        this.potVolar = potVolar;
        this.potNadar = potNadar;
        this.potCaminar = potCaminar;
    }

    public boolean potSaltar() {
        return potSaltar;
    }

    public boolean potVolar() {
        return potVolar;
    }

    public boolean potNadar() {
        return potNadar;
    }

    public boolean potCaminar() {
        return potCaminar;
    }

}
