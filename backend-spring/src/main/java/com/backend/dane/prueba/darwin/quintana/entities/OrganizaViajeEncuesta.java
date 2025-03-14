package com.backend.dane.prueba.darwin.quintana.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "organiza_viaje_encuesta")
public class OrganizaViajeEncuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_organiza_viaje", nullable = false)
    private OrganizaViaje organizaViaje;

    @ManyToOne
    @JoinColumn(name = "id_encuesta", nullable = false)
    @JsonBackReference(value = "encuesta-organiza")
    private Encuesta encuesta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrganizaViaje getOrganizaViaje() {
        return organizaViaje;
    }

    public void setOrganizaViaje(OrganizaViaje organizaViaje) {
        this.organizaViaje = organizaViaje;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
}
