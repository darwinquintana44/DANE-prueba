package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.dto.AlojamientoEncuestaDTO;
import com.backend.dane.prueba.darwin.quintana.dto.ArancelEncuestaDTO;
import com.backend.dane.prueba.darwin.quintana.entities.Encuesta;

import java.util.List;
import java.util.Optional;

public interface EncuestaService {
    List<Encuesta> findAll();
    Optional<Encuesta> findById(Long id);
    Encuesta save(
        Long id,
        Encuesta encuesta,
        List<Long> acompananteIds,
        List<Long> organizaViajeIds,
        List<Long> paqueteTuristicoIds,
        List<ArancelEncuestaDTO> arancelesEncuesta,
        List<AlojamientoEncuestaDTO> alojamientosEncuesta,
        Long usuarioId,
        Long paisResidePermanenId,
        Long idMotivoViajeId,
        Long idTipoGastoId,
        Long paisVisitaIds
    );
    Optional<Encuesta> deleteById(Long id);
}
