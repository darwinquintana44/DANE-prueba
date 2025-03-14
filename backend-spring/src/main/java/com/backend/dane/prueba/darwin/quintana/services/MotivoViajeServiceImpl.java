package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.MotivoViaje;
import com.backend.dane.prueba.darwin.quintana.repositories.MotivoViajeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MotivoViajeServiceImpl implements MotivoViajeService {

    final private MotivoViajeRepository repository;

    public MotivoViajeServiceImpl(MotivoViajeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MotivoViaje> findAll() {
        return (List<MotivoViaje>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MotivoViaje> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public MotivoViaje save(MotivoViaje motivoViaje) {
        return repository.save(motivoViaje);
    }

    @Override
    @Transactional
    public Optional<MotivoViaje> deleteById(Long id) {
        Optional<MotivoViaje> optionalMotivoViaje = repository.findById(id);

        if (optionalMotivoViaje.isPresent()) {
            repository.deleteById(id);
            return optionalMotivoViaje;
        }

        return Optional.empty();
    }
}
