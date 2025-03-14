package com.backend.dane.prueba.darwin.quintana.repositories;

import com.backend.dane.prueba.darwin.quintana.entities.ArancelesEncuesta;
import com.backend.dane.prueba.darwin.quintana.entities.Encuesta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArancelesEncuestaRepository extends CrudRepository<ArancelesEncuesta, Long> {
    // eliminamos cualquier asociacion de una encuesta
    void deleteByEncuesta(Encuesta encuesta);

    // busca asociaciones de una encuesta
    List<ArancelesEncuesta> findByEncuesta(Encuesta encuesta);
}
