package com.scisk.sciskbackend.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncodingManager implements PasswordEncodingManager {

    private final PasswordEncoder passwordEncoder;

    public BcryptPasswordEncodingManager(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPawword) {
        return passwordEncoder.matches(rawPassword, encodedPawword);
    }

}
