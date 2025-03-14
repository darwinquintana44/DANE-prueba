package com.backend.dane.prueba.darwin.quintana.controllers;

import com.backend.dane.prueba.darwin.quintana.entities.Usuario;
import com.backend.dane.prueba.darwin.quintana.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    final private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> list() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> detail(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.findById(id);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioDb = optionalUsuario.orElseThrow();

            usuarioDb.setNombres( usuario.getNombres() );
            usuarioDb.setApellidos( usuario.getApellidos() );
            usuarioDb.setUsuario( usuario.getUsuario() );
            usuarioDb.setPassword( usuario.getPassword() );

            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioDb));

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.deleteById(id);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body( optionalUsuario.orElseThrow() );
        }
        return ResponseEntity.notFound().build();
    }


}
