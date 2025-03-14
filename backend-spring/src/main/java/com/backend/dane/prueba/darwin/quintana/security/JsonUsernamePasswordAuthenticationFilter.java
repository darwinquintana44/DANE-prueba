package com.backend.dane.prueba.darwin.quintana.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.util.Map;

public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if(request.getContentType() != null &&
                request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
            try {
                Map<String, String> authRequestMap = objectMapper.readValue(request.getInputStream(), Map.class);
                String username = authRequestMap.get("usuario");
                String password = authRequestMap.get("password");
                UsernamePasswordAuthenticationToken authRequest =
                        new UsernamePasswordAuthenticationToken(username, password);
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            } catch (IOException e) {
                throw new RuntimeException("Error leyendo el request de autenticación", e);
            }
        } else {
            return super.attemptAuthentication(request, response);
        }
    }
}
