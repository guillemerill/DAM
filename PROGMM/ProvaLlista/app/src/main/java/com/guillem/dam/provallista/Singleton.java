package com.guillem.dam.provallista;

public class Singleton {

    public static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }

    public static void main() {
        Singleton s = Singleton.getInstance();
    }
}
