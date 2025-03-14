package com.backend.dane.prueba.darwin.quintana.controller;

import com.backend.dane.prueba.darwin.quintana.security.JwtTokenUtil;
import com.backend.dane.prueba.darwin.quintana.security.CustomUserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public Map<String, String> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("🔑 Intentando autenticar usuario: " + loginRequest.getUsuario());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsuario(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken((CustomUserDetails) authentication.getPrincipal());

        System.out.println("Token generado correctamente: " + jwt);

        Map<String, String> response = new HashMap<>();
        response.put("token", jwt);
        return response;
    }
}

class LoginRequest {
    private String usuario;
    private String password;

    public String getUsuario() { return usuario; }
    public String getPassword() { return password; }
}
