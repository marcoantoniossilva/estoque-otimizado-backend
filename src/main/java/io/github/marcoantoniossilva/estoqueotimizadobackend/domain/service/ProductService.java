package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService extends BaseCrudService<Product, Long> {

    Page<Product> findByDescriptionContaining(String description, Pageable pageable);

    Page<Product> listByBoxId(String boxId, Pageable pageable);
}
