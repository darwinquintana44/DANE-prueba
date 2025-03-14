package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.Paises;
import com.backend.dane.prueba.darwin.quintana.services.PaisesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/paises")
public class PaisesController {

    final private PaisesService service;

    public PaisesController(PaisesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Paises>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paises> detail(@PathVariable Long id) {
        Optional<Paises> optionalPaises = service.findById(id);
        if (optionalPaises.isPresent()) {
            return ResponseEntity.ok(optionalPaises.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Paises> create(@RequestBody Paises paises) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(paises) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paises> update(@RequestBody Paises paises, @PathVariable Long id) {
        Optional<Paises> optionalPaises = service.findById(id);
        if (optionalPaises.isPresent()) {
            Paises paisesDb = optionalPaises.orElseThrow();

            paisesDb.setDescripcion(paises.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paisesDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paises> delete(@PathVariable Long id) {
        Optional<Paises> optionalPaises = service.deleteById(id);
        if (optionalPaises.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalPaises.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
