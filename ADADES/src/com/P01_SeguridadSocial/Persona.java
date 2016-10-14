package com.P01_SeguridadSocial;


/**
 * Created by Guillem on 23/09/2016.
 */
public class Persona {
    // Attributes
    public String DNI;
    public String numSS;
    public String nombre;
    public String apellidos;
    public int edad;
    public double salario;

    // Default constructor
    public Persona() {}

    // Constructor
    public Persona(String DNI, String numSS, String nombre, String apellidos, int edad, double salario) {
        this.DNI = DNI;
        this.numSS = numSS;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters & Setters
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNumSS() {
        return numSS;
    }
    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
