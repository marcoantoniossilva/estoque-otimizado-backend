package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoxService extends BaseCrudService<Box,Long> {

    Page<Box> findByBoxCodeIgnoreCaseContaining(String term, Pageable pageable);

    Optional<Box> findByCode(String boxCode);

    boolean existsByCode(String boxCode);

    void deleteByCode(String boxCode);

}
