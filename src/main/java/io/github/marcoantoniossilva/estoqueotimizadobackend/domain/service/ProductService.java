package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService extends BaseCrudService<Product, Long> {

    Page<Product> findByDescriptionContaining(String description, Pageable pageable);

    Page<Product> findByBoxBoxId(String boxId, Pageable pageable);

    Optional<Box> findBoxById(Long productId);
}
