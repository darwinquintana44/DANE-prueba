package com.backend.dane.prueba.darwin.quintana.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "organiza_viaje")
public class OrganizaViaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
