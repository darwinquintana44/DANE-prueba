package com.backend.dane.prueba.darwin.quintana.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "aranceles_encuesta")
public class ArancelesEncuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aranceles", nullable = false)
    private Aranceles aranceles;

    @ManyToOne
    @JoinColumn(name = "id_encuesta", nullable = false)
    @JsonBackReference(value = "encuesta-arancel")
    private Encuesta encuesta;

    @Column(name = "hubo_gastos", nullable = false)
    private String huboGastos;

    @Column(name = "valor", nullable = false, precision = 10, scale = 0)
    private BigDecimal valor;

    @Column(name = "tipo_moneda", nullable = false)
    private String tipo_moneda;

    @Column(name = "nro_personas", nullable = false)
    private Integer nro_personas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aranceles getAranceles() {
        return aranceles;
    }

    public void setAranceles(Aranceles aranceles) {
        this.aranceles = aranceles;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public String getHuboGastos() {
        return huboGastos;
    }

    public void setHuboGastos(String huboGastos) {
        this.huboGastos = huboGastos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(String tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public Integer getNro_personas() {
        return nro_personas;
    }

    public void setNro_personas(Integer nro_personas) {
        this.nro_personas = nro_personas;
    }
}
