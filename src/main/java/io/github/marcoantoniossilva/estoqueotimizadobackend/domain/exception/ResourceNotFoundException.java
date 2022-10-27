package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}