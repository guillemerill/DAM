package com.Restaurante.Model;

/*
 * Entity Plato (nombre, tipo, precio, cocinero)
 */
public class Plato {
    // Atributos
    private String nombre;
    private String tipo;
    private double precio;
    private Cocinero cocinero;

    // Constructores
    public Plato() {
        cocinero = new Cocinero();
    }
    public Plato(String nombre, String tipo, double precio, Cocinero cocinero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cocinero = cocinero;
    }

    // Getters y Setters
    public Cocinero getCocinero() {
        return cocinero;
    }
    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }


    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", cocinero=" + cocinero.getNombre() +
                '}';
    }
}
