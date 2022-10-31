package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.impl;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository.ProductRepository;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
    public Page<Product> findByDescriptionContaining(String description, Pageable pageable) {
        return repository.findByDescriptionContaining(description, pageable);
    }

    @Override
    public Page<Product> findByBoxBoxId(String boxId, Pageable pageable) {
        return repository.findByBoxBoxId(boxId, pageable);
    }

    @Override
    public String findBoxIdByProductId(Long productId) {
        return repository.findBoxIdByProductId(productId);
    }
}
