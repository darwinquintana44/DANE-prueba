package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.TipoGasto;
import com.backend.dane.prueba.darwin.quintana.repositories.TipoGastoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TipoGastoServiceImpl implements TipoGastoService {

    final private TipoGastoRepository repository;

    public TipoGastoServiceImpl(TipoGastoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TipoGasto> findAll() {
        return (List<TipoGasto>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoGasto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public TipoGasto save(TipoGasto tipoGasto) {
        return repository.save(tipoGasto);
    }

    @Override
    @Transactional
    public Optional<TipoGasto> deleteById(Long id) {
        Optional<TipoGasto> tipoGastoOptional = repository.findById(id);

        if (tipoGastoOptional.isPresent()) {
            repository.deleteById(id);
            return tipoGastoOptional;
        }

        return Optional.empty();
    }
}
