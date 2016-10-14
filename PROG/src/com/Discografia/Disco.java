package com.Discografia;

/**
 * Created by DAM on 20/9/16.
 */
public class Disco {
    // Atributos
    private String titulo;
    private String grupo;
    private int ntemas;
    private Double duracion;

    // Constructor
    public Disco(String titulo, String grupo, int ntemas, Double duracion) {
        this.titulo = titulo;
        this.grupo = grupo;
        this.ntemas = ntemas;
        this.duracion = duracion;
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getNtemas() {
        return ntemas;
    }

    public void setNtemas(int ntemas) {
        this.ntemas = ntemas;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
