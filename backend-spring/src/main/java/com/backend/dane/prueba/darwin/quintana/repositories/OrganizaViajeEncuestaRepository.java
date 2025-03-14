package com.backend.dane.prueba.darwin.quintana.repositories;

import com.backend.dane.prueba.darwin.quintana.entities.Encuesta;
import com.backend.dane.prueba.darwin.quintana.entities.OrganizaViajeEncuesta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizaViajeEncuestaRepository extends CrudRepository<OrganizaViajeEncuesta, Long> {
    // eliminamos cualquier asociacion de una encuesta
    void deleteByEncuesta(Encuesta encuesta);

    // busca asociaciones de una encuesta
    List<OrganizaViajeEncuesta> findByEncuesta(Encuesta encuesta);
}
