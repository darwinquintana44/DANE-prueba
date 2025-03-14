package com.backend.dane.prueba.darwin.quintana.repositories;

import com.backend.dane.prueba.darwin.quintana.entities.Encuesta;
import com.backend.dane.prueba.darwin.quintana.entities.PaqueteTuristicoEncuesta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaqueteTuristicoEncuestaRepository extends CrudRepository<PaqueteTuristicoEncuesta, Long> {
    // eliminamos cualquier asociacion de una encuesta
    void deleteByEncuesta(Encuesta encuesta);

    // busca asociaciones de una encuesta
    List<PaqueteTuristicoEncuesta> findByEncuesta(Encuesta encuesta);
}
