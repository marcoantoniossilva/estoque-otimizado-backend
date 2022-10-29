package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserLoginResponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String token;
  private LocalDateTime expiresIn;
  private String tokenProvider;

  public UserLoginResponseDTO(String token, LocalDateTime expiresIn, String tokenProvider) {
    this.token = token;
    this.expiresIn = expiresIn;
    this.tokenProvider = tokenProvider;
  }

}