package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.PaqueteTuristico;
import com.backend.dane.prueba.darwin.quintana.services.PaqueteTuristicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paquete_turistico")
public class PaqueteTuristicoController {

    final private PaqueteTuristicoService service;

    public PaqueteTuristicoController(PaqueteTuristicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PaqueteTuristico>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaqueteTuristico> detail(@PathVariable Long id) {
        Optional<PaqueteTuristico> optionalPaqueteTuristico = service.findById(id);
        if (optionalPaqueteTuristico.isPresent()) {
            return ResponseEntity.ok(optionalPaqueteTuristico.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PaqueteTuristico> create(@RequestBody PaqueteTuristico paqueteTuristico) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(paqueteTuristico) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaqueteTuristico> update(@RequestBody PaqueteTuristico paqueteTuristico, @PathVariable Long id) {
        Optional<PaqueteTuristico> optionalPaqueteTuristico = service.findById(id);
        if (optionalPaqueteTuristico.isPresent()) {
            PaqueteTuristico paqueteTuristicoDb = optionalPaqueteTuristico.orElseThrow();

            paqueteTuristicoDb.setDescripcion(paqueteTuristico.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paqueteTuristicoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaqueteTuristico> delete(@PathVariable Long id) {
        Optional<PaqueteTuristico> optionalPaqueteTuristico = service.deleteById(id);
        if (optionalPaqueteTuristico.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalPaqueteTuristico.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
