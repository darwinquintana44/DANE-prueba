package com.backend.dane.prueba.darwin.quintana.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "alojamiento_encuesta_pais")
public class AlojamientoEncuestaPais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento", nullable = false)
    private Alojamiento alojamiento;

    @ManyToOne
    @JoinColumn(name = "id_encuesta", nullable = false)
    @JsonBackReference(value = "encuesta-alojamiento")
    private Encuesta encuesta;

    @ManyToOne
    @JoinColumn(name = "id_pais_visita", nullable = false)
    private Paises paises;

    @Column(name = "nro_noches", nullable = false)
    private Integer nro_noches;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
    }

    public Integer getNro_noches() {
        return nro_noches;
    }

    public void setNro_noches(Integer nro_noches) {
        this.nro_noches = nro_noches;
    }
}
