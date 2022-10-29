package io.github.marcoantoniossilva.estoqueotimizadobackend.security;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.User;

public class SecurityUtils {

  private static User loggedUser;

  public static User getLoggedUser() {
    return loggedUser;
  }

  public static void setLoggedUser(User loggedUser) {
    SecurityUtils.loggedUser = loggedUser;
  }
}