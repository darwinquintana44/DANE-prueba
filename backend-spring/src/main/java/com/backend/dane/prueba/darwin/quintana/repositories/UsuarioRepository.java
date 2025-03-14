package com.backend.dane.prueba.darwin.quintana.repositories;

import com.backend.dane.prueba.darwin.quintana.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
}
