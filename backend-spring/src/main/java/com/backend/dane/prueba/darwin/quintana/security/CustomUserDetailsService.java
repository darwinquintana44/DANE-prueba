package com.backend.dane.prueba.darwin.quintana.security;

import com.backend.dane.prueba.darwin.quintana.entities.Usuario;
import com.backend.dane.prueba.darwin.quintana.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔍 Buscando usuario en la base de datos: " + username);
        Usuario user = usuarioRepository.findByUsuario(username);

        if (user == null) {
            System.out.println("Usuario no encontrado: " + username);
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        System.out.println("Usuario encontrado: " + user.getUsuario());
        return new CustomUserDetails(user);
    }
}
