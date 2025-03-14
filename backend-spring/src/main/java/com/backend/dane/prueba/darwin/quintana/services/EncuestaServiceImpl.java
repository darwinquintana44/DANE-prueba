package com.backend.dane.prueba.darwin.quintana.services;

import com.backend.dane.prueba.darwin.quintana.dto.AlojamientoEncuestaDTO;
import com.backend.dane.prueba.darwin.quintana.dto.ArancelEncuestaDTO;
import com.backend.dane.prueba.darwin.quintana.entities.*;
import com.backend.dane.prueba.darwin.quintana.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EncuestaServiceImpl implements EncuestaService {

    final private EncuestaRepository encuestaRepository;
    final private PaisesRepository paisRepository;
    final private UsuarioRepository usuarioRepository;
    final private MotivoViajeRepository motivoViajeRepository;
    final private TipoGastoRepository tipoGastoRepository;

    final private AcompananteRepository acompananteRepository;
    final private AcompananteEncuestaRepository acompananteEncuestaRepository;

    final private OrganizaViajeRepository organizaViajeRepository;
    final private OrganizaViajeEncuestaRepository organizaViajeEncuestaRepository;

    final private PaqueteTuristicoRepository paqueteTuristicoRepository;
    final private PaqueteTuristicoEncuestaRepository paqueteTuristicoEncuestaRepository;

    final private ArancelesRepository arancelesRepository;
    final private ArancelesEncuestaRepository arancelesEncuestaRepository;

    final private AlojamientoRepository alojamientoRepository;
    final private AlojamientoEncuestaPaisRepository alojamientoEncuestaPaisRepository;

    public EncuestaServiceImpl(EncuestaRepository encuestaRepository, PaisesRepository paisRepository, UsuarioRepository usuarioRepository, MotivoViajeRepository motivoViajeRepository, TipoGastoRepository tipoGastoRepository, AcompananteRepository acompananteRepository, AcompananteEncuestaRepository acompananteEncuestaRepository, OrganizaViajeRepository organizaViajeRepository, OrganizaViajeEncuestaRepository organizaViajeEncuestaRepository, PaqueteTuristicoRepository paqueteTuristicoRepository, PaqueteTuristicoEncuestaRepository paqueteTuristicoEncuestaRepository, ArancelesRepository arancelesRepository, ArancelesEncuestaRepository arancelesEncuestaRepository, AlojamientoRepository alojamientoRepository, AlojamientoEncuestaPaisRepository alojamientoEncuestaPaisRepository) {
        this.encuestaRepository = encuestaRepository;
        this.paisRepository = paisRepository;
        this.usuarioRepository = usuarioRepository;
        this.motivoViajeRepository = motivoViajeRepository;
        this.tipoGastoRepository = tipoGastoRepository;

        this.acompananteRepository = acompananteRepository;
        this.acompananteEncuestaRepository = acompananteEncuestaRepository;
        this.organizaViajeRepository = organizaViajeRepository;
        this.organizaViajeEncuestaRepository = organizaViajeEncuestaRepository;
        this.paqueteTuristicoRepository = paqueteTuristicoRepository;
        this.paqueteTuristicoEncuestaRepository = paqueteTuristicoEncuestaRepository;
        this.arancelesRepository = arancelesRepository;
        this.arancelesEncuestaRepository = arancelesEncuestaRepository;
        this.alojamientoRepository = alojamientoRepository;
        this.alojamientoEncuestaPaisRepository = alojamientoEncuestaPaisRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Encuesta> findAll() {
        return (List<Encuesta>) encuestaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Encuesta> findById(Long id) {
        return encuestaRepository.findById(id);
    }

    @Override
    @Transactional
    public Encuesta save(
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
    ) {


        if (acompananteIds == null || acompananteIds.isEmpty()) {
            throw new RuntimeException("acompanantes es una campo obligatorio");
        }
        if (organizaViajeIds == null || organizaViajeIds.isEmpty()) {
            throw new RuntimeException("organizacion de viaje es una campo obligatorio");
        }
        if (paqueteTuristicoIds == null || paqueteTuristicoIds.isEmpty()) {
            throw new RuntimeException("paquete turistico es una campo obligatorio");
        }
        if (arancelesEncuesta == null || arancelesEncuesta.isEmpty()) {
            throw new RuntimeException("aranceles es una campo obligatorio");
        }
        if (alojamientosEncuesta == null || alojamientosEncuesta.isEmpty()) {
            throw new RuntimeException("tipo de lojamiento es una campo obligatorio");
        }

        Optional<Paises> paisesVisitasOptional = paisRepository.findById(paisVisitaIds);
        if (!paisesVisitasOptional.isPresent()) {
            throw new RuntimeException("pais de visita no encontrado");
        }
        Paises paisesVisita = paisesVisitasOptional.get();

        Encuesta nuevaEncuesta;

        if (id == null) {
            // creacion de la encuesta
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
            if (!usuarioOptional.isPresent()) {
                throw new RuntimeException("usuario no encontrado");
            }
            Optional<Paises> paisesOptional = paisRepository.findById(paisResidePermanenId);
            if (!paisesOptional.isPresent()) {
                throw new RuntimeException("pais no encontrado");
            }
            Optional<MotivoViaje> motivoViajeOptional = motivoViajeRepository.findById(idMotivoViajeId);
            if (!motivoViajeOptional.isPresent()) {
                throw new RuntimeException("motivo de viaje no encontrado");
            }
            Optional<TipoGasto> tipoGastoOptional = tipoGastoRepository.findById(idTipoGastoId);
            if (!tipoGastoOptional.isPresent()) {
                throw new RuntimeException("tipo de gasto no encontrado");
            }

            encuesta.setId_usuario(usuarioOptional.get());
            encuesta.setId_pais_reside_permanen(paisesOptional.get());
            encuesta.setId_motivo_viaje(motivoViajeOptional.get());
            encuesta.setId_tipo_gasto(tipoGastoOptional.get());
            nuevaEncuesta = encuestaRepository.save(encuesta);
        }else{
            // Actualización de la encuesta
            Optional<Encuesta> encuestaOptional = encuestaRepository.findById(id);
            if (!encuestaOptional.isPresent()) {
                throw new RuntimeException("encuesta no encontrada");
            }
            // Se cambia: se usa usuarioId en lugar de id
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
            if (!usuarioOptional.isPresent()) {
                throw new RuntimeException("usuario no encontrado");
            }
            Optional<Paises> paisesOptional = paisRepository.findById(paisResidePermanenId);
            if (!paisesOptional.isPresent()) {
                throw new RuntimeException("pais no encontrado");
            }
            // Se cambia: se usa idMotivoViajeId en lugar de id
            Optional<MotivoViaje> motivoViajeOptional = motivoViajeRepository.findById(idMotivoViajeId);
            if (!motivoViajeOptional.isPresent()) {
                throw new RuntimeException("motivo viaje no encontrado");
            }
            Optional<TipoGasto> tipoGastoOptional = tipoGastoRepository.findById(idTipoGastoId);
            if (!tipoGastoOptional.isPresent()) {
                throw new RuntimeException("tipo de gasto no encontrado");
            }

            Encuesta encuestaExistente = encuestaOptional.get();

            encuestaExistente.setId_usuario(usuarioOptional.get());
            encuestaExistente.setId_pais_reside_permanen(paisesOptional.get());
            encuestaExistente.setId_motivo_viaje(motivoViajeOptional.get());
            encuestaExistente.setId_tipo_gasto(tipoGastoOptional.get());
            encuestaExistente.setNacionalidad(encuesta.getNacionalidad());
            encuestaExistente.setSexo(encuesta.getSexo());
            encuestaExistente.setEdad(encuesta.getEdad());
            encuestaExistente.setOtro_acompanante(encuesta.getOtro_acompanante());
            encuestaExistente.setNro_acompanantes(encuesta.getNro_acompanantes());
            encuestaExistente.setOtro_motivo_viaje(encuesta.getOtro_motivo_viaje());
            encuestaExistente.setOtro_organiza_viaje(encuesta.getOtro_organiza_viaje());
            encuestaExistente.setOtro_paquete_turistico(encuesta.getOtro_paquete_turistico());

            // almacenamos la info
            nuevaEncuesta = encuestaRepository.save(encuestaExistente);

            // Se elimina la info de las tablas intermedias para actualización...
            acompananteEncuestaRepository.deleteByEncuesta(nuevaEncuesta);
            organizaViajeEncuestaRepository.deleteByEncuesta(nuevaEncuesta);
            paqueteTuristicoEncuestaRepository.deleteByEncuesta(nuevaEncuesta);
            arancelesEncuestaRepository.deleteByEncuesta(nuevaEncuesta);
            alojamientoEncuestaPaisRepository.deleteByEncuesta(nuevaEncuesta);
        }

        // asociamos la info de la encuesta en la tablas intermedias
        for (Long AcompananteId : acompananteIds) {
            Optional<Acompanante> acompananteOptional = acompananteRepository.findById(AcompananteId);
            if (!acompananteOptional.isPresent()) {
                throw new RuntimeException("acompanante no encontrado");
            }
            AcompananteEncuesta acompananteEncuesta = new AcompananteEncuesta();

            acompananteEncuesta.setAcompanante(acompananteOptional.get());
            acompananteEncuesta.setEncuesta(nuevaEncuesta);

            acompananteEncuestaRepository.save(acompananteEncuesta);
        }

        for (Long organizaViajeId : organizaViajeIds) {
            Optional<OrganizaViaje> organizaViajeOptional = organizaViajeRepository.findById(organizaViajeId);
            if (!organizaViajeOptional.isPresent()) {
                throw new RuntimeException("organiza viaje no encontrado");
            }
            OrganizaViajeEncuesta organizaViajeEncuesta = new OrganizaViajeEncuesta();

            organizaViajeEncuesta.setOrganizaViaje(organizaViajeOptional.get());
            organizaViajeEncuesta.setEncuesta(nuevaEncuesta);

            organizaViajeEncuestaRepository.save(organizaViajeEncuesta);
        }

        for (Long paqueteTuristicoId : paqueteTuristicoIds) {
            Optional<PaqueteTuristico> paqueteTuristicoOptional = paqueteTuristicoRepository.findById(paqueteTuristicoId);
            if (!paqueteTuristicoOptional.isPresent()) {
                throw new RuntimeException("paquete turistico no encontrado");
            }
            PaqueteTuristicoEncuesta paqueteTuristicoEncuesta = new PaqueteTuristicoEncuesta();

            paqueteTuristicoEncuesta.setPaqueteTuristico(paqueteTuristicoOptional.get());
            paqueteTuristicoEncuesta.setEncuesta(nuevaEncuesta);

            paqueteTuristicoEncuestaRepository.save(paqueteTuristicoEncuesta);
        }

        // Procesar la relación de aranceles
        for (ArancelEncuestaDTO aeDTO : arancelesEncuesta) {
            Optional<Aranceles> arancelesOptional = arancelesRepository.findById(aeDTO.getArancelId());
            if (!arancelesOptional.isPresent()) {
                throw new RuntimeException("arancel no encontrado");
            }
            ArancelesEncuesta arancelesEncuestaEntity = new ArancelesEncuesta();
            arancelesEncuestaEntity.setAranceles(arancelesOptional.get());
            arancelesEncuestaEntity.setEncuesta(nuevaEncuesta);
            arancelesEncuestaEntity.setHuboGastos(aeDTO.getHuboGastos());
            arancelesEncuestaEntity.setValor(aeDTO.getValor());
            arancelesEncuestaEntity.setTipo_moneda(aeDTO.getTipo_moneda());
            arancelesEncuestaEntity.setNro_personas(aeDTO.getNro_personas());
            arancelesEncuestaRepository.save(arancelesEncuestaEntity);
        }

        // Procesar la relación de alojamientos (nuevos datos que vienen en el JSON)
        for (AlojamientoEncuestaDTO aeDTO : alojamientosEncuesta) {
            Optional<Alojamiento> alojamientoOptional = alojamientoRepository.findById(aeDTO.getTipoAlojamientoId());
            if (!alojamientoOptional.isPresent()) {
                throw new RuntimeException("tipo alojamiento no encontrado");
            }
            AlojamientoEncuestaPais alojamientoEncuestaPais = new AlojamientoEncuestaPais();
            alojamientoEncuestaPais.setAlojamiento(alojamientoOptional.get());
            alojamientoEncuestaPais.setEncuesta(nuevaEncuesta);

            alojamientoEncuestaPais.setPaises(paisesVisita);
            alojamientoEncuestaPais.setNro_noches(aeDTO.getNroNoches());
            alojamientoEncuestaPaisRepository.save(alojamientoEncuestaPais);
        }


        return nuevaEncuesta;

    }

    @Override
    @Transactional
    public Optional<Encuesta> deleteById(Long id) {
        Optional<Encuesta> optionalEncuesta = encuestaRepository.findById(id);

        if (optionalEncuesta.isPresent()) {
            acompananteEncuestaRepository.deleteById(id);
            organizaViajeEncuestaRepository.deleteById(id);
            paqueteTuristicoEncuestaRepository.deleteById(id);
            arancelesEncuestaRepository.deleteById(id);
            alojamientoEncuestaPaisRepository.deleteById(id);

            encuestaRepository.deleteById(id);
            return optionalEncuesta;
        }

        return Optional.empty();
    }
}
