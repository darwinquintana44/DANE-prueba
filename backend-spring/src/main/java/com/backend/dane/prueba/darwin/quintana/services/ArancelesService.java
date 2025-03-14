package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Aranceles;

import java.util.List;
import java.util.Optional;

public interface ArancelesService {
    List<Aranceles> findAll();
    Optional<Aranceles> findById(Long id);
    Aranceles save(Aranceles aranceles);
    Optional<Aranceles> deleteById(Long id);
}
