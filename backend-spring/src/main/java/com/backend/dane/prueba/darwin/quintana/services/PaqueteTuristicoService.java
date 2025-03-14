package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.PaqueteTuristico;

import java.util.List;
import java.util.Optional;

public interface PaqueteTuristicoService {
    List<PaqueteTuristico> findAll();
    Optional<PaqueteTuristico> findById(Long id);
    PaqueteTuristico save(PaqueteTuristico paqueteTuristico);
    Optional<PaqueteTuristico> deleteById(Long id);
}
