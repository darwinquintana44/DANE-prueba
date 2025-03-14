package com.backend.dane.prueba.darwin.quintana.repositories;

import com.backend.dane.prueba.darwin.quintana.entities.AlojamientoEncuestaPais;
import com.backend.dane.prueba.darwin.quintana.entities.Encuesta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlojamientoEncuestaPaisRepository extends CrudRepository<AlojamientoEncuestaPais, Long> {
    // eliminamos cualquier asociacion de una encuesta
    void deleteByEncuesta(Encuesta encuesta);

    // busca asociaciones de una encuesta
    List<AlojamientoEncuestaPais> findByEncuesta(Encuesta encuesta);
}
