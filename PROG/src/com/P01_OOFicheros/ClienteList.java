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
    public void altaCliente(Cliente c) {
        boolean registrado = false;
        if (listaCliente != null) {
            for (Cliente telf : listaCliente) {
                if (telf.getTelefono().equals(c.getTelefono())) {
                    registrado = true;
                }
            }
        } else {
            registrado = false;
            listaCliente = new ArrayList<>();
        }

        if (registrado)     System.out.println("El teléfono ya está registrado");
        else    listaCliente.add(c);
    }

    public void altaPresupuesto(Presupuesto p, String telf) {
        for(Cliente c : listaCliente) {
            if (c.getTelefono().equals(telf)) {
                c.getPresupuestos().alta(p);
            }
        }
    }

    public String listadoCliente(Cliente c) {
        return "Cliente{" +
                ", nombre='" + c.getNombre() + '\'' +
                ", apellidos='" + c.getApellidos() + '\'' +
                ", telefono='" + c.getTelefono() + '\'' +
                ", presupuestos=" + c.getPresupuestos().getPresupuestolist().size() +
                '}';
    }

    public void obtenerPresupuesto(int codigo, String estado) {
        boolean encontrado = false;
        for(Cliente c : listaCliente) {
            for (Presupuesto p : c.getPresupuestos().getPresupuestolist()) {
                if (p.getnPresupuesto() == codigo) {
                    encontrado = true;
                    p.setEstado(estado);
                }
            }
        }
        if (encontrado)
            System.out.println("Se ha modificado correctamente.");
        else
            System.out.println("No se ha encontrado el presupuesto deseado");
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
