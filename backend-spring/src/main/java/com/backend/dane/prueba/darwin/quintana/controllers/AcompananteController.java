package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.Acompanante;
import com.backend.dane.prueba.darwin.quintana.services.AcompananteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acompanante")
public class AcompananteController {

    final private AcompananteService service;

    public AcompananteController(AcompananteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Acompanante>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acompanante> detail(@PathVariable Long id) {
        Optional<Acompanante> acompananteOptional = service.findById(id);
        if (acompananteOptional.isPresent()) {
            return ResponseEntity.ok(acompananteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Acompanante> create(@RequestBody Acompanante acompanante) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(acompanante) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acompanante> update(@RequestBody Acompanante acompanante, @PathVariable Long id) {
        Optional<Acompanante> optionalAcompanante = service.findById(id);
        if (optionalAcompanante.isPresent()) {
            Acompanante acompananteDb = optionalAcompanante.orElseThrow();

            acompananteDb.setDescripcion(acompanante.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(acompananteDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Acompanante> delete(@PathVariable Long id) {
        Optional<Acompanante> optionalAcompanante = service.deleteById(id);
        if (optionalAcompanante.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalAcompanante.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
