package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Paises;

import java.util.List;
import java.util.Optional;

public interface PaisesService {
    List<Paises> findAll();
    Optional<Paises> findById(Long id);
    Paises save(Paises paises);
    Optional<Paises> deleteById(Long id);
}
