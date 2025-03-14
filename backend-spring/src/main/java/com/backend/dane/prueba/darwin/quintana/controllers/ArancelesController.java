package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.Aranceles;
import com.backend.dane.prueba.darwin.quintana.services.ArancelesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aranceles")
public class ArancelesController {

    final private ArancelesService service;

    public ArancelesController(ArancelesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Aranceles>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aranceles> detail(@PathVariable Long id) {
        Optional<Aranceles> optionalAranceles = service.findById(id);
        if (optionalAranceles.isPresent()) {
            return ResponseEntity.ok(optionalAranceles.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Aranceles> create(@RequestBody Aranceles aranceles) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(aranceles) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aranceles> update(@RequestBody Aranceles aranceles, @PathVariable Long id) {
        Optional<Aranceles> optionalAranceles = service.findById(id);
        if (optionalAranceles.isPresent()) {
            Aranceles acompananteDb = optionalAranceles.orElseThrow();

            acompananteDb.setDescripcion(aranceles.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(acompananteDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aranceles> delete(@PathVariable Long id) {
        Optional<Aranceles> optionalAranceles = service.deleteById(id);
        if (optionalAranceles.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalAranceles.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
