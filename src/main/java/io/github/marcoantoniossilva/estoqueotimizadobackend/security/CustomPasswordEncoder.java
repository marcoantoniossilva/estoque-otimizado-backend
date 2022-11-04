package io.github.marcoantoniossilva.estoqueotimizadobackend.security;

import io.github.marcoantoniossilva.estoqueotimizadobackend.common.utils.HashUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return HashUtils.getSecureHash(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String hash = HashUtils.getSecureHash(rawPassword.toString());
        return hash.equals(encodedPassword);
    }
}