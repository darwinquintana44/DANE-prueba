package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Aranceles;
import com.backend.dane.prueba.darwin.quintana.repositories.ArancelesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArancelesServiceImpl implements ArancelesService {

    final private ArancelesRepository repository;

    public ArancelesServiceImpl(ArancelesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Aranceles> findAll() {
        return (List<Aranceles>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aranceles> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Aranceles save(Aranceles aranceles) {
        return repository.save(aranceles);
    }

    @Override
    @Transactional
    public Optional<Aranceles> deleteById(Long id) {
        Optional<Aranceles> optionalAranceles = repository.findById(id);

        if (optionalAranceles.isPresent()) {
            repository.deleteById(id);
            return optionalAranceles;
        }

        return Optional.empty();
    }
}
