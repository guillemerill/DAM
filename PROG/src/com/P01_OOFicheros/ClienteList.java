package com.P01_OOFicheros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClienteList implements Serializable {
    // Attributes
    private ArrayList<Cliente> listaCliente;

    // Constructors
    public ClienteList() {}

    public ClienteList(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    // Getters & Setters
    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }
    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    // Methods
    public boolean comprobarTelf(String telf) {
        if (listaCliente != null) {
            for (Cliente c : listaCliente) {
                if (c.getTelefono().equals(telf)) {
                    return true;
                }
            }
        } else {
            listaCliente = new ArrayList<>();
            comprobarTelf(telf);
        }
        return false;
    }
    public boolean esVIP(String telf) {
        if (listaCliente != null) {
            for (Cliente c : listaCliente) {
                if (c.getTelefono().equals(telf)) {
                    if (c.isDescuento())
                        return true;
                }
            }
        }
        return false;
    }

    public boolean altaCliente(Cliente c) {
        if (!comprobarTelf(c.getTelefono())) {
            listaCliente.add(c);
            return true;
        }
        return false;
    }

    public boolean altaPresupuesto(Presupuesto p, String telf) {
        for(Cliente c : listaCliente) {
            if (c.getTelefono().equals(telf)) {
                c.getPresupuestos().alta(p);
                return true;
            }
        }
        return false;
    }

    public String listadoCliente(Cliente c) {
        return "Cliente{" +
                ", nombre='" + c.getNombre() + '\'' +
                ", apellidos='" + c.getApellidos() + '\'' +
                ", telefono='" + c.getTelefono() + '\'' +
                ", presupuestos=" + c.getPresupuestos().getPresupuestolist().size() +
                '}';
    }

    public boolean cambiarPresupuesto(int codigo, String estado) {
        if (listaCliente != null) {
            for (Cliente c : listaCliente) {
                for (Presupuesto p : c.getPresupuestos().getPresupuestolist()) {
                    if (p.getnPresupuesto() == codigo) {
                        p.setEstado(estado);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Cliente> getLista() {
        return listaCliente;
    }

    public String mostrarClientePresupuesto(Cliente c, Presupuesto p) {
        return "Cliente{" +
            "Nombre: " + c.getNombre() +
            "Apellidos: " + c.getApellidos() +
            "Número presupuesto: " + p.getnPresupuesto() +
            "Concepto: " + p.getConcepto() +
            "Precio total: " + p.getPrecioTotal() +
            "Precio total con descuento: " + p.getPrecioFinalDesc() +
            "Precio total con IVA: " + p.getPrecioFinalIVA() +
            "Estado: " + p.getEstado() +
                "}";
    }


}
