package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model;

import lombok.Data;

@Data
public class UserLoginDTO {

  private Long id;
  private String email;
  private String password;

}