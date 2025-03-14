package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.Alojamiento;
import com.backend.dane.prueba.darwin.quintana.entities.Aranceles;
import com.backend.dane.prueba.darwin.quintana.services.AlojamientoService;
import com.backend.dane.prueba.darwin.quintana.services.ArancelesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alojamiento")
public class AlojamientoController {

    final private AlojamientoService service;

    public AlojamientoController(AlojamientoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Alojamiento>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alojamiento> detail(@PathVariable Long id) {
        Optional<Alojamiento> optionalAlojamiento = service.findById(id);
        if (optionalAlojamiento.isPresent()) {
            return ResponseEntity.ok(optionalAlojamiento.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Alojamiento> create(@RequestBody Alojamiento alojamiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(alojamiento) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alojamiento> update(@RequestBody Alojamiento alojamiento, @PathVariable Long id) {
        Optional<Alojamiento> optionalAlojamiento = service.findById(id);
        if (optionalAlojamiento.isPresent()) {
            Alojamiento alojamientoDb = optionalAlojamiento.orElseThrow();

            alojamientoDb.setDescripcion(alojamiento.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alojamientoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alojamiento> delete(@PathVariable Long id) {
        Optional<Alojamiento> optionalAlojamiento = service.deleteById(id);
        if (optionalAlojamiento.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalAlojamiento.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
