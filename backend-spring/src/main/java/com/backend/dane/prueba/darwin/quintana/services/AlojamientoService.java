package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Alojamiento;

import java.util.List;
import java.util.Optional;

public interface AlojamientoService {
    List<Alojamiento> findAll();
    Optional<Alojamiento> findById(Long id);
    Alojamiento save(Alojamiento alojamiento);
    Optional<Alojamiento> deleteById(Long id);
}
