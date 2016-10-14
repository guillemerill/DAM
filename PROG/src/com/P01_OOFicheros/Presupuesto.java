package com.P01_OOFicheros;

/**
 * Created by DAM on 11/10/16.
 */
public class Presupuesto {
    // Attributes
    private int codigoCliente;
    private int nPresupuesto;
    private String concepto;
    private double precioTotal;
    private double precioFinalDesc; // Con descuento
    private double precioFinalIVA; // 21%
    private String estado; // Aceptado, rechazado, pendiente

    // Constructor
    public Presupuesto(int codigoCliente, int nPresupuesto, String concepto, double precioTotal, double precioFinalDesc, double precioFinalIVA, String estado) {
        this.codigoCliente = codigoCliente;
        this.nPresupuesto = nPresupuesto;
        this.concepto = concepto;
        this.precioTotal = precioTotal;
        this.precioFinalDesc = precioFinalDesc;
        this.precioFinalIVA = precioFinalIVA;
        this.estado = estado;
    }

    // Getters & Setters
    public int getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getNpresupuesto() {
        return nPresupuesto;
    }
    public void setNpresupuesto(int npresupuesto) {
        this.nPresupuesto = npresupuesto;
    }

    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioFinalDesc() {
        return precioFinalDesc;
    }

    public double getPrecioFinalIVA() {
        return precioFinalIVA;
    }
}
