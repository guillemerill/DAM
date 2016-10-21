package com.P01_OOFicheros;

import java.io.Serializable;

public class Cliente implements Serializable {
    /*
    VIP: 5%
    */

    // Attributes
    private String nombre;
    private String apellidos;
    private String telefono;
    private boolean descuento;
    private PresupuestoList presupuestos;

    // Constructor

    public Cliente() {}

    public Cliente(String nombre, String apellidos, String telefono, boolean descuento, PresupuestoList presupuestos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.descuento = descuento;
        this.presupuestos = presupuestos;
    }

    // Getters and setters
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

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isDescuento() {
        return descuento;
    }
    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public PresupuestoList getPresupuestos() {
        return presupuestos;
    }
    public void setPresupuestos(PresupuestoList presupuestos) {
        this.presupuestos = presupuestos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", descuento=" + descuento +
                ", presupuestos=" + presupuestos +
                '}';
    }
}
