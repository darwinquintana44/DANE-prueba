package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Paises;
import com.backend.dane.prueba.darwin.quintana.repositories.PaisesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaisesServiceImpl implements PaisesService {

    final private PaisesRepository repository;

    public PaisesServiceImpl(PaisesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Paises> findAll() {
        return (List<Paises>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Paises> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Paises save(Paises paises) {
        return repository.save(paises);
    }

    @Override
    @Transactional
    public Optional<Paises> deleteById(Long id) {
        Optional<Paises> paisesOptional = repository.findById(id);

        if (paisesOptional.isPresent()) {
            repository.deleteById(id);
            return paisesOptional;
        }

        return Optional.empty();
    }
}
