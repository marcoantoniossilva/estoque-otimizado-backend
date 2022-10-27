package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository.ProductRepository;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
