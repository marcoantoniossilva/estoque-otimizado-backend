package io.github.marcoantoniossilva.estoqueotimizadobackend.security;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.util.HashUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return HashUtil.getSecureHash(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String hash = HashUtil.getSecureHash(rawPassword.toString());
        return hash.equals(encodedPassword);
    }
}