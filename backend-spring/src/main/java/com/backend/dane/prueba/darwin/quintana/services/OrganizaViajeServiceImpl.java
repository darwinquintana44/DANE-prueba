package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.OrganizaViaje;
import com.backend.dane.prueba.darwin.quintana.repositories.OrganizaViajeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizaViajeServiceImpl implements OrganizaViajeService {

    final private OrganizaViajeRepository repository;

    public OrganizaViajeServiceImpl(OrganizaViajeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrganizaViaje> findAll() {
        return (List<OrganizaViaje>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrganizaViaje> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public OrganizaViaje save(OrganizaViaje organizaViaje) {
        return repository.save(organizaViaje);
    }

    @Override
    @Transactional
    public Optional<OrganizaViaje> deleteById(Long id) {
        Optional<OrganizaViaje> optionalOrganizaViaje = repository.findById(id);

        if (optionalOrganizaViaje.isPresent()) {
            repository.deleteById(id);
            return optionalOrganizaViaje;
        }

        return Optional.empty();
    }
}
