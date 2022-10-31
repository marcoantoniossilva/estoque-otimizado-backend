package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  Page<Product> findByBoxBoxId(String boxId, Pageable pageable);

  Page<Product> findByDescriptionContaining(String description, Pageable pageable);

  String findBoxIdByProductId(Long productId);
}
