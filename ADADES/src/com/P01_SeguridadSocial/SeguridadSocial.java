package com.P01_SeguridadSocial;
// SORT HASHMAP

/**
 * Created by Guillem on 23/09/2016.
 */
import java.util.*;

public class SeguridadSocial extends Persona {

    private List<Persona> personasList;
    private Map<String, Persona> dniMap;
    private Map<String, Persona> numSSMap;

    public SeguridadSocial() {
        personasList = new ArrayList<>();
        dniMap = new HashMap<>();
        numSSMap = new HashMap<>();
    }

    public void altaPersona(Persona persona) {
        String DNI, numSS;
        if (personasList.size() != 0) {
            boolean pass = true;
            for (int i = 0; i < personasList.size(); i++) {
                DNI = personasList.get(i).getDNI();
                numSS = personasList.get(i).getNumSS();
                if (DNI.equals(persona.getDNI())|| numSS.equals(persona.getNumSS()))
                    pass = false;
            }
            if (pass) {
                personasList.add(persona);
                dniMap.put(persona.getDNI(), persona);
                numSSMap.put(persona.getNumSS(), persona);
            }
        } else {
            personasList.add(persona);
            dniMap.put(persona.getDNI(), persona);
            numSSMap.put(persona.getNumSS(), persona);
        }
    }

    public void bajaPersona(String dni) {
        // ArrayList
        String DNI;
        for (int i = 0; i < personasList.size(); i++) {
            DNI = personasList.get(i).getDNI();
            if (DNI.equals(dni)) {
                personasList.remove(i);
            }
        }

        // HashMap
        dniMap.remove(dni);
        numSSMap.remove(dni);
    }

    public Persona obtenerPersonaPorDNI(String dni, boolean array) {
        if (array) {
            // ArrayList
            String DNI;
            for (int i = 0; i < personasList.size(); i++) {
                DNI = personasList.get(i).getDNI();
                if (DNI.equals(dni)) {
                    return personasList.get(i);
                }
            }
            return personasList.get(0);
        } else {
            // HashMap
            return dniMap.get(dni);
        }
    }

    public Persona obtenerPersonaPorNumSS(String numSS, boolean array) {
        if (array) {
            // ArrayList
            String NUMSS;
            for (int i = 0; i < personasList.size(); i++) {
                NUMSS = personasList.get(i).getNumSS();
                if (NUMSS.equals(numSS)) {
                    return personasList.get(i);
                }
            }
            return personasList.get(0);
        } else {
            // HashMap
            return numSSMap.get(numSS);
        }
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        List<Persona> personasRango = new ArrayList<>();
        double salario;
        for (int i = 0; i < personasList.size(); i++) {
            salario = personasList.get(i).getSalario();
            if (min <= salario && salario <= max) {
                personasRango.add(personasList.get(i));
            }
        }
        return personasRango;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
        List<Persona> personasEdad = new ArrayList<>();

        for (int i = 0; i < personasList.size(); i++) {
            if (edad < personasList.get(i).getEdad()) {
                personasEdad.add(personasList.get(i));
            }
        }
        return personasEdad;
    }

    public List<Persona> obtenerTodas(){
        return personasList;
    }

    public void ordenEdad(){
        List<Persona> listaEdad = new ArrayList<>(dniMap.values());
        listaEdad.sort(Comparator.comparing(Persona::getEdad));
        System.out.println(listaEdad);
    }

    public void ordenApellido() {
        List<Persona> listaEdad = new ArrayList<>(dniMap.values());
        listaEdad.sort(Comparator.comparing(Persona::getApellidos));
        System.out.println(listaEdad);
    }

    public void ordenNumSS() {
        List<Persona> listaEdad = new ArrayList<>(dniMap.values());
        listaEdad.sort(Comparator.comparing(Persona::getNumSS));
        System.out.println(listaEdad);
    }
    @Override
    public String toString() {
        return "P01_SS.SeguridadSocial{" + "personasList=" + personasList + "}";
    }

}