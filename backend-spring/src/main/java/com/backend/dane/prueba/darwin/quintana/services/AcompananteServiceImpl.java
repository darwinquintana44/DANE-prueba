package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Acompanante;
import com.backend.dane.prueba.darwin.quintana.repositories.AcompananteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AcompananteServiceImpl implements AcompananteService {

    final private AcompananteRepository repository;

    public AcompananteServiceImpl(AcompananteRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Acompanante> findAll() {
        return (List<Acompanante>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Acompanante> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Acompanante save(Acompanante acompanante) {
        return repository.save(acompanante);
    }

    @Override
    @Transactional
    public Optional<Acompanante> deleteById(Long id) {
        Optional<Acompanante> acompananteOptional = repository.findById(id);

        if (acompananteOptional.isPresent()) {
            repository.deleteById(id);
            return acompananteOptional;
        }

        return Optional.empty();
    }
}
