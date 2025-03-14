package com.backend.dane.prueba.darwin.quintana.dto;


import java.util.List;

public class EncuestaDTO {

    private String nacionalidad;
    private String sexo;
    private Integer edad;
    private String otro_acompanante;
    private Integer nro_acompanantes;
    private String otro_motivo_viaje;
    private String otro_organiza_viaje;
    private String otro_paquete_turistico;

    private Long usuarioId;
    private Long paisResidePermanenId;
    private Long idMotivoViajeId;
    private Long idTipoGastoId;

    private List<Long> acompananteIds;
    private List<Long> organizaViajeIds;
    private List<Long> paqueteTuristicoIds;
    private List<Long> arancelIds;
    private List<Long> tipoAlojamientoIds;
    private Long paisVisitaIds;

    private List<ArancelEncuestaDTO> arancelesEncuesta;
    private List<AlojamientoEncuestaDTO> alojamientosEncuesta;



    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getOtro_acompanante() {
        return otro_acompanante;
    }

    public void setOtro_acompanante(String otro_acompanante) {
        this.otro_acompanante = otro_acompanante;
    }

    public Integer getNro_acompanantes() {
        return nro_acompanantes;
    }

    public void setNro_acompanantes(Integer nro_acompanantes) {
        this.nro_acompanantes = nro_acompanantes;
    }

    public String getOtro_motivo_viaje() {
        return otro_motivo_viaje;
    }

    public void setOtro_motivo_viaje(String otro_motivo_viaje) {
        this.otro_motivo_viaje = otro_motivo_viaje;
    }

    public String getOtro_organiza_viaje() {
        return otro_organiza_viaje;
    }

    public void setOtro_organiza_viaje(String otro_organiza_viaje) {
        this.otro_organiza_viaje = otro_organiza_viaje;
    }

    public String getOtro_paquete_turistico() {
        return otro_paquete_turistico;
    }

    public void setOtro_paquete_turistico(String otro_paquete_turistico) {
        this.otro_paquete_turistico = otro_paquete_turistico;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getPaisResidePermanenId() {
        return paisResidePermanenId;
    }

    public void setPaisResidePermanenId(Long paisResidePermanenId) {
        this.paisResidePermanenId = paisResidePermanenId;
    }

    public Long getIdMotivoViajeId() {
        return idMotivoViajeId;
    }

    public void setIdMotivoViajeId(Long idMotivoViajeId) {
        this.idMotivoViajeId = idMotivoViajeId;
    }

    public Long getIdTipoGastoId() {
        return idTipoGastoId;
    }

    public void setIdTipoGastoId(Long idTipoGastoId) {
        this.idTipoGastoId = idTipoGastoId;
    }

    public List<Long> getAcompananteIds() {
        return acompananteIds;
    }

    public void setAcompananteIds(List<Long> acompananteIds) {
        this.acompananteIds = acompananteIds;
    }

    public List<Long> getOrganizaViajeIds() {
        return organizaViajeIds;
    }

    public void setOrganizaViajeIds(List<Long> organizaViajeIds) {
        this.organizaViajeIds = organizaViajeIds;
    }

    public List<Long> getPaqueteTuristicoIds() {
        return paqueteTuristicoIds;
    }

    public void setPaqueteTuristicoIds(List<Long> paqueteTuristicoIds) {
        this.paqueteTuristicoIds = paqueteTuristicoIds;
    }

    public List<Long> getArancelIds() {
        return arancelIds;
    }

    public void setArancelIds(List<Long> arancelIds) {
        this.arancelIds = arancelIds;
    }

    public List<Long> getTipoAlojamientoIds() {
        return tipoAlojamientoIds;
    }

    public void setTipoAlojamientoIds(List<Long> tipoAlojamientoIds) {
        this.tipoAlojamientoIds = tipoAlojamientoIds;
    }

    public Long getPaisVisitaIds() {
        return paisVisitaIds;
    }

    public void setPaisVisitaIds(Long paisVisitaIds) {
        this.paisVisitaIds = paisVisitaIds;
    }

    public List<ArancelEncuestaDTO> getArancelesEncuesta() {
        return arancelesEncuesta;
    }

    public void setArancelesEncuesta(List<ArancelEncuestaDTO> arancelesEncuesta) {
        this.arancelesEncuesta = arancelesEncuesta;
    }

    public List<AlojamientoEncuestaDTO> getAlojamientosEncuesta() {
        return alojamientosEncuesta;
    }

    public void setAlojamientosEncuesta(List<AlojamientoEncuestaDTO> alojamientosEncuesta) {
        this.alojamientosEncuesta = alojamientosEncuesta;
    }
}
