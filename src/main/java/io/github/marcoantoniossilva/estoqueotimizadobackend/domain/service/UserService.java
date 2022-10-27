package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.User;

public interface UserService extends BaseCrudService<User, Long> {

    User findUserByEmailOrException(String email);

}
