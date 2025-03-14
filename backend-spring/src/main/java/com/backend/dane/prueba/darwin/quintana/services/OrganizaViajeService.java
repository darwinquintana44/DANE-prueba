package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.OrganizaViaje;

import java.util.List;
import java.util.Optional;

public interface OrganizaViajeService {
    List<OrganizaViaje> findAll();
    Optional<OrganizaViaje> findById(Long id);
    OrganizaViaje save(OrganizaViaje organizaViaje);
    Optional<OrganizaViaje> deleteById(Long id);
}
