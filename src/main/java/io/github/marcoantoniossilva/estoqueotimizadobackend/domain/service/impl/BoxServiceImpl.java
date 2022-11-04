package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository.BoxRepository;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.BoxService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoxServiceImpl extends BaseCrudServiceImpl<Box, Long>
        implements BoxService {

    private final BoxRepository repository;

    public BoxServiceImpl(BoxRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Box, Long> getRepository() {
        return this.repository;
    }

    @Override
    public Page<Box> findByBoxCodeIgnoreCaseContaining(String term, Pageable pageable) {
        return repository.findByCodeIgnoreCaseContaining(term, pageable);
    }

    @Override
    public Optional<Box> findByCode(String boxCode){
        return repository.findByCode(boxCode);
    }

    @Override
    public boolean existsByCode(String boxCode){
        return repository.existsByCode(boxCode);
    }

    @Override
    public void deleteByCode(String boxCode){
        repository.deleteByCode(boxCode);
    }

}
