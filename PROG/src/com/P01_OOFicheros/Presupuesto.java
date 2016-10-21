package com.P01_OOFicheros;

import java.io.Serializable;


public class Presupuesto implements Serializable {
    // Attributes
    private int nPresupuesto;
    private String concepto;
    private double precioTotal;
    private double precioFinalDesc; // Con descuento
    private double precioFinalIVA; // 21%
    private String estado; // Aceptado, rechazado, pendiente

    // Constructors

    public Presupuesto() {
    }

    public Presupuesto(int nPresupuesto, String concepto, double precioTotal, double precioFinalDesc, double precioFinalIVA, String estado) {
        this.nPresupuesto = nPresupuesto;
        this.concepto = concepto;
        this.precioTotal = precioTotal;
        this.precioFinalDesc = precioFinalDesc;
        this.precioFinalIVA = precioFinalIVA;
        this.estado = estado;
    }

    // Getters & Setters
    public int getnPresupuesto() {
        return nPresupuesto;
    }
    public void setnPresupuesto(int nPresupuesto) {
        this.nPresupuesto = nPresupuesto;
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

    public double getPrecioFinalDesc() {
        return precioFinalDesc;
    }
    public void setPrecioFinalDesc(double precioFinalDesc) {
        this.precioFinalDesc = precioFinalDesc;
    }

    public double getPrecioFinalIVA() {
        return precioFinalIVA;
    }
    public void setPrecioFinalIVA(double precioFinalIVA) {
        this.precioFinalIVA = precioFinalIVA;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
