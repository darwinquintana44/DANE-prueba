package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.entities.TipoGasto;

import java.util.*;

public interface TipoGastoService {
    List<TipoGasto> findAll();
    Optional<TipoGasto> findById(Long id);
    TipoGasto save(TipoGasto tipoGasto);
    Optional<TipoGasto> deleteById(Long id);
}
