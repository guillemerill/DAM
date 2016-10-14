package com.P01_OOFicheros;

import java.util.List;

/**
 * Created by DAM on 11/10/16.
 */
public class Cliente {
    /*
    VIP: 5%
    */

    // Attributes
    private int codigoCliente;
    private String nombre;
    private String apellidos;
    private String telefono;
    private boolean descuento;
    private List<Presupuesto> presupuestos;

    // Constructor

    public Cliente(int codigoCliente, String nombre, String apellidos, String telefono, boolean descuento) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.descuento = descuento;
    }

    // Getters and setters
    public int getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }
    public void setPresupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }
}
