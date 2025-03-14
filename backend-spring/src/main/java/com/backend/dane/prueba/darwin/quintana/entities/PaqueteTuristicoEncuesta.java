package com.backend.dane.prueba.darwin.quintana.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "paquete_turistico_encuesta")
public class PaqueteTuristicoEncuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paquete_turistico", nullable = false)
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "id_encuesta", nullable = false)
    @JsonBackReference(value = "encuesta-paquete")
    private Encuesta encuesta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaqueteTuristico getPaqueteTuristico() {
        return paqueteTuristico;
    }

    public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        this.paqueteTuristico = paqueteTuristico;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
}
