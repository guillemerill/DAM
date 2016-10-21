package com.P01_OOFicheros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PresupuestoList implements Serializable{
    // Attributes
    private List<Presupuesto> presupuestolist;

    // Constructors
    public PresupuestoList() {
    }
    public PresupuestoList(List<Presupuesto> presupuestolist) {
        this.presupuestolist = presupuestolist;
    }

    // Getters & Setters
    public List<Presupuesto> getPresupuestolist() {
        return presupuestolist;
    }
    public void setPresupuestolist(List<Presupuesto> presupuestolist) {
        this.presupuestolist = presupuestolist;
    }

    // Methods
    public void alta (Presupuesto p) {
        if (presupuestolist == null)
            presupuestolist = new ArrayList<>();

        presupuestolist.add(p);
    }
}
