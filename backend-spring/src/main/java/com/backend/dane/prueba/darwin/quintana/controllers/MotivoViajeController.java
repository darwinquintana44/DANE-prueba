package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.MotivoViaje;
import com.backend.dane.prueba.darwin.quintana.services.MotivoViajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/motivo_viaje")
public class MotivoViajeController {

    final private MotivoViajeService service;

    public MotivoViajeController(MotivoViajeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MotivoViaje>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotivoViaje> detail(@PathVariable Long id) {
        Optional<MotivoViaje> optionalMotivoViaje = service.findById(id);
        if (optionalMotivoViaje.isPresent()) {
            return ResponseEntity.ok(optionalMotivoViaje.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MotivoViaje> create(@RequestBody MotivoViaje motivoViaje) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(motivoViaje) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotivoViaje> update(@RequestBody MotivoViaje motivoViaje, @PathVariable Long id) {
        Optional<MotivoViaje> optionalMotivoViaje = service.findById(id);
        if (optionalMotivoViaje.isPresent()) {
            MotivoViaje motivoViajeDb = optionalMotivoViaje.orElseThrow();

            motivoViajeDb.setDescripcion(motivoViaje.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(motivoViajeDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MotivoViaje> delete(@PathVariable Long id) {
        Optional<MotivoViaje> optionalMotivoViaje = service.deleteById(id);
        if (optionalMotivoViaje.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalMotivoViaje.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
