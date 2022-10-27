package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository.BoxRepository;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.BoxService;
import org.springframework.data.jpa.repository.JpaRepository;

public class BoxServiceImpl extends BaseCrudServiceImpl<Box, String>
        implements BoxService {

    private final BoxRepository repository;

    public BoxServiceImpl(BoxRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Box, String> getRepository() {
        return this.repository;
    }
}
