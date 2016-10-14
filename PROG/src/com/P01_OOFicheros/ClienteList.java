package com.P01_OOFicheros;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAM on 14/10/16.
 */
public class ClienteList extends Main {
    private ArrayList<Cliente> listaCliente;

    public ClienteList() {
        listaCliente = new ArrayList<>();
    }

    // 1.- Alta cliente: debe solicitar los datos del cliente asegurándose de la validez de los datos. No puede haber dos clientes con el mismo número de teléfono.
    public void altaCliente(Cliente c) {
        boolean registrado = false;
        for(Cliente telf : listaCliente) {
            if(telf.getTelefono().equals(c.getTelefono())) {
                registrado = true;
            }
        }

        if (registrado)     System.out.println("El teléfono ya está registrado");
        else    listaCliente.add(c);
    }

     /*
    2. – Nuevo presupuesto. Debe solicitar el teléfono del cliente para el que será el presupuesto.
    Si el cliente no existe, deberá primero pedir los datos para dar de alta el cliente y luego los datos para el presupuesto.
    Si el cliente existe , pedirá los datos del presupuesto y registrará a qué cliente pertenece.
    La relación deberás hacerla como consideres más óptima en función de las funcionalidades que solicita la aplicación.
    Se deben pedir los datos del presupuesto necesarios (los campos que se pueden calcular no es necesario pedirlos al usuario). Se
    deberá asegurar la validez de los datos.
     */
    public void comprobarClienteTelf(String telf) {
        boolean registrado = false;
        for(Cliente carnet : listaCliente) {
            if(carnet.getTelefono().equals(telf)) {
                registrado = true;
            }
        }

        if (registrado) {
            nuevoPresupuesto();
        } else {
            nuevoCliente();
            nuevoPresupuesto();
        }
    }

    public void altaPresupuesto(Presupuesto p) {
        List<Presupuesto> presupuestosCliente = new ArrayList<>();

        for(Cliente c : listaCliente) {
            if (c.getCodigoCliente() == p.getCodigoCliente()) {
                presupuestosCliente = c.getPresupuestos();
                presupuestosCliente.add(p);
                c.setPresupuestos(presupuestosCliente);
            }
        }
    }

    /*
    3.- Presupuestos pendientes. Deberá mostrar los datos de todos los presupuestos que aún no han sido aceptados ni rechazados,
    junto con el nombre y apellidos del cliente al que pertenecen
     */
    public void obtenerPendientes() {
        for(Cliente c : listaCliente) {
            for (Presupuesto p : c.getPresupuestos()) {
                if (p.getEstado().equals("Pendiente")) {
                    mostrarClientePresupuesto(c, p);
                }
            }
        }
    }

    // 4.- Listado de presupuestos de un cliente determinado. Solicitará el teléfono del cliente y mostrará todos los datos de los presupuestos que se hayan emitido para dicho cliente.
    public void mostrarPresupuestosCliente(String telf) {
        for(Cliente c : listaCliente) {
            if(c.getTelefono().equals(telf)) {
                for (Presupuesto p : c.getPresupuestos()) {
                    mostrarClientePresupuesto(c, p);
                }
            }
        }
    }


    // 5.- Listado de presupuestos rechazados. Deberá mostrar los datos de todos los presupuestos han sido rechazados, junto con el nombre y apellidos del cliente al que pertenecen

    public void obtenerRechazados() {
        for(Cliente c : listaCliente) {
            for (Presupuesto p : c.getPresupuestos()) {
                if (p.getEstado().equals("Pendiente")) {
                    mostrarClientePresupuesto(c, p);
                }
            }
        }
    }

    private void mostrarClientePresupuesto(Cliente c, Presupuesto p) {
        System.out.println("-----------------------------");
        System.out.println("Nombre: " + c.getNombre());
        System.out.println("Apellidos: " + c.getApellidos());
        System.out.println("Número presupuesto: " + p.getNpresupuesto());
        System.out.println("Concepto: " + p.getConcepto());
        System.out.println("Precio total: " + p.getPrecioTotal());
        System.out.println("Precio total con descuento: " + p.getPrecioFinalDesc());
        System.out.println("Precio total con IVA: " + p.getPrecioFinalIVA());
        System.out.println("Estado: " + p.getEstado());
    }

    // 6.- Listado de clientes. Debe mostrar todos los datos del cliente así como el nº total de presupuestos que se han emitido para dicho cliente.
    public  void listadoCliente() {
        for (Cliente c : listaCliente) {
            System.out.println("-----------------------------");
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellidos: " + c.getApellidos());
            System.out.println("Telefono: " + c.getTelefono());
            System.out.println("Presupuestos: " + c.getPresupuestos().size());
        }

    }

    public Cliente obtenerGamePorNombre(String nombre) {
        // REcorremos la lista
        for (Cliente g : listaCliente) {
            // Si el nombre del juego actual es igual al nombre q me pasan
            if (g.getNombre().equalsIgnoreCase(nombre)) {
                // devolvemos el juego encontrado
                return g;
            }
        }
        // Si llega a este punto es que no ha encontrado
        // ningún juego con el nombre pasado
        return null;
    }

    public ArrayList<Cliente> getLista() {
        return listaCliente;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.listaCliente = lista;
    }





    /*

 (1 punto).

 (1 punto).
(1,5 puntos).
7.- Cambiar estado de un presupuesto. El programa deberá pedir el nº de
presupuesto y permitir cambiar el estado (aceptado / rechazado / pendiente). Si
el presupuesto no existe deberá indicarlo y volv er al menú principal sin modificar
ningún dato. (1 punto)
8.- Salir: El programa deberá finalizar. Los datos quedarán guardados.
     */
}
