package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseCrudService<ENTITY, ID> {

    List<ENTITY> findAll();

    Page<ENTITY> findAll(Pageable pageable);

    Optional<ENTITY> findById(ID id);

    ENTITY findByIdOrException(ID id);

    Boolean existsById(ID id);

    Long count();

    ENTITY save(ENTITY entity);

    void deleteById(ID id);

    void delete(ENTITY entity);

}
