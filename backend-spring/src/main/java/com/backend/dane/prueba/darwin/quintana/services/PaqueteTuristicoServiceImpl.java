package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.PaqueteTuristico;
import com.backend.dane.prueba.darwin.quintana.repositories.PaqueteTuristicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteTuristicoServiceImpl implements PaqueteTuristicoService {

    final private PaqueteTuristicoRepository repository;

    public PaqueteTuristicoServiceImpl(PaqueteTuristicoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PaqueteTuristico> findAll() {
        return (List<PaqueteTuristico>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaqueteTuristico> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public PaqueteTuristico save(PaqueteTuristico paqueteTuristico) {
        return repository.save(paqueteTuristico);
    }

    @Override
    @Transactional
    public Optional<PaqueteTuristico> deleteById(Long id) {
        Optional<PaqueteTuristico> optionalPaqueteTuristico = repository.findById(id);

        if (optionalPaqueteTuristico.isPresent()) {
            repository.deleteById(id);
            return optionalPaqueteTuristico;
        }

        return Optional.empty();
    }
}
