package com.carrera.domain;

import javax.persistence.*;

@Entity
public class Medalla {
    /**
     * Las medallas tendrán los siguientes atributos: Id, Enumeración (Oro, Plata, Bronce), Especialidad, Competición.
     */

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private TipoMedalla tipoMedalla;
    private String especialidad;
    private String competicion;

    // Constructors
    public Medalla() {
    }

    public Medalla(TipoMedalla tipoMedalla, String especialidad, String competicion) {
        this.tipoMedalla = tipoMedalla;
        this.especialidad = especialidad;
        this.competicion = competicion;
    }

    // Getters & Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }
    public void setTipoMedalla(TipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }
    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    // Methods
    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", tipoMedalla=" + tipoMedalla +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medalla medalla = (Medalla) o;

        if (id != medalla.id) return false;
        if (tipoMedalla != medalla.tipoMedalla) return false;
        if (especialidad != null ? !especialidad.equals(medalla.especialidad) : medalla.especialidad != null)
            return false;
        return competicion != null ? competicion.equals(medalla.competicion) : medalla.competicion == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tipoMedalla != null ? tipoMedalla.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        result = 31 * result + (competicion != null ? competicion.hashCode() : 0);
        return result;
    }
}