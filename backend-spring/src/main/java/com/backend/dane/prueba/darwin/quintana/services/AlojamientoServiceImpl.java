package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.Alojamiento;
import com.backend.dane.prueba.darwin.quintana.repositories.AlojamientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoServiceImpl implements AlojamientoService {

    final private AlojamientoRepository repository;

    public AlojamientoServiceImpl(AlojamientoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Alojamiento> findAll() {
        return (List<Alojamiento>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alojamiento> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Alojamiento save(Alojamiento alojamiento) {
        return repository.save(alojamiento);
    }

    @Override
    @Transactional
    public Optional<Alojamiento> deleteById(Long id) {
        Optional<Alojamiento> optionalAlojamiento = repository.findById(id);

        if (optionalAlojamiento.isPresent()) {
            repository.deleteById(id);
            return optionalAlojamiento;
        }

        return Optional.empty();
    }
}
