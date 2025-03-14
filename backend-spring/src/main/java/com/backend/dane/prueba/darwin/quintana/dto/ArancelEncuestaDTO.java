package com.backend.dane.prueba.darwin.quintana.dto;

import java.math.BigDecimal;

public class ArancelEncuestaDTO {
    private Long arancelId;
    private String huboGastos;
    private BigDecimal valor;
    private String tipo_moneda;
    private Integer nro_personas;

    public Long getArancelId() {
        return arancelId;
    }
    public void setArancelId(Long arancelId) {
        this.arancelId = arancelId;
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
