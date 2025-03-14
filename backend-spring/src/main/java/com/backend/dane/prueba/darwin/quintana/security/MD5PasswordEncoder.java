package com.backend.dane.prueba.darwin.quintana.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.backend.dane.prueba.darwin.quintana.util.MD5Util;

public class MD5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.getMD5(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
