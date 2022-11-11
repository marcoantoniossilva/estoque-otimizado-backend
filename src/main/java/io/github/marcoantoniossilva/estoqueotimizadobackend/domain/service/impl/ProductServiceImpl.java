package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository.ProductRepository;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
    public Page<Product> findByDescriptionIgnoreCaseContaining(String description, Pageable pageable) {
        return repository.findByDescriptionIgnoreCaseContaining(description, pageable);
    }

    @Override
    public Page<Product> findByBoxBoxId(Long boxId, Pageable pageable) {
        return repository.findByBoxId(boxId, pageable);
    }

    @Override
    public Optional<Box> getBoxById(Long productId) {
        return repository.getBoxById(productId);
    }
}
