package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository.ProductRepository;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class ProductServiceImpl extends BaseCrudServiceImpl<Product,Long>
        implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return this.repository;
    }

    @Override
    public Page<Product> findByDescriptionContaining(String description, Pageable pageable) {
        return repository.findByDescriptionContaining(description, pageable);
    }

    @Override
    public Page<Product> listByBoxId(String boxId, Pageable pageable) {
        return repository.listByBoxId(boxId, pageable);
    }
}
