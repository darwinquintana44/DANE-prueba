package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.MotivoViaje;

import java.util.List;
import java.util.Optional;

public interface MotivoViajeService {
    List<MotivoViaje> findAll();
    Optional<MotivoViaje> findById(Long id);
    MotivoViaje save(MotivoViaje motivoViaje);
    Optional<MotivoViaje> deleteById(Long id);
}
