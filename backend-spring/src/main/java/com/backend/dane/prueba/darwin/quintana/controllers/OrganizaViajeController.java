package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.OrganizaViaje;
import com.backend.dane.prueba.darwin.quintana.services.OrganizaViajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organiza_viaje")
public class OrganizaViajeController {

    final private OrganizaViajeService service;

    public OrganizaViajeController(OrganizaViajeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrganizaViaje>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizaViaje> detail(@PathVariable Long id) {
        Optional<OrganizaViaje> optionalOrganizaViaje = service.findById(id);
        if (optionalOrganizaViaje.isPresent()) {
            return ResponseEntity.ok(optionalOrganizaViaje.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrganizaViaje> create(@RequestBody OrganizaViaje organizaViaje) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(organizaViaje) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizaViaje> update(@RequestBody OrganizaViaje organizaViaje, @PathVariable Long id) {
        Optional<OrganizaViaje> optionalOrganizaViaje = service.findById(id);
        if (optionalOrganizaViaje.isPresent()) {
            OrganizaViaje organizaViajeDb = optionalOrganizaViaje.orElseThrow();

            organizaViajeDb.setDescripcion(organizaViaje.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(organizaViajeDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrganizaViaje> delete(@PathVariable Long id) {
        Optional<OrganizaViaje> optionalOrganizaViaje = service.deleteById(id);
        if (optionalOrganizaViaje.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalOrganizaViaje.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
