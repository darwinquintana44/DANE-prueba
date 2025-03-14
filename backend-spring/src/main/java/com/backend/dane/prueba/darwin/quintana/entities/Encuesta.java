package com.backend.dane.prueba.darwin.quintana.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "encuestas")
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_pais_reside_permanen", nullable = false)
    private Paises id_pais_reside_permanen;

    @ManyToOne
    @JoinColumn(name = "id_motivo_viaje", nullable = false, unique = true)
    private MotivoViaje id_motivo_viaje;

    @ManyToOne
    @JoinColumn(name = "id_tipo_gasto", nullable = false)
    private TipoGasto id_tipo_gasto;

    @Column(name = "nacionalidad", nullable = false)
    private String nacionalidad;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "otro_acompanante", nullable = true)
    private String otro_acompanante;

    @Column(name = "nro_acompanantes", nullable = true)
    private Integer nro_acompanantes;

    @Column(name = "otro_motivo_viaje", nullable = true)
    private String otro_motivo_viaje;

    @Column(name = "otro_organiza_viaje", nullable = true)
    private String otro_organiza_viaje;

    @Column(name = "otro_paquete_turistico", nullable = true)
    private String otro_paquete_turistico;

    @JsonManagedReference(value = "encuesta-acompanante")
    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AcompananteEncuesta> acompananteEncuestas;

    @JsonManagedReference(value = "encuesta-organiza")
    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrganizaViajeEncuesta> organizaViajeEncuestas;

    @JsonManagedReference(value = "encuesta-paquete")
    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PaqueteTuristicoEncuesta> paqueteTuristicoEncuestas;

    @JsonManagedReference(value = "encuesta-arancel")
    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ArancelesEncuesta> arancelesEncuestas;

    @JsonManagedReference(value = "encuesta-alojamiento")
    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AlojamientoEncuestaPais> alojamientoEncuestaPaises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Paises getId_pais_reside_permanen() {
        return id_pais_reside_permanen;
    }

    public void setId_pais_reside_permanen(Paises id_pais_reside_permanen) {
        this.id_pais_reside_permanen = id_pais_reside_permanen;
    }

    public MotivoViaje getId_motivo_viaje() {
        return id_motivo_viaje;
    }

    public void setId_motivo_viaje(MotivoViaje id_motivo_viaje) {
        this.id_motivo_viaje = id_motivo_viaje;
    }

    public TipoGasto getId_tipo_gasto() {
        return id_tipo_gasto;
    }

    public void setId_tipo_gasto(TipoGasto id_tipo_gasto) {
        this.id_tipo_gasto = id_tipo_gasto;
    }

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

    public List<AcompananteEncuesta> getAcompananteEncuestas() {
        return acompananteEncuestas;
    }

    public void setAcompananteEncuestas(List<AcompananteEncuesta> acompananteEncuestas) {
        this.acompananteEncuestas = acompananteEncuestas;
    }

    public List<OrganizaViajeEncuesta> getOrganizaViajeEncuestas() {
        return organizaViajeEncuestas;
    }

    public void setOrganizaViajeEncuestas(List<OrganizaViajeEncuesta> organizaViajeEncuestas) {
        this.organizaViajeEncuestas = organizaViajeEncuestas;
    }

    public List<PaqueteTuristicoEncuesta> getPaqueteTuristicoEncuestas() {
        return paqueteTuristicoEncuestas;
    }

    public void setPaqueteTuristicoEncuestas(List<PaqueteTuristicoEncuesta> paqueteTuristicoEncuestas) {
        this.paqueteTuristicoEncuestas = paqueteTuristicoEncuestas;
    }

    public List<ArancelesEncuesta> getArancelesEncuestas() {
        return arancelesEncuestas;
    }

    public void setArancelesEncuestas(List<ArancelesEncuesta> arancelesEncuestas) {
        this.arancelesEncuestas = arancelesEncuestas;
    }

    public List<AlojamientoEncuestaPais> getAlojamientoEncuestaPaises() {
        return alojamientoEncuestaPaises;
    }

    public void setAlojamientoEncuestaPaises(List<AlojamientoEncuestaPais> alojamientoEncuestaPaises) {
        this.alojamientoEncuestaPaises = alojamientoEncuestaPaises;
    }
}
