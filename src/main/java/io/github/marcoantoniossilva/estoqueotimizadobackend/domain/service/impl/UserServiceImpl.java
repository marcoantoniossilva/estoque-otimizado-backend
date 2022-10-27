package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.exception.BusinessException;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.exception.ResourceNotFoundException;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.User;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository.UserRepository;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl extends BaseCrudServiceImpl<User,Long>
        implements UserDetailsService, UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User save(User user) {

        if (repository.existsByEmail(user.getEmail())) {
            throw new BusinessException("Já existe um usuário cadastrado com este email!");
        }

        if (user.getUserId() == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(repository.getReferenceById(user.getUserId()).getPassword());
        }

        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws ResourceNotFoundException {
        User savedUser = repository.findByEmail(email).
                orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE "));
        return new org.springframework.security.core.userdetails.User(savedUser.getEmail(), savedUser.getPassword(), authorities);
    }

    public User findUserByEmailOrException(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
    }

    @Override
    protected JpaRepository<User,Long> getRepository() {
        return this.repository;
    }
}