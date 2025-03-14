package com.backend.dane.prueba.darwin.quintana.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "acompanante_encuesta")
public class AcompananteEncuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_acompanante", nullable = false)
    private Acompanante acompanante;

    @ManyToOne
    @JoinColumn(name = "id_encuesta", nullable = false)
    @JsonBackReference(value = "encuesta-acompanante")
    private Encuesta encuesta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Acompanante getAcompanante() {
        return acompanante;
    }

    public void setAcompanante(Acompanante acompanante) {
        this.acompanante = acompanante;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
}
