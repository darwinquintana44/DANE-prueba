package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Acompanante;

import java.util.*;

public interface AcompananteService {
    List<Acompanante> findAll();
    Optional<Acompanante> findById(Long id);
    Acompanante save(Acompanante acompanante);
    Optional<Acompanante> deleteById(Long id);
}
