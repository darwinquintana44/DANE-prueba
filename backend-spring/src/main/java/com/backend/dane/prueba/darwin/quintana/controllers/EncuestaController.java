package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.Encuesta;
import com.backend.dane.prueba.darwin.quintana.services.EncuestaService;
import com.backend.dane.prueba.darwin.quintana.dto.EncuestaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encuesta")
public class EncuestaController {

    final private EncuestaService service;

    @Autowired
    public EncuestaController(EncuestaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Encuesta>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encuesta> detail(@PathVariable Long id) {
        Optional<Encuesta> encuestaOptional = service.findById(id);
        if (encuestaOptional.isPresent()) {
            return ResponseEntity.ok(encuestaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Encuesta> create(@RequestBody EncuestaDTO encuestaDTO) {

        Encuesta encuesta = new Encuesta();

        encuesta.setNacionalidad(encuestaDTO.getNacionalidad());
        encuesta.setSexo(encuestaDTO.getSexo());
        encuesta.setEdad(encuestaDTO.getEdad());

        encuesta.setNro_acompanantes(encuestaDTO.getNro_acompanantes());
        encuesta.setOtro_acompanante(encuestaDTO.getOtro_acompanante());
        encuesta.setOtro_motivo_viaje(encuestaDTO.getOtro_motivo_viaje());
        encuesta.setOtro_organiza_viaje(encuestaDTO.getOtro_organiza_viaje());
        encuesta.setOtro_paquete_turistico(encuestaDTO.getOtro_paquete_turistico());

        Encuesta encuestaGuardada = service.save(
                null,
                encuesta,
                encuestaDTO.getAcompananteIds(),
                encuestaDTO.getOrganizaViajeIds(),
                encuestaDTO.getPaqueteTuristicoIds(),
                encuestaDTO.getArancelesEncuesta(),
                encuestaDTO.getAlojamientosEncuesta(),
                encuestaDTO.getUsuarioId(),
                encuestaDTO.getPaisResidePermanenId(),
                encuestaDTO.getIdMotivoViajeId(),
                encuestaDTO.getIdTipoGastoId(),
                encuestaDTO.getPaisVisitaIds()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(encuestaGuardada);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Encuesta> update(@RequestBody EncuestaDTO encuestaDTO, @PathVariable Long id) {

        Encuesta encuesta = new Encuesta();

        encuesta.setNacionalidad(encuestaDTO.getNacionalidad());
        encuesta.setSexo(encuestaDTO.getSexo());
        encuesta.setEdad(encuestaDTO.getEdad());

        encuesta.setNro_acompanantes(encuestaDTO.getNro_acompanantes());
        encuesta.setOtro_acompanante(encuestaDTO.getOtro_acompanante());
        encuesta.setOtro_motivo_viaje(encuestaDTO.getOtro_motivo_viaje());
        encuesta.setOtro_organiza_viaje(encuestaDTO.getOtro_organiza_viaje());
        encuesta.setOtro_paquete_turistico(encuestaDTO.getOtro_paquete_turistico());

        Encuesta encuestaGuardada = service.save(
                id,
                encuesta,
                encuestaDTO.getAcompananteIds(),
                encuestaDTO.getOrganizaViajeIds(),
                encuestaDTO.getPaqueteTuristicoIds(),
                encuestaDTO.getArancelesEncuesta(),
                encuestaDTO.getAlojamientosEncuesta(),
                encuestaDTO.getUsuarioId(),
                encuestaDTO.getPaisResidePermanenId(),
                encuestaDTO.getIdMotivoViajeId(),
                encuestaDTO.getIdTipoGastoId(),
                encuestaDTO.getPaisVisitaIds()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(encuestaGuardada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Encuesta> delete(@PathVariable Long id) {
        Optional<Encuesta> optionalEncuesta = service.deleteById(id);
        if (optionalEncuesta.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalEncuesta.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
