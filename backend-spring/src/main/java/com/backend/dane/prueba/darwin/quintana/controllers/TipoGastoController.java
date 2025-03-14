package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.TipoGasto;
import com.backend.dane.prueba.darwin.quintana.services.TipoGastoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tipo_gasto")
public class TipoGastoController {

    final private TipoGastoService service;

    public TipoGastoController(TipoGastoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoGasto>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoGasto> detail(@PathVariable Long id) {
        Optional<TipoGasto> optionalTipoGasto = service.findById(id);
        if (optionalTipoGasto.isPresent()) {
            return ResponseEntity.ok(optionalTipoGasto.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoGasto> create(@RequestBody TipoGasto tipoGasto) {
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(tipoGasto) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoGasto> update(@RequestBody TipoGasto tipoGasto, @PathVariable Long id) {
        Optional<TipoGasto> optionalTipoGasto = service.findById(id);
        if (optionalTipoGasto.isPresent()) {
            TipoGasto tipoGastoDb = optionalTipoGasto.orElseThrow();

            tipoGastoDb.setDescripcion(tipoGasto.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tipoGastoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoGasto> delete(@PathVariable Long id) {
        Optional<TipoGasto> optionalTipoGasto = service.deleteById(id);
        if (optionalTipoGasto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalTipoGasto.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }
}
